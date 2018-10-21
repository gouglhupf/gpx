package gouglhupf.gpx;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class LatitudeConverter implements SingleValueConverter {
    @Override
    public String toString(Object obj) {
        return String.valueOf(((Latitude) obj).getValue());
    }

    @Override
    public Object fromString(String str) {
        return new Latitude(Double.valueOf(str));
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Latitude.class);
    }
}
