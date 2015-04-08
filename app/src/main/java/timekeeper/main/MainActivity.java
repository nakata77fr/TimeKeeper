package timekeeper.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import timekeeper.core.timesheet.ITimeSheetRepository;
import timekeeper.core.timesheet.TimeSheetRepository;
import timekeeper.core.timesheet.TimeSheetRepositoryParam;
import timekeeper.core.timesheet.model.Event;
import timekeeper.core.timesheet.model.TimeSheet;


public class MainActivity extends Activity {

    private ITimeSheetRepository timeSheetService = new TimeSheetRepository();

    private EditText nameTimeSheetEditView;
    private EditText descriptionTimeSheetEditView;
    private EditText nameEditView;
    private EditText descriptionEditView;
    private EditText startEditView;
    private EditText endEditView;
    private Button insertBtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTimeSheetEditView = (EditText) findViewById(R.id.id_timesheetname_txt);
        descriptionTimeSheetEditView = (EditText) findViewById(R.id.id_timesheetdescription_txt);
        nameEditView = (EditText) findViewById(R.id.id_name_txt);
        descriptionEditView = (EditText) findViewById(R.id.id_description_txt);
        startEditView = (EditText) findViewById(R.id.id_start_txt);
        endEditView = (EditText) findViewById(R.id.id_end_text);
        insertBtnView = (Button) findViewById(R.id.id_insert_btn);

        List<TimeSheet> timeSheets = timeSheetService.get("id");

        TimeSheet timeSheet = timeSheets.get(0);
        String nameTimeSheet = timeSheet.getName();
        nameTimeSheetEditView.setText(nameTimeSheet);
        String descriptionTimeSheet = timeSheet.getDescription();
        descriptionTimeSheetEditView.setText(descriptionTimeSheet);

        List<Event> events = timeSheet.getEvents();
        Event event = events.get(0);
        String name = event.getName();
        final String description = event.getDescription();
        String start = event.getStart().toString();
        String end = event.getEnd().toString();
        nameEditView.setText(name);
        descriptionEditView.setText(description);
        startEditView.setText(start);
        endEditView.setText(end);


        insertBtnView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nameTimeSheet = nameTimeSheetEditView.getText().toString();
                String descriptionTimeSheet = descriptionTimeSheetEditView.getText().toString();

                String nameEvent = nameEditView.getText().toString();
                String descriptionEvent = descriptionEditView.getText().toString();
                Date start = new Date();
                Date end = new Date();

                Event event = new Event("idTestEvent", nameEvent, descriptionEvent, start, end);
                TimeSheetRepositoryParam timeSheetRepositoryParam = new TimeSheetRepositoryParam("idTestTimeSheet", nameTimeSheet, descriptionTimeSheet, Arrays.asList(event));
                timeSheetService.put(timeSheetRepositoryParam);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
