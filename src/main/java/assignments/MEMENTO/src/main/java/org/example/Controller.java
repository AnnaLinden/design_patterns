package org.example;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
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
        while (history.size() > currentHistoryIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(model.createMemento());
        currentHistoryIndex++;
    }

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

    public List<String> getHistoryDescriptions() {
        List<String> descriptions = new ArrayList<>();
        for (IMemento memento : history) {
            descriptions.add(memento.getDescription());
        }
        return descriptions;
    }

    public void restoreStateFromHistory(int index) {
        if (index >= 0 && index < history.size()) {
            IMemento selectedMemento = history.get(index);
            model.restoreState(selectedMemento);
            // No change in history or current index needed for simple state restoration
            gui.updateGui();
        }
    }

}