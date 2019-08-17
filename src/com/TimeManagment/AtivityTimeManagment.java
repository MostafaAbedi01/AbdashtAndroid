package com.TimeManagment;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AtivityTimeManagment extends Activity {
	private Spinner spinner1;
	private Spinner spinner2;
	private Spinner spinner3;
	TextView tv1;
	TextView tv2;
	TextView tv3;
	TextView tv4;
	TextView tv5;
	TextView tv6;
	TextView tv7;
	long countLiter;
	long valueDropdownlistMounth = 1;
	long valueDropdownlistTime = 1;
	long CityCount = 8154051;
	long countLiterSumMain;
	DecimalFormat formatter;

	// GradientDrawable gd;
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
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timemanagment);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		List<String> objlist = new ArrayList<String>();
		objlist.add(ConvertToPersionNumber("1 دقیقه"));
		objlist.add(ConvertToPersionNumber("2 دقیقه"));
		objlist.add(ConvertToPersionNumber("3 دقیقه"));
		objlist.add(ConvertToPersionNumber("4 دقیقه"));
		objlist.add(ConvertToPersionNumber("5 دقیقه"));
		objlist.add(ConvertToPersionNumber("6 دقیقه"));

		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter1);

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> objlist2 = new ArrayList<String>();
		objlist2.add(ConvertToPersionNumber("1 ماه"));
		objlist2.add(ConvertToPersionNumber("2 ماه"));
		objlist2.add(ConvertToPersionNumber("3 ماه"));
		objlist2.add(ConvertToPersionNumber("4 ماه"));
		objlist2.add(ConvertToPersionNumber("5 ماه"));
		objlist2.add(ConvertToPersionNumber("6 ماه"));
		objlist2.add(ConvertToPersionNumber("7 ماه"));
		objlist2.add(ConvertToPersionNumber("8 ماه"));
		objlist2.add(ConvertToPersionNumber("9 ماه"));
		objlist2.add(ConvertToPersionNumber("10 ماه"));
		objlist2.add(ConvertToPersionNumber("11 ماه"));
		objlist2.add(ConvertToPersionNumber("12 ماه"));
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist2);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter2);

		spinner3 = (Spinner) findViewById(R.id.spinner3);
		List<String> objlist3 = new ArrayList<String>();
		objlist3.add("تهران");
		objlist3.add("اصفهان");
		objlist3.add("مشهد");
		objlist3.add("کرج");
		objlist3.add("تبریز");
		objlist3.add("شیراز");
		objlist3.add("اهواز");
		objlist3.add("قم");
		objlist3.add("کرمانشاه");
		objlist3.add("ارومیه");
		objlist3.add("رشت");
		objlist3.add("زاهدان");
		objlist3.add("کرمان");
		objlist3.add("اراک");
		objlist3.add("همدان");
		objlist3.add("یزد");
		objlist3.add("اردبیل");
		objlist3.add("بندر عباس");
		objlist3.add("زنجان");
		objlist3.add("قزوین");
		objlist3.add("سنندج");
		objlist3.add("خرم‌آباد");
		objlist3.add("گرگان");
		objlist3.add("ساری");

		ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, objlist3);
		dataAdapter3
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(dataAdapter3);

		// gd = new GradientDrawable();
		// gd.setColor(Color.parseColor("#3B78E7"));
		// gd.setCornerRadius(5);
		// gd.setStroke(1, Color.parseColor("#FFD04A"));

		tv1 = (TextView) findViewById(R.id.lbl1);
		// tv1.setBackgroundDrawable(gd);

		tv2 = (TextView) findViewById(R.id.lbl2);
		// tv2.setBackgroundDrawable(gd);

		tv3 = (TextView) findViewById(R.id.lbl3);
		// tv3.setBackgroundDrawable(gd);

		tv4 = (TextView) findViewById(R.id.lbl4);
		// tv4.setBackgroundDrawable(gd);

		tv5 = (TextView) findViewById(R.id.lbl5);
		// tv5.setBackgroundDrawable(gd);

		tv6 = (TextView) findViewById(R.id.lbl6);
		// tv6.setBackgroundDrawable(gd);

		tv7 = (TextView) findViewById(R.id.lbl7);
		// tv7.setBackgroundDrawable(gd);

		formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		formatter.setDecimalFormatSymbols(symbols);

		tv1.setText(ConvertToPersionNumber(formatter.format(Long.parseLong(tv1.getText().toString()))));
		tv2.setText(formatter.format(Long.parseLong(tv2.getText().toString())));
		tv3.setText(formatter.format(Long.parseLong(tv3.getText().toString())));
		tv4.setText(formatter.format(Long.parseLong(tv4.getText().toString())));
		tv5.setText(formatter.format(Long.parseLong(tv5.getText().toString())));
		tv6.setText(formatter.format(Long.parseLong(tv6.getText().toString())));
		tv7.setText(formatter.format(Long.parseLong(tv7.getText().toString())));

		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				valueDropdownlistTime = arg3 + 1;
				countLiter = (valueDropdownlistTime * 20)
						* (valueDropdownlistMounth * 30);

				tv1.setText(ConvertToPersionNumber(formatter.format(countLiter)));

				countLiterSumMain = ((valueDropdownlistTime * 20)
						* (valueDropdownlistMounth * 30) * CityCount);

				tv3.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain)));
				tv4.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 2)));
				tv5.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 20000)));
				tv6.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 200)));
				tv7.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 4)));

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});

		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				valueDropdownlistMounth = arg3 + 1;
				countLiter = (valueDropdownlistTime * 20)
						* (valueDropdownlistMounth * 30);
				tv1.setText(ConvertToPersionNumber(formatter.format(countLiter)));
				countLiterSumMain = ((valueDropdownlistTime * 20)
						* (valueDropdownlistMounth * 30) * CityCount);
				tv3.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain)));
				tv4.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 2)));
				tv5.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 20000)));
				tv6.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 200)));
				tv7.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 4)));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});

		spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				if (arg2 == 0) {
					CityCount = 8154051;
				} else if (arg2 == 1) {
					CityCount = 1756126;
				} else if (arg2 == 2) {
					CityCount = 2749374;
				} else if (arg2 == 3) {
					CityCount = 1614626;
				} else if (arg2 == 4) {
					CityCount = 1494988;
				} else if (arg2 == 5) {
					CityCount = 1460665;
				} else if (arg2 == 6) {
					CityCount = 1112021;
				} else if (arg2 == 7) {
					CityCount = 1074036;
				} else if (arg2 == 8) {
					CityCount = 851405;
				} else if (arg2 == 9) {
					CityCount = 667499;
				} else if (arg2 == 10) {
					CityCount = 639951;
				} else if (arg2 == 11) {
					CityCount = 560725;
				} else if (arg2 == 12) {
					CityCount = 534441;
				} else if (arg2 == 13) {
					CityCount = 526182;
				} else if (arg2 == 14) {
					CityCount = 525794;
				} else if (arg2 == 15) {
					CityCount = 486152;
				} else if (arg2 == 16) {
					CityCount = 482632;
				} else if (arg2 == 17) {
					CityCount = 435751;
				} else if (arg2 == 18) {
					CityCount = 386851;
				} else if (arg2 == 19) {
					CityCount = 381598;
				} else if (arg2 == 20) {
					CityCount = 373987;
				} else if (arg2 == 21) {
					CityCount = 348216;
				} else if (arg2 == 22) {
					CityCount = 329536;
				} else if (arg2 == 23) {
					CityCount = 296417;
				}
				tv2.setText(ConvertToPersionNumber(formatter.format(CityCount)));
				countLiterSumMain = ((valueDropdownlistTime * 20)
						* (valueDropdownlistMounth * 30) * CityCount);

				tv3.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain)));

				tv4.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 2)));

				tv5.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 20000)));

				tv6.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 200)));

				tv7.setText(ConvertToPersionNumber(formatter.format(countLiterSumMain / 4)));

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		
		});
		
		
	}
}