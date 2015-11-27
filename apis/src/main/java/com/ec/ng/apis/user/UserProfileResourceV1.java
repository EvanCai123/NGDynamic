package com.ec.ng.apis.user;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.user.model.ContactModel;
import com.ec.ng.user.service.UserService;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserProfileResourceV1.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserProfileResourceV1.java Jul 20, 2015 2:59:14 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Path("/v1/userProfiles")
@Produces({MediaType.APPLICATION_JSON})
public class UserProfileResourceV1 {

	@Autowired
	private UserService userService;
	
	@GET
	public ContactModel getUserProfileByUserId(@QueryParam("userId") String userId)
	{
		ContactModel contact = userService.getUserContactByUserId(userId);
		return contact;
	}
	
	@POST
	public ContactModel createUserProfile(ContactModel userContact)
	{
		ContactModel result = new ContactModel();
		String id = userService.createUserContact(userContact);
		result.setId(id);
		return result;
	}
}

/*
*$Log: av-env.bat,v $
*/