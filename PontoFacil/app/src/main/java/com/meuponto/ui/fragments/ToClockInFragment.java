package com.meuponto.ui.fragments;

import com.meuponto.ui.activity.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ToClockInFragment extends Fragment {

	public ToClockInFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.to_clock_in_fragment, container, false);
		
		return view;
	}

}
