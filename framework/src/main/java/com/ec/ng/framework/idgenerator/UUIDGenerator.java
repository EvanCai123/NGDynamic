package com.ec.ng.framework.idgenerator;

import java.util.UUID;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: UUIDGenerator.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: UUIDGenerator.java Jul 16, 2015 9:23:08 AM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 16, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class UUIDGenerator {

	public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    } 

}

/*
*$Log: av-env.bat,v $
*/