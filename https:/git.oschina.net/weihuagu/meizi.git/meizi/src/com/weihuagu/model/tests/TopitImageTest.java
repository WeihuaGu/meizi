package com.weihuagu.model.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.weihuagu.model.TopitImage;
import com.weihuagu.model.ImageInfo;

import android.util.Log;
import junit.framework.TestCase;

public class TopitImageTest extends TestCase {
  private String pageUrl="http://www.topit.me/tag/校服的裙摆";
	//@Before
	//public void setUp() throws Exception {
	//}

	@Test
	public void testgetAllImages(){
		TopitImage huaban=new TopitImage();
		List<ImageInfo> imags=huaban.getAllImages(this.pageUrl);
		assertNotNull(imags);
		
	}

}
