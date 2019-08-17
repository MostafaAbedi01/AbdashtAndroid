package com.IranSoftjo;

import com.CalculateWaterUse.*;
import com.Equipment.AtivityEquipment;
import com.TimeManagment.AtivityTimeManagment;
import com.VirtualWater.AtivityListVirtualWater;
import com.lazylist.PhotoListActivity;

import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainMenu extends Activity {

	ConnectivityManager connMgr;
	android.net.NetworkInfo wifi;
	android.net.NetworkInfo mobile;
	private int hasInternet;

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setMessage("آیا مطمئن هستید میخواهید از نرم افزار خارج شوید؟")
				.setCancelable(false)
				.setPositiveButton("بله",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								finish();
							}
						}).setNegativeButton("خیر", null).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Button btnAbout = (Button) findViewById(R.id.btn_menu_About);
		btnAbout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this, ActivityAbout.class);
				startActivity(intent);
			}
		});

		Button btnSetting = (Button) findViewById(R.id.btn_menu_Setting);
		btnSetting.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainMenu.this, ActivityHelp.class);
				startActivity(intent);
			}
		});

		GridView gridView = (GridView) findViewById(R.id.menu_gridview);
		gridView.setAdapter(new MenuAdapter(this));

		connMgr = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent = new Intent();
				switch (arg2) {

				case 0:
					intent.setClass(arg1.getContext(),
							AtivityListVirtualWater.class);
					startActivity(intent);
					break;
				case 1:
					intent.setClass(arg1.getContext(),
							AtivityListMainMenu.class);
					startActivity(intent);
					break;
				case 2:
					intent.setClass(arg1.getContext(), AtivityEquipment.class);
					startActivity(intent);
					break;
				case 3:
					intent.setClass(arg1.getContext(),
							AtivityTimeManagment.class);
					startActivity(intent);
					break;
				case 4:
					wifi = connMgr
							.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
					mobile = connMgr
							.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
					if (wifi.isAvailable()
							&& wifi.getState() == android.net.NetworkInfo.State.CONNECTED) {
						hasInternet = 1;
						Toast.makeText(MainMenu.this,
								"اتصال Wifi با موفقیت برقرار است.",
								Toast.LENGTH_LONG).show();
					} else if (mobile.isAvailable()
							&& mobile.getState() == android.net.NetworkInfo.State.CONNECTED) {
						hasInternet = 1;
						Toast.makeText(MainMenu.this,
								"اتصال GPRS با موفقیت برقرار است .",
								Toast.LENGTH_LONG).show();
					} else {
						hasInternet = 0;
						Toast.makeText(
								MainMenu.this,
								" لطفا ابتدا به اینترنت متصل شوید. \n      سپس دوباره تلاش نمایید. ",
								Toast.LENGTH_LONG).show();
					}
					if (hasInternet == 1) {
						intent.setClass(arg1.getContext(),
								PhotoListActivity.class);
						startActivity(intent);
					}

					break;
				case 5:

					intent.setClass(arg1.getContext(), ActivityTakePhoto.class);
					startActivity(intent);

					break;
				default:
					intent.setClass(arg1.getContext(), ActivityTakePhoto.class);
					startActivity(intent);

				}

				// Vibrate for 300 milliseconds
				// vibre.vibrate(100);

				// Starting requested Activity

			}
		});
	}
}
