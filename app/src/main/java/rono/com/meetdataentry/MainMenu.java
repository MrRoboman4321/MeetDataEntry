package rono.com.meetdataentry;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainMenu extends AppCompatActivity {
    Calendar myCalendar = Calendar.getInstance();
    EditText meetDate;

    public static final String TEAM_ONE = "rono.com.meetdataentry.TEAMONE";
    public static final String TEAM_TWO = "rono.com.meetdataentry.TEAMTWO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        meetDate = (EditText) findViewById(R.id.meetDate);

        meetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainMenu.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        meetDate.setText(sdf.format(myCalendar.getTime()));
    }

    public void startEvents(View view) {
        Intent intent = new Intent(this, EventActivity.class);
        EditText team1 = (EditText) findViewById(R.id.team2);
        EditText team2 = (EditText) findViewById(R.id.team2);
        intent.putExtra(TEAM_ONE, team1.getText().toString());
        intent.putExtra(TEAM_TWO, team2.getText().toString());
        startActivity(intent);
    }
}
