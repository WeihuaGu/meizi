package com.weihuagu.utils;

import java.io.IOException;
import java.net.MalformedURLException;

public class WebPage {
	public static  String getWebPageByString(String pageUrl){
		 /**HtmlUnit请求web页面*/  
       // WebClient wc = new WebClient();  
        return "<html><head><title>test<title></head><body>test</body></html>";
        /**
        wc.getOptions().setJavaScriptEnabled(true); //启用JS解释器，默认为true  
        //wc.getOptions().setCssEnabled(false); //禁用css支持  
        wc.getOptions().setThrowExceptionOnScriptError(false); //js运行错误时，是否抛出异常  
        wc.getOptions().setTimeout(1500); //设置连接超时时间 ，这里是10S。如果为0，则无限期等待  
        try {
			HtmlPage page = (HtmlPage)wc.getPage(pageUrl);
			String pageXml = page.asXml();
			return pageXml;
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  
		**/
	}
		
}
