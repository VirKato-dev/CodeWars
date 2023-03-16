package a.patterns.observer.our;

import java.util.ArrayList;

public class WeatherData implements Subject {
    /**
     * Добавляем контейнер ArrayList для хранения наблюдателей
     */
    private final ArrayList<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    /**
     * Новые наблюдатели просто добавляются в конец списка.
     * @param o
     */
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Если наблюдатель хочет отменить регистрацию, мы просто удаляем его из списка.
     * @param o
     */
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Самое интересное:
     * оповещение наблюдателей об изменении состояния через метод update(),
     * реализуемый всеми наблюдателями.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * Оповещение наблюдателей о появлении новых данных.
     */
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Другие методы WeatherData
}