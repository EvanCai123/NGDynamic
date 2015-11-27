package com.ec.ng.entity.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityDaoTest.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityDaoTest.java Jul 10, 2015 1:15:22 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EntityDaoTest extends TestCase
{
	 @Autowired
	 ApplicationContext ctx;
	 
	 @Autowired
	 EntityDao entityDao;

    @Test
	public void testApp()
	 {
		//EntityDao entityDao = (EntityDao)ctx.getBean("entityDao");
		 //System.out.print(entityDao.create(null));
	 }
}

/*
*$Log: av-env.bat,v $
*/