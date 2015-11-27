package com.ec.ng.entitymeta.service;

import java.util.List;
import java.util.Map;

import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.entitymeta.model.EntityFieldMeta;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityMetaService.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityMetaService.java Jul 14, 2015 11:17:33 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 14, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface EntityMetaService 
{
	public String createEntityMeta (EntityMeta entityMeta);
	
	public String createEntityFieldMeta (EntityFieldMeta entityFieldMeta);
	
	public EntityMeta getEntityMetaById (String id);
	
	public List<EntityMeta> getEntitiesMeta (EntityMeta entityMeta);
	
	public EntityFieldMeta getEntityFieldMetaById (String id);
	
	public int updateEntityMeta(Map<String, Object> entityMeta);
	
	public List<EntityFieldMeta> getEntityFieldMetaByFieldModel(EntityFieldMeta fieldSearchCondition);
	
}

/*
*$Log: av-env.bat,v $
*/