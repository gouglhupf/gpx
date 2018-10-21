package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.SingleValueConverter;

@XStreamConverter(LongitudeConverter.class)
public class LongitudeConverter implements SingleValueConverter {
    @Override
    public String toString(Object obj) {
        return String.valueOf(((Longitude) obj).getValue());
    }

    @Override
    public Object fromString(String str) {
        return new Longitude(Double.valueOf(str));
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Longitude.class);
    }
}
