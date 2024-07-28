// Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, 
// its dependent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.

// In this example, we have a weather monitoring system where we have a WeatherData class which is the Subject. 

package Behavioural_Design_Pattern;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature, float humidity, float pressure);
}

// Subject interface
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Concrete Subject
class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Concrete Observer
class CurrentConditionsDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current conditions: " + temperature + "F degrees, " + humidity + "% humidity, " + pressure
                + " pressure");
    }
}

// Main class to demonstrate
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();

        weatherData.registerObserver(currentDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }
}
