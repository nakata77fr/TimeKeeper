package timekeeper.core;

import java.util.List;

import timekeeper.core.model.TimeKeeper;

public interface ITimeKeeperProvider {

    void put(TimeKeeperProviderParam parameter);

    TimeKeeper find(String id);

    List<TimeKeeper> findAll();
}
