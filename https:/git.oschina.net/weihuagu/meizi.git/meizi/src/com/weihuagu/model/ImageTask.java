package com.weihuagu.model;

import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

public class ImageTask extends AsyncTask<String, Void, List<ImageInfo>> {
	 private static final String URL = "http://www.dbmeinv.com/dbgroup/show.htm?cid=";
	 private int pageNum=1;
	 public AsyncResponse asyncResponse;  
	 
     public void setOnAsyncResponse(AsyncResponse asyncResponse)
     {
         this.asyncResponse = asyncResponse;
     }

	@Override
	protected List<ImageInfo> doInBackground(String ... categorylist) {
		// TODO Auto-generated method stub
		String source=categorylist[0];
		String category=categorylist[1];
		IImages images=new ImageFactory().factory(source);
		List<ImageInfo> imgs=images.getAllImages(category);
		return imgs;
	}
	
	@Override
    protected void onPostExecute(List<ImageInfo> imagelist) {          
        super.onPostExecute(imagelist);       
        if (imagelist != null)
        {               
            asyncResponse.onDataReceivedSuccess(imagelist);//将结果传给回调接口中的函数
        }
        else {
            asyncResponse.onDataReceivedFailed();
        }

    }               

}
