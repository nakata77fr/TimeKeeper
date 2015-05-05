package timekeeper.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import timekeeper.core.internal.TimeKeeperProvider;
import timekeeper.core.model.TimeKeeper;
import timekeeper.presenter.TimeKeeperPresenter;

public class TimeKeeperActivity extends Activity {

    private TimeKeeperAdapter timeKeeperAdapter;
    private TimeKeeperPresenter timeKeeperPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeKeeperPresenter = new TimeKeeperPresenter(this, new TimeKeeperProvider());
        ListView listView = (ListView) findViewById(R.id.list);
        timeKeeperAdapter = new TimeKeeperAdapter();
        listView.setAdapter(timeKeeperAdapter);
        timeKeeperPresenter.showTimekeeperAll();

    }

    public void showAllTimeKeeper(List<TimeKeeper> timeSheets) {
        timeKeeperAdapter.setTimeKeepers(timeSheets);
    }

    private class TimeKeeperAdapter extends BaseAdapter {

        private List<TimeKeeper> timeKeepers = new ArrayList<>();

        @Override
        public int getCount() {
            return timeKeepers.size();
        }

        @Override
        public TimeKeeper getItem(int position) {
            return timeKeepers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).hashCode();
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public TextView getView(int position, View convertView, ViewGroup viewGroup) {
            final TextView view;
            if (convertView == null) {
                view = new TextView(TimeKeeperActivity.this);
                view.setTextSize(20f);
                view.setPadding(30, 30, 30, 30);
            } else {
                view = (TextView) convertView;
            }
            view.setText(timeKeepers.get(position).getName() + "//" + timeKeepers.get(position).getDescription());
            return view;
        }

        public void setTimeKeepers(List<TimeKeeper> timeKeepers) {
            this.timeKeepers.clear();
            this.timeKeepers.addAll(timeKeepers);
            notifyDataSetChanged();
        }
    }
}
