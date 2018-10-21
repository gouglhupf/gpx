package gouglhupf.gpx;

import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;

abstract class GenericBuilder<B extends GenericBuilder> {
    String name;
    String desc;
    Link[] links;
    ZonedDateTime time;
    Extensions extensions;

    @SuppressWarnings("unchecked")
    public B name(String name) {
        this.name = name;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B desc(String desc) {
        this.desc = desc;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B links(Link... links) {
        this.links = links;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B time(ZonedDateTime time) {
        this.time = time;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B time(Instant instant, ZoneId zone) {
        this.time = instant != null ? ZonedDateTime.ofInstant(instant, zone != null ? zone : ZoneOffset.UTC) : null;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B time(long millis, ZoneId zone) {
        this.time = ZonedDateTime.ofInstant(Instant.ofEpochMilli(millis), zone != null ? zone : ZoneOffset.UTC);
        return (B) this;
    }

    public B time(Instant instant) {
        return this.time(instant, null);
    }

    public B time(long millis) {
        return this.time(Instant.ofEpochMilli(millis));
    }

    @SuppressWarnings("unchecked")
    public B extensions(Extensions extensions) {
        this.extensions = extensions;
        return (B) this;
    }
}
