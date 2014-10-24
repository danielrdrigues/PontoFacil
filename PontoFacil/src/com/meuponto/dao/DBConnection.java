package com.meuponto.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnection extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "meu_ponto.db";
	private static final int DATABASE_VERSION = 1;

	public DBConnection(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS timecard (" + "  id INTEGER PRIMARY KEY AUTOINCREMENT, " + "  idTimeCard TEXT, "
				+ "  checkPointOne NUMERIC, " + "  checkPointTwo NUMERIC, " + "  checkPointThree NUMERIC, " + "  checkPointFour NUMERIC " + ")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
