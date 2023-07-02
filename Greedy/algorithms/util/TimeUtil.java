package algorithms.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {

	public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) {
		return new GregorianCalendar(year, month, date, hourOfDay, minute, second).getTime();
	}
}
