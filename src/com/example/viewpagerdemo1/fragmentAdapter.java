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
		// TODO �Զ����ɵĹ��캯�����
		Log.i(TAG, "----fragmentadapter constructor----");
		this.mfragmentList=mFragmentList;
	}

	public Fragment getItem(int arg0) {
		// TODO �Զ����ɵķ������
		Log.i(TAG, "---getItem()----");
		return mfragmentList.get(arg0);
	}

	public int getCount() {
		// TODO �Զ����ɵķ������
		return mfragmentList.size();
	}

	
}
