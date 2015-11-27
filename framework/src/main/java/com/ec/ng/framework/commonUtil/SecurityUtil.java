package com.ec.ng.framework.commonUtil;

import java.security.SecureRandom;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: SecurityUtil.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: SecurityUtil.java Jul 20, 2015 8:04:04 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class SecurityUtil {

	private static Object lockObject = new Object();
	private static SecureRandom secureRandom = new SecureRandom();

	public static String generateSessionID()
	{
		synchronized(lockObject)
		{
			//Get 1024 random bits
			byte [] bytes = new byte[1024];
			secureRandom.nextBytes(bytes);
			StringBuilder s = new StringBuilder();
			for (int x= 0; x < 20; x++)
			{
				s.append(secureRandom.nextInt(10));
			}
			return s.toString();
		}
	}
}

/*
*$Log: av-env.bat,v $
*/