package com.ec.ng.user.dao.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ec.ng.framework.dataUtil.DBResultSetProcessor;
import com.ec.ng.user.model.UserSession;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserSessionProcessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserSessionProcessor.java Jul 20, 2015 10:57:32 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class UserSessionProcessor implements DBResultSetProcessor<UserSession> {

	@Override
	public UserSession processResultSetRow(ResultSet rs) throws SQLException {
		UserSession userSession = new UserSession();
		userSession.setOwner(rs.getString("OWNER"));
		userSession.setCreatedBy(rs.getString("CREATED_BY"));
		userSession.setCreatedDate(rs.getDate("CREATED_DATE"));
		userSession.setIsActive(rs.getString("IS_ACTIVE"));
		userSession.setUserId(rs.getString("USER_ID"));
		userSession.setUserName(rs.getString("USER_NAME"));
		userSession.setExpirationDate(rs.getDate("expiration_date"));
		userSession.setStatus(rs.getString("STATUS"));
		userSession.setIp(rs.getString("ACTION_BY_IP"));
		userSession.setUpdatedBy(rs.getString("UPDATED_BY"));
		userSession.setUpdatedDate(rs.getDate("UPDATED_DATE"));
		return userSession;
	}

}

/*
*$Log: av-env.bat,v $
*/