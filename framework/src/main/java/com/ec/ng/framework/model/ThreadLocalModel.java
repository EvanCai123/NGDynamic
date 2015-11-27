package com.ec.ng.framework.model;

import java.io.Serializable;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: ThreadLocalModel.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: ThreadLocalModel.java Jul 21, 2015 9:04:36 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 21, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class ThreadLocalModel implements Serializable {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -7623493606033254803L;

	private String owner;
	
	private String userId;
	
	private String userName;

	private String ip;
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void clean()
	{
		this.userId = null;
		this.owner = null;
		this.ip=null;
		this.userName=null;
	}
}

/*
*$Log: av-env.bat,v $
*/