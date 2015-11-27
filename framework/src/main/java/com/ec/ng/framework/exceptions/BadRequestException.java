package com.ec.ng.framework.exceptions;
/**
 * <pre>
 * 
 *  Next Generation
 *  File: BadRequestException.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: BadRequestException.java Jul 21, 2015 11:42:29 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class BadRequestException extends RuntimeException {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -4622126195986450832L;

	public BadRequestException(String msg) {
        super(msg);
	}
}

/*
*$Log: av-env.bat,v $
*/