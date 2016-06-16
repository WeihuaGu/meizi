package com.weihuagu.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class TuchongImage implements IImages {
	public static final String[] tabTitles = new String[]{"少女", "情绪",
    "日系","向美"};
	public  static final String[] tabIds = new String[]{"少女", "情绪", "日系","美女"};
	private String pageUrl="https://tuchong.com/tags/";

	@Override
	public List<ImageInfo> getAllImages(String category) {
		// TODO Auto-generated method stub
		String pageUrl=this.pageUrl+category+"?order=new";
        Document doc;
		try {
			doc = Jsoup.connect(pageUrl)
			        .timeout(10000)
			        .post();
			  String title = doc.title();
		      Elements urls = doc.select("figure.main-collage").select("img[src$=.jpg]");
		      if(urls.isEmpty()==true)
	            	Log.v("outdebug","get the elements null in TuchongImage");
	            List<ImageInfo> imgList = new ArrayList<ImageInfo>();
	            ImageInfo imageInfo;
	            for (Element url : urls) {
	                imageInfo = new ImageInfo();
	                //imageInfo.setImgTitle(url.attr("title"));
	                imageInfo.setImgUrl(url.attr("src"));
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
