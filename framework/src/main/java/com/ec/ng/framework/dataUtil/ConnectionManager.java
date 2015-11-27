package com.ec.ng.framework.dataUtil;

import java.sql.Connection;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: ConnectionManager.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ConnectionManager.java Jun 15, 2015 12:51:29 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface ConnectionManager 
{
	public Connection getConnection();
}

/*
*$Log: av-env.bat,v $
*/