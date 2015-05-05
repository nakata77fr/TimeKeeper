package timekeeper.core.model;

import java.util.List;

public class TimeKeeper {

    private String id;
    private String name;
    private String description;
    private List<Event> events;

    public TimeKeeper(String id, String name, String description, List<Event> events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.events = events;
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

    public List<Event> getEvents() {
        return events;
    }
}
