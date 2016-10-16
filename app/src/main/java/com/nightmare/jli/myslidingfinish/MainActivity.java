package com.nightmare.jli.myslidingfinish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends SwipeBackActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Button mButtonAbs = (Button) findViewById(R.id.absListview_activity);
		mButtonAbs.setOnClickListener(this);

		Button mButtonViewPager = (Button) findViewById(R.id.viewpager_activity);
		mButtonViewPager.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		Intent mIntent = null;
		switch (v.getId()) {
			case R.id.absListview_activity:
				mIntent = new Intent(MainActivity.this, AbsActivity.class);
				break;
			case R.id.viewpager_activity:
				mIntent = new Intent(MainActivity.this, ViewPagerActivity.class);
				break;
		}

		startActivity(mIntent);
	}


}
