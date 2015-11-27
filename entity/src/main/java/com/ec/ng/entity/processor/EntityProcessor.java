package com.ec.ng.entity.processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ec.ng.entity.model.EntityField;
import com.ec.ng.entitymeta.model.EntityFieldMeta;
import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.framework.dataUtil.DBResultSetProcessor;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityProcessor.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityProcessor.java Jul 17, 2015 3:17:40 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 17, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class EntityProcessor implements DBResultSetProcessor<EntityField>{

	@Override
	public EntityField processResultSetRow(ResultSet rs) throws SQLException {
		EntityField entityField= new EntityField();
		entityField.setId(rs.getString("ID"));
		entityField.setOwner(rs.getString("OWNER"));
		entityField.setName(rs.getString("FIELD_NAME"));
		entityField.setValue(rs.getString("VALUE"));
		entityField.setCreatedDate(rs.getDate("CREATED_DATE"));
		entityField.setIsActive(rs.getString("IS_ACTIVE"));
		entityField.setUpdatedBy(rs.getString("UPDATED_BY"));
		entityField.setUpdatedDate(rs.getDate("UPDATED_DATE"));
		entityField.setCreatedBy(rs.getString("CREATED_BY"));
		return entityField;
	}

}

/*
*$Log: av-env.bat,v $
*/