package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

// TODO Builder
@XStreamAlias("trkseg")
public class TrackSegment {
    @XStreamImplicit(itemFieldName = "trkpt")
    private WayPoint[] wayPoints;
    private Extensions extensions;

    public TrackSegment(WayPoint[] wayPoints, Extensions extensions) {
        this.wayPoints = wayPoints;
        this.extensions = extensions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public WayPoint[] getWayPoints() {
        return wayPoints;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public static class Builder {
        private WayPoint[] wayPoints;
        private Extensions extensions;

        public Builder wayPoints(WayPoint... wayPoints) {
            this.wayPoints = wayPoints;
            return this;
        }

        public Builder extensions(Extensions extensions) {
            this.extensions = extensions;
            return this;
        }

        public TrackSegment build() {
            return new TrackSegment(wayPoints, extensions);
        }
    }
}
