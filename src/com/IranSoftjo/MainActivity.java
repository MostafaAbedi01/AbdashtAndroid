package com.IranSoftjo;

import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				.setMessage("آیا مطمئن هستید میخواهید از نرم افزار خارج شوید؟")
				.setCancelable(false)
				.setPositiveButton("بله",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								MainActivity.this.finish();
							}
						}).setNegativeButton("خیر", null).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash_screen);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		Intent intent = new Intent(MainActivity.this, ActivityAbout.class);
		PendingIntent pendIntent = PendingIntent
				.getActivity(this, 0, intent, 0);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				this).setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("مدیریت مصرف آب")
				.setContentText("به اپلیکیشن مدیریت مصرف آب خوش آمدید")
				.setTicker("به اپلیکیشن مدیریت مصرف آب خوش آمدید")
				.setContentIntent(pendIntent).setAutoCancel(true);

		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(1, mBuilder.build());

	}

	@Override
	protected void onStart() {
		super.onStart();

		new Handler().postDelayed(new Thread() {

			@Override
			public void run() {
				super.run();

				// if (lockKey.matches("000")) {
				// Intent localIntentLock = new Intent(MainActivity.this,
				// ActivityLock.class);
				// finish();
				// startActivity(localIntentLock);
				// } else {
				Intent intent = new Intent(MainActivity.this, MainMenu.class);
				startActivity(intent);
				MainActivity.this.finish();
				overridePendingTransition(R.drawable.fade_in,
						R.drawable.fade_out);
				// }

			}

		}, 1500);
	}

}
