package com.ec.ng.entity.service;

import java.util.List;
import java.util.Map;

import com.ec.ng.entity.model.EntityField;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityService.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityService.java Jul 17, 2015 2:55:34 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 17, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface EntityService {

	public String create(String owner, String entityName, List<EntityField> entityFields);
	
	public List<EntityField> loadById(String owner, String id,  String entityName, List<String> returnFields) ;
	
	public List<EntityField> query(String owner,String entityName, Map<Object, Object> searchCondition,
			List<String> returnFields);
}

/*
*$Log: av-env.bat,v $
*/