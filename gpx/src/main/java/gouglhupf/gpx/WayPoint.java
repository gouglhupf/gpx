package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import org.threeten.bp.ZonedDateTime;

@XStreamAlias("trkpt")
public class WayPoint {

    @XStreamAsAttribute
    private Latitude lat;
    @XStreamAsAttribute
    private Longitude lon;

    private Double ele;
    private ZonedDateTime time;
    private Degrees magvar;
    private Double geoidheight;
    private String name;
    private String cmt;
    private String desc;
    private String src;
    @XStreamImplicit(itemFieldName = "link")
    private Link[] links;
    private String sym;
    private Fix fix;
    private UInteger sat;
    private Double hdop;
    private Double vdop;
    private Double pdop;
    private Double ageofdgpsdata;
    private String dgpsid;
    private Extensions extensions;
    private Float speed;

    public WayPoint(Latitude lat, Longitude lon, Double ele, ZonedDateTime time, Degrees magvar, Double geoidheight, String name, String cmt, String desc, String src, Link[] links, String sym, Fix fix, UInteger sat, Double hdop, Double vdop, Double pdop, Double ageofdgpsdata, String dgpsid, Extensions extensions, Float speed) {
        this.lat = lat;
        this.lon = lon;
        this.ele = ele;
        this.time = time;
        this.magvar = magvar;
        this.geoidheight = geoidheight;
        this.name = name;
        this.cmt = cmt;
        this.desc = desc;
        this.src = src;
        this.links = links;
        this.sym = sym;
        this.fix = fix;
        this.sat = sat;
        this.hdop = hdop;
        this.vdop = vdop;
        this.pdop = pdop;
        this.ageofdgpsdata = ageofdgpsdata;
        this.dgpsid = dgpsid;
        this.extensions = extensions;
        this.speed = speed;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Latitude getLat() {
        return lat;
    }

    public Longitude getLon() {
        return lon;
    }

    public Double getEle() {
        return ele;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public Degrees getMagvar() {
        return magvar;
    }

    public Double getGeoidheight() {
        return geoidheight;
    }

    public String getName() {
        return name;
    }

    public String getCmt() {
        return cmt;
    }

    public String getDesc() {
        return desc;
    }

    public String getSrc() {
        return src;
    }

    public Link[] getLinks() {
        return links;
    }

    public String getSym() {
        return sym;
    }

    public Fix getFix() {
        return fix;
    }

    public UInteger getSat() {
        return sat;
    }

    public Double getHdop() {
        return hdop;
    }

    public Double getVdop() {
        return vdop;
    }

    public Double getPdop() {
        return pdop;
    }

    public Double getAgeofdgpsdata() {
        return ageofdgpsdata;
    }

    public String getDgpsid() {
        return dgpsid;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public Float getSpeed() {
        return speed == null && extensions != null ? extensions.getSpeed() : speed;
    }

    public static class Builder extends GenericBuilder<Builder> {
        private Latitude lat;
        private Longitude lon;
        private Double ele;
        private Degrees magvar;
        private Double geoidheight;
        private String cmt;
        private String src;
        private String sym;
        private Fix fix;
        private UInteger sat;
        private Double hdop;
        private Double vdop;
        private Double pdop;
        private Double ageofdgpsdata;
        private String dgpsid;
        private Float speed;

        public Builder lat(double lat) {
            this.lat = Latitude.fromDouble(lat);
            return this;
        }

        public Builder lon(double lon) {
            this.lon = Longitude.fromDouble(lon);
            return this;
        }

        public Builder ele(Double ele) {
            this.ele = ele;
            return this;
        }

        public Builder magvar(Degrees magvar) {
            this.magvar = magvar;
            return this;
        }

        public Builder geoidheight(Double geoidheight) {
            this.geoidheight = geoidheight;
            return this;
        }

        public Builder cmt(String cmt) {
            this.cmt = cmt;
            return this;
        }

        public Builder src(String src) {
            this.src = src;
            return this;
        }

        public Builder sym(String sym) {
            this.sym = sym;
            return this;
        }

        public Builder fix(Fix fix) {
            this.fix = fix;
            return this;
        }

        public Builder sat(UInteger sat) {
            this.sat = sat;
            return this;
        }

        public Builder hdop(Double hdop) {
            this.hdop = hdop;
            return this;
        }

        public Builder vdop(Double vdop) {
            this.vdop = vdop;
            return this;
        }

        public Builder pdop(Double pdop) {
            this.pdop = pdop;
            return this;
        }

        public Builder ageofdgpsdata(Double ageofdgpsdata) {
            this.ageofdgpsdata = ageofdgpsdata;
            return this;
        }

        public Builder dgpsid(String dgpsid) {
            this.dgpsid = dgpsid;
            return this;
        }

        public Builder speed(Float speed) {
            this.speed = speed;
            return this;
        }

        public WayPoint build() {
            return new WayPoint(lat, lon, ele, time, magvar, geoidheight, name, cmt, desc, src, links, sym, fix, sat, hdop, vdop, pdop, ageofdgpsdata, dgpsid, extensions, speed);
        }
    }
}
