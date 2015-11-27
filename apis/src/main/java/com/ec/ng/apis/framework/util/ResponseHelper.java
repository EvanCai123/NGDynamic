package com.ec.ng.apis.framework.util;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.ec.ng.apis.framework.model.ErrorModel;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
/**
 * <pre>
 * 
 *  Next Generation
 *  File: ResponseHelper.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ResponseHelper.java Jul 21, 2015 9:28:40 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class ResponseHelper {

	public static Response notAuthorized(String message,Throwable e)
	{
		return error(SC_UNAUTHORIZED, SC_UNAUTHORIZED, message, e);
	}
	
	public static Response notFound(String message,Throwable e)
	{
		return error(SC_NOT_FOUND, SC_NOT_FOUND, message, e);
	}
	
	private static Response error(Integer statusCode,Integer code, String message,Throwable e)
	{
		String more = null;
		if(e!=null && e.getCause()!=null)
		{
			more=e.getCause().getMessage();
		}
		ErrorModel error = new ErrorModel(statusCode,code, message, more);
		
		ResponseBuilder responseBuilder = Response.status(statusCode);
		responseBuilder.entity(error);
		responseBuilder.type(MediaType.APPLICATION_JSON);
		return responseBuilder.build();
	}

}

/*
*$Log: av-env.bat,v $
*/