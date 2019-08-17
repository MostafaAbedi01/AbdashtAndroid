package com.IranSoftjo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import sqldbsave.TblPhotoList;
import com.UploadFile.HDFile;
import com.UploadFile.IMainActivityViewModel;
import com.UploadFile.MainActivityViewModel;
import com.UploadFile.UploadErrorCode;
import com.UploadFile.UploadFilesCompleteListener;
import contants.ServiceUrl;
import IranSoftjo.Abdasht.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTakePhoto extends Activity {
	public ImageView imageView;
	private ImageView btnSendServerPhoto;
	ImageView btnActiveCamera;
	private ProgressDialog progressDialog;
	IMainActivityViewModel viewModel;
	String pathEnvironment;
	Uri imageUri;
	String pathMain;
	EditText txtPhotoComment;
	private static final int SELECT_PHOTO = 100;
	private static final int Camera_PHOTO = 200;
	android.net.NetworkInfo wifi;
	android.net.NetworkInfo mobile;
	private int hasInternet;
	ConnectivityManager connMgr;
	EditText txtNameSender;
	EditText txtPhotoTitle;
	String guidKey;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		pathEnvironment = Environment.getExternalStorageDirectory().toString();
		new File(pathEnvironment).mkdir();
		new File(pathEnvironment + "/" + ServiceUrl.MainFolderfiles).mkdir();

		setContentView(R.layout.take_photo);
		imageView = (ImageView) findViewById(R.id.imgViewCameraPhoto);
		btnActiveCamera = (ImageView) findViewById(R.id.btnActiveCamera);
		txtPhotoComment = (EditText) findViewById(R.id.txtPhotoComment);
		txtPhotoTitle = (EditText) findViewById(R.id.txtPhotoTitle);
		txtNameSender = (EditText) findViewById(R.id.txtNameSender);

		TextView lblUserName = (TextView) findViewById(R.id.lblUserName);
		lblUserName.setText("ارسال گزارشات مردمی");

		btnActiveCamera.setFocusable(true);
		btnActiveCamera.setFocusableInTouchMode(true);
		btnActiveCamera.requestFocus();

		ImageView btnGalley = (ImageView) findViewById(R.id.btnGalley);
		btnGalley.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
				photoPickerIntent.setType("image/*");
				startActivityForResult(photoPickerIntent, SELECT_PHOTO);
			}
		});

		btnActiveCamera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				ContentValues values = new ContentValues();
				values.put(MediaStore.Images.Media.TITLE, "New Picture");
				values.put(MediaStore.Images.Media.DESCRIPTION,
						"From your Camera");
				imageUri = getContentResolver().insert(
						MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent, Camera_PHOTO);
			}
		});
		viewModel = (IMainActivityViewModel) new MainActivityViewModel();
		viewModel
				.setUploadFilesCompleteListener(ViewModelUploadFilesCompleteListener);
		btnSendServerPhoto = (ImageView) findViewById(R.id.btnSendServerPhoto);
		connMgr = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		btnSendServerPhoto.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
				mobile = connMgr
						.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
				if (wifi.isAvailable()
						&& wifi.getState() == android.net.NetworkInfo.State.CONNECTED) {
					hasInternet = 1;

				} else if (mobile.isAvailable()
						&& mobile.getState() == android.net.NetworkInfo.State.CONNECTED) {
					hasInternet = 1;

				} else {
					hasInternet = 0;
					Toast.makeText(
							ActivityTakePhoto.this,
							" لطفا ابتدا به اینترنت متصل شوید. \n      سپس دوباره تلاش نمایید. ",
							Toast.LENGTH_LONG).show();
				}
				if (hasInternet == 1) {

					progressDialog = new ProgressDialog(ActivityTakePhoto.this);
					progressDialog.setMessage("درحال ارسال  عکس  به سرور...");
					progressDialog.show();

					List<HDFile> selectedFiles = new ArrayList<HDFile>();

					HDFile file = new HDFile();
					file.setFilePath(pathMain + "/" + ServiceUrl.fileName
							+ ".jpg");

					file.setName(ServiceUrl.fileName + ".jpg");
					file.setId(ServiceUrl.FileItemId);

					selectedFiles.add(file);
					viewModel.uploadFiles(selectedFiles);
				}
			}
		});

	}

	UploadFilesCompleteListener ViewModelUploadFilesCompleteListener = new UploadFilesCompleteListener() {
		@Override
		public void onCompleted(UploadErrorCode errorCode) {

			progressDialog.dismiss();
			if (errorCode == UploadErrorCode.Failed)
				Toast.makeText(getApplicationContext(),
						"خطا در  ارسال به سرور به وجود آمده ست",
						Toast.LENGTH_LONG).show();
			else if (errorCode == UploadErrorCode.PartlySuccessful)
				Toast.makeText(getApplicationContext(),
						"بعضی از فایل با موفقیت به سرور ارسال شد",
						Toast.LENGTH_LONG).show();
			else {

				new AddTitlePhoto().execute();
			}

		}
	};

	void saveImage(Bitmap bitmap) {
		File filename;
		try {

			String uniqueID = UUID.randomUUID().toString();
			guidKey = uniqueID;
			ServiceUrl.fileName = uniqueID;

			ServiceUrl.Folderfiles = ServiceUrl.MainFolderfiles;

			pathMain = pathEnvironment + "/" + ServiceUrl.Folderfiles;
			new File(pathMain).mkdir();
			filename = new File(pathMain + "/" + ServiceUrl.fileName + ".jpg");

			FileOutputStream out = new FileOutputStream(filename);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
			out.flush();
			out.close();

			MediaStore.Images.Media.insertImage(getContentResolver(),
					filename.getAbsolutePath(), filename.getName(),
					filename.getName());

			// Toast.makeText(getApplicationContext(),
			// "  \n عکس با موفقیت در دستگاه ذخیره شد \n" + filename,
			// Toast.LENGTH_LONG).show();
		} catch (Exception e) {

			Toast.makeText(getApplicationContext(),
					"خطا در ذخیره سیستم :\n" + e.getMessage(),
					Toast.LENGTH_LONG).show();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			if (requestCode == SELECT_PHOTO) {

				String selectedImagePath;
				String filemanagerstring;
				Uri selectedImageUri = data.getData();
				filemanagerstring = selectedImageUri.getPath();
				selectedImagePath = getPath(selectedImageUri);

				imageView.setImageURI(selectedImageUri);

				imagePath.getBytes();

				Bitmap thumbnail = null;
				try {
					thumbnail = MediaStore.Images.Media.getBitmap(
							getContentResolver(), selectedImageUri);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageView.setImageBitmap(thumbnail);
				saveImage(thumbnail);
			} else {
				Bitmap thumbnail = null;
				try {
					thumbnail = MediaStore.Images.Media.getBitmap(
							getContentResolver(), imageUri);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				imageView.setImageBitmap(thumbnail);
				saveImage(thumbnail);
			}

			btnSendServerPhoto.setVisibility(View.VISIBLE);
		}
	}

	int column_index;
	String logo, imagePath, Logo;
	Cursor cursor;

	public String getPath(Uri uri) {
		String[] projection = { MediaColumns.DATA };
		Cursor cursor = managedQuery(uri, projection, null, null, null);
		column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
		cursor.moveToFirst();
		imagePath = cursor.getString(column_index);
		return cursor.getString(column_index);
	}

	class AddTitlePhoto extends AsyncTask<String, String, String> {
		@Override
		protected void onPostExecute(String s) {
			progressDialog.dismiss();

			Toast.makeText(
					getApplicationContext(),
					"عکس شما با موفقیت به سایت آبدشت ارسال گردید و پس از تایید مدیریت در سایت و اپلیکیشن قرار داده خواهد شد.",
					Toast.LENGTH_LONG).show();
			finish();

		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progressDialog = new ProgressDialog(ActivityTakePhoto.this);
			progressDialog
					.setMessage("در حال ارسال اطلاعات میباشد لطفا چند لحظه صبر داشته باشید...");
			progressDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			List<NameValuePair> args = new ArrayList<NameValuePair>();

			args.add(new BasicNameValuePair("GuidKey", guidKey));

			args.add(new BasicNameValuePair("Title", txtPhotoTitle.getText()
					.toString()));
			args.add(new BasicNameValuePair("Comment", txtPhotoComment
					.getText().toString()));
			args.add(new BasicNameValuePair("NameSender", txtNameSender
					.getText().toString()));

			util.JSONHttpClient jsonHttpClient = new util.JSONHttpClient();

			jsonHttpClient.PostParams(contants.ServiceUrl.TblPhotoListApi,
					args, TblPhotoList.class);

			return null;
		}
	}

}