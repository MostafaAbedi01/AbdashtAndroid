package com.Equipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.CalculateWaterUse.StaticValue;

import contants.ServiceUrl;
import IranSoftjo.Abdasht.R;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class AtivityEquipment extends ExpandableListActivity {

	public void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_equipment);
			this.getWindow().setFlags(
					WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);

			SimpleExpandableListAdapter expListAdapter = new SimpleExpandableListAdapter(
					this, createGroupList(), // Creating group List.
					R.layout.group_row, // Group item layout XML.
					new String[] { "Group Item" }, // the key of group item.
					new int[] { R.id.row_name }, // ID of each group item.-Data
													// under the key goes into
													// this TextView.
					createChildList(), // childData describes second-level
										// entries.
					R.layout.child_row, // Layout for sub-level entries(second
										// level).
					new String[] { "Sub Item" }, // Keys in childData maps to
													// display.
					new int[] { R.id.grp_child } // Data under the keys above go
													// into these TextViews.
			);
			setListAdapter(expListAdapter); // setting the adapter in the list.

		} catch (Exception e) {
			System.out.println("Errrr +++ " + e.getMessage());
		}
	}

	private List<HashMap<String, String>> createGroupList() {
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> m = new HashMap<String, String>();
		m.put("Group Item", StaticValue.ConvertToPersionNumber("1-	حمام"));
		result.add(m);

		m = new HashMap<String, String>();
		m.put("Group Item",
				StaticValue.ConvertToPersionNumber("2-	سرویس بهداشتی"));
		result.add(m);

		m = new HashMap<String, String>();
		m.put("Group Item", StaticValue.ConvertToPersionNumber("3-	روشویی"));
		result.add(m);

		m = new HashMap<String, String>();
		m.put("Group Item", StaticValue.ConvertToPersionNumber("4-	آشپزخانه"));
		result.add(m);

		m = new HashMap<String, String>();
		m.put("Group Item", StaticValue.ConvertToPersionNumber("5-	آبیاری"));
		result.add(m);

		return (List<HashMap<String, String>>) result;
	}

	private List<ArrayList<HashMap<String, String>>> createChildList() {

		ArrayList<ArrayList<HashMap<String, String>>> result = new ArrayList<ArrayList<HashMap<String, String>>>();
		HashMap<String, String> child;
		ArrayList<HashMap<String, String>> secList;

		// ===============================1
		secList = new ArrayList<HashMap<String, String>>();

		child = new HashMap<String, String>();
		child.put("Sub Item", "سردوش");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "دوش استاپ");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "سیرکولاتور");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "زمان سنج مصرف");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیر اهرمی");
		secList.add(child);

		result.add(secList);

		// ===============================2
		secList = new ArrayList<HashMap<String, String>>();

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیر اهرمی");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "فلاش تانک کم مصرف");
		secList.add(child);

		result.add(secList);

		// ===============================3
		secList = new ArrayList<HashMap<String, String>>();

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیر اهرمی");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیر الکترونیکی");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیر فشاری");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیرپدالی");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "سرشیرهای کاهنده مصرف");
		secList.add(child);

		result.add(secList);
		// ===============================4
		secList = new ArrayList<HashMap<String, String>>();

		child = new HashMap<String, String>();
		child.put("Sub Item", "شیر اهرمی");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "سرشیرهای کاهنده مصرف");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "لباسشویی کم مصرف");
		secList.add(child);

		child = new HashMap<String, String>();
		child.put("Sub Item", "ماشین ظرفشویی کم مصرف");
		secList.add(child);

		result.add(secList);
		// ===============================5

		secList = new ArrayList<HashMap<String, String>>();

		child = new HashMap<String, String>();
		child.put("Sub Item", "مالچ یا خاکپوش");
		secList.add(child);

		result.add(secList);

		return result;
	}

	public void onContentChanged() {
		System.out.println("onContentChanged");
		super.onContentChanged();
	}

	/* This function is called on each child click */
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		System.out
				.println("Inside onChildClick at groupPosition = "
						+ groupPosition + " Child clicked at position "
						+ childPosition);
		Intent intent = new Intent(AtivityEquipment.this,
				AtivityEquipment1_1.class);

		if (groupPosition == 0 && childPosition == 0) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment1_1.class);
		} else if (groupPosition == 0 && childPosition == 1) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment1_2.class);
		} else if (groupPosition == 0 && childPosition == 2) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment1_3.class);
		} else if (groupPosition == 0 && childPosition == 3) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment1_4.class);
		} else if (groupPosition == 0 && childPosition == 4) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment1_5.class);
		}

		else if (groupPosition == 1 && childPosition == 0) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment2_1.class);
		} else if (groupPosition == 1 && childPosition == 1) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment2_2.class);
		}

		else if (groupPosition == 2 && childPosition == 0) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment3_1.class);
		} else if (groupPosition == 2 && childPosition == 1) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment3_2.class);
		} else if (groupPosition == 2 && childPosition == 2) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment3_3.class);
		} else if (groupPosition == 2 && childPosition == 3) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment3_4.class);
		} else if (groupPosition == 2 && childPosition == 4) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment3_5.class);
		}

		else if (groupPosition == 3 && childPosition == 0) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment4_1.class);
		} else if (groupPosition == 3 && childPosition == 1) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment4_2.class);
		} else if (groupPosition == 3 && childPosition == 2) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment4_3.class);
		} else if (groupPosition == 3 && childPosition == 3) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment4_4.class);
		} else if (groupPosition == 3 && childPosition == 4) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment3_5.class);
		}

		else if (groupPosition == 4 && childPosition == 0) {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment5_1.class);
		}

		else {
			intent = new Intent(AtivityEquipment.this,
					AtivityEquipment1_1.class);
		}
		startActivity(intent);
		// Toast.makeText(getApplicationContext(),
		// " \nعرض: " + groupPosition + "\nطول: " + childPosition,
		// Toast.LENGTH_LONG).show();

		ServiceUrl.EquipmentTitle = parent.getExpandableListAdapter()
				.getChild(groupPosition, childPosition).toString();
		ServiceUrl.EquipmentTitle = ServiceUrl.EquipmentTitle.replace('=', ' ');
		ServiceUrl.EquipmentTitle = ServiceUrl.EquipmentTitle.replace('{', ' ');
		ServiceUrl.EquipmentTitle = ServiceUrl.EquipmentTitle.replace('}', ' ');
		ServiceUrl.EquipmentTitle = ServiceUrl.EquipmentTitle.replace(
				"Sub Item", " ");

		return true;
	}

	/* This function is called on expansion of the group */
	public void onGroupExpand(int groupPosition) {
		try {
			System.out.println("Group exapanding Listener => groupPosition = "
					+ groupPosition);

			// Toast.makeText(getApplicationContext(),
			// " \nعرض: " + groupPosition + "\nطول: ", Toast.LENGTH_LONG)
			// .show();

		} catch (Exception e) {
			System.out.println(" groupPosition Errrr +++ " + e.getMessage());
		}
	}
}