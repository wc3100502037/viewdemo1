package com.example.viewpagerdemo1;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class contactFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreateView(inflater, container, savedInstanceState);
	    View contactView =inflater.inflate(R.layout.activity_tab_contact,container,false);
	    return contactView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onActivityCreated(savedInstanceState);
	}

}
