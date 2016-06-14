package com.weihuagu.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.weihuagu.utils.WebPage;

import android.util.Log;

public class TopitImage implements IImages {
	public static final String[] tabTitles = new String[]{"校服的裙摆", "清纯",
            "婚纱"};
    public  static final String[] tabIds = new String[]{"校服的裙摆", "清纯",
    "婚纱"};
    private String pageUrl="http://www.topit.me/tag/";
	@Override
	public List<ImageInfo> getAllImages(String  category) {
		  String pageUrl=this.pageUrl+category;
		  String pageXml=WebPage.getWebPageByString(pageUrl);
		  Document doc = Jsoup.parse(pageXml);
		  Log.v("outdebug",doc.toString());
		   Elements urls =doc.select("img");
		  // Elements urls =imgs.select("[src$=.jpg]");
		   Log.v("outdebug", String.valueOf(urls.size()));
		   if(urls.isEmpty()==true)
		    	Log.v("outdebug","get the elements null in topit");
		   List<ImageInfo> imgList = new ArrayList<ImageInfo>();
		   ImageInfo imageInfo;
		    for (Element url : urls) {
		        imageInfo = new ImageInfo();
		        imageInfo.setImgUrl(url.attr("src"));
		        imgList.add(imageInfo);
		    }
		    return imgList;
	}

}
