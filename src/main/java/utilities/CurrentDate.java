package utilities;

import java.time.LocalDate;

public class CurrentDate {

	// *********Get Current Date And Increment Year*********
	public static String getCurrentDate_IncrementYear(int plus) {
		LocalDate localDate = LocalDate.now();
		return LocalDate.parse(localDate.toString()).plusYears(plus).toString();
	}

}
