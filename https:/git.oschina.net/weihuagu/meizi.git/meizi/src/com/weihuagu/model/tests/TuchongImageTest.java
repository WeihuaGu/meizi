package com.weihuagu.model.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.weihuagu.model.ImageInfo;
import com.weihuagu.model.DbmeinvImage;
import com.weihuagu.model.TuchongImage;

import android.util.Log;

public class TuchongImageTest {
	private TuchongImage img=new TuchongImage();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetAllImages(){
	
				List<ImageInfo> imags=img.getAllImages("美女");
				assertNotNull(imags);
				Log.v("outdebug", imags.get(0).getImgUrl());
		
	}

}
