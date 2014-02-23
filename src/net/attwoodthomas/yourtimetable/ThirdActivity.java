package net.attwoodthomas.yourtimetable;

import net.attwoodthomas.database.helper.DatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends Activity {

	// Member Variables
		private Button mUpdateButton;
		private TextView mTitle;
		private EditText mPeriod1;
		private EditText mPeriod2;
		private EditText mPeriod3;
		private EditText mPeriod4;
		private EditText mPeriod5;
		private EditText mPeriod6;
		private String mWeek;
		private String mDay;
		private int mCounter = 0;
		private DatabaseHelper db = new DatabaseHelper(this);
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_third);
			mUpdateButton = (Button) findViewById(R.id.button31);
			mPeriod1 = (EditText) findViewById(R.id.editText31);
			mPeriod2 = (EditText) findViewById(R.id.editText32);
			mPeriod3 = (EditText) findViewById(R.id.editText33);
			mPeriod4 = (EditText) findViewById(R.id.editText34);
			mPeriod5 = (EditText) findViewById(R.id.editText35);
			mPeriod6 = (EditText) findViewById(R.id.editText36);
			mTitle = (TextView) findViewById(R.id.textView32);
			
			mUpdateButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// Set week and day
					if (mCounter < 5) {
						mWeek = "A";
					}
					
					else {
						mWeek = "B";
					}
					
					if (mCounter == 0 || mCounter == 5) {
						mDay = "Monday";
					}
					
					else if (mCounter == 1 || mCounter == 6) {
						mDay = "Tuesday";
					}
					
					else if (mCounter == 2 || mCounter == 7) {
						mDay = "Wednesday";
					}
					
					else if (mCounter == 3 || mCounter == 8) {
						mDay = "Thursday";
					}
					
					else {
						mDay = "Friday";
					}
					
					
					
					if (mCounter > 9) {
						Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
						startActivity(intent);
					}
					else {
						db.updateLessons(mWeek, mDay, mPeriod1.getText().toString(), mPeriod2.getText().toString(), mPeriod3.getText().toString(), mPeriod4.getText().toString(), mPeriod5.getText().toString(), mPeriod6.getText().toString());
						mCounter = mCounter + 1;
						mTitle.setText("Week " + mWeek + " " + mDay);
					}
					
					
					
				}
			});
		}
		
		public void onUpdate() {
			mCounter = 0;
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_third, menu);
		return true;
	}

}
