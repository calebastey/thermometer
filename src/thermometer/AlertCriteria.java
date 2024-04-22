package thermometer;


public class AlertCriteria {

    private final TrendDirection trendDirection;
    private final Double temperature;
    private final Double rangeThreshold;
    private final String alertName;

    public AlertCriteria(
            String alertName,
            Double temperature,
            TrendDirection trendDirection,
            Double rangeThreshold

    ) {
        this.trendDirection = trendDirection;
        this.temperature = temperature;
        this.rangeThreshold = rangeThreshold;
        this.alertName = alertName;
    }

    public boolean shouldAlert(Double previous, Double current) {
        var currentDirection = TrendDirection.getTrendDirection(current, previous);

        var trendMatches = TrendDirection.matches(currentDirection, this.trendDirection);
        var wasOutsideRange = (current - previous) > this.rangeThreshold;

        return trendMatches && wasOutsideRange;
    }

    public String getAlert() {
        return String.format("%s - Temperature %s", alertName, temperature);
    }
}
