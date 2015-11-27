package com.ec.ng.entitymeta.model;

import java.io.Serializable;

import com.ec.ng.framework.commonUtil.ValidationUtil;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: relationField.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: relationField.java Jul 13, 2015 3:12:17 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 13, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class RelationField implements Serializable {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 2803077309074517665L;
	
	private String parentFeildId;
	
	private String childFieldId;
	
	private String createdBy;
	
	private String createdDate;
	
	private String updatedBy;
	
	private String updatedDate;
	
	private String isActive;

	public String getParentFeildId() {
		return parentFeildId;
	}

	public void setParentFeildId(String parentFeildId) {
		this.parentFeildId = parentFeildId;
	}

	public String getChildFieldId() {
		return childFieldId;
	}

	public void setChildFieldId(String childFieldId) {
		this.childFieldId = childFieldId;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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