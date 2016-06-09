package com.weihuagu.meizi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.weihuagu.model.Images;
import com.weihuagu.view.PagerAdapter;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;



public class MainActivity extends AppCompatActivity {
	 private Toolbar mToolBar;
	 private static final String[] tabTitles = Images.tabTitles;
	  private static final String[] tabIds = Images.tabIds;
	  
	  private void setupViewPager(ViewPager viewPager) {
	        PagerAdapter adapter = new PagerAdapter(this.getSupportFragmentManager());
	        int mCount = tabTitles.length;
	        for (int i = 0; i < mCount; i++) {
	        	Fragment mfragment=PageSectionFragment.newInstance(tabIds[i]);
	            adapter.addFragment(mfragment, tabTitles[i]);
	        }

	        viewPager.setAdapter(adapter);
	    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.initUiResouces();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void initUiResouces(){
	    
	        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);
	        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
	        if (mViewPager != null) {
	            this.setupViewPager(mViewPager);
	            mTabLayout.setupWithViewPager(mViewPager);
	        }
	    

		
		
	}
}
