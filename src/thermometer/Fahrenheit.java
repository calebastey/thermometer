package thermometer;

public class Fahrenheit implements TemperatureRepresentation {
    @Override
    public double convert(double temperature) {
        return (temperature - 273.15) * 1.8 + 32;
    }

    @Override
    public String name() {
        return "Fahrenheit";
    }
}
