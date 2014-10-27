package com.meuponto.util;

import android.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.meuponto.ui.fragments.TimeCardFragment;
import com.meuponto.ui.fragments.ToClockInFragment;
import com.meuponto.util.Constants.FragmentScreen;

public class FragmentController {

	public static void chooseScreen(FragmentManager fragmentManager, FragmentScreen fragmentScreen, int frameContainer, boolean isAnimated,
			boolean isBack) {

		FragmentTransaction transaction = fragmentManager.beginTransaction();

		Fragment fragment = null;

		switch (fragmentScreen) {
			case HOME:
				fragment = new TimeCardFragment();
				break;
			case ABOUT:

				break;
			case CONFIG:

				break;
			case HELP:

				break;
			case MONTHS:

				break;
			case TO_CLOCK_IN:
				fragment = new ToClockInFragment();
				break;
		}

		if (isAnimated) {
			if (isBack) {
				transaction.setCustomAnimations(R.anim.slide_out_right, R.anim.slide_in_left);
			} else {
				transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
			}
		}

		transaction.replace(frameContainer, fragment);
		transaction.commit();
	}
}
