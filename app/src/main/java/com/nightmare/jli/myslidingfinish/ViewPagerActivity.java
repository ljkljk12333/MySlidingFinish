package com.nightmare.jli.myslidingfinish;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerActivity extends SwipeBackActivity {

	private ViewPager viewPager;
	private List<View> list = new ArrayList<View>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
		
		viewPager = (ViewPager) findViewById(R.id.frame_main_viewpage);

		System.out.println(list.size());
		
		viewPager.setAdapter(new Adapter(this));
	}
	
	
	
	public class Adapter extends PagerAdapter{

		Context mContext;
		LayoutInflater mInflater;
		private List<View> mContents;
		
		public Adapter(Context tempContext){
			mContext=tempContext;
			mInflater=LayoutInflater.from(mContext);
			this.mContents = setPagerContent(5);
		}

		@Override
		public int getCount() {
			return mContents.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mContents.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = mContents.get(position);
			TextView textView= (TextView)view.findViewById(R.id.text);
			textView.setText("第"+(position+1)+"页");
			container.addView(view);
			return view;
		}

		/**
		 * 设置各分页内容
		 *
		 * @return 设置过布局后的各分页链表
		 */
		private List<View> setPagerContent(int contentsCount) {
			List<View> contents = new ArrayList<>();

			for (int i=0;i<contentsCount;i++) {
				View view = mInflater.inflate(R.layout.viewpager_item, null);
				contents.add(view);
			}

			return contents;
		}
		
	}


}
