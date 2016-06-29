package com.weihuagu.meizi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.weihuagu.model.Advertising;
import com.weihuagu.model.DbmeinvImage;
import com.weihuagu.model.DuitangImage;
import com.weihuagu.model.IAdView;
import com.weihuagu.model.TuchongImage;
import com.weihuagu.view.AdListener;
import com.weihuagu.view.PagerAdapter;

import org.json.JSONObject;

import com.baidu.appx.BDBannerAd;
import com.baidu.appx.BDInterstitialAd;
import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;
import com.weihuagu.meizi.AboutActivity;
import com.weihuagu.meizi.R;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IAdView{
	 private SharedPreferences  Setting=null;
	 private static final String[] TuchuangtabTitles = TuchongImage.tabTitles;
	 private static final String[] TuchuangtabIds = TuchongImage.tabIds;
	 private static final String[] DbmeinvtabTitles = DbmeinvImage.tabTitles;
	 private static final String[] DbmeinvtabIds = DbmeinvImage.tabIds;
	 private static final String[] DuitangtabTitles = DuitangImage.tabTitles;
	 private static final String[] DuitangtabIds = DuitangImage.tabIds;
	 
	 
	  
	  private void setupViewPager(ViewPager viewPager) {
		
	        PagerAdapter adapter = new PagerAdapter(this.getSupportFragmentManager());
	
	        for (int i = 0; i < TuchuangtabTitles.length; i++) {
	        	Fragment mfragment=PageSectionFragment.newInstance(TuchuangtabIds[i],"tuchong");
	            adapter.addFragment(mfragment, TuchuangtabTitles[i]);
	        }
	        for (int i = 0; i < DbmeinvtabTitles.length; i++) {
	        	Fragment mfragment=PageSectionFragment.newInstance(DbmeinvtabIds[i],"dbmeinv");
	            adapter.addFragment(mfragment, DbmeinvtabTitles[i]);
	        }
	        
	  //      for (int i = 0; i <  DuitangtabTitles.length; i++) {
	    //    	Fragment mfragment=PageSectionFragment.newInstance( DuitangtabIds[i],"duitang");
	  //          adapter.addFragment(mfragment,  DuitangtabTitles[i]);
	  //      }
	        
	        
	        viewPager.setAdapter(adapter);
	    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.initSetting();
		this.initUiResouces();
		this.showBannerAd();
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_vote) {
	        this.vote(getResources().getString(R.string.appPkg));
			return true;
		}
		if (id == R.id.action_setting) {
			Intent startsetting=new Intent(this,SettingActivity.class);
			startActivity(startsetting);
			return true;
		}
		if (id== R.id.action_about){
			Intent startabout=new Intent(this,AboutActivity.class);
			startActivity(startabout);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void initUiResouces(){
	    
	        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);
	        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
	        if (mViewPager != null) {
	            this.setupViewPager(mViewPager);
	            mTabLayout.setupWithViewPager(mViewPager);
	        }
	   
	}
	public void initSetting(){
		this.Setting=getSharedPreferences("settingfile",0);
		SharedPreferences.Editor editor=this.Setting.edit();
		if(Setting.contains("ad")==false){
		editor.putBoolean("ad", true);
		editor.commit();
		}

		
	}
	
	
	public void vote( String appPkg){
           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse("http://mobile.baidu.com/item?docid=" + appPkg));
           //这里存在一个极端情况就是有些用户浏览器也没有，再判断一次
           if (intent.resolveActivity(getPackageManager()) != null) { //有浏览器
               startActivity(intent);
           } else { 
               Toast.makeText(this, "no broswer,can't vote the app!", Toast.LENGTH_SHORT).show();
           }
       
	}

	
	
	@Override
	public View getAdView() {
		// TODO Auto-generated method stub
		return null;
	}
	public AdView bannerview=null;
	public void showBannerAd(){
		if(this.Setting.getBoolean("ad", true)){
			
			 String adPlaceId = "2015351"; //  重要：请填上您的广告位ID，代码位错误会导致无法请求到广告
			 bannerview = new AdView(this, adPlaceId);
		        // 设置监听器
			 bannerview.setListener(new AdViewListener() {
		            public void onAdSwitch() {
		                Log.v("ssp", "onAdSwitch");
		            }

		            public void onAdShow(JSONObject info) {
		                // 广告已经渲染出来
		                Log.v("ssp", "onAdShow " + info.toString());
		            }
		            
		            public void onAdReady(AdView adView) {
		                // 资源已经缓存完毕，还没有渲染出来
		                Log.v("ssp", "onAdReady " + adView);
		            }

		            public void onAdFailed(String reason) {
		                Log.v("ssp", "onAdFailed " + reason);
		            }

		            public void onAdClick(JSONObject info) {
		                // Log.V("ssp", "onAdClick " + info.toString());

		            }
		        });
		Log.v("ssp", "adview new");
		ViewGroup  container = (LinearLayout)findViewById(R.id.adview_container);
		container.addView(bannerview);
		}
		
	}
	public void hideBannerAd(){
		if (bannerview != null) {
			ViewGroup  container = (LinearLayout)findViewById(R.id.adview_container);
			container.removeAllViews();
			bannerview.destroy();
			bannerview = null;
		}
		
		
	}
	@Override
	protected void onDestroy() {
		if (bannerview != null) {
			bannerview.destroy();
		}
		super.onDestroy();
	}
	@Override
	protected void onRestart(){
		if(this.Setting.getBoolean("ad", true)){
			if(this.bannerview==null)
			this.showBannerAd();
		}
		
		if(!this.Setting.getBoolean("ad", true)){
			this.hideBannerAd();
			
		}
		super.onRestart();
		
	}
	
	
}
