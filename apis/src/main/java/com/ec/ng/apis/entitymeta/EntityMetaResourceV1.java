package com.ec.ng.apis.entitymeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.entitymeta.model.EntityMeta;
import com.ec.ng.entitymeta.service.EntityMetaService;
import com.ec.ng.framework.idgenerator.UUIDGenerator;


/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityMetaResourceV1.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityMetaResourceV1.java Jul 14, 2015 8:05:15 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 14, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Path("/v1/meta/entities")
@Produces({MediaType.APPLICATION_JSON})
public class EntityMetaResourceV1 
{
	@Autowired
	private EntityMetaService entityMetaService;
	
	@GET
	@Path("/{id}")
	public EntityMeta getEntityMetaById(@PathParam("id") String id)
	{
		EntityMeta entity = entityMetaService.getEntityMetaById(id);
		return entity;
	}
	
	@GET
	public List<EntityMeta> getEntitiesMeta(@QueryParam("owner") String owner,@QueryParam("name") String name)
	{
		EntityMeta entityMeta = new EntityMeta();
		entityMeta.setOwner(owner);
		entityMeta.setName(name);
		List<EntityMeta> entities = entityMetaService.getEntitiesMeta(entityMeta);
		return entities;
	}
	
	@POST
	public EntityMeta createEntityMeta(EntityMeta entityMeta) {
		
		EntityMeta result = new EntityMeta();
		String id = entityMetaService.createEntityMeta(entityMeta);
		result.setId(id);
		return result;
	}
	
	@PUT
	public String createEntityMeta(Map<String, Object> entityMeta) {
		
		int id = entityMetaService.updateEntityMeta(entityMeta);
		String result = null;
		return result;
	}
}

/*
*$Log: av-env.bat,v $
*/