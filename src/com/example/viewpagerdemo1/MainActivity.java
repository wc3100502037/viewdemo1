package com.example.viewpagerdemo1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
   
	private List<Fragment> mFragmentList=new ArrayList<Fragment>();
	private fragmentAdapter mfragmentAdapter; 
	private ViewPager mViewPage;
	private TextView mTabChat,mTabContact,mTabFriend;
	private ImageView mTabLine;
	
	contactFragment mcontactFragment;
	chatFragment mchatFragment;
	friendfragment mfriendFragment;
	
	private int currentIndex;
	private int screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
     mTabChat=(TextView) findViewById(R.id.id_chat_tv);
     mTabContact=(TextView) findViewById(R.id.id_contact_tv);
     mTabFriend=(TextView) findViewById(R.id.id_friend_tv);
     mTabLine=(ImageView) findViewById(R.id.id_tab_line);
     
    
     mViewPage=(ViewPager) findViewById(R.id.id_pageview);
        
     mcontactFragment=new contactFragment();
     mchatFragment=new chatFragment();
     mfriendFragment=new friendfragment();
     
     mFragmentList.add(mchatFragment);
     mFragmentList.add(mcontactFragment);
     mFragmentList.add(mfriendFragment);
     InitTabLine();
     mfragmentAdapter=new fragmentAdapter(this.getSupportFragmentManager(),mFragmentList);
     mViewPage.setAdapter(mfragmentAdapter);
     mViewPage.setCurrentItem(0);
     
     
     mViewPage.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int position) {
			// TODO 自动生成的方法存根
			mTabChat.setTextColor(Color.BLACK);
			mTabContact.setTextColor(Color.BLACK);
			mTabFriend.setTextColor(Color.BLACK);
			int currentItem=mViewPage.getCurrentItem();
			switch(currentItem)
			{
			case 0:mTabChat.setTextColor(Color.RED);
			       break;
			case 1:mTabContact.setTextColor(Color.RED);
			       break;
			case 2:mTabFriend.setTextColor(Color.RED);
			       break;
			
			}
			currentIndex=position;
			
		}
		/**
		 * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
		 * offsetPixels:当前页面偏移的像素位置
		 */
     
    
		@Override
		public void onPageScrolled(int position, float offset, int offsetpixel) {
			// TODO 自动生成的方法存根
			LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) mTabLine.getLayoutParams();
			Log.i("----Offset----",offset+"");
			if (currentIndex == 0 && position == 0)// 0->1
			{
				lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 3) + currentIndex
						* (screenWidth / 3));

			} else if (currentIndex == 1 && position == 0) // 1->0
			{
				lp.leftMargin = (int) (-(1 - offset)
						* (screenWidth * 1.0 / 3) + currentIndex
						* (screenWidth / 3));

			} else if (currentIndex == 1 && position == 1) // 1->2
			{
				lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 3) + currentIndex
						* (screenWidth / 3));
			} else if (currentIndex == 2 && position == 1) // 2->1
			{
				lp.leftMargin = (int) (-(1 - offset)
						* (screenWidth * 1.0 / 3) + currentIndex
						* (screenWidth / 3));
			}
			/*
			if((currentIndex==0)&&(position==0))
			{
				lp.leftMargin=(int)(offset*(screenWidth*1.0/3)+currentIndex*(screenWidth/3));
				
			}else if((currentIndex==1)&&(position==0))
			{
				lp.leftMargin=(int)(-(1-offset)*(screenWidth*1.0/3)+currentIndex*(screenWidth/3));
				
			}else if((currentIndex==1)&&(position==1))
			{
				lp.leftMargin=(int)(offset*(screenWidth*1.0/3)+currentIndex*(screenWidth/3));
				
			}else if((currentIndex==2)&&(position==1))
			{
				lp.leftMargin=(int)(-(1-offset)*(screenWidth*1.0/3)+currentIndex*(screenWidth/3));
			}*/
			mTabLine.setLayoutParams(lp);			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO 自动生成的方法存根
			
		}
	});
     
     
     
       mTabChat.setOnClickListener(new View.OnClickListener() {
		
		public void onClick(View v) {
			// TODO 自动生成的方法存根
		 	mViewPage.setCurrentItem(0);
		 	LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) mTabLine.getLayoutParams();
		 	lp.leftMargin=0;
		 	mTabLine.setLayoutParams(lp);
		}
	});
       
       
       mTabContact.setOnClickListener(new View.OnClickListener() {
   		
   		public void onClick(View v) {
   			// TODO 自动生成的方法存根
   		 	mViewPage.setCurrentItem(1);
   		    LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) mTabLine.getLayoutParams();
		 	lp.leftMargin=2*screenWidth/3;
		 	mTabLine.setLayoutParams(lp);
   		}
   	});
      
       
       mTabFriend.setOnClickListener(new View.OnClickListener() {
   		
   		public void onClick(View v) {
   			// TODO 自动生成的方法存根
   		 	mViewPage.setCurrentItem(2);
   		    LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) mTabLine.getLayoutParams();
		 	lp.leftMargin=screenWidth/3;
		 	mTabLine.setLayoutParams(lp);
   		}
   	});
    }
   public void InitTabLine()
   {
	   DisplayMetrics dpMetrics=new DisplayMetrics();
	   getWindowManager().getDefaultDisplay().getMetrics(dpMetrics);
	   screenWidth=dpMetrics.widthPixels;
	   LinearLayout.LayoutParams lp=(LinearLayout.LayoutParams) mTabLine.getLayoutParams();
	   lp.width=screenWidth/3;
	   mTabLine.setLayoutParams(lp);
   }

  
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
