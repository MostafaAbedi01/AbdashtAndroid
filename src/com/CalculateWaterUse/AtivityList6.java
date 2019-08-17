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

public class AtivityList6 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l16_1_masjed,
			R.drawable.l16_2_gorestan, R.drawable.l16_3_hozeelmiyeh };

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
				//ItemDetails obj_itemDetails = (ItemDetails) o;
				// Toast.makeText(AtivityList3.this,
				// "بخش : " + " " + obj_itemDetails.getName(),
				// Toast.LENGTH_LONG).show();
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityList6.this,
							ActivityList6_1Mosque.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList6.this,
							ActivityList6_2Cemetery.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList6.this,
							ActivityList6_3Seminary.class);
				} else {
					localIntentLock = new Intent(AtivityList6.this,
							ActivityList6_1Mosque.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("مسجد");
		item_details.setImageNumber(imgid[0]);
		item_details
				.setItemDescription("شامل:"
						+ "اماكن مذهبي و عبادي مانند مسجد، حسینیه، تکیه، زیارتگاه و معابد سایر ادیان"
						+ " و...");
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("گورستان");
		item_details.setItemDescription("شامل:" + "گورستان، مراکز دفن "
				+ " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("حوزه علمیه");
		item_details.setItemDescription("شامل:"
				+ "مدارس علوم ديني شبانه روزي و روزانه " + " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		return results;
	}
}