package com.VirtualWater;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.CalculateWaterUse.ItemDetails;
import IranSoftjo.Abdasht.R;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AtivityListVirtualWater extends Activity {

	private Integer[] imgid = { R.drawable.virtualwater_milk,
			R.drawable.virtualwater_potato, R.drawable.virtualwater_tomatoes,
			R.drawable.virtualwater_shoe, R.drawable.virtualwater_bread,
			R.drawable.virtualwater_apple, R.drawable.virtualwater_sugar,
			R.drawable.virtualwater_soya, R.drawable.virtualwater_meat,
			R.drawable.virtualwater_cheese, R.drawable.virtualwater_rice,
			R.drawable.virtualwater_paper, R.drawable.virtualwater_chicken,
			R.drawable.virtualwater_gin, R.drawable.virtualwater_butter,
			R.drawable.virtualwater_hamburger, R.drawable.virtualwater_coffee,
			R.drawable.virtualwater_orang, };

	private BaseAdapterVirtualWater adapter;
	Button btnResult;
	double calculationAll = 0;
	double calculation1 = 0;
	double calculation2 = 0;
	double calculation3 = 0;
	double calculation4 = 0;
	double calculation5 = 0;
	double calculation6 = 0;
	double calculation7 = 0;
	double calculation8 = 0;
	double calculation9 = 0;
	double calculation10 = 0;
	double calculation11 = 0;
	double calculation12 = 0;
	double calculation13 = 0;
	double calculation14 = 0;
	double calculation15 = 0;
	double calculation16 = 0;
	double calculation17 = 0;
	double calculation18 = 0;
	DecimalFormat formatter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_virtualwater);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		formatter.setDecimalFormatSymbols(symbols);

		setupListViewAdapter();
		btnResult = (Button) findViewById(R.id.btnResultVirtualWater);
		GetSearchResults();

	}

	public void removeAtomPayOnClickHandler(View v) {
		ItemDetailsVirtualWater itemToRemove = (ItemDetailsVirtualWater) v
				.getTag();

		double count = (int) itemToRemove.getValue();
		double calculationCurrent = 0;
		if (itemToRemove.getImageNumber() == imgid[0]) {
			calculation1 = (((double) (count / 7) / 4) * 1000);
			calculationCurrent = (int) calculation1;

		} else if (itemToRemove.getImageNumber() == imgid[1]) {
			calculation2 = (((double) (count * 1000) / 7) * (0.925));
			calculationCurrent = (int) calculation2;

		} else if (itemToRemove.getImageNumber() == imgid[2]) {
			// گوجه
			calculation3 = (((double) count / 7) * (186));
			calculationCurrent = (int) calculation3;

		} else if (itemToRemove.getImageNumber() == imgid[3]) {
			calculation4 = ((double) count / 360) * 8000;
			calculationCurrent = (int) calculation4;
		} else if (itemToRemove.getImageNumber() == imgid[4]) {
			calculation5 = ((double) (count / 7) * 150);
			calculationCurrent = (int) calculation5;
		} else if (itemToRemove.getImageNumber() == imgid[5]) {
			calculation6 = (((double) (count * 1000) / 7) * (0.7));
			calculationCurrent = (int) calculation6;
		} else if (itemToRemove.getImageNumber() == imgid[6]) {
			// مصرف شکر
			calculation7 = ((count) / 7) * (175);
			calculationCurrent = (int) calculation7;
		} else if (itemToRemove.getImageNumber() == imgid[7]) {
			calculation8 = (count / 7) * 1800;
			calculationCurrent = (int) calculation8;
		} else if (itemToRemove.getImageNumber() == imgid[8]) {
			calculation9 = ((count * 1000) / 7) * (4500 / 300);
			calculationCurrent = (int) calculation9;
		} else if (itemToRemove.getImageNumber() == imgid[9]) {
			// پنیر
			calculation10 = ((count * 1000) / 7) * (2500 / 500);
			calculationCurrent = (int) calculation10;
		} else if (itemToRemove.getImageNumber() == imgid[10]) {
			calculation11 = (count / 7) * 14508;
			calculationCurrent = (int) calculation11;
		} else if (itemToRemove.getImageNumber() == imgid[11]) {
			calculation12 = (count / 7) * 10;
			calculationCurrent = (int) calculation12;
		} else if (itemToRemove.getImageNumber() == imgid[12]) {
			// فیله مرغ
			calculation13 = (count / 7) * (3600);
			calculationCurrent = (int) calculation13;
		} else if (itemToRemove.getImageNumber() == imgid[13]) {
			calculation14 = (count / 365) * 10850;
			calculationCurrent = (int) calculation14;
		} else if (itemToRemove.getImageNumber() == imgid[14]) {
			// کره
			calculation15 = (count / 7) * (18 / 1);
			calculationCurrent = (int) calculation15;
		} else if (itemToRemove.getImageNumber() == imgid[15]) {
			calculation16 = (count / 7) * 2400;
			calculationCurrent = (int) calculation16;
		} else if (itemToRemove.getImageNumber() == imgid[16]) {
			// قهوه
			calculation17 = (count * 1.12) / 7;
			calculationCurrent = (int) calculation17;
		} else if (itemToRemove.getImageNumber() == imgid[17]) {
			// پرتقال
			calculation18 = (count * 500) / 7;
			calculationCurrent = (int) calculation18;
		}
		calculationAll = calculation1 + calculation2 + calculation3
				+ calculation4 + calculation5 + calculation6 + calculation7
				+ calculation8 + calculation9 + calculation10 + calculation11
				+ calculation12 + calculation13 + calculation14 + calculation15
				+ calculation16 + calculation17 + calculation18;

		btnResult.setText(ConvertToPersionNumber(formatter.format(Long
				.parseLong(String.valueOf((int) calculationAll)))));
		itemToRemove.setSubResult(ConvertToPersionNumber(String
				.valueOf((int) calculationCurrent) + "  لیتر در روز  "));

		// TextView lblSubResult = (TextView) findViewById(R.id.lblSubResult);
		Toast.makeText(
				AtivityListVirtualWater.this,
				"مصرف پنهان روزانه " + itemToRemove.getName() + " شما "
						+ "     \n \n     " + (int) calculationCurrent
						+ "         لیتر در روز          ", Toast.LENGTH_LONG)
				.show();

		ListView atomPaysListView = (ListView) findViewById(R.id.EnterPays_atomPaysList);
		// adapter.notifyDataSetChanged();
		atomPaysListView.invalidateViews();

		View view = this.getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

	private void setupListViewAdapter() {
		adapter = new BaseAdapterVirtualWater(AtivityListVirtualWater.this,
				R.layout.item_details_virtualwater,
				new ArrayList<ItemDetailsVirtualWater>());
		ListView atomPaysListView = (ListView) findViewById(R.id.EnterPays_atomPaysList);
		atomPaysListView.setAdapter(adapter);
	}

	private void GetSearchResults() {

		String result = "۰ لیتر در روز ";
		ItemDetailsVirtualWater item_details = new ItemDetailsVirtualWater();
		item_details.setName("شیر");
		item_details
				.setItemDescription("برای تولید هر لیتر شیر ۱۰۰۰ لیتر آب مورد نیاز است ");
		item_details.setUnit("لیوان در هفته");
		item_details.setSubResult(result);
		item_details.setImageNumber(imgid[0]);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("سیب زمینی");
		item_details
				.setItemDescription("برای تولید هر ۱ کیلوگرم سیب زمینی ۹٢۵ لیتر آب مورد نیاز است ");
		item_details.setUnit("کیلو در هفته");
		item_details.setSubResult(result);
		item_details.setImageNumber(imgid[1]);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("گوجه");
		item_details.setImageNumber(imgid[2]);
		item_details
				.setItemDescription("برای تولید هر ۱ کیلوگرم گوجه ۱۸۶ لیتر آب مورد نیاز است ");
		item_details.setUnit("کیلو در هفته");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("خرید کفش");
		item_details.setUnit("عدد در سال");
		item_details.setImageNumber(imgid[3]);
		item_details
				.setItemDescription("برای تولید هر جفت کفش چرمی ۸۰۰۰ لیتر آب مورد نیاز است ");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("مصرف نان");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[4]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر عدد نان 150 لیتر آب مورد نیاز است "));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("سیب");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[5]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر 1 کیلوگرم سیب 700 لیتر آب مورد نیاز است "));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("شکر");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[6]);
		item_details
				.setItemDescription("برای تولید هر ۱ کیلوگرم شکر ۱۷۵ لیتر آب مورد نیاز است");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("سویا");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[7]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر کیلوگرم سویا 1800 ایتر آب نیاز دارد "));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("گوشت");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[8]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر 1 کیلو گرم گوشت 15000 لیتر آب مورد نیاز است"));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("پنیر");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[9]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر 1 کیلو گرم پنیر 5000 لیتر آب مورد نیاز است "));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("برنج");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[10]);
		item_details
				.setItemDescription("برای تولید هر ۱ کیلوگرم برنج ۱۴۵۰۸ لیتر آب مورد نیاز است ");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("کاغذ");
		item_details.setUnit("برگ در هفته");
		item_details.setImageNumber(imgid[11]);
		item_details
				.setItemDescription("برای تولید هر برگ کاغذ ۱۰ لیتر آب مورد نیاز است ");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("فیله مرغ");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[12]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر 1 کیلو گرم فیله مرغ 3600 لیتر آب مورد نیاز است "));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("لباس جین");
		item_details.setUnit("عدد در سال");
		item_details.setImageNumber(imgid[13]);
		item_details
				.setItemDescription("برای تولید هر ۱ عدد جین ۱۰۸۵۰ لیتر آب مورد نیاز است ");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("کره");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[14]);
		item_details
				.setItemDescription("برای تولید هر ۱ کیلوگرم کره ۱۸۰۰۰ لیتر آب مورد نیاز است ");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("همبرگر");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[15]);
		item_details
				.setItemDescription(ConvertToPersionNumber("برای تولید هر 1 عدد همبرگر ۲۴۰۰ لیتر آب مورد نیاز است"));
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("قهوه");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[16]);
		item_details
				.setItemDescription("برای تولید هر ۷٥۰ گرم قهوه ٨٤۰ لیتر آب مورد نیاز است");
		item_details.setSubResult(result);
		adapter.add(item_details);

		item_details = new ItemDetailsVirtualWater();
		item_details.setName("پرتقال");
		item_details.setUnit("کیلو در هفته");
		item_details.setImageNumber(imgid[17]);
		item_details
				.setItemDescription("برای تولید هر ١ کیلو پرتقال ۵۰۰ لیتر آب مورد نیاز است");
		item_details.setSubResult(result);
		adapter.add(item_details);

	}

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

	public static String ConvertToEnglishNumber(String value) {
		String newValue = value.replace("١", "1").replace("٢", "2")
				.replace("٣", "3").replace("٤", "4").replace("٥", "5")
				.replace("٦", "6").replace("7", "٧").replace("٨", "8")
				.replace("٩", "9").replace("٠", "0").replace("۱", "1")
				.replace("۲", "2").replace("۳", "3").replace("۴", "4")
				.replace("۵", "5").replace("۶", "6").replace("۷", "7")
				.replace("۸", "8").replace("۹", "9").replace("۰", "0");

		return newValue;
	}

}