package com.weihuagu.model;

public class ImageFactory {
	public static final String tuchong="tuchong";
	public static final String dbmeinv = "dbmeinv"; 
	public IImages factory(String type){
		if(type==dbmeinv){
			return new DbmeinvImage();	
		}
		if(type==tuchong){
			return new TuchongImage();
		}
		return null;
		
	}
}
