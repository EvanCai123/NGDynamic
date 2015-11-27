package com.ec.ng.apis.framework.model;

import java.io.Serializable;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: Error.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Error.java Jul 21, 2015 9:48:17 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class ErrorModel implements Serializable  {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 2204607354641860450L;

	private Integer status;
	
	private Integer code;

	private String message;
	
	private String more;
	
	public ErrorModel(Integer status,Integer code,String message,String more)
	{
		this.code=code;
		this.status=status;
		this.message=message;
		this.more=more;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

}

/*
*$Log: av-env.bat,v $
*/