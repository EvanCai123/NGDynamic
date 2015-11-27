package com.ec.ng.entitymeta.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ec.ng.framework.commonUtil.ValidationUtil;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityModel.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityModel.java Jul 13, 2015 12:17:24 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 13, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class EntityMeta implements Serializable {
	
	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = -8771276825379260406L;

	private String id;
	
	private String owner;
	
	private String name;
	
	private String alias;

	private String tableName;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private String isActive;
	
	private List<EntityFieldMeta> fields;
	
	private List<Relation> relations;
	
	private String description;
	
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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

	public List<EntityFieldMeta> getFields() {
		return fields;
	}

	public void setFields(List<EntityFieldMeta> fields) {
		this.fields = fields;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

/*
*$Log: av-env.bat,v $
*/