package gouglhupf.gpx;

public class Bounds {
    private Latitude minlat;
    private Longitude minlon;
    private Latitude maxlat;
    private Longitude maxlon;

    public Bounds(double minlat, double minlon, double maxlat, double maxlon) {
        this.minlat = Latitude.fromDouble(minlat);
        this.minlon = Longitude.fromDouble(minlon);
        this.maxlat = Latitude.fromDouble(maxlat);
        this.maxlon = Longitude.fromDouble(maxlon);
    }

    public Latitude getMinlat() {
        return minlat;
    }

    public Longitude getMinlon() {
        return minlon;
    }

    public Latitude getMaxlat() {
        return maxlat;
    }

    public Longitude getMaxlon() {
        return maxlon;
    }
}
