package assignments.OBSERVER.model;

import assignments.OBSERVER.view.WeatherObserver;

public interface Subject {
    void registerObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}
