package com.who;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String dateStr="2015-15-12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
		Date date = sdf.parse(dateStr); 
		System.out.println(sdf.format(date));
	}

}
