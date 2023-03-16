package a.patterns.observer.our;

/**
 * Элемент реализует Observer, чтобы получать данные от объекта WeatherData.
 * Также он реализует интерфейс DisplayElement, как и все визуальные элементы в нашем API.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    /**
     * Конструктору передается объект WeatherData, который используется для регистрации
     * элемента в качестве наблюдателя.
     * @param weatherData
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /**
     * При вызове update() мы сохраняем значения температуры и влажности, после чего вызываем display().
     * @param temperature
     * @param humidity
     * @param pressure
     */
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    /**
     * Метод display() просто выводит текущие значения температуры и влажности.
     */
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}