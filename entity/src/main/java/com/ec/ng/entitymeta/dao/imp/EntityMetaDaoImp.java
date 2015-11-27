package com.ec.ng.entitymeta.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

import com.ec.ng.entitymeta.dao.EntityMetaDao;
import com.ec.ng.entitymeta.dao.Processor.EntityFieldMetaProcessor;
import com.ec.ng.entitymeta.dao.Processor.EntityMetaProcessor;
import com.ec.ng.entitymeta.model.EntityFieldMeta;
import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.entitymeta.model.Relation;
import com.ec.ng.entitymeta.model.RelationField;
import com.ec.ng.framework.commonUtil.ValidationUtil;
import com.ec.ng.framework.dataUtil.DBAccessor;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityMetaDaoImp.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityMetaDaoImp.java Jul 11, 2015 1:48:18 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 11, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Repository(value="entityMetaDao")
public final class EntityMetaDaoImp implements EntityMetaDao
{

	public int createEntityMeta(EntityMeta entityMeta) {
		int count = 0;
		String tableName = entityMeta.getName();
		if(ValidationUtil.isNotEmpty(tableName))
		{
			if(createTable(tableName.toUpperCase()))
			{
				String sql = "INSERT INTO ENTITY (ID,OWNER,NAME,TABLE_NAME,ALIAS,DESCRIPTION,"
						+ "UPDATED_DATE,IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?)";
				
				Object[] params = new Object[] {entityMeta.getId(),entityMeta.getOwner(),entityMeta.getName(),
						entityMeta.getName(),entityMeta.getAlias(),entityMeta.getDescription(),
						entityMeta.getUpdatedDate(),entityMeta.getIsActive(),entityMeta.getUpdatedBy(),
						entityMeta.getCreatedBy(),entityMeta.getCreatedDate()};
				
				DBAccessor accessor = new DBAccessor();
				try {
					count = accessor.update(sql.toString(), params);
				} catch (SQLException e) {
					rollbackTable(tableName);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return count;
	}

	public int createEntityFieldMeta(EntityFieldMeta entityFieldMeta) {
		
		int count = 0;
		String sql = "INSERT INTO ENTITY_FIELDS (ID,OWNER,ENTITY_ID,NAME,ALIAS,TYPE,"
				+ "IS_DROPDOWN,VALUE,IS_NULLABLE,DESCRIPTION,HELP_TEXT,"
				+ "UPDATED_DATE,IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params = new Object[] {entityFieldMeta.getId(),entityFieldMeta.getOwner(),entityFieldMeta.getEntityId(),
				entityFieldMeta.getName(),entityFieldMeta.getAlias(),entityFieldMeta.getType(),
				entityFieldMeta.getIsDropdown(),entityFieldMeta.getValue(),entityFieldMeta.getIsNullable(),
				entityFieldMeta.getDescription(),entityFieldMeta.getHelpText(),entityFieldMeta.getUpdatedDate(),
				entityFieldMeta.getIsActive(),entityFieldMeta.getUpdatedBy(),entityFieldMeta.getCreatedBy(),entityFieldMeta.getCreatedDate()};
		
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.update(sql.toString(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int createEntityFieldsMeta(List<EntityFieldMeta> entityFieldsMeta) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEntityMeta(Map<String, Object> entityMeta) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEntityFieldsMeta(List<EntityFieldMeta> entityFieldsMeta) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEntityMeta(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEntityFieldMeta(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEntityFieldsMeta(List<String> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<EntityMeta> getEntitiesMeta(EntityMeta entity) {
		List<EntityMeta> entities = null;
		String sql = "SELECT ID, OWNER, NAME, TABLE_NAME, ALIAS, DESCRIPTION, UPDATED_DATE, "
				+ "IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE "
				+ "FROM ENTITY "
				+ "WHERE OWNER=? ";
		List<Object> params = new ArrayList<Object> ();
		params.add(entity.getOwner());
		if(ValidationUtil.isNotEmpty(entity.getName()))
		{
			sql+="AND NAME=?";
			params.add(entity.getName());
		}
		if(ValidationUtil.isNotEmpty(entity.getId()))
		{
			sql+="AND ID=?";
			params.add(entity.getId());
		}
//		if(ValidationUtil.isNotEmpty(entity.G()))
//		{
//			sql+="AND NAME=?";
//			params.add(entity.getName());
//		}
		
		DBAccessor accessor = new DBAccessor();
		try {
			entities = (List<EntityMeta>)accessor.select(sql, params.toArray(),new EntityMetaProcessor());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entities;
	}

	public EntityMeta getEntityByName(String owner, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createEntityRelation(Relation relation) {
		int count = 0;
		String sql = "INSERT INTO ENTITY_RELATION (OWNER,PARENT_ENTITY_ID,CHILD_ENTITY_ID,"
				+ "PARENT_FIELD_ID,CHILD_FEILD_ID,RELATIONSHIP,"
				+ "UPDATED_DATE,IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		
		List<Object[]> parameters = new ArrayList<Object[]>();
		
		if(relation.getFields()!=null && relation.getFields().size()>0)
		{
			for (RelationField relationField : relation.getFields())
			{
				Object[] params = new Object[] {relation.getOwner(),relation.getParentEntityId(),
						relation.getChildEntityId(),relationField.getParentFeildId(),relationField.getChildFieldId(),
						relation.getRelation(),relationField.getUpdatedDate(),relationField.getIsActive(),
						relationField.getUpdatedBy(),relationField.getCreatedBy(),relationField.getCreatedDate()};
				parameters.add(params);
			}
			DBAccessor accessor = new DBAccessor();
			try {
				count = accessor.batchUpdate(sql, parameters);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	public int updateRelation(Relation relation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEntityMeta(String owner, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEntityFieldMeta(String owner, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteEntityFieldsMeta(String owner, List<String> names) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteRelation(Relation relation) {
		// TODO Auto-generated method stub
		return 0;
	}
	


	@Override
	public EntityMeta getEntityMetaById(String id) {
		EntityMeta entity = null;
		String sql = "SELECT ID, OWNER, NAME, TABLE_NAME, ALIAS, DESCRIPTION, UPDATED_DATE, "
				+ "IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE "
				+ "FROM ENTITY "
				+ "WHERE ID=?";
		Object[] params = new Object[] {id};
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<EntityMeta> entities = (List<EntityMeta>)accessor.select(sql, params,new EntityMetaProcessor());
			if(entities!=null && entities.size()>0)
			{
				entity = entities.get(0);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}
	

	@Override
	public EntityFieldMeta getEntityFieldMetaById(String id) {
		// TODO Auto-generated method stub
		EntityFieldMeta entityField = null;
		String sql = "SELECT ID, ENTITY_ID, OWNER, NAME, ALIAS,TYPE,VALUE,IS_DROPDOWN,IS_NULLABLE,"
				+ " DESCRIPTION, HELP_TEXT,LENGTH, UPDATED_DATE,"
				+ "IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE "
				+ "FROM ENTITY_FIELDS "
				+ "WHERE ID=?";
		Object[] params = new Object[] {id};
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<EntityFieldMeta> entities = (List<EntityFieldMeta>) accessor.select(sql, params,new EntityFieldMetaProcessor());
			if(entities!=null && entities.size()>0)
			{
				entityField = entities.get(0);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entityField;
	}
	
	@Override
	public List<EntityFieldMeta> getEntityFieldMetaByFieldModel(EntityFieldMeta fieldSearchCondition) {
		// TODO Auto-generated method stub
		List<EntityFieldMeta> entityFields = null;
		String sql = "SELECT ID, ENTITY_ID, OWNER, NAME, ALIAS,TYPE,VALUE,IS_DROPDOWN,IS_NULLABLE,"
				+ " DESCRIPTION, HELP_TEXT,LENGTH, UPDATED_DATE,"
				+ "IS_ACTIVE,UPDATED_BY,CREATED_BY,CREATED_DATE "
				+ "FROM ENTITY_FIELDS "
				+ "WHERE OWNER=? ";
		List<Object> params= new ArrayList<Object>();
		params.add(fieldSearchCondition.getOwner());
		if(ValidationUtil.isEmpty(fieldSearchCondition.getEntityId()))
		{
			sql +="AND ENTITY_ID=?";
			params.add(fieldSearchCondition.getEntityId());
		}
		
//		if(ValidationUtil.isEmpty(fieldSearchCondition.GET()))
//		{
			
//		}
		
		DBAccessor accessor = new DBAccessor();
		try {
			entityFields = (List<EntityFieldMeta>) accessor.select(sql, params.toArray(),new EntityFieldMetaProcessor());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entityFields;
	}
	
	private boolean createTable(String tableName)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE ");
		sql.append(tableName);
		sql.append(" (ID VARCHAR(128) NOT NULL,");
		sql.append(" OWNER VARCHAR(225) NOT NULL,");
		sql.append(" FIELD_NAME VARCHAR(225) NOT NULL,");
		sql.append(" VALUE VARCHAR(225) NOT NULL,");
		sql.append(" CREATED_BY VARCHAR(225) NOT NULL,");
		sql.append(" CREATED_DATE DATETIME NOT NULL,");
		sql.append(" UPDATED_BY VARCHAR(225) NOT NULL,");
		sql.append(" UPDATED_DATE DATETIME NOT NULL,");
		sql.append(" IS_ACTIVE VARCHAR(1) NOT NULL) ");
		
		DBAccessor accessor = new DBAccessor();
		try {
			accessor.update(sql.toString(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		if(createTableIndex(tableName) && createTableUniqueIndex(tableName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean createTableIndex(String tableName)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("ALTER TABLE ");
		sql.append(tableName);
		sql.append(" ADD INDEX ");
		sql.append(tableName);
		sql.append("_IDX (OWNER ASC, FIELD_NAME ASC)  COMMENT '' ");

		DBAccessor accessor = new DBAccessor();
		try {
			accessor.update(sql.toString(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollbackTable(tableName);
			return false;
		}
		return true;
	}

	private boolean createTableUniqueIndex(String tableName)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("ALTER TABLE ");
		sql.append(tableName);
		sql.append(" ADD UNIQUE INDEX ");
		sql.append(tableName);
		sql.append("_UNIQUE (ID ASC,FIELD_NAME ASC)  COMMENT '' ");

		DBAccessor accessor = new DBAccessor();
		try {
			accessor.update(sql.toString(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollbackTable(tableName);
			return false;
		}
		return true;
	}

	private static void rollbackTable(String tableName)
	{
		String sql = "DROP TABLE "+tableName;
		
		DBAccessor accessor = new DBAccessor();
		try {
			accessor.update(sql.toString(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/*
*$Log: av-env.bat,v $
*/