package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Link {

    @XStreamAsAttribute
    private String href;

    private String text;
    private String type;

    public Link(String href, String text, String type) {
        this.href = href;
        this.text = text;
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }
}
