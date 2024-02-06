package assignments.OBSERVER.view;

public class WeatherDisplay implements WeatherObserver {

    private String observerName;

    public WeatherDisplay(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(float temperature) {
    }

}
