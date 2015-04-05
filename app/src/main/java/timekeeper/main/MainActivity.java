package timekeeper.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import timekeeper.core.event.ITimeSheetRepository;
import timekeeper.core.event.TimeSheetRepository;
import timekeeper.core.event.model.Event;
import timekeeper.core.event.model.TimeSheet;


public class MainActivity extends Activity {

    private ITimeSheetRepository timeSheetService = new TimeSheetRepository();

    private EditText nameEditView = (EditText) findViewById(R.id.id_name_txt);
    private EditText descriptionEditView = (EditText) findViewById(R.id.id_description_txt);
    private EditText startEditView = (EditText) findViewById(R.id.id_start_txt);
    private EditText endEditView = (EditText) findViewById(R.id.id_end_text);
    private Button insertBtnView = (Button) findViewById(R.id.id_insert_btn);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TimeSheet> timeSheets = timeSheetService.get("id");
        List<Event> events = timeSheets.get(0).getEvents();
        Event event = events.get(0);
        String name = event.getName();
        String description = event.getDescription();
        String start = event.getStart().toString();
        String end = event.getEnd().toString();

        nameEditView.setText(name);
        descriptionEditView.setText(description);
        startEditView.setText(start);
        endEditView.setText(end);
        insertBtnView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

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
