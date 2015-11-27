package com.ec.ng.entitymeta.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ec.ng.framework.commonUtil.ValidationUtil;
/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityFieldModel.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityFieldModel.java Jul 13, 2015 12:17:38 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 13, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class EntityFieldMeta implements Serializable {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -240510881829351920L;

	private String id;
	
	private String owner;
	
	private String entityId;
	
	private String name;
	
	private String alias;
	
	private String value;
	
	private String type;
	
	private String isDropdown;
	
	private List<Object> optionals;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private String isActive;
	
	private String isReadOnly;
	
	private String isNullable;

	private String description;
	
	private String helpText;
	
	private Integer length;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsDropdown() {
		return isDropdown;
	}

	public void setIsDropdown(String isDropdown) {
		this.isDropdown = isDropdown;
	}

	public List<Object> getOptionals() {
		return optionals;
	}

	public void setOptionals(List<Object> optionals) {
		this.optionals = optionals;
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getIsNullable() {
		return isNullable;
	}

	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	
	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	
}

/*
*$Log: av-env.bat,v $
*/