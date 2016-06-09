package com.weihuagu.meizi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_vote) {
			 String appPkg=getResources().getString(R.string.appPkg);
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
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
