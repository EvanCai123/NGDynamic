package com.ec.ng.framework.commonUtil;

import org.apache.catalina.realm.RealmBase;

/**
 * <pre>
 * 
 *  Next Generation
 *  File: EncryptionUtil.java
 * 
 *  Evan Cai.
 *  Copyright (C): 2015
 * 
 *  Description:
 *  TODO
 * 
 *  Notes:
 * 	$Id: EncryptionUtil.java Jul 20, 2015 2:01:39 PM Evan Cai $ 
 * 
 *  Revision History
 *  &lt;Date&gt;,			&lt;Who&gt;,			&lt;What&gt;
 *  Jul 20, 2015		Evan Cai		Initial.
 *  
 * </pre>
 */
public class EncryptionUtil {

	public static String encryptPassword(String password)
	{
		return RealmBase.Digest(password, "SHA", null);
	}
}

/*
*$Log: av-env.bat,v $
*/