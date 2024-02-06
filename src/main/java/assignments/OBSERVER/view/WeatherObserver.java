package assignments.OBSERVER.view;

public interface WeatherObserver {
    void update(float temperature);

    default void onRemove() {
        System.out.println("Observer removed");
    }
}
