package timekeeper.core.timesheet;

import java.util.List;

import timekeeper.core.timesheet.model.TimeSheet;

public interface ITimeSheetRepository {

    void put(TimeSheetRepositoryParam parameter);

    List<TimeSheet> get(String id);
}
