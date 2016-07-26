package com.example.viewpagerdemo1;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import android.os.Bundle;

public class fragmentAdapter extends FragmentPagerAdapter {
    String TAG="----fragmentAdapter----";
	List<Fragment> mfragmentList=new ArrayList<Fragment>();
	public fragmentAdapter(FragmentManager fragmentManager,List<Fragment> mFragmentList) {
		super(fragmentManager);
		// TODO 自动生成的构造函数存根
		Log.i(TAG, "----fragmentadapter constructor----");
		this.mfragmentList=mFragmentList;
	}

	public Fragment getItem(int arg0) {
		// TODO 自动生成的方法存根
		Log.i(TAG, "---getItem()----");
		return mfragmentList.get(arg0);
	}

	public int getCount() {
		// TODO 自动生成的方法存根
		return mfragmentList.size();
	}

	
}
