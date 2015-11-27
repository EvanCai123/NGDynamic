package com.ec.ng.framework.dataUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: JDBCConnectionManager.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: JDBCConnectionManager.java Jun 15, 2015 1:02:22 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class JDBCConnectionManager 
{
	public static Connection getConnection()
	{
		Connection conn = null;
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1/ng";
		Properties properties = new Properties();
		properties.setProperty("user", "ng");
		properties.setProperty("password", "ng123");
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, properties);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}

/*
*$Log: av-env.bat,v $
*/