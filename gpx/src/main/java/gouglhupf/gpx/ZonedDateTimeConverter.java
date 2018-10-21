package gouglhupf.gpx;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import org.threeten.bp.ZonedDateTime;

public class ZonedDateTimeConverter implements SingleValueConverter {

    @Override
    public boolean canConvert(final Class type) {
        return ZonedDateTime.class == type;
    }

    @Override
    public String toString(final Object obj) {
        if (obj == null) {
            return null;
        }

        return ZonedDateTimeFormat.format((ZonedDateTime) obj);
    }

    @Override
    public Object fromString(final String str) {
        return ZonedDateTimeFormat.parse(str);
    }
}
