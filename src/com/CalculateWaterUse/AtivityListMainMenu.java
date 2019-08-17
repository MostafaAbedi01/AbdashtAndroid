package com.CalculateWaterUse;

import java.util.ArrayList;
import IranSoftjo.Abdasht.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AtivityListMainMenu extends ExtendActivityWithUp {

	private Integer[] imgid = { R.drawable.l1_1kabgah, R.drawable.l1_2nezami,
			R.drawable.l1_3masjed, R.drawable.l1_4edareh,
			R.drawable.l1_5tejari, R.drawable.l1_6omomi, R.drawable.l1_7uni,
			R.drawable.l1_8sanati, R.drawable.l1_9darmangah,
			R.drawable.l1_10koshtargah, };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listimage);

		ArrayList<ItemDetails> image_details = GetSearchResults();
		setvalue(0);
		final ListView lv1 = (ListView) findViewById(R.id.listV_main);
		lv1.setAdapter(new ItemListBaseAdapter(this, image_details));

		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position,
					long id) {
				Object pos = lv1.getItemAtPosition(position);
				ItemDetails obj_itemDetails = (ItemDetails) pos;

				StaticValue.CalculateWaterUseLevel2 = obj_itemDetails.getName();
				Intent localIntentLock = null;
				if (position == 0) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList1.class);
				} else if (position == 1) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList2.class);
				} else if (position == 2) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList3.class);
				} else if (position == 3) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList4.class);
				} else if (position == 4) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList5.class);
				} else if (position == 5) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList6.class);
				} else if (position == 6) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList7.class);
				} else if (position == 7) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList8.class);
				} else if (position == 8) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList9.class);
				} else if (position == 9) {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList10.class);
				} else {
					localIntentLock = new Intent(AtivityListMainMenu.this,
							AtivityList1.class);
				}
				startActivity(localIntentLock);
			}
		});
	}

	private ArrayList<ItemDetails> GetSearchResults() {
		ArrayList<ItemDetails> results = new ArrayList<ItemDetails>();

		ItemDetails item_details = new ItemDetails();
		item_details.setName("خانگی");
		item_details.setItemDescription("شامل:" + "آپارتمان،خانه ویلایی"
				+ " و...");
		item_details.setImageNumber(imgid[0]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("تجاری");
		item_details.setItemDescription("شامل:" + "هتل،پاساژ" + " و...");
		item_details.setImageNumber(imgid[4]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("دامپروری");
		item_details.setItemDescription("شامل:" + "گاو،مرغ" + " و...");
		item_details.setImageNumber(imgid[9]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("آموزشی");
		item_details.setItemDescription("شامل:" + "دانشگاه،مدرسه" + " و...");
		item_details.setImageNumber(imgid[6]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("درمانی");
		item_details.setItemDescription("شامل:" + "بیمارستان،آزمایشگاه"
				+ " و...");
		item_details.setImageNumber(imgid[8]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("مذهبی");
		item_details.setItemDescription("شامل:" + "مسجد،گورستان" + " و...");
		item_details.setImageNumber(imgid[2]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("اداری");
		item_details.setItemDescription("شامل:" + "اداره،ترمینال" + " و...");
		item_details.setImageNumber(imgid[3]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("صنعتی");
		item_details.setItemDescription("شامل:" + "کارخانه،تعمیرگاه" + " و...");
		item_details.setImageNumber(imgid[7]);
		results.add(item_details);

		item_details = new ItemDetails();
		item_details.setName("عمومی");
		item_details.setItemDescription("شامل:" + "پارک،کمپ" + " و...");
		item_details.setImageNumber(imgid[5]);
		results.add(item_details);
		item_details = new ItemDetails();
		item_details.setName("نظامی");
		item_details
				.setItemDescription("شامل:" + "مرکزانتظامی،زندان" + " و...");
		item_details.setImageNumber(imgid[1]);
		results.add(item_details);

		return results;
	}
}