package com.ec.ng.entity.dao;

import java.util.List;
import java.util.Map;

import com.ec.ng.entity.model.EntityField;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityDao.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityDao.java Jul 10, 2015 11:23:26 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 10, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface EntityDao 
{
	public int create(String owner, String entityName, List<EntityField> entityFields);
	
	public List<EntityField> loadById(String id, String entityName, List<String> returnFields);
	
	public int batchCreate (List<Map<Object, Object>> entity);
	
	public int update (Map<Object, Object> entity);
	
	public int batchUpdate (List<Map<Object, Object>> entity);
	
	public int delete (Map<Object, Object> entity);
	
	public int batchDelete (Map<Object, Object> entity);
	
	public List<EntityField> query(String owner,String entityName, Map<Object, Object> searchCondition,
			List<String> returnFields);
	
}

/*
*$Log: av-env.bat,v $
*/