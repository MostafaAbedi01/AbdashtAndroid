package com.lazylist;

import android.app.Activity;
import IranSoftjo.Abdasht.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LazyAdapter extends BaseAdapter {

	private Activity activity;
	private String[] data;
	private String[] dataTitle;
	private String[] dataNameSender;
	private String[] dataComment;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;

	public LazyAdapter(Activity a, String[] d, String[] Title,
			String[] NameSender, String[] Comment) {
		activity = a;
		data = d;
		dataTitle = Title;
		dataNameSender = NameSender;
		dataComment = Comment;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {
		return data.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if (convertView == null)
			vi = inflater.inflate(R.layout.activity_photoitem, null);

		TextView lblTitle = (TextView) vi.findViewById(R.id.lblTitle);
		TextView lblNameSender = (TextView) vi.findViewById(R.id.lblNameSender);
		TextView lblComment = (TextView) vi.findViewById(R.id.lblComment);

		ImageView image = (ImageView) vi.findViewById(R.id.image);
		lblTitle.setText(dataTitle[position]);
		lblNameSender.setText("ارسال کننده:" + dataNameSender[position]);
		lblComment.setText(dataComment[position]);
		imageLoader.DisplayImage(data[position], image);
		return vi;
	}
}