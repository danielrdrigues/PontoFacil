package com.meuponto.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import com.meuponto.util.Constants.RobotoFontType;

public class FontManager {

	private static Typeface fontTypeFace;

	public static Typeface getFontTeste(AssetManager manager) {
		if (fontTypeFace == null) {
			fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Black.ttf");
		}
		return fontTypeFace;
	}

	public static Typeface getRobotoFont(RobotoFontType type, AssetManager manager) {
		switch (type) {
			case ROBOTO_BLACK:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Black.ttf");
				break;
			case ROBOTO_BLACK_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-BlackItalic.ttf");
				break;
			case ROBOTO_BOLD:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Bold.ttf");
				break;
			case ROBOTO_BOLD_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-BoldItalick.ttf");
				break;
			case ROBOTO_CONDENSED_BOLD:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-Bold.ttf");
				break;
			case ROBOTO_CONDENSED_BOLD_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-BoldItalic.ttf");
				break;
			case ROBOTO_CONDENSED_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-Italic.ttf");
				break;
			case ROBOTO_CONDENSED_LIGHT:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-Light.ttf");
				break;
			case ROBOTO_CONDENSED_LIGTH_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-LightItalic.ttf");
				break;
			case ROBOTO_CONDENSED_REGULAR:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/RobotoCondensed-Regular.ttf");
				break;
			case ROBOTO_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Italic.ttf");
				break;
			case ROBOTO_LIGHT:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Light.ttf");
				break;
			case ROBOTO_LIGHT_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-LightItalic.ttf.ttf");
				break;
			case ROBOTO_MEDIUM:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Medium.ttf");
				break;
			case ROBOTO_MEDIUM_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-MediumItalic.ttf");
				break;
			case ROBOTO_REGULAR:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Regular.ttf");
				break;
			case ROBOTO_THIN:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-Thin.ttf");
				break;
			case ROBOTO_THIN_ITALIC:
				fontTypeFace = Typeface.createFromAsset(manager, "fonts/Roboto-ThinItalic.ttf");
				break;
			default:
				break;
		}

		return fontTypeFace;
	}
}
