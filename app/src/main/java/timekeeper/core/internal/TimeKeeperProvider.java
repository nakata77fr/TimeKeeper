package timekeeper.core.internal;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import timekeeper.core.ITimeKeeperProvider;
import timekeeper.core.TimeKeeperProviderParam;
import timekeeper.core.model.Event;
import timekeeper.core.model.TimeKeeper;

public class TimeKeeperProvider implements ITimeKeeperProvider {

    @Override
    public void put(TimeKeeperProviderParam parameter) {
        List<Event> events = parameter.getEvents();
        new TimeKeeper(parameter.getId(), parameter.getName(), parameter.getDescription(), events);
        //put on database
    }

    @Override
    public TimeKeeper find(String id) {
        return null;
    }

    @Override
    public List<TimeKeeper> findAll() {
        Date start = new Date();
        Date end = new Date();
        Event event = new Event("idEvent", "nameEvent", "descriptionEvent", start, end);
        Date start2 = new Date();
        Date end2 = new Date();
        Event event2 = new Event("idEvent2", "nameEvent2", "descriptionEvent2", start2, end2);
        List<Event> events = Arrays.asList(event, event2);
        return Arrays.asList(new TimeKeeper("id", "name", "description", events));
    }

}
