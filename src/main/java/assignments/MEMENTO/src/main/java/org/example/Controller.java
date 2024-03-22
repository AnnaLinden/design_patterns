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
    private List<IMemento> history = new ArrayList<>();
    private int currentHistoryIndex = -1; // Tracks the current position in the history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveCurrentState();
        model.setOption(optionNumber, choice);
        gui.updateGui();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveCurrentState();
        model.setIsSelected(isSelected);
        gui.updateGui();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveCurrentState() {
        // Remove any states ahead of the current index before adding a new state
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

    public void showHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        ListView<String> listView = new ListView<>();
        for (int i = 0; i <= currentHistoryIndex; i++) {
            listView.getItems().add(history.get(i).getDescription() + " (State " + i + ")");
        }

        listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0 && index <= currentHistoryIndex) {
                model.restoreState(history.get(index));
                gui.updateGui();
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 400);
        historyStage.setScene(scene);
        historyStage.show();
    }
}