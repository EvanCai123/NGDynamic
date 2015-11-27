package com.ec.ng.apis.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.ng.entity.model.EntityField;
import com.ec.ng.entity.service.EntityService;
import com.ec.ng.framework.commonUtil.DateTimeUitl;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EntityResourceV1.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EntityResourceV1.java Jul 17, 2015 3:30:06 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 17, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
@Path("/v1/entities/{entityName}")
@Produces({MediaType.APPLICATION_JSON})
public class EntityResourceV1 {
	
	@Autowired
	private EntityService entityService;
	
	@GET
	@Path("/{id}")
	public Map<String, Object> getEntityById(@PathParam("entityName") String entityName, @PathParam("id") String id)
	{
		String owner = "Evan";
		List<EntityField> entityFields = entityService.loadById(owner, id, entityName, null);
		Map<String, Object> entity = new HashMap<String, Object>();
		List<Map<String, Object>> entities = convertEntityFieldToMap(entityFields);
		if(entities!=null)
		{
			entity=entities.get(0);
		}
		return entity;
	}
	
	@GET
	public List<Map<String, Object>> getEntities(@PathParam("entityName") String entityName, @QueryParam("owner") String id)
	{
		String owner = "Evan";
		List<EntityField> entityFields = entityService.query(owner, entityName, null, null);
		
		return convertEntityFieldToMap(entityFields);
	}
	
	@POST
	public Map<String,String> createEntity(@PathParam("entityName") String entityName, Map<String, String> entity) {
		Map<String, String> result = new HashMap<String, String>();
		String owner = "Evan";
		List<EntityField> entityFields= convertMapToEntityField(entityName,entity);
		String id = entityService.create(owner, entityName, entityFields);
		result.put("id", id);
		return result;
	}

	private List<Map<String, Object>> convertEntityFieldToMap(List<EntityField> entityFields)
	{
		Map<String, Map<String, Object>> result = new HashMap<String,Map<String, Object>>();
		if(entityFields!=null && entityFields.size()>0)
		{
			for (EntityField field: entityFields)
			{
				String id = field.getId();
				Map<String, Object> entity = null;
				if(result.get(id)==null)
				{
					entity = new HashMap<String, Object>();
					result.put(id, entity);
				}
				else
				{
					entity = result.get(id);
				}
				
				entity.put("id", field.getId());
				entity.put("createdBy", field.getCreatedBy());
				entity.put("updatedBy", field.getUpdatedBy());
				entity.put("updateDate", field.getUpdatedDate());
				entity.put("createdDate", field.getCreatedDate());
				entity.put("isActive", field.getIsActive());
				entity.put(field.getName(), field.getValue());
			}
		}
		List<Map<String, Object>> entities = new ArrayList<Map<String, Object>>();;
		if(result!=null && result.size()>0)
		{
			entities.addAll(result.values());
			
		}
		return entities;
	}
	
	private List<EntityField> convertMapToEntityField(String entityName, Map<String, String> entity)
	{
		List<EntityField> result = new ArrayList<EntityField>();
		
		if(entity!=null && entity.size()>0)
		{
			Set<String> keySet = entity.keySet();
			for (String key : keySet)
			{
				EntityField field= new EntityField();
				field.setCreatedBy("Evan");
				field.setCreatedDate(DateTimeUitl.getCurrentDate());
				field.setEntityName(entityName);
				field.setIsActive("A");
				field.setName(key);
				field.setValue(entity.get(key));
				field.setUpdatedBy("Evan");
				field.setUpdatedDate(DateTimeUitl.getCurrentDate());
				result.add(field);
			}
		}
		return result;
	}
}

/*
*$Log: av-env.bat,v $
*/