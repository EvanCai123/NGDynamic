package com.ec.ng.framework.dataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: DBAccessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: DBAccessor.java Jun 15, 2015 3:43:49 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jun 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class DBAccessor 
{
	private ConnectionManager connManager=null;
	public DBAccessor ()
	{
		connManager = new NGConnectionManger();
	}
	
	public List<Map<String, Object>> select (String sqlString, Object[] parameters)
	{
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
		Connection conn = connManager.getConnection();
		DefaultDBResultSetProcessor processor = new DefaultDBResultSetProcessor();
		
		try {
			pstmt = conn.prepareStatement(sqlString);
			DbUtil.setParameters(pstmt, parameters);
			rs = DbUtil.executeQuery(pstmt, sqlString, parameters);
			
			if(rs!=null)
			{
				while(rs.next())
				{
					Map<String, Object> modelObject = processor.processResultSetRow(rs);
					records.add(modelObject);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JdbcUtil.closeResultSet(rs);
			JdbcUtil.closeStatement(pstmt);
			JdbcUtil.closeConnection(conn);
		}
		return records;
	}
	public int update(String sqlString, Object[] parameters) throws  SQLException
	{
		//String sql = sqlString.toUpperCase().trim();

		PreparedStatement pstmt = null;
		Connection conn = connManager.getConnection();
		//long beginTime = System.currentTimeMillis();
		try
		{
			/*if (LOGGER.isDebugEnabled())
			{
				LOGGER.debug(sqlString);
			}
			if (!isOracle)
			{
				sqlString = DbUtils.removeUpperFromSql(sqlString);
			}
			
			boolean isNeedAudit = getDatabaseAuditImpl().beforeAudit(sqlString, parameters);
			*/
			pstmt = conn.prepareStatement(sqlString);
			DbUtil.setParameters(pstmt, parameters);
			int count = pstmt.executeUpdate();
			/*long endTimer = System.currentTimeMillis();
			if (count > 500 || (endTimer - beginTime) > logSQLLongDurations)
			{
				DbUtils.logRiskySql(sqlString, parameters, beginTime);
				LOGGER.warn("SQL, s(" + beginTime 
					+ ") Total time:" + (endTimer - beginTime) 
					+ " Total records:" + count);
			}
			if(count > 0 && isNeedAudit)
			{
				getDatabaseAuditImpl().audit(sqlString, parameters);
			}*/
			return count;
		}
		finally
		{
			JdbcUtil.closeStatement(pstmt);
			JdbcUtil.closeConnection(conn);
			/*if (LogUtil.isDebug()) 
			{
				StackTraceElement[] stackList = (new Exception()).getStackTrace();
				LogUtil.addStackTrace(LogUtil.replaceProxy(stackList, "DAO", 
					parameters, System.currentTimeMillis() - beginTime));
			}*/
		}

	}
	
	public int batchUpdate(String sqlString, List<Object[]> parameters) throws SQLException
	{
		PreparedStatement pstmt = null;
		Connection conn = connManager.getConnection();;
		try
		{
			/*if (LOGGER.isDebugEnabled())
			{
				LOGGER.debug(sqlString);
			}
			
			boolean isNeedAudit = getDatabaseAuditImpl().beforeBatchAudit(sqlString, parameters);
			*/
			pstmt = conn.prepareStatement(sqlString);
			for (int i = 0; i < parameters.size(); i++)
			{
				DbUtil.setParameters(pstmt, parameters.get(i));
				pstmt.addBatch();
			}
			int[] resultList = pstmt.executeBatch();
			int affectCount = 0;
			for (int count : resultList)
			{
				affectCount = affectCount + count;
			}
			if (affectCount <= -2)
			{
				affectCount = pstmt.getUpdateCount();
			}
			/*if (affectCount > 0 && isNeedAudit)
			{
				getDatabaseAuditImpl().batchAudit(sqlString, parameters);
			}
			long endTimer = System.currentTimeMillis();
			if (affectCount > 500 || (endTimer - startTimer) > logSQLLongDurations)
			{
				DbUtils.logRiskySql(sqlString, null, startTimer);
				LOGGER.warn("SQL, s(" + startTimer 
					+ ") Total time:" + (endTimer - startTimer) 
					+ " Total records:" + affectCount);
			}*/
			return affectCount;
		}
		finally
		{
			JdbcUtil.closeStatement(pstmt);
			JdbcUtil.closeConnection(conn);
		}

	}
	
	/**
	 * Execute a database query, return all the data in a collection one time,
	 * be careful to use it if large data returned.
	 * 
	 * @param <T>		- domain model type
	 * @param clazz - Domain model class
	 * @param conn 	externalConn		external connection will not be closed here.
	 * @param sql - SQL statement
	 * @param parameters - The search criteria values.
	 * @return List
	 * @throws NamingException
	 * @throws SQLException
	 */
	public List<?> select(String sqlString, Object[] parameters, DBResultSetProcessor<?> processor)
			throws NamingException, SQLException
	{
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Object> records = new ArrayList<Object>(50);
		Connection conn = null;
//		long startTimer = System.currentTimeMillis();
		try
		{
			conn = connManager.getConnection();	
			
			pstmt = conn.prepareStatement(sqlString);
//			if (LOGGER.isDebugEnabled())
//			{
//				LOGGER.debug(sqlString);
//			}
			DbUtil.setParameters(pstmt, parameters);

			rs = DbUtil.executeQuery(pstmt, sqlString, parameters);

//			int counter = 0;
//			long sequenceNumber = 0;
			while (rs.next())
			{
				Object modelObj = processor.processResultSetRow(rs);
				records.add(modelObj);
//				counter ++;
//				if (counter == 500)
//				{
//					sequenceNumber = System.currentTimeMillis();
//					DbUtils.logRiskySql(sqlString, parameters, sequenceNumber);
//				}
//				if (counter == 10000)
//				{
//					long endTimer = System.currentTimeMillis();
//					LOGGER.error("Risky SQL is retrieving too many records(>10000), s(" + sequenceNumber 
//							+ ") cost:" + (endTimer - startTimer));
//				}
			}
//			if (counter >= 500)
//			{
//				long endTimer = System.currentTimeMillis();
//				LOGGER.warn("SQL, s(" + sequenceNumber 
//						+ ") Total time:" + (endTimer - startTimer) 
//						+ " Total records:" + counter);
//			}
		}
		finally
		{
			JdbcUtil.closeResultSet(rs);
			JdbcUtil.closeStatement(pstmt);

			JdbcUtil.closeConnection(conn);	
//			if (LogUtil.isDebug())
//			{
//				StackTraceElement[] stackList = (new Exception()).getStackTrace();
//				LogUtil.addStackTrace(LogUtil.replaceProxy(stackList, "DAO", 
//					parameters, System.currentTimeMillis() - startTimer));
//			}
		}
		
		return records;
	}
}

/*
*$Log: av-env.bat,v $
*/