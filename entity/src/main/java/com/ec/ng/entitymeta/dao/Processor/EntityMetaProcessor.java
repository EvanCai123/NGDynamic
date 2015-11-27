package com.ec.ng.entitymeta.dao.Processor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.framework.commonUtil.DateTimeUitl;
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
 * 	$Id: EntityProcessor.java Jul 15, 2015 7:32:53 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 15, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class EntityMetaProcessor implements DBResultSetProcessor<EntityMeta>{

	@Override
	public EntityMeta processResultSetRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		EntityMeta entityMeta= new EntityMeta();
		entityMeta.setId(rs.getString("ID"));
		entityMeta.setOwner(rs.getString("OWNER"));
		entityMeta.setAlias(rs.getString("ALIAS"));
		entityMeta.setCreatedBy(rs.getString("CREATED_BY"));
		entityMeta.setCreatedDate(rs.getDate("CREATED_DATE"));
		entityMeta.setDescription(rs.getString("DESCRIPTION"));
		entityMeta.setIsActive(rs.getString("IS_ACTIVE"));
		entityMeta.setName(rs.getString("NAME"));
		entityMeta.setTableName(rs.getString("TABLE_NAME"));
		entityMeta.setUpdatedBy(rs.getString("UPDATED_BY"));
		entityMeta.setUpdatedDate(rs.getDate("UPDATED_DATE"));
		return entityMeta;
	}

}

/*
*$Log: av-env.bat,v $
*/