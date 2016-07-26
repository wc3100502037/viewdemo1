package com.example.viewpagerdemo1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class friendfragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		 super.onCreateView(inflater, container, savedInstanceState);
	     View friendView=inflater.inflate(R.layout.activity_tab_friend,container,false);
	     return friendView;
	}

}
