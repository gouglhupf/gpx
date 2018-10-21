package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("rte")
public class Route {
    private String name;
    private String cmt;
    private String desc;
    @XStreamImplicit(itemFieldName = "link")
    private Link[] links;
    private UInteger number;
    private String type;
    private Extensions extensions;
    @XStreamImplicit(itemFieldName = "rtept")
    private WayPoint[] wayPoints;

    public Route(String name, String cmt, String desc, Link[] links, UInteger number, String type, Extensions extensions, WayPoint[] wayPoints) {
        this.name = name;
        this.cmt = cmt;
        this.desc = desc;
        this.links = links;
        this.number = number;
        this.type = type;
        this.extensions = extensions;
        this.wayPoints = wayPoints;
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

    public WayPoint[] getWayPoints() {
        return wayPoints;
    }

    public static class Builder {
        private String name;
        private String cmt;
        private String desc;
        private Link[] links;
        private UInteger number;
        private String type;
        private Extensions extensions;
        private WayPoint[] wayPoints;

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

        public Builder links(Link... links) {
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

        public Builder wayPoints(WayPoint... wayPoints) {
            this.wayPoints = wayPoints;
            return this;
        }

        public Route build() {
            return new Route(name, cmt, desc, links, number, type, extensions, wayPoints);
        }
    }
}
