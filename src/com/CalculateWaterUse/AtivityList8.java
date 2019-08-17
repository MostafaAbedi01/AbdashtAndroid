package com.CalculateWaterUse;

import java.util.ArrayList;

import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AtivityList8 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l18_1_labaniat,
			R.drawable.l18_2_tamirgah, R.drawable.l18_3_mojtamaetamirgah,
			R.drawable.l18_4_karvash, R.drawable.l18_5_khoshkshoi,
			R.drawable.l18_6_kargah, R.drawable.l18_7_karkhaneh,
			R.drawable.l18_8_koshtargah, };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listimage);
		setvalue(1);
		ArrayList<ItemDetails> image_details = GetSearchResults();

		final ListView lv1 = (ListView) findViewById(R.id.listV_main);
		lv1.setAdapter(new ItemListBaseAdapter(this, image_details));

		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				 Object o = lv1.getItemAtPosition(position);
					ItemDetails obj_itemDetails = (ItemDetails) o;
					StaticValue.CalculateWaterUseLevel3 = obj_itemDetails.getName();
				// Toast.makeText(AtivityList3.this,
				// "بخش : " + " " + obj_itemDetails.getName(),
				// Toast.LENGTH_LONG).show();
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_1Dairy.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_2CarRepair.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_3Garage.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_4Carwash.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_5Laundry.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_6Workshop.class);
				} else if (position == 6) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_7Factory.class);
				} else if (position == 7) {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_8Slaughterhouse.class);
				} else {
					localIntentLock = new Intent(AtivityList8.this,
							ActivityList8_1Dairy.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("لبنیات سازی");
		item_details.setImageNumber(imgid[0]);
		item_details
				.setItemDescription("شامل:"
						+ "کارخانه لبنیات سازی ،كارخانهفرآورده هاي لبني و كارگاه ماست بندي و پنير سازي "
						+ " و...");
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("تعميرگاه اتومبیل");
		item_details.setItemDescription("شامل:"
				+ "تعميرگاه مستقل اتومبيل و موتور سیکلت " + " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("مجتمع تعمیرگاهی ");
		item_details.setItemDescription("شامل:" + "مجتمع تعمیرگاهی اتومبیل ها "
				+ " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("کارواش");
		item_details.setItemDescription("شامل:"
				+ "کارواش و مراکز شستشوی ماشین " + " و...");
		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("خشکشویی");

		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("انواع کارگاه");

		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("كارخانجات");

		item_details.setImageNumber(imgid[6]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("کشتارگاه");

		item_details.setImageNumber(imgid[7]);
		results.add(item_details);
		return results;
	}
}