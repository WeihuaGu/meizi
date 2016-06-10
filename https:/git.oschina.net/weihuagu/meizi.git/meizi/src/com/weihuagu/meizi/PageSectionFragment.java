package com.weihuagu.meizi;

import java.util.List;

import com.weihuagu.model.AsyncResponse;
import com.weihuagu.model.ImageInfo;
import com.weihuagu.model.ImageTask;
import com.weihuagu.utils.Validator;
import com.weihuagu.view.GridViewAdapter;
import com.weihuagu.view.GridViewWithHeaderAndFooter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class PageSectionFragment extends Fragment implements  AsyncResponse{
	 private Context mContext;
	 private String mCategoryId=null;
	 private GridViewWithHeaderAndFooter mgridlist=null;
	 private List<ImageInfo> imgList;
	 private GridViewAdapter mAdapter=null;
	 private static final String KEY_CONTENT = "PageSectionFragment:CategoryId";
	 public static PageSectionFragment newInstance(String categoryId) {
        PageSectionFragment fragment = new PageSectionFragment();
        fragment.mCategoryId = categoryId;
        return fragment;
    }
	 @Override
	    public void onCreate(@Nullable Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
	            mCategoryId = savedInstanceState.getString(KEY_CONTENT);
	            this.getImageData();
	        }
	}
	 @Override
	    public void onSaveInstanceState(Bundle outState) {
	        super.onSaveInstanceState(outState);
	        outState.putString(KEY_CONTENT, mCategoryId);
	}
	 	@Nullable
	    @Override
	    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_section, container, false);
	        this.mgridlist=(GridViewWithHeaderAndFooter) view.findViewById(R.id.gridlist);
	       // View headerView = inflater.inflate(R.layout.grid_header_view, container, false);
	        //this.mgridlist.addHeaderView(headerView);
	        return view;
	    }
		@Override
		public void onDataReceivedSuccess(List<ImageInfo> imagelist) {
			// TODO Auto-generated method stub
			if(imagelist!=null){
				for(int i=0;i<imagelist.size();i++){
					if(imagelist.get(i)!=null){
						this.imgList.add(imagelist.get(i));
						}	
				}
				//load adapter
				this.mContext=getActivity();
				this.mAdapter=new GridViewAdapter();
				this.mAdapter.setContext(this.mContext);
				this.mAdapter.addImagList(this.imgList);
				this.mgridlist.setAdapter(this.mAdapter);
				
			}
			
			
		}
		@Override
		public void onDataReceivedFailed() {
			// TODO Auto-generated method stub
			Toast toast=Toast.makeText(getActivity(), "接受数据失败了", Toast.LENGTH_SHORT); 
			toast.show();             
		}
		
		public void getImageData() {
	        if (Validator.isEffective(mCategoryId)) {
	        	ImageTask mtask = new ImageTask();
	    		mtask.setOnAsyncResponse(this);
	    		mtask.execute(this.mCategoryId);
	        
	        }
	        
		}

}
