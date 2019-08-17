package com.IranSoftjo;

import IranSoftjo.Abdasht.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter {
	private LayoutInflater myInflater;

	private Integer[] labelIDs = { R.string.menu_item1, R.string.menu_item2,
			R.string.menu_item3, R.string.menu_item4, R.string.menu_item5,
			R.string.menu_item6, };

	private Integer[] imageIDs = { R.drawable.menu02, R.drawable.menu01,
			R.drawable.menu04, R.drawable.menu03, R.drawable.menu06,
			R.drawable.menu05,

	};

	public MenuAdapter(Context context) {
		myInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return imageIDs.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = myInflater.inflate(R.layout.grid_menu, null);
			holder = new ViewHolder();
			holder.ivIcon = (ImageView) convertView
					.findViewById(R.id.menu_icon);
			holder.tvLabel = (TextView) convertView
					.findViewById(R.id.menu_label);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.ivIcon.setImageResource(imageIDs[position]);
		holder.tvLabel.setText(labelIDs[position]);

		return convertView;
	}

	static class ViewHolder {
		ImageView ivIcon;
		TextView tvLabel;
	}

}
