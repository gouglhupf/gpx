package gouglhupf.gpx;

public class UInteger {
    private int value;

    public UInteger(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("%d is negative.", value));
        } else {
            this.value = value;
        }
    }

    public int getValue() {
        return value;
    }
}
