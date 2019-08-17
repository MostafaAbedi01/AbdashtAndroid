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

public class AtivityList3 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l13_1_asb, R.drawable.l13_2_gav,
			R.drawable.l13_3_gosvand, R.drawable.l13_4_morgh,
			R.drawable.l13_5_shotormorgh, R.drawable.l13_6_boghamamo };

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
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_1Horse.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_2Cow.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_3Sheep.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_4Chicken.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_5Ostrich.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_6Turkey.class);
				} else {
					localIntentLock = new Intent(AtivityList3.this,
							ActivityList3_1Horse.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("اسب");
		item_details.setImageNumber(imgid[0]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("گاو");

		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("گوسفند");
		item_details.setItemDescription("شامل:" + "بز و گوسفند" + " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("مرغ");
		item_details.setItemDescription("شامل:" + "مرغ و خروس" + " و...");
		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("شترمرغ");

		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("بوقلمون");

		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		return results;
	}
}