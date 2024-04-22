import thermometer.AlertCriteria;
import thermometer.TemperatureAwareEnvironment;
import thermometer.Thermometer;
import thermometer.TrendDirection;

import java.util.List;

import static thermometer.TemperatureRepresentationType.CELSIUS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var thermometer = new Thermometer(CELSIUS);
        var alertCriteria = new AlertCriteria("FREEZING", 32.0d, TrendDirection.DECREASING, 5.0d);
        var environ = new TemperatureAwareEnvironment(thermometer, List.of(alertCriteria));
        var kelvinTemps = List.of(283.15d, 274d, 273.15, 272.0d, 272.5d);

        kelvinTemps.forEach(environ::readTemperature);


    }
}