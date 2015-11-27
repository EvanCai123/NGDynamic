package com.ec.ng.apis.user;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.apis.framework.annotations.IgnoreAuthentication;
import com.ec.ng.user.model.UserModel;
import com.ec.ng.user.service.UserService;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserResourceV1.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserResourceV1.java Jul 20, 2015 2:27:37 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Path("/v1/users")
@Produces({MediaType.APPLICATION_JSON})
public class UserResourceV1 {

	@Autowired
	private UserService userService;
	
	@GET
	@Path("/{id}")
	public UserModel getUserById(@PathParam("id") String id)
	{
		UserModel user = userService.getUserById(id);
		return user;
	}
	
	@IgnoreAuthentication
	@POST
	public UserModel createUser(UserModel user)
	{
		UserModel result = new UserModel();
		String id = userService.createUser(user);
		result.setId(id);
		return result;
	}
}

/*
*$Log: av-env.bat,v $
*/