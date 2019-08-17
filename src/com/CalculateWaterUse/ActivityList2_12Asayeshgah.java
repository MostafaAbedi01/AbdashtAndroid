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

public class ActivityList2_12Asayeshgah extends ExtendActivityWithUp {

	private ImageView btnResult;
	private Vibrator vibre;
	EditText txtValue;
	EditText txtValue2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2_12asayeshgah);

		setvalue(2);
		txtValue = (EditText) findViewById(R.id.txtValue);
		txtValue2 = (EditText) findViewById(R.id.txtValue2);
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
				int countShower2 = 0;
				String valStr2 = txtValue2.getText().toString();
				if (!valStr2.equals(""))
					countShower2 = Integer.parseInt(valStr2);
				else {
					Toast.makeText(getBaseContext(),
							"لطفا مقدار را وارد نمایید.", Toast.LENGTH_LONG)
							.show();
				}
				StaticValue.LiterShowerCalc = (int) (countShower * 100)
						+ (countShower2 * 100);
				StaticValue.LiterCalc = StaticValue.LiterShowerCalc;
				StaticValue.LiterMain = StaticValue.LiterShowerMain;
				Intent localIntentLock = new Intent(
						ActivityList2_12Asayeshgah.this,
						ActivityGaugeViewOther.class);
				startActivity(localIntentLock);
				vibre.vibrate(300);
			}
		});

	}
}
