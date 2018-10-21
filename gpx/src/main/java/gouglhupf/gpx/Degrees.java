package gouglhupf.gpx;

public class Degrees {
    private double value;

    Degrees(double value) {
        if (value >= 0.0D && value < 360.0D) {
            this.value = value;
        } else {
            throw new IllegalArgumentException(String.format("%f not in the range [0, 360).", value));
        }
    }

    public double getValue() {
        return value;
    }
}
