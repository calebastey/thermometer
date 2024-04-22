package thermometer;

public enum TrendDirection {
    INCREASING,
    DECREASING,
    STATIC,
    ANY;

    public static TrendDirection getTrendDirection(Double previous, Double current) {
        if (Math.abs(current - previous) < .000001d) {
            return STATIC;
        }
        else if (current > previous) {
            return INCREASING;
        }
        else {
            return DECREASING;
        }
    }

    public static boolean matches(TrendDirection current, TrendDirection requested) {
        if (requested == ANY) {
            return true;
        }
        else {
            return current == requested;
        }
    }
}
