package timekeeper.core.timesheet;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import timekeeper.core.timesheet.model.Event;
import timekeeper.core.timesheet.model.TimeSheet;

public class TimeSheetRepository implements ITimeSheetRepository {

    @Override
    public void put(TimeSheetRepositoryParam parameter) {
        List<Event> events = parameter.getEvents();
        new TimeSheet(parameter.getId(), parameter.getName(), parameter.getDescription(), events);
        //put on database
    }

    @Override
    public List<TimeSheet> get(String id) {
        Date start = new Date();
        Date end = new Date();
        Event event = new Event("idEvent", "nameEvent", "descriptionEvent", start, end);
        Date start2 = new Date();
        Date end2 = new Date();
        Event event2 = new Event("idEvent2", "nameEvent2", "descriptionEvent2", start2, end2);
        List<Event> events = Arrays.asList(event, event2);
        return Arrays.asList(new TimeSheet("id", "name", "description", events));
    }

}
