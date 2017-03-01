package com.vv.utils;

public class FileNameBuilder {
	public String generateFileName(String actualName,String reqFileName,String extType){
		String splitArr[] = actualName.split("\\.");
		return reqFileName+"_"+extType+"."+splitArr[splitArr.length-1];
	}
}
