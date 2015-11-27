package com.ec.ng.entity.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

import com.ec.ng.entity.dao.EntityDao;
import com.ec.ng.entity.model.EntityField;
import com.ec.ng.entity.processor.EntityProcessor;
import com.ec.ng.framework.dataUtil.DBAccessor;

/**
 * <pre>T
 * 
 *  Next Generation
 *  File: EntityDaoImp.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityDaoImp.java Jul 10, 2015 11:24:02 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */

@Repository(value="entityDao")
public class EntityDaoImp implements EntityDao{

	@Override
	public int create(String owner, String entityName, List<EntityField> entityFields) {
		int count =0;
		String sql ="INSERT INTO "+entityName+" (ID,OWNER,"
				+ "FIELD_NAME,VALUE,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE) " 
				+ "values(?,?,?,?,?,?,?,?,?)";

		
		List<Object[]> parameters = new ArrayList<Object[]>();
		
		if(entityFields!=null && entityFields.size()>0)
		{
			for (EntityField field : entityFields)
			{
				Object[] params = new Object[] {field.getId(),owner,field.getName(),field.getValue(),
						field.getCreatedBy(),field.getCreatedDate(),field.getUpdatedBy(),
						field.getUpdatedDate(),field.getIsActive()};
				parameters.add(params);
			}
		}		
		DBAccessor accessor = new DBAccessor();
		try {
			count = accessor.batchUpdate(sql, parameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<EntityField> loadById(String id, String entityName, List<String> returnFields) {
		List<EntityField> result = null;
		String sql = "SELECT ID, OWNER,FIELD_NAME,VALUE,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE "
				+ "FROM "+entityName
				+ " WHERE ID=?";
		Object[] params = new Object[] {id};
		
		DBAccessor accessor = new DBAccessor();
		try {
			List<EntityField> entities = (List<EntityField>)accessor.select(sql, params,new EntityProcessor());
			
			if(entities!=null && entities.size()>0)
			{
				result = new ArrayList<EntityField>();
				for (EntityField entity : entities)
				{
					result.add(entity);
				}
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int batchCreate(List<Map<Object, Object>> entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Map<Object, Object> entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchUpdate(List<Map<Object, Object>> entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Map<Object, Object> entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchDelete(Map<Object, Object> entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EntityField> query(String owner,String entityName, Map<Object, Object> searchCondition,
			List<String> returnFields) {
		List<EntityField> entities = null;
		String sql = "SELECT ID, OWNER,FIELD_NAME,VALUE,CREATED_BY,CREATED_DATE,UPDATED_BY,UPDATED_DATE,IS_ACTIVE "
				+ "FROM "+entityName
				+ " WHERE OWNER=?";
		List<Object> params = new ArrayList<Object>();
		params.add(owner);
		
		DBAccessor accessor = new DBAccessor();
		try {
			entities = (List<EntityField>)accessor.select(sql, params.toArray(),new EntityProcessor());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entities;
	}
}

/*
*$Log: av-env.bat,v $
*/