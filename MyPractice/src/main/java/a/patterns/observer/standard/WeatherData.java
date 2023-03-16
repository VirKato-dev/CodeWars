package a.patterns.observer.standard;

import java.util.Observable;

/**
 * Суперкласс берет на себя все управление наблюдателями,
 * поэтому мы удаляем код регистрации, добавления и оповещения
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    /**
     * Перед вызовом notifyObservers() необходимо вызвать setChanged().
     */
    public void measurementsChanged() {
        setChanged();
        // Объект данных не передается —
        // это означает, что мы используем модель ЗАПРОСА ДАННЫХ.
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float
            pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Эти методы будут использоваться наблюдателями для получения состояния объекта WeatherData.

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}