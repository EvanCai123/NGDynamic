package com.ec.ng.entitymeta.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.ng.entitymeta.dao.EntityMetaDao;
import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.entitymeta.model.EntityFieldMeta;
import com.ec.ng.entitymeta.service.EntityMetaService;
import com.ec.ng.framework.idgenerator.UUIDGenerator;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityMetaServiceImp.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityMetaServiceImp.java Jul 14, 2015 11:18:10 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 14, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Service(value = "entityMetaService")
public class EntityMetaServiceImp implements EntityMetaService
{
	@Autowired
	private EntityMetaDao entityMetaDao;
	
	public String createEntityMeta(EntityMeta entityMeta) {
		String id = UUIDGenerator.getUUID();
		entityMeta.setId(id);
		if(entityMetaDao.createEntityMeta(entityMeta)>0)
		{
			return id;
		}
		else
		{
			return null;
		}
	}

	public String createEntityFieldMeta(EntityFieldMeta entityFieldMeta) {
		String id =UUIDGenerator.getUUID();
		entityFieldMeta.setId(id);
		if(entityMetaDao.createEntityFieldMeta(entityFieldMeta)>0)
		{
			return id;
		}
		else
		{
			return null;
		}
	}

	@Override
	public EntityMeta getEntityMetaById(String id) {
		return entityMetaDao.getEntityMetaById(id);
	}

	@Override
	public List<EntityMeta> getEntitiesMeta(EntityMeta entityMeta) {
		return entityMetaDao.getEntitiesMeta(entityMeta);
	}

	@Override
	public EntityFieldMeta getEntityFieldMetaById(String id) {
		return entityMetaDao.getEntityFieldMetaById(id);
	}

	@Override
	public int updateEntityMeta(Map<String, Object> entityMeta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EntityFieldMeta> getEntityFieldMetaByFieldModel(
			EntityFieldMeta fieldSearchCondition) {
		return entityMetaDao.getEntityFieldMetaByFieldModel(fieldSearchCondition);
	}

}

/*
*$Log: av-env.bat,v $
*/