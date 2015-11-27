package com.ec.ng.apis.user;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.apis.framework.annotations.IgnoreAuthentication;
import com.ec.ng.apis.framework.util.RestThreadLocal;
import com.ec.ng.framework.commonUtil.ValidationUtil;
import com.ec.ng.user.service.UserService;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: AuthenticationResourceV1.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AuthenticationResourceV1.java Jul 20, 2015 8:09:02 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Path("/v1/auth")
@Produces( {MediaType.APPLICATION_JSON})
public class AuthenticationResourceV1 {

	@Autowired
	private UserService userService;

	@IgnoreAuthentication
	@POST
	@Path("/token")
	public Map<String,String> signon4AgencyUser(Map<String,String> authRequest)
	{
		Map<String,String> result = new HashMap<String,String>();
		if(ValidationUtil.isEmpty(authRequest))
		{
			
		}
		String owner = (String)authRequest.get("owner");
		String email = (String)authRequest.get("email");
		String userName = (String)authRequest.get("userName");
		String password = (String)authRequest.get("password");
		String token =userService.createUserToken(owner, userName, email,password,RestThreadLocal.getIp());
		result.put("token", token);
		return result;
	}
}

/*
*$Log: av-env.bat,v $
*/