package com.farmatodo.reportes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalendarFilter {

	 public static void main(String[] args) {

			String dateIn = "09-10-2017"; // date example
			Calendar hoy = Calendar.getInstance();// get the actual day
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy"); // date format
			Date d1 = null;
			try {
				d1 = format.parse(dateIn); // here we put the date in
			} catch (ParseException e) {
				e.printStackTrace();
			}

			System.out.println(getDateDiff(d1,hoy.getTime(),TimeUnit.DAYS));
			
			if (getDateDiff(d1, hoy.getTime(), TimeUnit.DAYS)>45) { // if is more than 45 days we put today-45 like a limit
				
				hoy.add(Calendar.DATE, -45);
				System.out.println(format.format(hoy.getTime()));
			}else
				System.out.println("BE COOL, ESTAS DENTRO DE LOS 45 DIAS");
			
		  }
	 
	 public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		    long diffInMillies = date2.getTime() - date1.getTime(); // we compare the dates differences
		    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
		}

}
