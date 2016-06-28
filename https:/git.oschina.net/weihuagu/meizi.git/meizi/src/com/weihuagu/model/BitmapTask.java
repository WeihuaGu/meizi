package com.weihuagu.model;

import java.util.List;

import com.weihuagu.utils.Web;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class BitmapTask extends AsyncTask<String, Void,Bitmap> {
    private BitmapAsyncResponse asyncResponse=null;
	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		String source=params[0];
		Bitmap image =Web.getBitMBitmap(source);
		return image;
	}
	public void setOnAsyncResponse(BitmapAsyncResponse asyncResponse)
    {
        this.asyncResponse = asyncResponse;
    }
	@Override
    protected void onPostExecute(Bitmap bitmap) {          
        super.onPostExecute(bitmap);       
        if (bitmap != null)
        {               
            asyncResponse.onDataReceivedSuccess(bitmap);//将结果传给回调接口中的函数
        }
        else {
            asyncResponse.onDataReceivedFailed();
        }

    }               
}
