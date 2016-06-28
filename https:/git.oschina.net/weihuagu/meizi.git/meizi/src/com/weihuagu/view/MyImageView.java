package com.weihuagu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyImageView extends ImageView{
	 private String imgurl=null;
	    public void setImgUrl(String url){
	    	this.imgurl=url;
	    }
	    public String getImgUrl(){
	    	return this.imgurl;
	    }
		public MyImageView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		

}
