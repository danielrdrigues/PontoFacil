package com.meuponto.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.meuponto.model.SlideMenuItem;
import com.meuponto.ui.activity.R;
import com.meuponto.util.Constants.RobotoFontType;
import com.meuponto.util.FontManager;

public class SlideMenuAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<SlideMenuItem> slideMenuItens;

	public SlideMenuAdapter(Context context, ArrayList<SlideMenuItem> slideMenuItens) {
		this.context = context;
		this.slideMenuItens = slideMenuItens;
	}

	@Override
	public int getCount() {
		return this.slideMenuItens.size();
	}

	@Override
	public Object getItem(int position) {
		return slideMenuItens.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.slide_menu_list_item, null);
		}

		TextView title = (TextView) view.findViewById(R.id.title);
		title.setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_LIGHT, this.context.getAssets()));
		title.setText(slideMenuItens.get(position).getTitle());

		return view;
	}
}
