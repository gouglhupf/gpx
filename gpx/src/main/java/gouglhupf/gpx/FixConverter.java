package gouglhupf.gpx;

import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.enums.EnumConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;

public class FixConverter extends EnumConverter {
    public static FixConverter getInstance() {
        return new FixConverter();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return Fix.ofName(reader.getValue());
    }

    @Override
    public boolean canConvert(Class clazz) {
        return Fix.class.isAssignableFrom(clazz);
    }
}
