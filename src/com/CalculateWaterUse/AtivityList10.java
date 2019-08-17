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

public class AtivityList10 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l110_1_nezami,
			R.drawable.l110_2_zendan };

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
//				Toast.makeText(AtivityList10.this,
//						"بخش : " + " " + obj_itemDetails.getName(),
//						Toast.LENGTH_LONG).show();
				StaticValue.CalculateWaterUseLevel3 = obj_itemDetails.getName();
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityList10.this,
							ActivityList10_1Police.class);
				} else {
					localIntentLock = new Intent(AtivityList10.this,
							ActivityList10_2Prison.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("مراکز انتظامی");
		item_details.setItemDescription("شامل:" + " مراکز نظامي و انتظامی "
				+ " و...");

		item_details.setImageNumber(imgid[0]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("زندان");
		item_details.setItemDescription("شامل:" + "مرکز بازپروری،زندان"
				+ " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		return results;
	}
}