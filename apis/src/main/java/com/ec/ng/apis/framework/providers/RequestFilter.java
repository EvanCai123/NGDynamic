package com.ec.ng.apis.framework.providers;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.apis.framework.annotations.IgnoreAuthentication;
import com.ec.ng.apis.framework.util.ResponseHelper;
import com.ec.ng.apis.framework.util.RestThreadLocal;
import com.ec.ng.user.model.UserSession;
import com.ec.ng.user.service.UserService;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: AuthenticationHandler.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: AuthenticationHandler.java Jul 20, 2015 3:45:28 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Provider
public class RequestFilter implements ContainerRequestFilter{

	@Context   
	 private HttpServletRequest servletRequest;
	
	@Context
    private ResourceInfo resourceInfo;
	
	@Autowired
	private UserService userService;
	
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		RestThreadLocal.clean();
		String ip = servletRequest.getRemoteAddr();
		if(resourceInfo.getResourceMethod().getAnnotation(IgnoreAuthentication.class)==null)
		{
			MultivaluedMap<String, String> paramters = requestContext.getUriInfo().getQueryParameters();
			String token = paramters.getFirst("token");
			UserSession userSession = userService.getUserSessionByToken(token);
			if(userSession==null)
			{
				String msg = "The token is invalid, please login for the new token.";

				requestContext.abortWith(ResponseHelper.notAuthorized(msg,null));
				return;
			}
			
			RestThreadLocal.setOwner(userSession.getOwner().toUpperCase());
			RestThreadLocal.setUserId(userSession.getUserId());
			RestThreadLocal.setUserName(userSession.getUserName().toUpperCase());
		}
		else
		{
			RestThreadLocal.setIp(ip);
		}
	}

}

/*
*$Log: av-env.bat,v $
*/