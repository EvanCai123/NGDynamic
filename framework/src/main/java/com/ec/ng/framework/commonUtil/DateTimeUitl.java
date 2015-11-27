package com.ec.ng.framework.commonUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: DateTimeUitl.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DateTimeUitl.java Jul 15, 2015 9:10:31 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class DateTimeUitl 
{
	private static Calendar calendar = Calendar.getInstance();
	
	public static Date getDateTime (Date processDate)
	{
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(processDate);
	  	
	  	return processDate;
	}
	
	public static Date getCurrentDate ()
	{
		return new Date(calendar.getTime().getTime());
	}
}

/*
*$Log: av-env.bat,v $
*/