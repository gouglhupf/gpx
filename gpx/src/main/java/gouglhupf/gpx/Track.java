package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("trk")
public class Track {
    private String name;
    private String cmt;
    private String desc;
    private String src;
    @XStreamImplicit(itemFieldName = "link")
    private Link[] links;
    private UInteger number;
    private String type;
    private Extensions extensions;
    @XStreamImplicit(itemFieldName = "trkseg")
    private TrackSegment[] trackSegments;

    public Track(String name, String cmt, String desc, String src, Link[] links, UInteger number, String type, Extensions extensions, TrackSegment[] trackSegments) {
        this.name = name;
        this.cmt = cmt;
        this.desc = desc;
        this.src = src;
        this.links = links;
        this.number = number;
        this.type = type;
        this.extensions = extensions;
        this.trackSegments = trackSegments;
    }

    public static Builder builder() {
        return new Builder();
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

    public UInteger getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public TrackSegment[] getTrackSegments() {
        return trackSegments;
    }

    public static class Builder {
        private String name;
        private String cmt;
        private String desc;
        private String src;
        private Link[] links;
        private UInteger number;
        private String type;
        private Extensions extensions;
        private TrackSegment[] trackSegments;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cmt(String cmt) {
            this.cmt = cmt;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder src(String src) {
            this.src = src;
            return this;
        }

        public Builder links(Link[] links) {
            this.links = links;
            return this;
        }

        public Builder number(UInteger number) {
            this.number = number;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder extensions(Extensions extensions) {
            this.extensions = extensions;
            return this;
        }

        public Builder trackSegments(TrackSegment... trackSegments) {
            this.trackSegments = trackSegments;
            return this;
        }

        public Track build() {
            return new Track(name, cmt, desc, src, links, number, type, extensions, trackSegments);
        }
    }
}
