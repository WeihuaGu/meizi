package com.weihuagu.meizi;

import com.weihuagu.meizi.R;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
public class SettingActivity extends AppCompatActivity {
	private SharedPreferences  Setting=null;
	private Switch ad=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		ad=(Switch)findViewById(R.id.ad);
		this.Setting=getSharedPreferences("settingfile",0);
		if(this.Setting.getBoolean("ad", true)){
			ad.setChecked(true);
		}else{
			ad.setChecked(false);
		}
		ad.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
			boolean isChecked) {
				SharedPreferences Setting=getSharedPreferences("settingfile",0);
			if (isChecked) {
			    //打开
				SharedPreferences.Editor editor=Setting.edit();
				editor.putBoolean("ad", true);
				editor.commit();
				
			} else {
			    // 关闭
				SharedPreferences.Editor editor=Setting.edit();
				editor.putBoolean("ad", false);
				editor.commit();
			}
			}
			});
	}
}
