package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamConverter(FixConverter.class)
public enum Fix {
    NONE("none"),
    DIM_2("2d"),
    DIM_3("3d"),
    DGPS("dgps"),
    PPS("pps");

    private String value;

    Fix(String value) {
        if (value == null)
            throw new NullPointerException();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Fix ofName(String name) {
        if (name.equals("2d"))
            return DIM_2;
        else if (name.equals("3d"))
            return DIM_3;
        else if (name.equals("pps"))
            return PPS;
        else if (name.equals("dgps"))
            return DGPS;
        else if (name.equals("none"))
            return NONE;

        return null;
    }
}
