package thermometer;

import java.util.ArrayList;
import java.util.List;

public class TemperatureAwareEnvironment {

    private static final int WINDOW_SIZE = 10;

    private final Thermometer thermometer;
    private final List<AlertCriteria> alertCriteria;
    private final List<Double> readings;
    private final Alerter alerter;

    public TemperatureAwareEnvironment(
            Thermometer thermometer,
            List<AlertCriteria> alertCriteria
    ) {
        this.thermometer = thermometer;
        this.readings = new ArrayList<>();
        this.alertCriteria = alertCriteria;
        this.alerter = new Alerter();
    }

    public void readTemperature(Double temperature) {
        var convertedTemperature = thermometer.read(temperature);

        readings.addFirst(convertedTemperature);
        if (this.readings.size() > WINDOW_SIZE) {
            readings.removeLast();
        }

        if (readings.size() > 1) {
            for (var criteria : this.alertCriteria) {
                if (criteria.shouldAlert(readings.get(0), readings.get(1))) {
                    this.alerter.alert(criteria.getAlert());
                }
            }
        }
    }
}
