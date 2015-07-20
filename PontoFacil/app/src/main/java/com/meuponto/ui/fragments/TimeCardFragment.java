package com.meuponto.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meuponto.ui.activity.R;
import com.meuponto.util.Constants.FragmentScreen;
import com.meuponto.util.Constants.RobotoFontType;
import com.meuponto.util.DateManager;
import com.meuponto.util.FontManager;
import com.meuponto.util.FragmentController;

public class TimeCardFragment extends Fragment implements OnClickListener {

	private TextView currentDayLabel;
	private TextView currentMonthLabel;
	private LinearLayout toClockIn;

	public TimeCardFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.time_card_fragment, container, false);

		this.initViews(view);

		return view;
	}

	private void initViews(View rootView) {
		this.toClockIn = (LinearLayout) rootView.findViewById(R.id.to_clock_in);
		this.currentDayLabel = (TextView) rootView.findViewById(R.id.current_day);
		this.currentMonthLabel = (TextView) rootView.findViewById(R.id.current_month);

		this.initValues();
	}

	private void initValues() {
		this.toClockIn.setOnClickListener(this);
		
		this.currentDayLabel.setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_LIGHT, getActivity().getAssets()));
		this.currentDayLabel.setText("" + DateManager.getCurrentDay());

		this.currentMonthLabel.setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_MEDIUM, getActivity().getAssets()));
		String months[] = getResources().getStringArray(R.array.months_array);
		this.currentMonthLabel.setText(months[DateManager.getCurrentMonth()]);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.to_clock_in:
				FragmentController.chooseScreen(getActivity().getSupportFragmentManager(), FragmentScreen.TO_CLOCK_IN,
						R.id.frame_container, true, false);
				break;

			default:
				break;
		}
	}

}
