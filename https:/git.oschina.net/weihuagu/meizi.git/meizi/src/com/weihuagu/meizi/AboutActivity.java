package com.weihuagu.meizi;
import com.baidu.appx.BDBannerAd;
import com.weihuagu.view.AdListener;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
	 public static final String  SDK_APP_KEY="dFUqWHAm6sTNt1R3yPlrXaDPVCiTkcem";
	 private String SDK_INTERSTITIAL_AD_ID="TAFEZmRD5ITGA9ynLunoWlCC";
	 private String SDK_BANNER_AD_ID = "ZKMa6z9z8a5Buv2ohfxzF7cy";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

	}
	private BDBannerAd	bannerview;
	public void showBanner(View v) {
    	if (null == bannerview) {
			println("---- bannerAd start to show ----");
			bannerview = new BDBannerAd(this, SDK_APP_KEY, SDK_BANNER_AD_ID);
			bannerview.setAdSize(BDBannerAd.SIZE_FLEXIBLE);
			bannerview.setAdListener(new AdListener("Banner"));
			ViewGroup  container = (ViewGroup)findViewById(R.id.adview_container);
			container.addView(bannerview);
		}
    	else {
    		println("---- bannerAd is showing, should hide first");
    	}
    }

    public void hideBanner(View v) {
    	if (bannerview != null) {
			ViewGroup  container = (ViewGroup)findViewById(R.id.adview_container);
			container.removeAllViews();
			bannerview.destroy();
			bannerview = null;
			println("---- bannerAd is hidden ----");
		}
    	else {
			println("---- bannerAd not found ----");
    	}
    }
    public void println(String text){
    	Log.v("ad",text);
    }


}
