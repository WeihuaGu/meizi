package com.weihuagu.model;

import java.util.List;

import android.os.AsyncTask;

public class ImageTask extends AsyncTask<String, Void, List<ImageInfo>> {
	 private static final String URL = "http://www.dbmeinv.com/dbgroup/show.htm?cid=";
	 private int pageNum=5;
	 public AsyncResponse asyncResponse;  
	 
     public void setOnAsyncResponse(AsyncResponse asyncResponse)
     {
         this.asyncResponse = asyncResponse;
     }

	@Override
	protected List<ImageInfo> doInBackground(String ... mCategoryId) {
		// TODO Auto-generated method stub
		 final String pageUrl = URL + mCategoryId[0] + "&pager_offset=" + pageNum;
		//Images images=new Images();
		//return images.getAllImages(pageUrl);
		 return null;
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
