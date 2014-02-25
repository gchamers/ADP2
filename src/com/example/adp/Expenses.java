package com.example.adp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Expenses extends Activity {

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expenses);
		final Context context = this;
		
		MySQLiteHelper my_db_helper = new MySQLiteHelper(context);
		SQLiteDatabase db = my_db_helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_NAME_EXPENSES, "Garrett Hamers");
		values.put(MySQLiteHelper.COLUMN_AMOUNT_EXPENSES, 1000);
		values.put(MySQLiteHelper.COLUMN_GROWTH_RATE_EXPENSES, 3);
		values.put(MySQLiteHelper.COLUMN_BEGIN_YEAR_EXPENSES, 2013);
		values.put(MySQLiteHelper.COLUMN_END_YEAR_EXPENSES, 2015);
		
		long row_id = db.insert(MySQLiteHelper.TABLE_EXPENSES, MySQLiteHelper.COLUMN_NAME_NULLABLE, values);
	}
	

	
}
