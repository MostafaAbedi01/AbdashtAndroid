package com.UploadFile;



import java.util.List;


public interface IMainActivityViewModel {
    List<HDFile> getLocalFiles();

    void uploadFiles(List<HDFile> items);

    void setUploadFilesCompleteListener(UploadFilesCompleteListener uploadFilesCompleteListener);

    List<HDFile> getUploadFiles();
}
