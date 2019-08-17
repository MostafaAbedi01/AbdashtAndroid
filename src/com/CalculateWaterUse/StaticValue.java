package com.CalculateWaterUse;

public class StaticValue {

	public static String ConvertToPersionNumber(String number) {
		String newValue = number.replace("1", "١").replace("2", "٢")
				.replace("3", "٣").replace("4", "٤").replace("5", "٥")
				.replace("6", "٦").replace("٧", "7").replace("8", "٨")
				.replace("9", "٩").replace("0", "٠").replace("1", "۱")
				.replace("2", "۲").replace("3", "۳").replace("4", "۴")
				.replace("5", "۵").replace("6", "۶").replace("7", "۷")
				.replace("8", "۸").replace("9", "۹").replace("0", "۰");

		return newValue;
	}

	public static String CalculateWaterUseLevel1 = "محاسبه مصرف";
	public static String CalculateWaterUseLevel2 = "خانگی";
	public static String CalculateWaterUseLevel3 = "حمام";

	public static int LiterCalc = 0;
	public static int LiterMain = 0;

	public static final int LiterShowerMain = 40;
	public static int LiterShowerCalc = 80;

	public static final int LiterWcMain = 20;
	public static int LiterWcCalc = 80;

	public static final int LiterKitchenMain = 30;
	public static int LiterKitchenCalc = 30;

	public static final int LiterWasherMain = 30;
	public static int LiterWasherCalc = 30;

	public static final int LiterGardenAreaMain = 40;
	public static int LiterGardenAreaCalc = 0;

	public static final int LiterCoolerMain = 30;
	public static int LiterCoolerCalc = 0;

	public static final int LiterCleaningHouseMain = 30;
	public static int LiterCleaningHouseCalc = 30;

	public static final int LiterCarWashMain = 30;
	public static int LiterCarWashCalc = 30;

	public static final int LiterHandWashingMain = 30;
	public static int LiterHandWashingCalc = 30;

}
