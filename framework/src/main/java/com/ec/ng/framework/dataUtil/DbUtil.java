package com.ec.ng.framework.dataUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: DbUtil.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DbUtil.java Jun 15, 2015 4:14:09 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class DbUtil 
{
	public static void setParameters(PreparedStatement pstmt, Object[] parameters) throws SQLException
	{
		if (parameters != null)
		{
			for (int i = 0; i < parameters.length; i++)
			{
				if (parameters[i] == null || "".equals(parameters[i]))
				{
					pstmt.setString(i + 1, null);
				}
				else if (parameters[i] instanceof java.sql.Date)
				{
					/**
					 * Get better performance when performing SQL query with date range for Oracle. 
					 */
					pstmt.setDate(i + 1, (java.sql.Date) parameters[i]);
				}
				else if (parameters[i] instanceof java.util.Date)
				{
					pstmt.setTimestamp(i + 1, new Timestamp(((java.util.Date) parameters[i]).getTime()));
				}
				else if (parameters[i] instanceof InputStream)
				{
					try
					{
						//if the input stream is empty, set to null.
						if (((InputStream) parameters[i]).available() == 0)
						{
							pstmt.setBinaryStream(i + 1, null, 0);
						}
						//Set InputSteam
						else
						{
							pstmt.setBinaryStream(i + 1, (InputStream) parameters[i], ((InputStream) parameters[i])
								.available());
						}
					}
					catch (IOException e)
					{
						throw new SQLException(e);
					}
				}
				/*else if (parameters[i] instanceof Reader)
				{
					//Fix JBOSS bug of Jboss-common-jdbc-wrapper.jar
					PreparedStatement origStmt = pstmt.unwrap(PreparedStatement.class);
					SqlSyntaxAdapterFactory ssaf = SqlSyntaxAdapterFactory.getInstance();
					SqlSyntaxAdapter ssa = ssaf.getSqlAdapter();
					ssa.setCharacterStream(origStmt, i+ 1, (Reader) parameters[i]);
				}
				//Add contition for only deal with Float and Double in Oracle.
				else if ((parameters[i] instanceof Float || parameters[i] instanceof Double)
						&& isOracle)
				{
					pstmt.setObject(i + 1, parameters[i].toString());
				}*/
				else if (parameters[i] instanceof Enum)
				{
					pstmt.setObject(i + 1, parameters[i].toString());
				}
				/*else if (parameters[i] instanceof JGeometry)
				{
					STRUCT obj = AccelaJGeometry.store2((JGeometry) parameters[i], conn.getMetaData().getConnection());
					pstmt.setObject(i + 1, obj);
				}*/
				else
				{
					pstmt.setObject(i + 1, parameters[i]);
				}
			}
		}
	}
	
	/**
	 * 
	 * Execute SQL query and log the execution time.
	 *
	 * @param stmt		PreparedStatement
	 * @param sql		SQL query
	 * @param parameters SQL parameters
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(PreparedStatement stmt, String sql, Object[] parameters)
			throws SQLException
	{
		ResultSet rs = null;
		/*if (logCount > 0 || logSQLLongDurations > 0.0)
		{
			long beginTime = System.currentTimeMillis();
			try
			{
				rs = stmt.executeQuery();
			}
			finally
			{
				if (logCount > 0 || System.currentTimeMillis() - beginTime > logSQLLongDurations)
				{
					StringBuilder sb = new StringBuilder();
					sb.append("SQL(Time: ").append(
						durationFormat.format((System.currentTimeMillis() - beginTime) / 1000));
					sb.append("s) ");
					sb.append(sql);
					if (parameters != null)
					{
						sb.append("\r\n Param:");
						for (Object param : parameters)
						{
							if (param != null)
							{
								sb.append(param.toString()).append('|');
							}
							else
							{
								sb.append("null|");
							}
						}
					}
					LOGGER.warn(sb.toString());
				}
			}
		}
		else
		{*/
			rs = stmt.executeQuery();
		//}
		return rs;
	}
}

/*
*$Log: av-env.bat,v $
*/