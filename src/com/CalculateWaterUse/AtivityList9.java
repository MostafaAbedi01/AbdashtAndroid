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

public class AtivityList9 extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l19_1_atashneshani,
			R.drawable.l19_2_abkhori, R.drawable.l19_3_camp,
			R.drawable.l19_4_park, R.drawable.l19_5_wcomomi,
			R.drawable.l19_6_kampdosh };

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
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList9_1FireStations.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList9_2Drinkers.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList9_3Camp.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList9_4Park.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList9_5Wc.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList9_6CampShower.class);
				} else {
					localIntentLock = new Intent(AtivityList9.this,
							ActivityList8_1Dairy.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("آتش نشانی");
		item_details.setImageNumber(imgid[0]);
		item_details.setItemDescription("شامل:" + "ماشین های آتش نشاني"
				+ " و...");
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آب خوری");
		item_details.setItemDescription("شامل:" + " آبخوري عمومي" + " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("کمپ");
		item_details.setItemDescription("شامل:"
				+ "كمپ توريستي محل برپايي چادر مسافرتي و پلاژهاي بدون دوش "
				+ " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("پارک");
		item_details
				.setItemDescription("شامل:"
						+ " زمین چمن ورزشگاهها و فضاي سبز مستقل پارکها، میادین و بلوارها "
						+ " و...");
		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("دستشویی");
		item_details.setItemDescription("شامل:" + "سرويسهاي بهداشتي عمومی "
				+ " و...");
		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("کمپ با دوش ");
		item_details.setItemDescription("شامل:" + "کمپهای با دوش" + " و...");
		item_details.setImageNumber(imgid[5]);
		results.add(item_details);

		return results;
	}
}