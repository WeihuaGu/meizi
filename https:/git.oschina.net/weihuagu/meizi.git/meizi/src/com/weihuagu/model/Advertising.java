package com.weihuagu.model;

import android.util.Log;
import com.baidu.appx.BDBannerAd;
import com.baidu.appx.BDInterstitialAd;
import com.baidu.appx.BDSplashAd;
public class Advertising implements  BDBannerAd.BannerAdListener, BDInterstitialAd.InterstitialAdListener, BDSplashAd.SplashAdListener{
	private IAdView adview=null;
	public void loadBannerAd(IAdView adview){
		this.adview=adview;
		
	}
	
	private String stringTag;
	public Advertising(String tag) {
		this.stringTag = tag;
	}
	
	@Override
	public void onAdvertisementDataDidLoadFailure() {
		Log.v("ad", "data load failure");
		
	}

	@Override
	public void onAdvertisementDataDidLoadSuccess() {
		Log.v("ad", "data load success");
	}

	@Override
	public void onAdvertisementViewDidClick() {
		Log.v("ad", "click");
	}

	@Override
	public void onAdvertisementViewDidShow() {
		Log.v("ad","show");
	}

	@Override
	public void onAdvertisementViewWillStartNewIntent() {
		Log.v("ad", "start new intent");
	}

	@Override
	public void onAdvertisementViewDidHide() {
		Log.v("ad", "hide");
	}
	
}
