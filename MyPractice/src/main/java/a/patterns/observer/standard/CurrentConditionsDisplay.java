package a.patterns.observer.standard;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private Observable observable;
    private float temperature;
    private float humidity;

    /**
     * Объект элемента текущего состояния добавляется в качестве наблюдателя.
     * @param observable
     */
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    /**
     * Обновленный метод update() получает Observable и необязательные данные.
     * @param obs   the observable object.
     * @param arg   an argument passed to the {@code notifyObservers} method.
     */
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            // Сначала проверяем, что субъект относится к типу WeatherData,
            // затем используем его get-методы для получения температуры и влажности,
            // после чего вызываем display().
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions: "+temperature
                + "F degrees and "+humidity + "% humidity");
    }
}
