package gouglhupf.gpx;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.mapper.MapperWrapper;

import java.io.InputStream;
import java.io.OutputStream;

@XStreamAlias("gpx")
public class GPX {

    private static XStream sInstance;

    @XStreamAsAttribute
    private String xmlns = "http://www.topografix.com/GPX/1/1";
    @XStreamAsAttribute
    private String version = "1.1";
    @XStreamAsAttribute
    private String creator = "XStream-GPX-Abstraction";
    @XStreamAsAttribute
    @XStreamAlias("xmlns:xsi")
    private String xmlns_xsi = "http://www.w3.org/2001/XMLSchema-instance";
    @XStreamAlias("xsi:schemaLocation")
    @XStreamAsAttribute
    private String xsi_schemaLocation = "http://www.topografix.com/GPX/1/1 http://www.topografix.com/GPX/1/1/gpx.xsd";
    private Metadata metadata;
    @XStreamImplicit(itemFieldName = "wpt")
    private WayPoint[] wayPoints;
    @XStreamImplicit(itemFieldName = "rte")
    private Route[] routes;
    @XStreamImplicit(itemFieldName = "trk")
    private Track[] tracks;
    private Extensions extensions;

    public GPX(Metadata metadata, WayPoint[] wayPoints, Route[] routes, Track[] tracks, Extensions extensions) {
        this.metadata = metadata;
        this.wayPoints = wayPoints;
        this.routes = routes;
        this.tracks = tracks;
        this.extensions = extensions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static void toXML(GPX gpx, OutputStream stream) {
        getXStream().toXML(gpx, stream);
    }

    public static GPX fromXML(InputStream stream) {
        return (GPX) getXStream().fromXML(stream);
    }

    private static XStream getXStream() {
        if (sInstance != null)
            return sInstance;

        XStream xstream = new XStream() {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Extensions.class)
                            try {
                                return Extensions.class.getDeclaredField(fieldName) != null;
                            } catch (NoSuchFieldException e) {
                                return false;
                            }

                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };

        xstream.processAnnotations(GPX.class);

        xstream.registerConverter(new ZonedDateTimeConverter());

        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypesByWildcard(new String[]{"gouglhupf.gpx.**"});

        sInstance = xstream;

        return xstream;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public WayPoint[] getWayPoints() {
        return wayPoints;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public static class Builder {
        private Metadata metadata;
        private WayPoint[] wayPoints;
        private Route[] routes;
        private Track[] tracks;
        private Extensions extensions;

        public Builder metadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder wayPoints(WayPoint... wayPoints) {
            this.wayPoints = wayPoints;
            return this;
        }

        public Builder routes(Route... routes) {
            this.routes = routes;
            return this;
        }

        public Builder tracks(Track... tracks) {
            this.tracks = tracks;
            return this;
        }

        public Builder extensions(Extensions extensions) {
            this.extensions = extensions;
            return this;
        }

        public GPX build() {
            return new GPX(metadata, wayPoints, routes, tracks, extensions);
        }
    }
}
