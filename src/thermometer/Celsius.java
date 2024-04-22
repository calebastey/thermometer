package thermometer;

public class Celsius implements TemperatureRepresentation {
    @Override
    public double convert(double temp) {
        return temp - 273.15;
    }

    @Override
    public String name() {
        return "Celsius";
    }
}
