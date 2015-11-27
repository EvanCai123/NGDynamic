package com.ec.ng.apis.framework.providers;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ec.ng.apis.framework.util.ResponseHelper;
import com.ec.ng.framework.constants.MessageConstants;
import com.ec.ng.framework.exceptions.UserInvalidException;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: RESTExceptionMapper.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: RESTExceptionMapper.java Jul 21, 2015 12:18:47 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Provider
public class RESTExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		Response response = null;
		if (exception instanceof UserInvalidException)
		{
			response = ResponseHelper.notAuthorized(exception.getMessage(),null);
		}
		else if (exception instanceof NotFoundException)
		{
			response = ResponseHelper.notFound(MessageConstants.RESOURCE_NOT_FOUND, null);
		}
		return response;
	}

}

/*
*$Log: av-env.bat,v $
*/