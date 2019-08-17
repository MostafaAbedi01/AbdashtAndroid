package com.Equipment;

import contants.ServiceUrl;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class ExtendActivityWithTitle extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}

	public void setvalue() {
		TextView txtTitle = (TextView) findViewById(R.id.txtEquipmentTitle);
		txtTitle.setText(ServiceUrl.EquipmentTitle);
	}
}