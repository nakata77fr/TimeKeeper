package timekeeper.core.event;

import java.util.List;

import timekeeper.core.event.model.TimeSheet;

public interface ITimeSheetRepository {

    void put(TimeSheetRepositoryParam parameter);

    List<TimeSheet> get(String id);
}
