package com.ec.ng.framework.dataUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: DefaultDBResultSetProcessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DefaultDBResultSetProcessor.java Jun 15, 2015 5:11:00 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class DefaultDBResultSetProcessor 
{

	public Map<String, Object> processResultSetRow(ResultSet rs) throws SQLException
	{
		ResultSetMetaData meta = rs.getMetaData();
		int numcols = meta.getColumnCount();
		Map<String, Object> record = new HashMap<String, Object>();
		
		// to deal the case of "select 1 from ..." 
		if (numcols == 1)
		{
			String columnName = meta.getColumnName(1);
			Object value = rs.getObject(1);
			if (value instanceof Date)
			{
				value = rs.getTimestamp(1);
			}
			record.put(columnName, value);
			return record;
		}
		for (int i = 0; i < numcols; i++)
		{
			String columnName = meta.getColumnName(i + 1);
			Object value =null;
			// to deal the case like "select 1 as 'a', column2 from ..."
			if (columnName.indexOf(' ') > 0 || columnName.trim().length() == 0)
			{
				value  = rs.getObject(i + 1);
				if (value instanceof Date)
				{
					value= rs.getTimestamp(i + 1);
				}
			}
			else
			{
				value = rs.getObject(columnName.trim());
				if (value instanceof Date)
				{
					value = rs.getTimestamp(columnName.trim());
				}
			}
			record.put(columnName, value);
		}
		return record;
	}
}

/*
*$Log: av-env.bat,v $
*/