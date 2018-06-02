package com.techtransformers.lostnfound.Utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.techtransformers.lostnfound.constants.LostAndFoundConstants;

public class LostAndFoundUtility {

	public static Timestamp convertDateToTimeStamp(String dateInString) {

		SimpleDateFormat formatter = new SimpleDateFormat(LostAndFoundConstants.EN_DATE_FORMAT);
		Date date = new Date();
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Timestamp timeStamp = new Timestamp(date.getTime());
		return timeStamp;
	}
	
	public static String convertTimestampToDate(Timestamp dateInTimeStamp) {
		Date date = new Date();
		String formattedStringDate = LostAndFoundConstants.BLANK;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			if (dateInTimeStamp != null) {
				date = new Date(dateInTimeStamp.getTime());
				formattedStringDate = dateFormat.format(date);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return formattedStringDate;
	}
}
