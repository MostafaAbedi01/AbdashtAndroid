package com.lazylist;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import sqldbsave.TblPhotoList;
import util.JSONHttpClient;
import contants.ServiceUrl;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;

public class PhotoListActivity extends Activity {
	WebView imageViewGallery;
	ListView list;
	LazyAdapter adapter;
	private Context c;
	ArrayList<HashMap<String, String>> productList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photolist);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		productList = new ArrayList<HashMap<String, String>>();
		new LoadAllPhoto().execute();

		list = (ListView) findViewById(R.id.list);

		Button b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(listener);
		c = this;

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				imageViewGallery = new WebView(c);
				// imageViewGallery.getSettings().setDefaultZoom(ZOOM_LEVEL);
				imageViewGallery.getSettings().setBuiltInZoomControls(true);

				imageViewGallery.setInitialScale(100);

				imageViewGallery.getSettings().setLoadWithOverviewMode(true);
				imageViewGallery.getSettings().setUseWideViewPort(true);
				RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
						RelativeLayout.LayoutParams.FILL_PARENT,
						RelativeLayout.LayoutParams.FILL_PARENT);
				imageViewGallery.setLayoutParams(params);
				String MY_URL_STRING = "";

				// MY_URL_STRING =
				// "http://www.raspodportal.com/Uploads/TblPhotoList/a31965c1705f498599203feb46f555ba_Thumb.jpg";
				// MY_URL_STRING =
				// "http://www.iransoftjoo.ir/Uploads/Pages/PageThumbnailImage/cbc42e3007aa40d6be09e1f4abfd7561.jpg";
				MY_URL_STRING = mStringsImageUrl[arg2];

				// new
				// DownloadImageTask(imageViewGallery).execute(MY_URL_STRING);
				imageViewGallery.loadUrl(MY_URL_STRING);
				// imageViewGallery
				// .setImageBitmap(getBitmapFromURL(MY_URL_STRING));
				BitmapFactory.Options o2 = new BitmapFactory.Options();
				o2.inPurgeable = true;

				try {

					// imageViewGallery.setMaxZoom(4f);

					Dialog d = new AlertDialog.Builder(c)
							.setView(imageViewGallery).setCancelable(true)
							.create();

					d.setCanceledOnTouchOutside(true);
					d.show();
				} catch (Exception ex) {
					Log.e("Exception", ex.getLocalizedMessage());
				}
			}
		});
	}

	@Override
	public void onDestroy() {
		list.setAdapter(null);
		super.onDestroy();
	}

	public OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			finish();
			// adapter.imageLoader.clearCache();
			// adapter.notifyDataSetChanged();
		}
	};

	private String[] mStringsThumbnailImageUrl = {};
	private String[] mStringsImageUrl = {};
	private String[] mStringsTitle = {};
	private String[] mStringsNameSender = {};
	private String[] mStringsComment = {};
	
	public static Bitmap getBitmapFromURL(String src) {
		try {
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			return myBitmap;
		} catch (IOException e) {
			// Log exception
			return null;
		}
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon11 = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}
	}

	class LoadAllPhoto extends AsyncTask<String, String, String> {
		private ProgressDialog progressDialog;

		@Override
		protected String doInBackground(String... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			JSONHttpClient jsonHttpClient = new JSONHttpClient();

			TblPhotoList[] products = jsonHttpClient.Get(
					ServiceUrl.TblPhotoListApi, nameValuePairs,
					TblPhotoList[].class);
			mStringsThumbnailImageUrl = new String[products.length];
			mStringsImageUrl = new String[products.length];
			mStringsTitle = new String[products.length];
			mStringsNameSender = new String[products.length];
			mStringsComment = new String[products.length];
			if (products.length > 0) {
				for (int i = 0; i < products.length; i++) {
					mStringsThumbnailImageUrl[i] = ServiceUrl.ImageUrl
							+ products[i].getThumbnailImageUrl();

					mStringsImageUrl[i] = ServiceUrl.ImageUrl
							+ products[i].getImageUrl();
					mStringsTitle[i] = products[i].getTitle();
					mStringsNameSender[i] = products[i].getNameSender();
					mStringsComment[i] = products[i].getComment();
				}
			}
			return null;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog = new ProgressDialog(PhotoListActivity.this);
			progressDialog.setMessage("درحال دریافت تصاویر از سرور...");
			progressDialog.show();
		}

		@Override
		protected void onPostExecute(String s) {
			progressDialog.dismiss();
			runOnUiThread(new Runnable() {
				@Override
				public void run() {

					adapter = new LazyAdapter(PhotoListActivity.this,
							mStringsThumbnailImageUrl, mStringsTitle,mStringsNameSender,mStringsComment);
					list.setAdapter(adapter);
				}
			});
		}
	}
}
