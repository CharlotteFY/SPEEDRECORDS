package com.example.speedrecords;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.speedrecords.db.AppDatabase;
import com.example.speedrecords.model.User;
import com.example.speedrecords.util.AppExecutors;
import com.example.speedrecords.util.DateFormatter;

import java.util.Calendar;
import java.util.Date;

public class AddUserActivity extends AppCompatActivity {

  private Calendar mBirthDateCalendar = Calendar.getInstance();
  private Calendar mSomeTimeCalendar = Calendar.getInstance();
  private EditText mBirthDateEditText, mSomeTimeEditText;
  private String distance,duration;
  private double speed;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_user);
    EditText distanceEditText = findViewById(R.id.editText_distance);
    EditText editText_duration = findViewById(R.id.editText_duration);
    String distancenumText = distanceEditText.getText().toString();
    distance = distancenumText;
    int numdistance = Integer.parseInt(distancenumText);
    String durationnumText = editText_duration.getText().toString();
    duration = durationnumText;
    int numduration = Integer.parseInt(durationnumText);
    double speed = (numdistance*numduration) * 3.6;

    Button saveButton = findViewById(R.id.save_button);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // อ่านค่าจากช่อง first_name_edit_text, last_name_edit_text
        //double speed = (numdistance*numduration) * 3.6;
        String distanceEdit = distance;
        String durationEdit = duration;
        int gender;
        boolean single;

        final User user = new User(0,distanceEdit,durationEdit);

        AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
          @Override
          public void run() { // worker thread
            AppDatabase db = AppDatabase.getInstance(AddUserActivity.this);
            db.userDao().addUser(user);
            finish();
          }
        });
      }
    });
  }
}
