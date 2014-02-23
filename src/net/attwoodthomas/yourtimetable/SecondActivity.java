package net.attwoodthomas.yourtimetable;

import net.attwoodthomas.database.helper.DatabaseHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

	public static String period1;
	public static String period2;
	public static String period3;
	public static String period4;
	public static String period5;
	public static String period6;
	
	private String TAG = "SecondActivity";
	
	private TextView mPeriod1TextView;
	private TextView mPeriod2TextView;
	private TextView mPeriod3TextView;
	private TextView mPeriod4TextView;
	private TextView mPeriod5TextView;
	private TextView mPeriod6TextView;
	private Button mGoBackButton;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		mPeriod1TextView = (TextView) findViewById(R.id.textView23);
		mPeriod2TextView = (TextView) findViewById(R.id.textView25);
		mPeriod3TextView = (TextView) findViewById(R.id.textView27);
		mPeriod4TextView = (TextView) findViewById(R.id.textView29);
		mPeriod5TextView = (TextView) findViewById(R.id.textView211);
		mPeriod6TextView = (TextView) findViewById(R.id.textView213);
		mGoBackButton = (Button) findViewById(R.id.button21);
		
		mGoBackButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public void onResume() {
		super.onResume();
		DatabaseHelper db = new DatabaseHelper(this);
		db.getLessons();
		mPeriod1TextView.setText(period1);
		mPeriod2TextView.setText(period2);
		mPeriod3TextView.setText(period3);
		mPeriod4TextView.setText(period4);
		mPeriod5TextView.setText(period5);
		mPeriod6TextView.setText(period6);
	}
	
	@Override
	protected void onStop() {
	    Log.w(TAG, "App stopped");

	    super.onStop();
	}

	@Override
	protected void onDestroy() {
	    Log.w(TAG, "App destoryed");

	    super.onDestroy();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_second, menu);
		return true;
	}

}
