package timekeeper.core.event;


import java.util.List;

import timekeeper.core.event.model.Event;

public class TimeSheetRepositoryParam {

    private String id;
    private String name;
    private String description;
    private List<Event> events;

    public TimeSheetRepositoryParam(String id, String name, String description, List<Event> events) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.events = events;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheetRepositoryParam that = (TimeSheetRepositoryParam) o;

        if (!description.equals(that.description)) return false;
        if (!events.equals(that.events)) return false;
        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + events.hashCode();
        return result;
    }
}
