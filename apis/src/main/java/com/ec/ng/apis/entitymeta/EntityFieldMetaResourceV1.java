package com.ec.ng.apis.entitymeta;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.entitymeta.model.EntityFieldMeta;
import com.ec.ng.entitymeta.service.EntityMetaService;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityFieldMetaResourceV1.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityFieldMetaResourceV1.java Jul 16, 2015 2:01:24 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 16, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Path("/v1/meta/fields")
@Produces({MediaType.APPLICATION_JSON})
public class EntityFieldMetaResourceV1 {

	@Autowired
	private EntityMetaService entityMetaService;
	
	@GET
	@Path("/{id}")
	public EntityFieldMeta getEntityFieldMetaById(@PathParam("id") String id)
	{
		EntityFieldMeta entityField = entityMetaService.getEntityFieldMetaById(id);
		return entityField;
	}

	@GET
	public List<EntityFieldMeta> getEntityFieldMeta(@QueryParam("owner") String owner, @QueryParam("entityId") String entityId)
	{
		EntityFieldMeta searchCondition = new EntityFieldMeta();
		searchCondition.setOwner(owner);
		searchCondition.setEntityId(entityId);
		List<EntityFieldMeta> entityFields = entityMetaService.getEntityFieldMetaByFieldModel(searchCondition);
		return entityFields;
	}
	
	@POST
	public EntityFieldMeta createEntityMetaFields(EntityFieldMeta entityFieldMeta) {
		
		EntityFieldMeta result = new EntityFieldMeta();
		String id = entityMetaService.createEntityFieldMeta(entityFieldMeta);
		result.setId(id);
		return result; 
	}
}

/*
*$Log: av-env.bat,v $
*/