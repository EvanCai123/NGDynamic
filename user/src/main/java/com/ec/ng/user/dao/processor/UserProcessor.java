package com.ec.ng.user.dao.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ec.ng.framework.dataUtil.DBResultSetProcessor;
import com.ec.ng.user.model.UserModel;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserProcessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserProcessor.java Jul 20, 2015 1:10:16 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class UserProcessor implements DBResultSetProcessor<UserModel>{

	@Override
	public UserModel processResultSetRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		UserModel user= new UserModel();
		user.setId(rs.getString("ID"));
		user.setOwner(rs.getString("OWNER"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setEmail(rs.getString("EMAIL"));
		user.setCreatedBy(rs.getString("CREATED_BY"));
		user.setCreatedDate(rs.getDate("CREATED_DATE"));
		user.setIsActive(rs.getString("IS_ACTIVE"));
		user.setName(rs.getString("NAME"));
		user.setUpdatedBy(rs.getString("UPDATED_BY"));
		user.setUpdatedDate(rs.getDate("UPDATED_DATE"));
		return user;
	}

}

/*
*$Log: av-env.bat,v $
*/