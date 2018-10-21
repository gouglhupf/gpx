package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import org.threeten.bp.ZonedDateTime;

@XStreamAlias("metadata")
public class Metadata {
    private String name;
    private String desc;
    private Person author;
    private String copyright;
    @XStreamImplicit(itemFieldName = "link")
    private Link[] links;
    private ZonedDateTime time;
    private String keywords;
    private Bounds bounds;
    private Extensions extensions;

    public Metadata(String name, String desc, Person author, String copyright, Link[] links, ZonedDateTime time, String keywords, Bounds bounds, Extensions extensions) {
        this.name = name;
        this.desc = desc;
        this.author = author;
        this.copyright = copyright;
        this.links = links;
        this.time = time;
        this.keywords = keywords;
        this.bounds = bounds;
        this.extensions = extensions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Person getAuthor() {
        return author;
    }

    public String getCopyright() {
        return copyright;
    }

    public Link[] getLinks() {
        return links;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public String getKeywords() {
        return keywords;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public static class Builder extends GenericBuilder<Builder> {
        private Person author;
        private String copyright;
        private String keywords;
        private Bounds bounds;

        public Builder author(Person author) {
            this.author = author;
            return this;
        }

        public Builder copyright(String copyright) {
            this.copyright = copyright;
            return this;
        }

        public Builder keywords(String keywords) {
            this.keywords = keywords;
            return this;
        }

        public Builder bounds(Bounds bounds) {
            this.bounds = bounds;
            return this;
        }

        public Metadata build() {
            return new Metadata(name, desc, author, copyright, links, time, keywords, bounds, extensions);
        }
    }
}
