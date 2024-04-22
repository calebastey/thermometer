package thermometer;

import static thermometer.TemperatureRepresentationType.CELSIUS;

public class Thermometer {
    private final TemperatureRepresentation rep;

    private Double temperatureKelvin;

    public Thermometer(TemperatureRepresentationType type) {
        if (type == CELSIUS) {
            rep = new Celsius();
        }
        else {
            rep  = new Fahrenheit();
        }
    }

    public double read(double temperature) {
        this.temperatureKelvin = temperature;
        return this.rep.convert(this.temperatureKelvin);
    }

    public double currentTemperature() {
        return this.rep.convert(this.temperatureKelvin);
    }

}
