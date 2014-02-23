package net.attwoodthomas.database.helper;

import net.attwoodthomas.yourtimetable.MainActivity;
import net.attwoodthomas.yourtimetable.SecondActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper  extends SQLiteOpenHelper {
	// Logcat tag
    private static final String LOG = "DatabaseHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "lessons";
 
  
 
    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_LESSONS = "CREATE TABLE lessons (Week VARCHAR(1), Day VARCHAR(10), Period1 VACHAR(20)," +
    		"Period2 VARCHAR(20),Period3 VARCHAR(20),Period4 VARCHAR(20),Period5 VARCHAR(20),Period6 VARCHAR(20));";
    
    private static final String INSERT_VALUES = "INSERT INTO lessons VALUES " +
    		"('A', 'Monday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music'), " +
    		"('A', 'Tuesday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('A', 'Wednesday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('A', 'Thursday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('A', 'Friday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('B', 'Monday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music'), " +
    		"('B', 'Tuesday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('B', 'Wednesday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('B', 'Thursday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music')," +
    		"('B', 'Friday', 'PE', 'PE', 'SE', 'Reading', 'Drama', 'Music');";
    		
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
 
        // creating required tables
        db.execSQL(CREATE_TABLE_LESSONS);
      	checkDB();

    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_LESSONS);
 
        // create new tables
        onCreate(db);
    }
    
    public void getLessons () {
    	
    	SQLiteDatabase db = this.getReadableDatabase();
    	db.execSQL(INSERT_VALUES);
    	Cursor c = db.rawQuery("SELECT Period1, Period2, Period3, Period4, Period5, Period6 FROM lessons WHERE Week = ? AND day = ?", new String[] {MainActivity.mWeek, MainActivity.mDay}); 
    	Log.d(LOG, "1");
    	c.moveToNext();
    	Log.d(LOG, "2");
    	SecondActivity.period1  = (c.getString(c.getColumnIndex("Period1")));
      	Log.d(LOG, "3");
    	SecondActivity.period2  = (c.getString(c.getColumnIndex("Period2")));
      	Log.d(LOG, "4");
    	SecondActivity.period3  = (c.getString(c.getColumnIndex("Period3")));
      	Log.d(LOG, "5");
    	SecondActivity.period4  = (c.getString(c.getColumnIndex("Period4")));
      	Log.d(LOG, "6");
    	SecondActivity.period5  = (c.getString(c.getColumnIndex("Period5")));
      	Log.d(LOG, "7");
    	SecondActivity.period6  = (c.getString(c.getColumnIndex("Period6")));
      	Log.d(LOG, "8");
    	// db.execSQL("SELECT period1, period2, period3, period4, period5, period6 FROM lessons WHERE week = " + MainActivity.mWeek + "AND day = " + MainActivity.mDay);
    	c.close();
    	
    }
    
    public void updateLessons (String week, String day, String period1,String period2,String period3,String period4,String period5,String period6) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	String delete_row = "DELETE FROM lessons WHERE week = '" + week + "' AND day = '" + day + "';";
    	String insert_row = "INSERT INTO lessons VALUES ('" + week + "', '" + day + "', '" + period1 + "', '" + period2 + "', '" + period3 + "', '" + period4+ "', '" + period5 + "', '" + period6 + "');";
    	db.execSQL(delete_row);
    	db.execSQL(insert_row);
    }
    
    public void checkDB () {
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor c = db.rawQuery("SELECT * FROM lessons", null);
    	if (c.moveToFirst()) {
    		Log.d(LOG, "not emtpy");
    	}
    	else {
    		Log.d(LOG, "emtpy");
    		db.execSQL(INSERT_VALUES);
    		db.close();
    	}
    	
    }
    


}
