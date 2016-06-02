package com.hb.util;

import java.util.UUID;

public class nameConvert {

	public static String nameConverttoUUID(String sourcefilename) {


		int beginindex = sourcefilename.lastIndexOf(".");
		
		String goalfilename = UUID.randomUUID().toString()+sourcefilename.substring(beginindex, sourcefilename.length());
		
		return goalfilename;
	}
}
