package com.weihuagu.meizi;
import com.baidu.appx.BDBannerAd;
import com.weihuagu.meizi.R;
import com.weihuagu.view.AdListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends Activity {
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
			
			bannerview = new BDBannerAd(this, SDK_APP_KEY, SDK_BANNER_AD_ID);
			bannerview.setAdSize(BDBannerAd.SIZE_FLEXIBLE);
			bannerview.setAdListener(new AdListener("Banner"));
			println(bannerview.toString());
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
    public void clearLog(View v) {
    	if (logview != null) {
			logview.setText("");
		}
    }

   
	private TextView  logview;
	@SuppressLint("InlinedApi") 
	private void println(String tag, String msg) {
		if (null == logview) {
			logview = (TextView)findViewById(R.id.logview);
		}
		logview.append("\n" + tag + msg);
	}
	
	private void println(String msg) {
		println("", msg);
	}
	
	@Override
	protected void onDestroy() {
		if (bannerview != null) {
			bannerview.destroy();
		}
		super.onDestroy();
	}

}
