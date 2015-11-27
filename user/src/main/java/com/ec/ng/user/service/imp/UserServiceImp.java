package com.ec.ng.user.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.ng.framework.commonUtil.DateTimeUitl;
import com.ec.ng.framework.commonUtil.EncryptionUtil;
import com.ec.ng.framework.commonUtil.SecurityUtil;
import com.ec.ng.framework.commonUtil.ValidationUtil;
import com.ec.ng.framework.constants.Constants;
import com.ec.ng.framework.constants.MessageConstants;
import com.ec.ng.framework.exceptions.UserInvalidException;
import com.ec.ng.framework.idgenerator.UUIDGenerator;
import com.ec.ng.user.dao.UserDao;
import com.ec.ng.user.model.ContactModel;
import com.ec.ng.user.model.UserGroupModel;
import com.ec.ng.user.model.UserModel;
import com.ec.ng.user.model.UserSession;
import com.ec.ng.user.service.UserService;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserServiceImp.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserServiceImp.java Jul 20, 2015 12:43:59 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Service(value = "userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public String createUser(UserModel user) {
		String id = UUIDGenerator.getUUID();
		String password = user.getPassword();
		if(ValidationUtil.isNotEmpty(password))
		{
			user.setPassword(EncryptionUtil.encryptPassword(password));
		}
		
		user.setId(id);
		if(userDao.createUser(user)>0)
		{
			return id;
		}
		return null;
	}

	@Override
	public String createUserContact(ContactModel userContact) {
		String id = UUIDGenerator.getUUID();
		userContact.setId(id);
		if(userDao.createUserContact(userContact)>0)
		{
			return id;
		}
		return null;
	}

	@Override
	public String createUserGroup(UserGroupModel userGroup) {
		String id = UUIDGenerator.getUUID();
		userGroup.setId(id);
		if(userDao.createUserGroup(userGroup)>0)
		{
			return id;
		}
		return null;
	}

	@Override
	public int assignUserToGroup(UserModel user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public ContactModel getUserContactByUserId(String userId) {
		return userDao.getUserContactByUserId(userId);
	}

	@Override
	public String createUserToken(String owner, String userName, String email, String password,String ip) {
		
		UserModel user = userDao.getUserByName(owner,userName,email);
		
		String sessionId = null;
		if(user!=null && checkUserPasswrd(user.getPassword(), password))
		{
			UserSession oldUserSession = new UserSession();
			oldUserSession.setUserName(user.getName());
			oldUserSession.setUserId(user.getId());
			oldUserSession.setUpdatedBy(user.getName());
			oldUserSession.setUpdatedDate(DateTimeUitl.getCurrentDate());
			oldUserSession.setOwner(owner);
			oldUserSession.setIsActive(Constants.IS_NOT_ACTIVE);
			oldUserSession.setStatus(Constants.EXPIRED);
			oldUserSession.setIp(ip);

			userDao.updateUserToken(oldUserSession);
			
			sessionId = SecurityUtil.generateSessionID();
			UserSession userSession = new UserSession();
			userSession.setUserName(user.getName());
			userSession.setSessionId(sessionId);
			userSession.setCreatedBy(user.getName());
			userSession.setUpdatedBy(user.getName());
			userSession.setCreatedDate(DateTimeUitl.getCurrentDate());
			userSession.setUpdatedDate(DateTimeUitl.getCurrentDate());
			userSession.setOwner(owner);
			userSession.setIsActive(Constants.IS_ACTIVE);
			userSession.setUserId(user.getId());
			userSession.setExpirationDate(DateTimeUitl.getCurrentDate());
			userSession.setIp(ip);
			userSession.setStatus(Constants.ACTIVE);
			if(userDao.createUserToken(userSession)>0)
			{
				return sessionId;
			}
		}
		else
		{
			throw new UserInvalidException(MessageConstants.INVALID_USER);
		}
		return null;
	}
	
	private boolean checkUserPasswrd(String dbPassword, String password)
	{
		boolean isCorrect = false;

		if(ValidationUtil.isNotEmpty(password) 
				&& EncryptionUtil.encryptPassword(password).equals(dbPassword))
		{
			isCorrect = true;
		}
		return isCorrect;
	}

	@Override
	public UserSession getUserSessionByToken(String token) {
		return userDao.getUserSessionByToken(token);
	}

}

/*
*$Log: av-env.bat,v $
*/