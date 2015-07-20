package com.meuponto.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import com.meuponto.util.Constants.RobotoFontType;

public class FontManager {

	private static Typeface fontTypeFace;

	public static Typeface getRobotoFont(RobotoFontType type, AssetManager manager) {
		fontTypeFace = Typeface.createFromAsset(manager, type.getFontTypeFace());
		return fontTypeFace;
	}
}
