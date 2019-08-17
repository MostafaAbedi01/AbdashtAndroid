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

public class AtivityList7 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l17_1_edareh,
			R.drawable.l17_2_terminal, };

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
				// ItemDetails obj_itemDetails = (ItemDetails) o;
				// Toast.makeText(AtivityList3.this,
				// "بخش : " + " " + obj_itemDetails.getName(),
				// Toast.LENGTH_LONG).show();
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityList7.this,
							ActivityList7_1Office.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList7.this,
							ActivityList7_2Terminal.class);
				} else {
					localIntentLock = new Intent(AtivityList7.this,
							ActivityList7_1Office.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("اداره");
		item_details.setImageNumber(imgid[0]);
		item_details
				.setItemDescription("شامل:"
						+ " ادارات دولتی و خصوصی،دفاتر ازدواج وطلاق،دفاترپستي،آژانس مسافرتی"
						+ " و...");
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("ترمینال");
		item_details.setItemDescription("شامل:"
				+ " پايانه هاي مسافر بري استاني  " + " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		return results;
	}
}