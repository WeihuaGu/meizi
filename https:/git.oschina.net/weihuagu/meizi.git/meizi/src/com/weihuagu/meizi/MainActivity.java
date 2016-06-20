package com.weihuagu.meizi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.weihuagu.model.DbmeinvImage;
import com.weihuagu.model.TuchongImage;
import com.weihuagu.view.AdListener;
import com.weihuagu.view.PagerAdapter;
import com.baidu.appx.BDBannerAd;
import com.baidu.appx.BDInterstitialAd;
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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	 private SharedPreferences  Setting=null;
	 private static final String[] TuchuangtabTitles = TuchongImage.tabTitles;
	 private static final String[] TuchuangtabIds = TuchongImage.tabIds;
	 private static final String[] DbmeinvtabTitles = DbmeinvImage.tabTitles;
	 private static final String[] DbmeinvtabIds = DbmeinvImage.tabIds;
	 
	  
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
	        
	        
	        viewPager.setAdapter(adapter);
	    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.initSetting();
		this.initUiResouces();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
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
		
	}
	
	
	public void vote( String appPkg){
		 Uri uri = Uri.parse("market://details?id=" + appPkg);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        
       //存在手机里没安装应用市场的情况，跳转会包异常，做一个接收判断
       if (intent.resolveActivity(getPackageManager()) != null) { //可以接收
           startActivity(intent);
       } else { //没有应用市场，我们通过浏览器跳转到Google Play
           intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + appPkg));
           //这里存在一个极端情况就是有些用户浏览器也没有，再判断一次
           if (intent.resolveActivity(getPackageManager()) != null) { //有浏览器
               startActivity(intent);
           } else { 
               Toast.makeText(this, "no broswer,can't vote the app!", Toast.LENGTH_SHORT).show();
           }
       }
	}
}
