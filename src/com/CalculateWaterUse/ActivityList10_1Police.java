package com.CalculateWaterUse;

import org.codeandmagic.android.gauge.demo.ActivityGaugeViewOther;
import IranSoftjo.Abdasht.R;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityList10_1Police extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	EditText txtValue;
	EditText txtValue3;
	EditText txtValue2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity10_1police);

		setvalue(2);
		txtValue = (EditText) findViewById(R.id.txtValue);
		txtValue2 = (EditText) findViewById(R.id.txtValue2);
		txtValue3 = (EditText) findViewById(R.id.txtValue3);

		
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
					Toast.makeText(ActivityList10_1Police.this,
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}

				int countShower2 = 0;
				String valStr2 = txtValue2.getText().toString();
				if (!valStr2.equals(""))
					countShower2 = Integer.parseInt(valStr2);
				else {
					Toast.makeText(ActivityList10_1Police.this,
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}

				int countShower3 = 0;
				String valStr3 = txtValue3.getText().toString();
				if (!valStr3.equals(""))
					countShower3 = Integer.parseInt(valStr3);
				else {
					Toast.makeText(ActivityList10_1Police.this,
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}

				StaticValue.LiterShowerCalc = (int) (countShower * 150)
						+ (countShower2 * 150) + (countShower3 * 40);
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(
						ActivityList10_1Police.this,
						ActivityGaugeViewOther.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});
		// InputMethodManager imm = (InputMethodManager)
		// getSystemService(Context.INPUT_METHOD_SERVICE);
		// imm.showSoftInput(txtValue, InputMethodManager.SHOW_IMPLICIT);
	}
}
