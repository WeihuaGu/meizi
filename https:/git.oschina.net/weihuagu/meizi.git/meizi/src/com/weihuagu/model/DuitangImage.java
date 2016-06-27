package com.weihuagu.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class DuitangImage implements IImages {
	public static final String[] tabTitles = new String[]{ "婚纱","摄影"};
    public  static final String[] tabIds = new String[]{"wedding","photography"};
    private static final String pageUrl = "http://www.duitang.com/category/?cat=";
    private Map<String, String> cookies = new  HashMap<String,String>();
	@Override
	public List<ImageInfo> getAllImages(String category) {
		// TODO Auto-generated method stub
		 try {
	        	String pageUrl=this.pageUrl+category;
	        	
	        	cookies.put("js", "1");
	        	cookies.put("sessionid", "c0df61e9-b36f-42d2-b6a3-f13957d0e1fc");
	        	cookies.put("__utma", "74400135.1168219620.1466907913.1466907913.1466907913.1");
	        	cookies.put("_utmb", "74400135.33.10.1466907913");
	        	cookies.put(" __utmz", "74400135.1466907913.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); js=1");
				cookies.put("_fromcat", "category");
				cookies.put("__utmc", "74400135");
				cookies.put("__utmt","1");
	            Document doc = Jsoup.connect(pageUrl)
	            		.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux i686; rv:47.0) Gecko/20100101 Firefox/47.0") 
	            		.cookies(cookies)
	                    .timeout(10000)
	                    .post();
	            String title = doc.title();
	           // Elements urls = doc.select("div.mbpho").select("img[src$=.jpeg]");
	            Elements urls = doc.select("div.mbpho");
	            if(urls.isEmpty()==true){
	            	Log.v("zhuaqu","get the elements null in DuitangImage");
	                Log.v("zhuaqu", "page  url  is "+pageUrl);
	                Log.v("zhuaqu", doc.toString());
	            }
	            List<ImageInfo> imgList = new ArrayList<ImageInfo>();
	            ImageInfo imageInfo;
	            for (Element url : urls) {
	                imageInfo = new ImageInfo();
	                imageInfo.setImgTitle(url.attr("alt"));
	                imageInfo.setImgUrl(url.attr("src"));
	                imgList.add(imageInfo);
	            }

	            return imgList;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
		
	}

}
