package com.example.customview;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;

import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


@SuppressLint("NewApi") public class MainActivity extends Activity{
	
	private ViewGroup m_rootLayout;
	private FTFLImageView mFtflImageView;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		m_rootLayout = (ViewGroup) findViewById(R.id.root);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		mFtflImageView=new FTFLImageView(this, m_rootLayout,width,height);
	}
	}
