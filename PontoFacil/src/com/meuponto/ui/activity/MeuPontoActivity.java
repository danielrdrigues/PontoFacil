package com.meuponto.ui.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meuponto.ui.adapter.SlideMenuAdapter;
import com.meuponto.ui.adapter.SlideMenuItem;
import com.meuponto.ui.fragments.TimeCardFragment;
import com.meuponto.util.Constants.RobotoFontType;
import com.meuponto.util.FontManager;

public class MeuPontoActivity extends Activity implements OnClickListener, DrawerListener {

	private DrawerLayout drawerLayout;
	private ImageView openMenu;
	private ImageView openCalendar;
	private ImageView closeMenu;
	private RelativeLayout slideMenuLayout;
	private ListView slideMenu;
	private String[] slideMenuTitles;
	private ArrayList<SlideMenuItem> slideMenuItens;
	private SlideMenuAdapter slideMenuAdapter;

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
		this.openMenu = (ImageView) findViewById(R.id.open_menu);
		this.openCalendar = (ImageView) findViewById(R.id.open_calendar);
		this.closeMenu = (ImageView) findViewById(R.id.close_menu);
		this.slideMenuLayout = (RelativeLayout) findViewById(R.id.slide_menu_layout);
		this.slideMenu = (ListView) findViewById(R.id.slide_menu);

		this.initValues();
	}

	private void initValues() {
		this.openMenu.setOnClickListener(this);
		this.openCalendar.setOnClickListener(this);
		this.drawerLayout.setDrawerListener(this);
		this.closeMenu.setOnClickListener(this);

		((TextView) findViewById(R.id.app_name)).setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_LIGHT, getAssets()));

		this.slideMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		this.slideMenuItens = new ArrayList<SlideMenuItem>();

		for (int i = 0; i < this.slideMenuTitles.length; i++) {
			this.slideMenuItens.add(new SlideMenuItem(slideMenuTitles[i]));
		}

		this.slideMenuAdapter = new SlideMenuAdapter(getApplicationContext(), slideMenuItens);
		this.slideMenu.setAdapter(slideMenuAdapter);
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
				this.drawerLayout.openDrawer(this.slideMenuLayout);
				break;
			case R.id.open_calendar:
				break;
			case R.id.close_menu:
				this.drawerLayout.closeDrawer(this.slideMenuLayout);
				break;
		}
	}

	@Override
	public void onDrawerClosed(View drawerView) {
	}

	@Override
	public void onDrawerOpened(View drawerView) {
	}

	@Override
	public void onDrawerSlide(View drawerView, float slideOffset) {
		float alpha = 1;
		alpha = alpha - slideOffset;
		this.openMenu.setAlpha(alpha);
		this.openMenu.invalidate();
	}

	@Override
	public void onDrawerStateChanged(int newState) {
	}
}
