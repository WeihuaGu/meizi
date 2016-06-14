package com.weihuagu.model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

public class Images implements IImages{
	/**
	public static final String[] tabTitles = new String[]{"小清新", "文艺范",
            "大长腿", "黑丝袜", "小翘臀", "大胸妹"};
    public  static final String[] tabIds = new String[]{"4", "5", "3", "7",
            "6", "2"};
     **/
	public static final String[] tabTitles = new String[]{ "小清新", "文艺范"};
    public  static final String[] tabIds = new String[]{"4", "5"};
    private static final String pageUrl = "http://www.dbmeinv.com/dbgroup/show.htm?cid=";
	public List<ImageInfo> getAllImages(String  category) {
        try {
        	String pageUrl=this.pageUrl+category;
            Document doc = Jsoup.connect(pageUrl)
                    .timeout(10000)
                    .post();
            String title = doc.title();
            Elements urls = doc.select("img[src$=.jpg]");
            if(urls.isEmpty()==true)
            	Log.v("outdebug","get the elements null in images");
            List<ImageInfo> imgList = new ArrayList<ImageInfo>();
            ImageInfo imageInfo;
            for (Element url : urls) {
                imageInfo = new ImageInfo();
                imageInfo.setImgTitle(url.attr("title"));
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
