package com.UploadFile;

import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class UploadedFileActivityViewModel implements IUploadedFileActivityViewModel {
    private List<HDFile> wallpapers;

    public List<HDFile> getItems()
    {
        return this.wallpapers;
    }


    @Override
    public void setItems(List<HDFile> wallpapers) {
        this.wallpapers = wallpapers;
       
    }
}
