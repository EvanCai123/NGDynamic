package com.ec.ng.entity.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.ng.entity.dao.EntityDao;
import com.ec.ng.entity.model.EntityField;
import com.ec.ng.entity.service.EntityService;
import com.ec.ng.entitymeta.dao.EntityMetaDao;
import com.ec.ng.framework.idgenerator.UUIDGenerator;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityServiceImp.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityServiceImp.java Jul 17, 2015 2:55:59 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 17, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Service(value = "entityService")
public class EntityServiceImp implements EntityService{

	@Autowired
	private EntityDao entityDao;
	@Override
	public String create(String owner, String entityName, List<EntityField> entityFields) {
		String result = null;
		if(entityFields!=null && entityFields.size()>0)
		{
			String id = UUIDGenerator.getUUID();
			for(EntityField entity:entityFields)
			{
				entity.setId(id);
				
			}
			if(entityDao.create(owner, entityName, entityFields)>0)
			{
				result = id;
			}
		}
		
		return result;
	}

	@Override
	public List<EntityField> loadById(String owner, String id,  String entityName, List<String> returnFields) {
		
		return entityDao.loadById(id, entityName, returnFields);
	}

	@Override
	public List<EntityField> query(String owner, String entityName,
			Map<Object, Object> searchCondition, List<String> returnFields) {
		// TODO Auto-generated method stub
		return entityDao.query(owner, entityName, searchCondition, returnFields);
	}

}

/*
*$Log: av-env.bat,v $
*/