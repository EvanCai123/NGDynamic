package com.ec.ng.framework.dataUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: DBResultSetProcessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DBResultSetProcessor.java Jul 15, 2015 7:30:36 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface DBResultSetProcessor<E>
{
	/**
	 * Method processResultSetRow. The implmenter can decide how to process the
	 * current row of the ResultSet. Usually, the DAOOracle implements this API
	 * to convert a result set row into a datamodel.
	 * 
	 * @param rs
	 *            The SQL execute result set from database.
	 * @return Object The process result. It's usually a data model.
	 * @throws SQLException
	 *             Due to any data access exception encountered.
	 */
	public E processResultSetRow(ResultSet rs) throws SQLException;
}

/*
*$Log: av-env.bat,v $
*/