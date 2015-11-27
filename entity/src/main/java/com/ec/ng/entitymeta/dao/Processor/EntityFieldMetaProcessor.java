package com.ec.ng.entitymeta.dao.Processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ec.ng.entitymeta.model.EntityFieldMeta;
import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.framework.dataUtil.DBResultSetProcessor;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityFieldProcessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityFieldProcessor.java Jul 16, 2015 2:09:47 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 16, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class EntityFieldMetaProcessor  implements DBResultSetProcessor<EntityFieldMeta>{

	@Override
	public EntityFieldMeta processResultSetRow(ResultSet rs)
			throws SQLException 
	{
		EntityFieldMeta entityFieldMeta= new EntityFieldMeta();
		entityFieldMeta.setId(rs.getString("ID"));
		entityFieldMeta.setOwner(rs.getString("OWNER"));
		entityFieldMeta.setAlias(rs.getString("ALIAS"));
		entityFieldMeta.setCreatedBy(rs.getString("CREATED_BY"));
		entityFieldMeta.setCreatedDate(rs.getDate("CREATED_DATE"));
		entityFieldMeta.setDescription(rs.getString("DESCRIPTION"));
		entityFieldMeta.setIsActive(rs.getString("IS_ACTIVE"));
		entityFieldMeta.setName(rs.getString("NAME"));
		entityFieldMeta.setEntityId(rs.getString("ENTITY_ID"));
		entityFieldMeta.setUpdatedBy(rs.getString("UPDATED_BY"));
		entityFieldMeta.setUpdatedDate(rs.getDate("UPDATED_DATE"));
		entityFieldMeta.setHelpText(rs.getString("HELP_TEXT"));
		entityFieldMeta.setIsDropdown(rs.getString("IS_DROPDOWN"));
		entityFieldMeta.setIsNullable(rs.getString("IS_NULLABLE"));
		if(rs.getInt("LENGTH")!=0)
		{
			entityFieldMeta.setLength(rs.getInt("LENGTH"));
		}
		entityFieldMeta.setType(rs.getString("type"));
		entityFieldMeta.setValue(rs.getString("value"));
		return entityFieldMeta;
	}

}

/*
*$Log: av-env.bat,v $
*/