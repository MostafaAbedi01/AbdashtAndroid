package com.CalculateWaterUse;

import org.codeandmagic.android.gauge.demo.ActivityGaugeView;
import org.codeandmagic.android.gauge.demo.ActivityGaugeViewOther;

import IranSoftjo.Abdasht.R;
import android.R.integer;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ActivityList2_9Hotle4Star extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	EditText txtValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2_9hotel4);

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
					Toast.makeText(getBaseContext(),
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}
			     int result = 0;
                 if (countShower <= 2) {
                     result = (countShower * 225);
                 } else {
                     result = (2 * 225) + ((countShower - 2) * 200);
                 }
                 
				StaticValue.LiterShowerCalc = (int) (result);
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(ActivityList2_9Hotle4Star.this,
						ActivityGaugeViewOther.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
