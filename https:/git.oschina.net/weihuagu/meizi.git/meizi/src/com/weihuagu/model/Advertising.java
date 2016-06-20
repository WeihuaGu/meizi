package com.weihuagu.model;

import com.baidu.appx.BDBannerAd;
import com.weihuagu.view.AdListener;

import android.util.Log;

public class Advertising {
	public static final String  SDK_APP_KEY="dFUqWHAm6sTNt1R3yPlrXaDPVCiTkcem";
	private String SDK_INTERSTITIAL_AD_ID="TAFEZmRD5ITGA9ynLunoWlCC";
	private String SDK_BANNER_AD_ID = "ZKMa6z9z8a5Buv2ohfxzF7cy";
	private BDBannerAd	bannerview;
	private IBannerAd bannerad;
	public Advertising(IBannerAd bannerad){
		this.bannerad=bannerad;
		this.bannerad.getAdView(bannerview);
		
	}
	private void println(String msg) {
			Log.v("ad", msg);
	}
	
}
