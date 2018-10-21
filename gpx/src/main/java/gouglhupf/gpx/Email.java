package gouglhupf.gpx;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Email {
    @XStreamAsAttribute
    private String id;
    @XStreamAsAttribute
    private String domain;

    public Email(String id, String domain) {
        this.id = id;
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }
}
