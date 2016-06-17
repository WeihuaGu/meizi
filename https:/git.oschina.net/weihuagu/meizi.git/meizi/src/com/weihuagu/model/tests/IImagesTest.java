package com.weihuagu.model.tests;

import java.util.List;

import org.junit.Test;

import com.weihuagu.model.ImageInfo;
import com.weihuagu.model.DbmeinvImage;

import android.util.Log;
import junit.framework.TestCase;

public class IImagesTest extends TestCase {
	private static final String URL = "http://www.dbmeinv.com/dbgroup/show.htm?cid=5&pager_offset=2";
	private DbmeinvImage img=new DbmeinvImage();
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testgetAllImages(){
	
				List<ImageInfo> imags=img.getAllImages(URL);
				assertNotNull(imags);
		
	}

}
