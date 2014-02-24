package net.attwoodthomas.yourtimetable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static String mWeek;
	public static String mDay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final RadioGroup group1 = (RadioGroup) findViewById(R.id.radioGroup1);
		final RadioGroup group2 = (RadioGroup) findViewById(R.id.radioGroup2);
		Button getTimetable = (Button) findViewById(R.id.button1);
		Button updateTimetable = (Button) findViewById(R.id.button2);

		// Call Method

		getTimetable.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(MainActivity.this, "Getting Timetable", Toast.LENGTH_LONG).show();

				// Set Variables for checked button
				Log.d("Mian", "0.5");
				if (group1.getCheckedRadioButtonId() == 2131165187) {
					// Check if it is Week A
					mWeek = "A";
				}

				else { // Check if its Week B
					mWeek = "B";

				}

				if (group2.getCheckedRadioButtonId() == 2131165191) {
					// Check if its Monday
					mDay = "Monday";
				}

				else if (group2.getCheckedRadioButtonId() == 2131165192) {
					// Check if its Tuesday
					mDay = "Tuesday";
				}

				else if (group2.getCheckedRadioButtonId() == 2131165193) {
					// Check if its Wednesday
					mDay = "Wednesday";
				}

				else if (group2.getCheckedRadioButtonId() == 2131165194) {
					// Check if its Thursday
					mDay = "Thursday";
				}

				else {
					mDay = "Friday";
				}
				Log.d("Main", "1");
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);

			}
		});

		updateTimetable.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(MainActivity.this, "Update Timetable", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
