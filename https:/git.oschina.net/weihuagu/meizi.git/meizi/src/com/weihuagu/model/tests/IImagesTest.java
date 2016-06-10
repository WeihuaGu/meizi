package com.weihuagu.model.tests;

import org.junit.Test;

import com.weihuagu.model.Images;

import junit.framework.TestCase;

public class IImagesTest extends TestCase {
	private static final String URL = "http://www.dbmeinv.com/dbgroup/show.htm?cid=5&pager_offset=2";
	private Images img=new Images();
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void getAllImages(){
		assertEquals("youku","youku");
		
	}

}
