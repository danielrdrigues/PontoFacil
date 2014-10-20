package com.meuponto.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meuponto.util.Constants.RobotoFontType;
import com.meuponto.util.DateManager;
import com.meuponto.util.FontManager;

public class TimeCardActivity extends Activity {

	private LinearLayout toClockIn;
	private TextView currentDayLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_card_activity);

		this.initViews();
		this.initValues();
	}

	private void initViews() {
		this.toClockIn = (LinearLayout) findViewById(R.id.to_clock_in);
		this.currentDayLabel = (TextView) this.toClockIn.findViewById(R.id.current_day);
	}

	private void initValues() {
		this.currentDayLabel.setTypeface(FontManager.getRobotoFont(RobotoFontType.ROBOTO_LIGHT, this.getAssets()));
		this.currentDayLabel.setText("" + DateManager.getCurrentDay());
	}
}
