package timekeeper.presenter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import timekeeper.core.internal.TimeKeeperProvider;
import timekeeper.core.model.Event;
import timekeeper.core.model.TimeKeeper;
import timekeeper.view.TimeKeeperActivity;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimeKeeperPresenterTest {

    @Mock
    private TimeKeeperActivity timeKeeperActivity;

    @Mock
    private TimeKeeperProvider timeKeeperProvider;

    @InjectMocks
    private TimeKeeperPresenter timeKeeperPresenter;

    @Test
    public void showTimekeeperAll_return_all_timekeeper() {
        //Set
        Date start = new Date();
        Date end = new Date();
        Event event = new Event("idEvent", "nameEvent", "descriptionEvent", start, end);
        Date start2 = new Date();
        Date end2 = new Date();
        Event event2 = new Event("idEvent2", "nameEvent2", "descriptionEvent2", start2, end2);
        List<Event> events = Arrays.asList(event, event2);
        List<TimeKeeper> timeKeepers = Arrays.asList(new TimeKeeper("id", "name", "description", events));
        when(timeKeeperProvider.findAll()).thenReturn(timeKeepers);
        //Test
        timeKeeperPresenter.showTimekeeperAll();
        //Assert
        verify(timeKeeperActivity).showAllTimeKeeper(eq(timeKeepers));
    }

}