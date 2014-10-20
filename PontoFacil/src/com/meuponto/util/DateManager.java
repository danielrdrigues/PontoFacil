package com.meuponto.util;

import java.util.Calendar;

public class DateManager {

	private static Calendar currentDate = Calendar.getInstance();

	public static int getCurrentDay() {
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		return day;
	}

}
