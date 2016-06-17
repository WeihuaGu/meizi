package com.weihuagu.model;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class TuchongImage implements IImages {
	public static final String[] tabTitles = new String[]{"少女", "情绪",
    "日系","向美"};
	public  static final String[] tabIds = new String[]{"少女", "情绪", "日系","美女"};
	private String pageUrl="http://tuchong.com/tags/";
    private Map<String, String> cookies = new  HashMap<String,String>();
	@Override
	public List<ImageInfo> getAllImages(String category) {
		// TODO Auto-generated method stub
        Document doc;
		try {
			String pageUrl=this.pageUrl+URLEncoder.encode(category, "UTF-8")+"?order=new";
			cookies.put("version", "pc");
			cookies.put("webp_enabled", "0");
			
			doc = Jsoup.connect(pageUrl)
					.cookies(cookies)
					.url(pageUrl)
			        .userAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:47.0) Gecko/20100101 Firefox/47.0") 
			        .post();
			  Elements div=doc.select("div.post-collage");
			  Elements imgs = doc.select("img[src$=.jpg]");
		      if(div.isEmpty()==true)
	            	Log.v("outdebug","get the elements null in TuchongImage");
	            List<ImageInfo> imgList = new ArrayList<ImageInfo>();
	            for (Element img : imgs) {
	            	ImageInfo imageInfo;  
	                imageInfo = new ImageInfo();
	            	Log.v("outdebug",img.attr("src"));
	                imageInfo.setImgUrl(img.attr("src"));
	                imgList.add(imageInfo);
	            }

	         return imgList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.v("outdebug", "tuchongimage exception"+e.getMessage());
			return null;
		}
      
		
	}

}
