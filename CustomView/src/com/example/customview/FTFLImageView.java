package com.example.customview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FTFLImageView implements OnTouchListener {
	private int m_X = 0;
	private int m_Y = 0;
	int mWindowWidth;
	int mWindowHeight;
	private ImageView m_imageView;
	private ViewGroup m_rootLayout;
	private Context mContext;

	public FTFLImageView(Context eContext, ViewGroup e_rootLayout, int eWidth,
			int eHeight) {
		this.mContext = eContext;
		this.m_rootLayout = e_rootLayout;
		this.mWindowWidth = eWidth;
		this.mWindowHeight = eHeight;
		m_imageView = (ImageView) m_rootLayout.findViewById(R.id.imageView);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				150, 150);
		m_imageView.setLayoutParams(layoutParams);
		// m_imageView.b
		m_imageView.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int x = (int) event.getRawX();
		int y = (int) event.getRawY();

		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v
					.getLayoutParams();
			m_X = x - lParams.leftMargin;
			m_Y = y - lParams.topMargin;

			// Toast.makeText(context,"X="+m_imageView.getLeft()+"Y="+m_imageView.getRight(),
			// 5000).show();
			break;

		case MotionEvent.ACTION_UP:

			break;

		case MotionEvent.ACTION_MOVE:

			Toast.makeText(
					mContext,
					"X=" + m_imageView.getLeft() + "Y="
							+ m_imageView.getRight(), 5000).show();
			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v
					.getLayoutParams();
			if ((x < 150 || x + 150 > mWindowWidth)
					|| (y < 150 || y + 150 > mWindowHeight)) {
				break;
			}
			layoutParams.leftMargin = x - m_X;
			layoutParams.topMargin = y - m_Y;
			layoutParams.rightMargin = -250;
			layoutParams.bottomMargin = -250;
			v.setLayoutParams(layoutParams);

			break;
		}

		m_rootLayout.invalidate();
		return true;
	}

}
