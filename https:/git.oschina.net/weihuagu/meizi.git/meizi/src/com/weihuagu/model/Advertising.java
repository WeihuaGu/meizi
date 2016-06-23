package com.weihuagu.model;

import com.google.android.gms.ads.AdRequest;

public class Advertising {
	private IAdView adview=null;
	public void loadBannerAd(IAdView adview){
		this.adview=adview;
		AdRequest adRequest = new AdRequest.Builder().build();
		adview.getAdView().loadAd(adRequest);
	}
	
}
