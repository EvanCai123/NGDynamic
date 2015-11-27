package com.ec.ng.framework.configurationUtil;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: ApplicationContextLoad.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ApplicationContextLoad.java Jul 10, 2015 3:52:39 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class ApplicationContextLoad<T> implements ApplicationContextAware
{
	private ApplicationContext applicationContext = null;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	public ApplicationContext getApplicationContext()
	{
		return this.applicationContext;
	}
	
	public Object getBean (String beanName)
	{
		return this.applicationContext.getBean(beanName);
	}
	
	public Object getBean (Class<T> beanName)
	{
		return this.applicationContext.getBean(beanName);
	}

}

/*
*$Log: av-env.bat,v $
*/