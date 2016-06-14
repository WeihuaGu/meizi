package com.weihuagu.model;

public class ImageFactory {
	public static final String topit = "topit"; 
	public static final String dbmeinv = "dbmeinv"; 
	public IImages factory(String type){
		if(type==topit){
		return new TopitImage();	
		}
		if(type==dbmeinv){
			return new Images();	
			}
		return null;
		
	}
}
