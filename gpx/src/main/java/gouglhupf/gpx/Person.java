package gouglhupf.gpx;

public class Person {
    private String name;
    private Email email;
    private Link link;

    public Person(String name, Email email, Link link) {
        this.name = name;
        this.email = email;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Link getLink() {
        return link;
    }
}
