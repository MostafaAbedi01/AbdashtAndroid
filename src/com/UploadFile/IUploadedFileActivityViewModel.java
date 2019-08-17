package com.UploadFile;

import java.util.List;

public interface IUploadedFileActivityViewModel {
	void setItems(List<HDFile> files);

	List<HDFile> getItems();
}
