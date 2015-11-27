package com.ec.ng.framework.exceptions;
/**
 * <pre>
 * 
 *  Next Generation
 *  File: UnauthorizedException.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UnauthorizedException.java Jul 21, 2015 11:39:19 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class UnauthorizedException extends RuntimeException{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -6047538696747012907L;

	public UnauthorizedException(String msg) {
        super(msg);
	}
}

/*
*$Log: av-env.bat,v $
*/