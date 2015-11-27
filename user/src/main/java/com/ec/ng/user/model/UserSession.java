package com.ec.ng.user.model;

import java.io.Serializable;
import java.util.Date;

import com.ec.ng.framework.commonUtil.ValidationUtil;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UserSession.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UserSession.java Jul 20, 2015 8:24:08 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class UserSession implements Serializable {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -6918715608374901967L;

	private String owner;
	
	private String userId;
	
	private String userName;
	
	private String sessionId;
	
	private Date expirationDate;
	
	private String status;
	
	private String ip;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String isActive;

	public String getOwner() {
		if(ValidationUtil.isNotEmpty(owner))
		{
			return owner.toUpperCase();
		}
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
		if(ValidationUtil.isNotEmpty(userName))
		{
			return userName.toUpperCase();
		}
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUpdatedBy() {
		if(ValidationUtil.isNotEmpty(updatedBy))
		{
			return updatedBy.toUpperCase();
		}
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		if(ValidationUtil.isNotEmpty(createdBy))
		{
			return createdBy.toUpperCase();
		}
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}

/*
*$Log: av-env.bat,v $
*/