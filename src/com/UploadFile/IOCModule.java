package com.UploadFile;

import com.google.inject.Binder;
import com.google.inject.Module;

public class IOCModule implements Module {
	@Override
	public void configure(Binder binder) {
		binder.bind(IMainActivityViewModel.class).to(
				MainActivityViewModel.class);
		binder.bind(IUploadedFileActivityViewModel.class).to(
				UploadedFileActivityViewModel.class);

	}
}
