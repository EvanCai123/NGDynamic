package com.ec.ng.user.dao;

import com.ec.ng.user.model.ContactModel;
import com.ec.ng.user.model.UserGroupModel;
import com.ec.ng.user.model.UserModel;
import com.ec.ng.user.model.UserSession;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserDao.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserDao.java Jul 20, 2015 9:08:17 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface UserDao {

	public int createUser(UserModel user);
	
	public int createUserContact(ContactModel userContact);
	
	public int createUserGroup (UserGroupModel userGroup);
	
	public int assignUserToGroup (UserModel user );
	
	public UserModel getUserById(String id);
	
	public UserModel getUserByName(String owner, String userName,String email);
	
	public ContactModel getUserContactByUserId (String userId);
	
	public int createUserToken(UserSession userSession);

	public int updateUserToken(UserSession userSession);
	
	public UserSession getUserSessionByToken (String token);
}

/*
*$Log: av-env.bat,v $
*/