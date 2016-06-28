package com.weihuagu.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.weihuagu.meizi.AboutActivity;
import com.weihuagu.meizi.R;
import com.weihuagu.meizi.WallPaperActivity;
import com.weihuagu.model.ImageInfo;
import com.weihuagu.utils.Validator;

public class GridViewAdapter extends BaseAdapter implements View.OnClickListener{
	private List<ImageInfo> imgList=new ArrayList<ImageInfo>();
	private Context mContext;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgList.size();
	}
	 public void addImagList(List<ImageInfo> img) {
		for(int i=0;i<img.size();i++){
        this.imgList.add(img.get(i));
		}
     }
    public void setContext(Context context){
    	this.mContext=context;
    }
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return imgList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		 return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 View view = convertView;
		 ViewHolder viewHolder;
		 if (convertView == null) {
             view = LayoutInflater.from(mContext).inflate(R.layout.listview_row_item, parent, false);
             viewHolder = new ViewHolder();
             viewHolder.iv_img = (MyImageView ) view.findViewById(R.id.img);
             viewHolder.tv_title = (TextView) view.findViewById(R.id.img_title);
             view.setTag(viewHolder);
         } else {
             viewHolder = (ViewHolder) view.getTag();
         }
		 ImageInfo imgInfo = imgList.get(position);
         String title = imgInfo.getImgTitle();
         String imgUrl = imgInfo.getImgUrl();

         if (Validator.isEffective(title)) {
             viewHolder.tv_title.setText(title);
         }
       
         if (Validator.isEffective(imgUrl)) {
        	 Glide.with(mContext).load(imgUrl).into(viewHolder.iv_img);
         }
 
         viewHolder.iv_img.setImgUrl(imgUrl);
         viewHolder.iv_img.setOnClickListener(this);        
		 return view;
	}
	
	 @Override
     public void onClick(View view) {
    		
            MyImageView img=(MyImageView) view;
			Intent wallpater=new Intent(this.mContext,WallPaperActivity.class);
			wallpater.putExtra("imgurl", img.getImgUrl());
			this.mContext.startActivity(wallpater);
     }

	
private  class ViewHolder {
          public MyImageView  iv_img;
          public TextView tv_title;
}

}
