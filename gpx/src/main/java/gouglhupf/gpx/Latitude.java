package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(LatitudeConverter.class)
public class Latitude {

    private double value;

    public Latitude(double value) {
        this.value = value;
        if (value >= -90.0D && value <= 90.0D) {
            this.value = value;
        } else {
            throw new IllegalArgumentException(String.format("%f is not in range [-90, 90].", value));
        }
    }

    public static Latitude fromDouble(double value) {
        return new Latitude(value);
    }

    public double getValue() {
        return value;
    }
}
