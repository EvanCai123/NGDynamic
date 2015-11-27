package com.ec.ng.framework.exceptions;
/**
 * <pre>
 * 
 *  Next Generation
 *  File: UnknownResourceException.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UnknownResourceException.java Jul 21, 2015 11:41:10 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class UnknownResourceException extends RuntimeException{

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 5459146977189159743L;

	public UnknownResourceException(String msg) {
        super(msg);
	}
}

/*
*$Log: av-env.bat,v $
*/