package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(LongitudeConverter.class)
public class Longitude {

    private double value;

    public Longitude(double value) {
        if (value >= -180.0D && value <= 180.0D) {
            this.value = value;
        } else {
            throw new IllegalArgumentException(String.format("%f is not in range [-180, 180].", value));
        }
    }

    public static Longitude fromDouble(double value) {
        return new Longitude(value);
    }

    public double getValue() {
        return value;
    }
}
