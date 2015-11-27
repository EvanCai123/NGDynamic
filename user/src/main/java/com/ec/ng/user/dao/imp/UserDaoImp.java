package com.ec.ng.user.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

import com.ec.ng.framework.commonUtil.ValidationUtil;
import com.ec.ng.framework.constants.Constants;
import com.ec.ng.framework.dataUtil.DBAccessor;
import com.ec.ng.user.dao.UserDao;
import com.ec.ng.user.dao.processor.ContactProcessor;
import com.ec.ng.user.dao.processor.UserProcessor;
import com.ec.ng.user.dao.processor.UserSessionProcessor;
import com.ec.ng.user.model.ContactModel;
import com.ec.ng.user.model.UserGroupModel;
import com.ec.ng.user.model.UserModel;
import com.ec.ng.user.model.UserSession;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserDaoImp.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserDaoImp.java Jul 20, 2015 9:08:28 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Repository(value="userDao")
public class UserDaoImp implements UserDao{

	@Override
	public int createUser(UserModel user) {
		int count =0;
		String sqlString ="INSERT INTO USER (ID,OWNER,"
				+ "NAME,PASSWORD,EMAIL,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE) " 
				+ "values(?,?,?,?,?,?,?,?,?,?)";
			
		Object[] parameters = new Object[] {user.getId(),user.getOwner(),user.getName(),user.getPassword(),
				user.getEmail(), user.getCreatedBy(),user.getCreatedDate(),user.getUpdatedBy(),
				user.getUpdatedDate(),user.getIsActive()};
	
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.update(sqlString, parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int createUserContact(ContactModel userContact) {
		int count =0;
		String sqlString ="INSERT INTO CONTACT (ID,OWNER,USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME"
				+ "EMAIL,PHONE,ADDRESS1,ADDRESS2,CITY,STATE,COUNTRY,ZIP,"
				+ "CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE) " 
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
		Object[] parameters = new Object[] {userContact.getId(),userContact.getOwner(),userContact.getFristName(),
				userContact.getMiddleName(),userContact.getLastName(),userContact.getEmail(),userContact.getPhone(),
				userContact.getAddress1(),userContact.getAddress2(),userContact.getCity(),userContact.getState(),
				userContact.getCountry(),userContact.getZip(), userContact.getCreatedBy(),userContact.getCreatedDate(),
				userContact.getUpdatedBy(),userContact.getUpdatedDate(),userContact.getIsActive()};
	
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.update(sqlString, parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int createUserGroup(UserGroupModel userGroup) {
		int count =0;
		String sqlString ="INSERT INTO user_group (ID,OWNER,"
				+ "NAME,description,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE) " 
				+ "values(?,?,?,?,?,?,?,?,?,?)";
			
		Object[] parameters = new Object[] {userGroup.getId(),userGroup.getOwner(),userGroup.getName(),
				userGroup.getDescription(), userGroup.getCreatedBy(),userGroup.getCreatedDate(),userGroup.getUpdatedBy(),
				userGroup.getUpdatedDate(),userGroup.getIsActive()};
	
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.update(sqlString, parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int assignUserToGroup(UserModel user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel getUserById(String id) {
		
		String sql = "SELECT ID,OWNER,"
				+ "NAME,PASSWORD,EMAIL,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE "
				+ "FROM USER"
				+ " WHERE ID=?";
		Object[] params = new Object[] {id};
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<UserModel> users = (List<UserModel>)accessor.select(sql, params,new UserProcessor());
			
			if(users!=null && users.size()>0)
			{
				for (UserModel user : users)
				{
					return user;
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ContactModel getUserContactByUserId(String userId) {
		String sql = "SELECT ID,OWNER,USER_ID,FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMAIL,PHONE,ADDRESS1,"
				+ "ADDRESS2,CITY,STATE,COUNTRY,ZIP,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE "
				+ "FROM contact"
				+ " WHERE USER_ID=?";
		Object[] params = new Object[] {userId};
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<ContactModel> contacts = (List<ContactModel>)accessor.select(sql, params,new ContactProcessor());
			
			if(contacts!=null && contacts.size()>0)
			{
				for (ContactModel contact : contacts)
				{
					return contact;
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int createUserToken(UserSession userSession) {
		int count =0;
		String sqlString ="INSERT INTO USER_SESSIONS (OWNER,SESSION_ID,"
				+ "USER_NAME,USER_ID,EXPIRATION_DATE,STATUS,ACTION_BY_IP,"
				+ "CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE) " 
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
		Object[] parameters = new Object[] {userSession.getOwner(),userSession.getSessionId(),
				userSession.getUserName(),userSession.getUserId(),
				userSession.getExpirationDate(),userSession.getStatus(),userSession.getIp(),
				userSession.getCreatedBy(),userSession.getCreatedDate(),userSession.getUpdatedBy(),
				userSession.getUpdatedDate(),userSession.getIsActive()};
	
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.update(sqlString, parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateUserToken(UserSession userSession) {
		int count =0;
		String sqlString ="UPDATE USER_SESSIONS SET STATUS=?, ACTION_BY_IP=?,"
				+ "UPDATED_BY=?,UPDATED_DATE=?,IS_ACTIVE=? " 
				+ "WHERE USER_ID=? AND IS_ACTIVE=? AND STATUS=?";
			
		Object[] parameters = new Object[] {userSession.getStatus(),userSession.getIp(),
				userSession.getUpdatedBy(),userSession.getUpdatedDate(),userSession.getIsActive(),
				userSession.getUserId(),Constants.IS_ACTIVE,Constants.ACTIVE};
	
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.update(sqlString, parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public UserModel getUserByName(String owner, String userName,String email) {
		
		if(ValidationUtil.isEmpty(owner) && ValidationUtil.isEmpty(email))
		{
			return null;
		}
		
		String sql = "SELECT ID,OWNER,"
				+ "NAME,PASSWORD,EMAIL,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE "
				+ "FROM USER"
				+ " WHERE OWNER=? AND IS_ACTIVE=?";
		
		List<String> params = new ArrayList<String>();
		params.add(owner);
		params.add(Constants.IS_ACTIVE);
		
		if(ValidationUtil.isNotEmpty(userName))
		{
			sql+=" AND NAME=?";
			params.add(userName.toUpperCase());
		}
		if(ValidationUtil.isNotEmpty(email))
		{
			sql+=" AND EMAIL=?";
			params.add(email);
		}
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<UserModel> users = (List<UserModel>)accessor.select(sql, params.toArray(),new UserProcessor());
			
			if(users!=null && users.size()>0)
			{
				for (UserModel user : users)
				{
					return user;
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserSession getUserSessionByToken(String token) {

		String sql ="SELECT OWNER,SESSION_ID,"
				+ "USER_NAME,USER_ID,EXPIRATION_DATE,STATUS,ACTION_BY_IP,"
				+ "CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE "
				+ "FROM USER_SESSIONS " 
				+ "WHERE SESSION_ID=? AND STATUS=? AND IS_ACTIVE=?";
			
		Object[] params = new Object[] {token,Constants.ACTIVE,Constants.IS_ACTIVE};
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<UserSession> userSessions = (List<UserSession>)accessor.select(sql, params,new UserSessionProcessor());
			
			if(userSessions!=null && userSessions.size()>0)
			{
				for (UserSession userSession : userSessions)
				{
					return userSession;
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

/*
*$Log: av-env.bat,v $
*/