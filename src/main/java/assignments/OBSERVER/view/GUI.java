package assignments.OBSERVER.view;

import assignments.OBSERVER.model.WeatherData;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    private WeatherData weatherData;

    @Override
    public void start(Stage primaryStage) {
        weatherData = new WeatherData();

        openWindow("Weather Display 1", weatherData);
        openWindow("Weather Display 2", weatherData);
        openWindow("Weather Display 3", weatherData);

        weatherData.start();

    }

    private void openWindow(String windowName, WeatherData weatherData) {
        Stage stage = new Stage();
        stage.setTitle(windowName);

        Label temperatureLabel = new Label("Current Temperature: ");
        WeatherObserver display = temperature -> Platform
                .runLater(
                        () -> temperatureLabel.setText("Current Temperature: " + String.format("%.2f°C", temperature)));

        weatherData.registerObserver(display);

        VBox root = new VBox(temperatureLabel);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.show();

    }

}
