package timekeeper.core.event.model;


import java.util.Date;

public class Event {

    private String id;
    private String name;
    private String description;
    private Date start;
    private Date end;

    public Event(String id, String name, String description, Date start, Date end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
