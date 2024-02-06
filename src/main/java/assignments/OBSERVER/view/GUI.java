package assignments.OBSERVER.view;

import java.util.HashMap;
import java.util.Map;

import assignments.OBSERVER.model.WeatherData;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GUI extends Application {

    private WeatherData weatherData;
    private Map<String, Label> labelsMap = new HashMap<>();
    private Map<String, WeatherObserver> observersMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        weatherData = new WeatherData();

        openWindow("Weather Display 1", weatherData);
        openWindow("Weather Display 2", weatherData);
        openWindow("Weather Display 3", weatherData);

        weatherData.start();

        scheduleStopUpdates("Weather Display 2", weatherData, 3);

    }

    private void openWindow(String windowName, WeatherData weatherData) {
        Stage stage = new Stage();
        stage.setTitle(windowName);

        Label temperatureLabel = new Label("Current Temperature: ");
        WeatherObserver display = temperature -> Platform
                .runLater(
                        () -> temperatureLabel.setText("Current Temperature: " + String.format("%.2f°C", temperature)));

        weatherData.registerObserver(display);
        labelsMap.put(windowName, temperatureLabel);
        observersMap.put(windowName, display);

        VBox root = new VBox(temperatureLabel);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.show();

    }

    private void scheduleStopUpdates(String windowName, WeatherData weatherData, int secondsToWait) {
        Label label = labelsMap.get(windowName); // Correctly retrieve the Label
        WeatherObserver observerToRemove = observersMap.get(windowName); // Retrieve the observer by window name

        if (label != null && observerToRemove != null) {
            PauseTransition wait = new PauseTransition(Duration.seconds(secondsToWait));
            wait.setOnFinished(e -> {
                weatherData.removeObserver(observerToRemove); // Remove the observer
                Platform.runLater(() -> label
                        .setText("Observer is no longer notified of weather changes."));
                observersMap.remove(windowName); // Remove the observer from the map
            });
            wait.play();
        }
    }

}
