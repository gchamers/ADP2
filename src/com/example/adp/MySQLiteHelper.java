package com.example.adp;

import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	  public static final String TABLE_EXPENSES = "expenses";
	  public static final String COLUMN_ID_EXPNESES = "_id";
	  public static final String COLUMN_NAME_EXPENSES = "name";
	  public static final String COLUMN_AMOUNT_EXPENSES = "amount";
	  public static final String COLUMN_GROWTH_RATE_EXPENSES = "growth_rate";
	  public static final String COLUMN_BEGIN_YEAR_EXPENSES = "begin_year";
	  public static final String COLUMN_END_YEAR_EXPENSES = "end_year";
	  public static final String COLUMN_NAME_NOT_NULLABLE = "not null";
	  public static final String COLUMN_NAME_NULLABLE = "null";
	  
	  private static final String DATABASE_NAME = "ADP.db";
	  private static final int DATABASE_VERSION = 1;

	  private static final String DATABASE_CREATE = "create table " + TABLE_EXPENSES + "(" 
			  + COLUMN_ID_EXPNESES + " integer primary key autoincrement, "
			  + COLUMN_NAME_EXPENSES + " text " + COLUMN_NAME_NOT_NULLABLE
			  + COLUMN_AMOUNT_EXPENSES + " real " + COLUMN_NAME_NOT_NULLABLE
			  + COLUMN_GROWTH_RATE_EXPENSES + " real " + COLUMN_NAME_NOT_NULLABLE
			  + COLUMN_BEGIN_YEAR_EXPENSES + " integer " + COLUMN_NAME_NOT_NULLABLE
			  + COLUMN_END_YEAR_EXPENSES + " integer " + COLUMN_NAME_NOT_NULLABLE +");";

	  public MySQLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(MySQLiteHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
	    onCreate(db);
	  }
}
