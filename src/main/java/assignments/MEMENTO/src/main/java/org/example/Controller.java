package org.example;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Keeps track of all states for undo/redo
    private int currentHistoryIndex = -1; // Tracks the current position in the history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        gui.updateGui();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        gui.updateGui();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveToHistory() {
        history.add(model.createMemento());
        currentHistoryIndex++;
    }

    //original undo
//    public void undo() {
//        if (!history.isEmpty()) {
//            System.out.println("Memento found in history");
//            IMemento previousState = history.remove(history.size() - 1);
//            model.restoreState(previousState);
//            gui.updateGui();
//        }
//    }

    // Changed undo method to work with the current index, enabling both undo and redo functionalities
    public void undo() {
        if (currentHistoryIndex > 0) {
            currentHistoryIndex--;
            model.restoreState(history.get(currentHistoryIndex));
            gui.updateGui();
        }
    }

    public void redo() {
        if (currentHistoryIndex < history.size() - 1) {
            currentHistoryIndex++;
            model.restoreState(history.get(currentHistoryIndex));
            gui.updateGui();
        }
    }

    // Provides descriptions for all saved states, enabling the history view feature
    public List<String> getHistoryDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (IMemento memento : history) {
            descriptions.add(memento.getDescription());
        }
        return descriptions;
    }

    // Allows direct restoration of a state from the history
    public void restoreStateFromHistory(int index) {
        if (index >= 0 && index < history.size()) {
            IMemento selectedMemento = history.get(index);
            model.restoreState(selectedMemento);
            gui.updateGui();
        }
    }

}