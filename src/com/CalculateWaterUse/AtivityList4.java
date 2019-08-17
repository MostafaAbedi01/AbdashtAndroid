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

public class AtivityList4 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l14_1_uni,
			R.drawable.l14_2_mahdekodak, R.drawable.l14_3_madrese,
			R.drawable.l14_4_sinama, R.drawable.l14_5_mozeh,
			R.drawable.l14_6_farhangsara, };

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
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_1Uni.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_2Kindergarten.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_3School.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_4Movie.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_5Museum.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_6CulturalCenter.class);
				} else {
					localIntentLock = new Intent(AtivityList4.this,
							ActivityList4_1Uni.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("دانشگاه");
		item_details.setImageNumber(imgid[0]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("مهدکودک");

		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("مدرسه");
		item_details.setItemDescription("شامل:"
				+ "مدرسه و آموزشگاه شبانه روزي و روزانه" + " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("سینما،تئاتر");

		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("موزه،کتابخانه");
		item_details.setItemDescription("شامل:"
				+ "موزه و كتابخانه و ساير مكانهاي فرهنگي " + " و...");
		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("فرهنگسرا");

		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		return results;
	}
}