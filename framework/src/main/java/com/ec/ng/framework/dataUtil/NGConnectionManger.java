package com.ec.ng.framework.dataUtil;

import java.sql.Connection;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: NGConnectionManger.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: NGConnectionManger.java Jun 15, 2015 12:59:07 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class NGConnectionManger implements ConnectionManager
{
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return JDBCConnectionManager.getConnection();
	}

}

/*
*$Log: av-env.bat,v $
*/