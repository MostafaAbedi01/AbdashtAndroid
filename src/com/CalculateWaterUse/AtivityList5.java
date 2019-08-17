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

public class AtivityList5 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l15_1_matab,
			R.drawable.l15_2_azmayeshgah, R.drawable.l15_3_bimarestan,
			R.drawable.l15_4_dandanpezeshki, R.drawable.l15_5_darmangah,
			R.drawable.l15_6_akhtemanpezeshkan, };

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
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList5_1Clinic.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList5_2Laboratory.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList5_3Hospital.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList5_4Dentist.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList5_5Infirmary.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList5_6MedicalCenter.class);
				} else {
					localIntentLock = new Intent(AtivityList5.this,
							ActivityList4_1Uni.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("مطب");
		item_details.setImageNumber(imgid[0]);
		item_details.setItemDescription("شامل:"
				+ "مطب پزشک عمومی تخصصی، دندانپزشک و روانپزشک" + " و...");
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آزمايشگاه");
		item_details.setItemDescription("شامل:"
				+ "درمانگاه، آزمايشگاه، مجتمع درماني " + " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("بيمارستان");
		item_details.setItemDescription("شامل:"
				+ "انواع بيمارستان، خصوصي، دولتي، معمولي،آموزشی، تخصصی وعمومی "
				+ " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("دندانپزشکی");

		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("درمانگاه");

		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("مرکزپزشکان");
		item_details.setItemDescription("شامل:" + "مرکز و ساختمان پزشکان"
				+ " و...");
		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		return results;
	}
}