package com.ec.ng.user.service;

import com.ec.ng.user.model.ContactModel;
import com.ec.ng.user.model.UserGroupModel;
import com.ec.ng.user.model.UserModel;
import com.ec.ng.user.model.UserSession;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserService.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserService.java Jul 20, 2015 12:43:47 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface UserService {

	public String createUser(UserModel user);
	
	public String createUserContact(ContactModel userContact);
	
	public String createUserGroup (UserGroupModel userGroup);
	
	public int assignUserToGroup (UserModel user );
	
	public UserModel getUserById(String id);
	
	public ContactModel getUserContactByUserId (String userId);
	
	public String createUserToken(String owner, String userName, String email,String password,String ip);
	
	public UserSession getUserSessionByToken (String token);
}

/*
*$Log: av-env.bat,v $
*/