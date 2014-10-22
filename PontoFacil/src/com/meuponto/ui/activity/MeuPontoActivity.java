package com.meuponto.ui.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.meuponto.ui.fragments.TimeCardFragment;

public class MeuPontoActivity extends Activity implements OnClickListener, DrawerListener {

	private DrawerLayout drawerLayout;
	private RelativeLayout slideMenu;
	private ImageView openMenu;
	private ImageView openCalendar;

	private FragmentManager fragmentManager = getFragmentManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meu_ponto_activity);

		this.initViews();

		if (savedInstanceState == null) {
			displayView(0);
		}
	}

	private void initViews() {
		this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		this.slideMenu = (RelativeLayout) findViewById(R.id.slide_menu);
		this.openMenu = (ImageView) findViewById(R.id.open_menu);
		this.openCalendar = (ImageView) findViewById(R.id.open_calendar);

		this.initValues();
	}

	private void initValues() {
		this.openMenu.setOnClickListener(this);
		this.openCalendar.setOnClickListener(this);
		this.drawerLayout.setDrawerListener(this);
	}

	private void displayView(int position) {
		Fragment fragment = null;
		switch (position) {
			case 0:
				fragment = new TimeCardFragment();
				break;
		}

		if (fragment != null) {
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.open_menu:
				this.drawerLayout.openDrawer(this.slideMenu);
				break;
			case R.id.open_calendar:
				break;
		}
	}

	@Override
	public void onDrawerClosed(View drawerView) {
		Log.i("MeuPonto", "Closed");
	}

	@Override
	public void onDrawerOpened(View drawerView) {
		Log.i("MeuPonto", "Opened");
	}

	@Override
	public void onDrawerSlide(View drawerView, float slideOffset) {
		float alpha = 1;
		alpha = alpha - slideOffset;
		Log.i("MeuPonto", "SlideOffset -> " + slideOffset);
		this.openMenu.setAlpha(alpha);
		this.openMenu.invalidate();
	}

	@Override
	public void onDrawerStateChanged(int newState) {
		//Log.i("MeuPonto", "newState -> " + newState);
	}
}
