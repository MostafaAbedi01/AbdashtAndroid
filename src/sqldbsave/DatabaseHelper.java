package sqldbsave;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	private final String TAG = "DatabaseHelper";
	private static final String DATABASE_NAME = "dbManhole";	
	private static final String TABLE_NAME    = "contacts";
	private static final String TABLE_NAMETblSetting    = "tblSetting";
	private static final String COLUMN_ID     = "_id";
	private static final String COLUMN_NAME   = "name";
	private static final String COLUMN_VALUE  = "value";
	private static final String CREATE_TABLE  = "CREATE TABLE " + TABLE_NAME + " (" + 
		COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
		COLUMN_NAME + " TEXT," +
		COLUMN_VALUE + " TEXT" +
		");";
	
	private static final String COLUMN_Company     = "Company";
	private static final String COLUMN_User     = "User";
	private static final String COLUMN_System     = "System";
	private static final String COLUMN_MobileNumber     = "MobileNumber";
	private static final String CREATE_TABLETblSetting  = "CREATE TABLE " + TABLE_NAMETblSetting + " (" + 
			COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
			COLUMN_Company + " INTEGER," +
			COLUMN_System + " INTEGER, " +
			COLUMN_User + " INTEGER, " +
			COLUMN_MobileNumber + " TEXT" +
			");";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
		
		Log.i(TAG, "Object created.");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE);
		db.execSQL(CREATE_TABLETblSetting);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion + ", which will destroy all old data");
		db.execSQL("Drop table if exists " + TABLE_NAME);
		db.execSQL("Drop table if exists " + CREATE_TABLETblSetting);
		onCreate(db);
	}
	
	public String getTableName() {
		return TABLE_NAME;
	}
	
	public String getRowIdName() {
		return COLUMN_ID;
	}
	
	public String getTABLE_NAMETblSetting() {
		return TABLE_NAMETblSetting;
	}
	
	
}
