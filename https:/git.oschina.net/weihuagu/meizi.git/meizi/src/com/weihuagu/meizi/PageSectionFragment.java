package com.weihuagu.meizi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PageSectionFragment extends Fragment {
	 private String mCategoryId=null;
	 public static PageSectionFragment newInstance(String categoryId) {
        PageSectionFragment fragment = new PageSectionFragment();
        fragment.mCategoryId = categoryId;
        return fragment;
    }
	 	@Nullable
	    @Override
	    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_section, container, false);
	        return view;
	    }

}
