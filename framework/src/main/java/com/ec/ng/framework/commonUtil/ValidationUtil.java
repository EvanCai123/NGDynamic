package com.ec.ng.framework.commonUtil;

import java.util.Map;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: ValidationUtil.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ValidationUtil.java Jul 20, 2015 8:15:20 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class ValidationUtil {

	public static boolean isEmpty(String str)
	{
		if(str==null || str=="")
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str)
	{
		if(str==null || str=="")
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static boolean isEmpty(Map<String, String> mapObject)
	{
		if(mapObject==null || mapObject.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isNotEmpty(Map<String, String> mapObject)
	{
		if(mapObject==null || mapObject.size()==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

/*
*$Log: av-env.bat,v $
*/