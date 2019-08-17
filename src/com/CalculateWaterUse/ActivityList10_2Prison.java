package com.CalculateWaterUse;

import org.codeandmagic.android.gauge.demo.ActivityGaugeViewOther;

import com.IranSoftjo.ActivityTakePhoto;

import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityList10_2Prison extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	EditText txtValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity10_2prison);

		setvalue(2);
		txtValue = (EditText) findViewById(R.id.txtValue);
		vibre = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		btnResult = (ImageView) findViewById(R.id.btnResult);
		btnResult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int countShower = 0;
				String valStr = txtValue.getText().toString();
				if (!valStr.equals(""))
					countShower = Integer.parseInt(valStr);
				else {
					Toast.makeText(ActivityList10_2Prison.this,
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}

				StaticValue.LiterShowerCalc = (int) (countShower * 150);
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(
						ActivityList10_2Prison.this,
						ActivityGaugeViewOther.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
