package com.UploadFile;

import android.os.AsyncTask;
import android.os.Environment;
import com.hintdesk.core.utils.IOUtil;
import com.hintdesk.core.utils.JSONHttpClient;
import contants.ServiceUrl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class MainActivityViewModel implements IMainActivityViewModel {
	private UploadFilesCompleteListener uploadFilesCompleteListener;
	private List<HDFile> uploadedFiles;

	public void setUploadFilesCompleteListener(
			UploadFilesCompleteListener uploadFilesCompleteListener) {
		this.uploadFilesCompleteListener = uploadFilesCompleteListener;
	}

	@Override
	public List<HDFile> getUploadFiles() {
		return uploadedFiles;
	}

	@Override
	public List<HDFile> getLocalFiles() {
		List<HDFile> result = new ArrayList<HDFile>();
		String sdCard = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		String wallpaperPath = sdCard + "/" + ServiceUrl.Folderfiles + "/";
		File directoryWallpapers = new File(wallpaperPath);
		// if (!directoryWallpapers.exists()) {
		// //wallpaperPath = sdCard + "/Pic";
		// directoryWallpapers = new File(wallpaperPath);
		// }

		if (directoryWallpapers.exists()) {
			File files[] = directoryWallpapers.listFiles();

			if (files.length > 0) {
				for (int index = 0; index < files.length; index++) {
					HDFile wallpaper = new HDFile();
					// wallpaper.setId(CryptoUtil.Md5(files[index].getName()));
					wallpaper.setId(files[index].getName());
					wallpaper.setName(files[index].getName());
					wallpaper.setFilePath(IOUtil.pathCombine(wallpaperPath,
							files[index].getName()));
					result.add(wallpaper);
				}

			}
		}
		return result;
	}

	@Override
	public void uploadFiles(List<HDFile> files) {
		new UploadFilesTask().execute(files.toArray(new HDFile[files.size()]));
	}

	class UploadFilesTask extends AsyncTask<HDFile, String, Integer> {
		Integer totalCount = 0;

		@Override
		protected Integer doInBackground(HDFile... params) {
			Integer uploadCount = 0;
			totalCount = params.length;
			uploadedFiles = new ArrayList<HDFile>();

			for (int index = 0; index < params.length; index++) {
				File file = new File(params[index].getFilePath());

				JSONHttpClient jsonHttpClient = new JSONHttpClient();

				String jsonText = null;
				try {
					jsonText = EntityUtils.toString(new StringEntity(
							params[index].getName(), HTTP.UTF_8), HTTP.UTF_8);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				HDFile[] hdFiles = jsonHttpClient.PostFile(ServiceUrl.hdfiles,
						params[index].getId(), file, jsonText, HDFile[].class);
				if (hdFiles != null && hdFiles.length == 1) {
					uploadCount++;
					uploadedFiles.add(hdFiles[0]);
				}
			}
			return uploadCount;
		}

		@Override
		protected void onPostExecute(Integer uploadCount) {
			UploadErrorCode errorCode = UploadErrorCode.OK;
			if (uploadCount == 0)
				errorCode = UploadErrorCode.Failed;
			else if (uploadCount < totalCount)
				errorCode = UploadErrorCode.PartlySuccessful;
			if (uploadFilesCompleteListener != null)
				uploadFilesCompleteListener.onCompleted(errorCode);

		}
	}

}
