package com.meuponto.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TimeCardDAO {

	private static final String TABLE_TIME_CARD = "timecard";

	private SQLiteDatabase db;
	private DBConnection sqliteOpenHelper;

	private static final String SQL_ARG = " =  ?";

	private static final String ID_TIMECARD = "idTimeCard";

	private static final String CHECK_POINT_ONE = "checkPointOne";
	private static final String CHECK_POINT_TWO = "checkPointTwo";
	private static final String CHECK_POINT_THREE = "checkPointThree";
	private static final String CHECK_POINT_FOUR = "checkPointFour";

	private SimpleDateFormat simpleFormatter = new SimpleDateFormat(
			"dd/MM/yyyy", Locale.getDefault());

	public TimeCardDAO(Context context) {
		sqliteOpenHelper = new DBConnection(context);
	}

	protected void open() throws SQLException {
		db = sqliteOpenHelper.getWritableDatabase();
	}

	protected void close() {
		sqliteOpenHelper.close();
	}

	public void clearAll() {
		open();
		try {
			db.delete(TABLE_TIME_CARD, "", null);
		} finally {
			close();
		}
	}

	public void insertCheckPoint(Long checkPointOne) throws SQLException {
		this.open();

		try {
			ContentValues values = new ContentValues();
			values.put(ID_TIMECARD,
					simpleFormatter.format(new Date(checkPointOne)));
			values.put(CHECK_POINT_ONE, checkPointOne);

			db.insert(TABLE_TIME_CARD, null, values);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			close();
		}
	}

	private String getCheckPointTime(int orderCheckPoint) {
		String result = "";

		switch (orderCheckPoint) {
		case 1:
			result = CHECK_POINT_ONE;
			break;
		case 2:
			result = CHECK_POINT_TWO;
			break;
		case 3:
			result = CHECK_POINT_THREE;
			break;
		case 4:
			result = CHECK_POINT_FOUR;
			break;
		default:
			break;
		}

		return result;

	}

	public void updateCheckPoint(int orderCheckPoint, Long checkPoint) {
		this.open();

		try {
			Date date = new Date(checkPoint);
			String dateFormatted = simpleFormatter.format(date);

			ContentValues values = new ContentValues();
			String checkPointOrder = getCheckPointTime(orderCheckPoint);
			values.put(checkPointOrder, checkPoint);

			final String WHERE_CLAUSE = ID_TIMECARD + SQL_ARG;
			final String[] WHERE_ARGS = new String[] { dateFormatted };

			db.update(TABLE_TIME_CARD, values, WHERE_CLAUSE, WHERE_ARGS);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
