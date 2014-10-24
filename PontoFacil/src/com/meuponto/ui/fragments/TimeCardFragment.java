package com.meuponto.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meuponto.ui.activity.R;
import com.meuponto.util.Constants.RobotoFontType;
import com.meuponto.util.DateManager;
import com.meuponto.util.FontManager;

public class TimeCardFragment extends Fragment {

	private TextView currentDayLabel;
	private TextView currentMonthLabel;

	public TimeCardFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.time_card_fragment, container, false);

		this.initViews(view);

		return view;
	}

	private void initViews(View rootView) {
		this.currentDayLabel = (TextView) rootView.findViewById(R.id.current_day);
		this.currentMonthLabel = (TextView) rootView.findViewById(R.id.current_month);

		this.initValues();
	}

	private void initValues() {
		this.currentDayLabel.setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_LIGHT, getActivity().getAssets()));
		this.currentDayLabel.setText("" + DateManager.getCurrentDay());

		this.currentMonthLabel.setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_MEDIUM, getActivity().getAssets()));
		String months[] = getResources().getStringArray(R.array.months_array);
		this.currentMonthLabel.setText(months[DateManager.getCurrentMonth()]);
	}

}
