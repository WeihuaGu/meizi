package com.weihuagu.meizi;
import java.io.IOException;
import java.util.List;

import com.bumptech.glide.Glide;
import com.weihuagu.meizi.R;
import com.weihuagu.model.AsyncResponse;
import com.weihuagu.model.BitmapAsyncResponse;
import com.weihuagu.model.BitmapTask;
import com.weihuagu.model.ImageInfo;
import com.weihuagu.utils.Validator;
import com.weihuagu.utils.Web;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class WallPaperActivity extends AppCompatActivity  implements  BitmapAsyncResponse{
	private String imgurl=null;
	private ImageView img=null;
	@Override	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallpaper);
		this.setImgUrl(this.getImgUrl());
		this.initUiResouces();
		
	}
	public void initUiResouces() {
		this.img=(ImageView) findViewById(R.id.imgdetail);
		if (Validator.isEffective(this.imgurl)) {
            Glide.with(this).load(this.imgurl).into(this.img);
        }
		
	}
	public String getImgUrl(){
		Intent intent=getIntent();
		return intent.getStringExtra("imgurl");
}
	public void setImgUrl(String url){
		this.imgurl=url;
		
	}
    public void setWallpaper (View v) {  
    	
    	BitmapTask task=new BitmapTask();
    	task.setOnAsyncResponse(this);
    	task.execute(this.imgurl);
    	
    }
	
	@Override
	public void onDataReceivedFailed() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onDataReceivedSuccess(Bitmap image) {
		// TODO Auto-generated method stub
		 WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
		 try
			{
				wallpaperManager.setBitmap(image);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		
	}  
	
}
