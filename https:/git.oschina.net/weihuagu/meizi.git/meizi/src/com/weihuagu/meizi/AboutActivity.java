package com.weihuagu.meizi;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.weihuagu.meizi.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
public class AboutActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		/**
		AdView mAdView = (AdView ) findViewById ( R.id.adView );
		AdRequest adRequest = new AdRequest.Builder().build();
		Toast.makeText(this, adRequest.getContentUrl(), Toast.LENGTH_LONG).show();
		mAdView.loadAd(adRequest);
		**/
	}
}
