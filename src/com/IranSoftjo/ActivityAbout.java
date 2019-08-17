package com.IranSoftjo;

import contants.ServiceUrl;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAbout extends Activity {

	Button btnPhone;
	private ImageView imgDownload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		imgDownload = ((ImageView) findViewById(R.id.imgupdate));
		imgDownload.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				goToUrl(ServiceUrl.Android_URL);
			}
		});

		TextView link = (TextView) findViewById(R.id.lblDownload);
		String linkText = "<a href='" + ServiceUrl.Android_URL + "'> تاریخ آخرین تغییرات : "
				+ ServiceUrl.VersionSoftware + " </a>";
		link.setText(Html.fromHtml(linkText));
		link.setMovementMethod(LinkMovementMethod.getInstance());

		TextView lblSite = (TextView) findViewById(R.id.lblSite);
		String lblSiteText = "<a href='http://www.Abdasht.ir/'>www.Abdasht.ir</a>";
		lblSite.setText(Html.fromHtml(lblSiteText));
		lblSite.setMovementMethod(LinkMovementMethod.getInstance());

		TextView email = (TextView) findViewById(R.id.lblEmail);
		String emailText = "<a href=\"mailto:Info@Abdasht.ir\">Info@Abdasht.ir</a>";
		email.setText(Html.fromHtml(emailText));
		email.setMovementMethod(LinkMovementMethod.getInstance());

		
		TextView AboutMeSite = (TextView) findViewById(R.id.AboutMeSite);
		String AboutMeSiteStr = " سایت：<a href='http://ariapazhvan.com/'>www.ariapazhvan.com</a>";
		AboutMeSite.setText(Html.fromHtml(AboutMeSiteStr));
		AboutMeSite.setMovementMethod(LinkMovementMethod.getInstance());

	}

	private void goToUrl(String url) {
		Uri uriUrl = Uri.parse(url);
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
		startActivity(launchBrowser);
	}

}
