package assignments.OBSERVER.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import assignments.OBSERVER.view.WeatherObserver;

public class WeatherData extends Thread implements Subject {

    private float temperature;
    private List<WeatherObserver> observers;
    private final float MIN_TEMP = -50.0f;
    private final float MAX_TEMP = 50.0f;

    public WeatherData() {
        observers = new ArrayList<>();
        temperature = new Random().nextFloat() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP;
    }

    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private void changeTemperature() {
        temperature += new Random().nextFloat() * 2 - 1;
        if (temperature < MIN_TEMP) {
            temperature = MIN_TEMP;
        } else if (temperature > MAX_TEMP) {
            temperature = MAX_TEMP;
        }
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {

            try {
                changeTemperature();
                Thread.sleep(new Random().nextInt(4000) + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Properly handle thread interruption
                System.out.println("WeatherData thread interrupted.");
                break;
            }
        }
    }

}
