package com.ec.ng.entitymeta.model;

import java.io.Serializable;
import java.util.List;

import com.ec.ng.framework.commonUtil.ValidationUtil;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: Relation.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: Relation.java Jul 13, 2015 3:20:37 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 13, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class Relation implements Serializable {

	/**
	 * Comment for &lt;code&gt;serialVersionUID&lt;/code&gt;
	 */
	private static final long serialVersionUID = 5724412573392392059L;
	
	private String owner;

	private String parentEntityId;
	
	private String childEntityId;

	private String relation;

	private List<RelationField> fields;
	

	public String getParentEntityId() {
		return parentEntityId;
	}

	public void setParentEntityId(String parentEntityId) {
		this.parentEntityId = parentEntityId;
	}

	public String getChildEntityId() {
		return childEntityId;
	}

	public void setChildEntityId(String childEntityId) {
		this.childEntityId = childEntityId;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public List<RelationField> getFields() {
		return fields;
	}

	public void setFields(List<RelationField> fields) {
		this.fields = fields;
	}
	
}

/*
*$Log: av-env.bat,v $
*/