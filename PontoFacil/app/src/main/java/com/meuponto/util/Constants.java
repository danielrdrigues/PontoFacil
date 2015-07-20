package com.meuponto.util;

public class Constants {
	
	public static enum FragmentScreen {
		HOME,
		CONFIG,
		MONTHS,
		HELP,
		ABOUT,
		TO_CLOCK_IN
	}
	
	public static enum RobotoFontType {
		ROBOTO_BLACK("fonts/Roboto-Black.ttf"), 
		ROBOTO_BLACK_ITALIC("fonts/Roboto-BlackItalic.ttf"), 
		ROBOTO_BOLD("fonts/Roboto-Bold.ttf"), 
		ROBOTO_BOLD_ITALIC("fonts/Roboto-BoldItalick.ttf"),
		ROBOTO_ITALIC("fonts/Roboto-Italic.ttf"), 
		ROBOTO_LIGHT("fonts/Roboto-Light.ttf"), 
		ROBOTO_LIGHT_ITALIC("fonts/Roboto-LightItalic.ttf.ttf"), 
		ROBOTO_MEDIUM("fonts/Roboto-Medium.ttf"), 
		ROBOTO_MEDIUM_ITALIC("fonts/Roboto-MediumItalic.ttf"), 
		ROBOTO_REGULAR("fonts/Roboto-Regular.ttf"), 
		ROBOTO_THIN("fonts/Roboto-Thin.ttf"), 
		ROBOTO_THIN_ITALIC("fonts/Roboto-ThinItalic.ttf"), 
		ROBOTO_CONDENSED_BOLD("fonts/RobotoCondensed-Bold.ttf"), 
		ROBOTO_CONDENSED_BOLD_ITALIC("fonts/RobotoCondensed-BoldItalic.ttf"), 
		ROBOTO_CONDENSED_ITALIC("fonts/RobotoCondensed-Italic.ttf"), 
		ROBOTO_CONDENSED_LIGHT("fonts/RobotoCondensed-Light.ttf"), 
		ROBOTO_CONDENSED_LIGTH_ITALIC("fonts/RobotoCondensed-LightItalic.ttf"), 
		ROBOTO_CONDENSED_REGULAR("fonts/RobotoCondensed-Regular.ttf");

		private String fontTypeFace;

		private RobotoFontType(String fontTypeFace) {
			this.setFontTypeFace(fontTypeFace);
		}

		public String getFontTypeFace() {
			return fontTypeFace;
		}

		public void setFontTypeFace(String fontTypeFace) {
			this.fontTypeFace = fontTypeFace;
		}
	}

}
