package a.patterns.observer;

import a.patterns.observer.standard.CurrentConditionsDisplay;
import a.patterns.observer.standard.WeatherData;
//import a.patterns.observer.our.CurrentConditionsDisplay;
//import a.patterns.observer.our.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        // будет реагировать на изменение данных
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
