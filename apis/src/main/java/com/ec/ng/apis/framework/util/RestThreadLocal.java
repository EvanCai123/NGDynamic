package com.ec.ng.apis.framework.util;

import com.ec.ng.framework.model.ThreadLocalModel;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: WebThreadLocal.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: WebThreadLocal.java Jul 21, 2015 9:08:12 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class RestThreadLocal {

	private static ThreadLocal<ThreadLocalModel> threadLocal = new ThreadLocal<ThreadLocalModel>();

	public static ThreadLocalModel getThreadLocal()
	{
		return threadLocal.get();
	}

	public static void setThreadLocal(ThreadLocalModel threadLocalModel)
	{
		threadLocal.set(threadLocalModel);
	}

	public static String getOwner()
	{
		if (threadLocal.get() == null)
		{
			return null;
		}
		else
		{
			return threadLocal.get().getOwner();
		}
	}
	
	public static String getUserId()
	{
		if (threadLocal.get() == null)
		{
			return null;
		}
		else
		{
			return threadLocal.get().getUserId();
		}
	}
	
	public static String getUserName()
	{
		if (threadLocal.get() == null)
		{
			return null;
		}
		else
		{
			return threadLocal.get().getUserName();
		}
	}
	
	public static String getIp()
	{
		if (threadLocal.get() == null)
		{
			return null;
		}
		else
		{
			return threadLocal.get().getIp();
		}
	}
	
	public static void setOwner(String owner)
	{
		ThreadLocalModel model = threadLocal.get();
		if (model == null)
		{
			model = new ThreadLocalModel();
		}
		model.setOwner(owner);
		threadLocal.set(model);
	}
	
	public static void setUserId(String userId)
	{
		ThreadLocalModel model = threadLocal.get();
		if (model == null)
		{
			model = new ThreadLocalModel();
		}
		model.setOwner(userId);
		threadLocal.set(model);
	}
	
	public static void setUserName(String userName)
	{
		ThreadLocalModel model = threadLocal.get();
		if (model == null)
		{
			model = new ThreadLocalModel();
		}
		model.setUserName(userName);
		threadLocal.set(model);
	}
	
	public static void setIp(String ip)
	{
		ThreadLocalModel model = threadLocal.get();
		if (model == null)
		{
			model = new ThreadLocalModel();
		}
		model.setIp(ip);
		threadLocal.set(model);
	}
	
	public static void clean()
	{
		ThreadLocalModel model = threadLocal.get();
		if (model != null)
		{
			model.clean();
		}
	}
}

/*
*$Log: av-env.bat,v $
*/