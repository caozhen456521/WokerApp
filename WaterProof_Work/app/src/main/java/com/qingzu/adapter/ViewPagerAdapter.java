package com.qingzu.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
public class ViewPagerAdapter extends PagerAdapter {
	private ArrayList<View> views = null;

	public ViewPagerAdapter(ArrayList<View> views) {
		this.views = views;
	}


	@Override
	public int getCount() {
		if (views != null) {
			return views.size();
		}
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Object instantiateItem(View view, int position) {
		((ViewPager) view).addView(views.get(position));
		return views.get(position);

	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {

		return (arg0 == arg1);
	}

	@Override
	public void destroyItem(View view, int position, Object object) {
		((ViewPager) view).removeView(views.get(position));
	}

}