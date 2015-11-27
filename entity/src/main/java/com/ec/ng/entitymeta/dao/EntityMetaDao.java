package com.ec.ng.entitymeta.dao;

import java.util.List;
import java.util.Map;

import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.entitymeta.model.EntityFieldMeta;
import com.ec.ng.entitymeta.model.Relation;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityMetaDao.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityMetaDao.java Jul 11, 2015 1:48:06 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 11, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public interface EntityMetaDao 
{
	public int createEntityMeta (EntityMeta entityMeta);
	
	public int createEntityFieldMeta (EntityFieldMeta entityFieldMeta);
	
	public int createEntityFieldsMeta (List<EntityFieldMeta> entityFieldsMeta);
	
	public int createEntityRelation (Relation relation);
	
	public int updateEntityMeta(Map<String, Object> entityMeta);
	
	public int updateRelation (Relation relation);
	
	public int updateEntityFieldsMeta (List<EntityFieldMeta> entityFieldsMeta);
	
	public int deleteEntityMeta(String owner, String name);
	
	public int deleteEntityFieldMeta(String owner, String name);
	
	public int deleteEntityFieldsMeta(String owner, List<String> names);
	
	public int deleteRelation (Relation relation);
	
	public List<EntityMeta> getEntitiesMeta (EntityMeta entity);
	
	public EntityMeta getEntityMetaById (String id);
	
	public EntityFieldMeta getEntityFieldMetaById (String id);
	
	public List<EntityFieldMeta> getEntityFieldMetaByFieldModel(EntityFieldMeta fieldSearchCondition);
}

/*
*$Log: av-env.bat,v $
*/