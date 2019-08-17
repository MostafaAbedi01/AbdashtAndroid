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

public class AtivityList2 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l12_1_pasaj,
			R.drawable.l12_2_sopermarket, R.drawable.l12_3_miveh,
			R.drawable.l12_4_gosht, R.drawable.l12_5_nanvay,
			R.drawable.l12_6_studiom, R.drawable.l12_7_pool,
			R.drawable.l12_8_bilyard, R.drawable.l12_9_hotel4setare,
			R.drawable.l12_10_hotele3setare, R.drawable.l12_11_motel,
			R.drawable.l12_12_asayeshgah, R.drawable.l12_13_restoran,
			R.drawable.l12_14_kababi, R.drawable.l12_15_sandeviji,
			R.drawable.l12_16_ashpazkhaneh, R.drawable.l12_17_garmabeh,
			R.drawable.l12_18_khabgah };

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
				// Toast.makeText(AtivityList2.this,
				// "بخش : " + " " + obj_itemDetails.getName(),
				// Toast.LENGTH_LONG).show();
			
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_1Pasazh.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_2SoperMarket.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_3Miveh.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_4Gosht.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_5Nanvai.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_6Estadion.class);
				} else if (position == 6) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_7Estakhr.class);
				} else if (position == 7) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_8Bilyard.class);
				} else if (position == 8) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_9Hotle4Star.class);
				} else if (position == 9) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_10Hotle3Star.class);
				} else if (position == 10) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_11Motel.class);
				} else if (position == 11) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_12Asayeshgah.class);
				} else if (position == 12) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_13Restoran.class);
				} else if (position == 13) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_14Kababi.class);
				} else if (position == 14) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_15Sandevigi.class);
				} else if (position == 15) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_16Ashpazkhane.class);
				} else if (position == 16) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_17Garmabeh.class);
				} else if (position == 17) {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_18Khabgah.class);
				} else {
					localIntentLock = new Intent(AtivityList2.this,
							ActivityList2_1Pasazh.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("پاساژ");
		item_details.setItemDescription("شامل:" + "پاساژ،مجتمع های تجاری"
				+ " و...");

		item_details.setImageNumber(imgid[0]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("سوپرمارکت");

		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("فروشگاه میوه");

		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("فروشگاه گوشت");

		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("نانوایی");

		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("استادیوم");

		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("استخر");

		item_details.setImageNumber(imgid[6]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("سالن بیلیارد");

		item_details.setImageNumber(imgid[7]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("هتل4ستاره");

		item_details.setImageNumber(imgid[8]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("هتل3ستاره");

		item_details.setImageNumber(imgid[9]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("متل");
		item_details.setImageNumber(imgid[10]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آسایشگاه");
		item_details.setImageNumber(imgid[11]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("رستوران");
		item_details.setImageNumber(imgid[12]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("کبابی");
		item_details.setImageNumber(imgid[13]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("ساندویجی");
		item_details.setImageNumber(imgid[14]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آشپزخانه");
		item_details.setImageNumber(imgid[15]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("گرمابه");
		item_details.setImageNumber(imgid[16]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("خوابگاه");
		item_details.setImageNumber(imgid[17]);
		results.add(item_details);
		return results;
	}
}