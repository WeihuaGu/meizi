package com.weihuagu.model;

public class ImageFactory {
	public static final String tuchong="tuchong";
	public static final String dbmeinv = "dbmeinv"; 
	public static final String duitang="duitang";
	public IImages factory(String type){
		if(type==dbmeinv){
			return new DbmeinvImage();	
		}
		if(type==tuchong){
			return new TuchongImage();
		}
		if(type==duitang){
			return new DuitangImage();
		}
		return null;
		
	}
}
