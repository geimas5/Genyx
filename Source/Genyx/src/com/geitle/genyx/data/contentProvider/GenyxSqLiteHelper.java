package com.geitle.genyx.data.contentProvider;

import java.io.InputStream;

import com.geitle.genyx.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GenyxSqLiteHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "genyx.db";
	private static final int DATABASE_VERSION = 1;
	
	private Context context;
	
	public GenyxSqLiteHelper(Context context, CursorFactory factory) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
	    runUpdateScript(database, R.raw.createdatabase);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// not possible.... yet! ;)
	}	
	
	
	private void runUpdateScript(SQLiteDatabase db, int resourceId){
		InputStream stream = this.context.getResources().openRawResource(R.raw.createdatabase);
		String sql = convertStreamToString(stream);
		
		for(String statement : sql.split(";")){
			db.execSQL(statement);
		}
	}
	
	private static String convertStreamToString(InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
}
