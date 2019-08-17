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

public class AtivityList1 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l111_1_hamam,
			R.drawable.l111_2_datshoe, R.drawable.l111_3_ashpaz,
			R.drawable.l111_4_lebasshoe, R.drawable.l111_5_abyari,
			R.drawable.l111_6_koler, R.drawable.l111_7_nezafat,
			R.drawable.l111_8_carwash, R.drawable.l111_9_roshoe };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listimage_listitem);
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
				// Toast.makeText(AtivityList1_ListItem.this,
				// "بخش : " + " " + obj_itemDetails.getName(),
				// Toast.LENGTH_LONG).show();
				StaticValue.CalculateWaterUseLevel3 = obj_itemDetails.getName();
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_1Hamam.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_2ServiceBehdashti.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_3AshpazKhane.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_4Lebas.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_5Abyari.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_6Sarmayesh.class);
				} else if (position == 6) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_7Nezafat.class);
				} else if (position == 7) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_8Mashin.class);
				} else if (position == 8) {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_9DastShoie.class);
				} else {
					localIntentLock = new Intent(AtivityList1.this,
							ActivityKhanegi_1Hamam.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("حمام");
		item_details.setImageNumber(imgid[0]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("سرویس بهداشتی");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آشپزخانه");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("شستشوی لباس");
		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آبیاری");
		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("سیستم سرمایش");
		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("نظافت منزل");
		item_details.setImageNumber(imgid[6]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("شستشوی ماشین");
		item_details.setImageNumber(imgid[7]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("دست شویی");
		item_details.setImageNumber(imgid[8]);
		results.add(item_details);
		return results;
	}
}