package timekeeper.presenter;


import java.util.List;

import timekeeper.core.ITimeKeeperProvider;
import timekeeper.core.model.TimeKeeper;
import timekeeper.view.TimeKeeperActivity;

public class TimeKeeperPresenter {
    private final TimeKeeperActivity timeKeeperActivity;
    private final ITimeKeeperProvider timeKeeperProvider;

    public TimeKeeperPresenter(TimeKeeperActivity timeKeeperActivity, ITimeKeeperProvider timeKeeperProvider) {
        this.timeKeeperActivity = timeKeeperActivity;
        this.timeKeeperProvider = timeKeeperProvider;
    }

    public void showTimekeeperAll() {
        List<TimeKeeper> timeSheets = timeKeeperProvider.findAll();
        timeKeeperActivity.showAllTimeKeeper(timeSheets);
    }
}
