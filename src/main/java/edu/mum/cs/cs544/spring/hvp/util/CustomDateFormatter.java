package edu.mum.cs.cs544.spring.hvp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormatter {
	//@DateTimeFormat(pattern = "dd/mm/yyyy")
	private static final String DATE_PATTERN = "MM/dd/yyyy";

	public static String displayDateFormat(Date date) {
		DateFormat dFormat = new SimpleDateFormat(DATE_PATTERN);
		if (date != null) {			
			return dFormat.format(date);
		}
		return dFormat.format(new Date());
	}
}
