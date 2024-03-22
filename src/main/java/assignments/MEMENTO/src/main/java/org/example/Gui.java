package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change.");
        // Label for redo functionality.
        Label labelReDo = new Label("Press Ctrl-Y to redo the last change.");
        label.setPadding(insets);
        labelReDo.setPadding(insets);

        // Button to show history.
        Button showHistoryButton = new Button("Show History");
        showHistoryButton.setOnAction(event -> showHistoryWindow());

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label, labelReDo, showHistoryButton);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            }
        });


        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();

        scene.setOnKeyPressed(event -> {
            if (event.isControlDown()) {
                if (event.getCode() == KeyCode.Z) {
                    controller.undo();
                } else if (event.getCode() == KeyCode.Y) {
                    controller.redo();
                }
            }
        });
    }
    //Displays a window with the history of states.
    public void showHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        ListView<String> listView = new ListView<>();
        List<String> historyDescriptions = controller.getHistoryDescriptions();

        // Include the state number in each list item
        for (int i = 0; i < historyDescriptions.size(); i++) {
            String descriptionWithIndex = "State " + i + ": " + historyDescriptions.get(i);
            listView.getItems().add(descriptionWithIndex);
        }

        listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                // Allows restoring state from the selected history item.
                controller.restoreStateFromHistory(index);
                updateGui();
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 300, 400);
        historyStage.setScene(scene);
        historyStage.show();
    }
    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }


}