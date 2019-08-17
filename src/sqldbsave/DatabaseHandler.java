package sqldbsave;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseHandler {

	private final String TAG 	 = "DatabaseHandler";
	static final  String NAME    = "name";
	static final  String VALUE   = "value";
	
	
	
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	public DatabaseHandler(Context context) {
		dbHelper = new DatabaseHelper(context);
		Log.i(TAG, "Object created.");
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public void insertContact(TblManhol contact)
	{
		ContentValues cv = new ContentValues();
		
//		cv.put(NAME,  contact.getRfid());
//		cv.put(VALUE, contact.getcodepm());
//		cv.put(VALUE, contact.getcodepm());
		database.insert(dbHelper.getTableName(), NAME, cv);
		
		Log.i(TAG, "Contact added successfully.");
	}
	
	public void deleteContact(long id) {
		database.delete(dbHelper.getTableName(), dbHelper.getRowIdName() + "=" + id, null);
	}
	
	public void updateContact(long id) {
		ContentValues cv = new ContentValues();
		
		cv.put(NAME,  "Kamalan.com");
		cv.put(VALUE, "123456");
		database.update(dbHelper.getTableName(), cv, dbHelper.getRowIdName() + "=" + id, null);
	}
	
	public List<TblManhol> getAllContacts() {
		List<TblManhol> contacts = new ArrayList<TblManhol>();
		
		Cursor cursor = database.query(dbHelper.getTableName(),	null, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			TblManhol contact = cursorToContact(cursor);
			contacts.add(contact);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		
		return contacts;
	}
	
	public void clearTable() {
		database.delete(dbHelper.getTableName(), null, null);
	}
	
	private TblManhol cursorToContact(Cursor cursor) {
		TblManhol contact = new TblManhol();
		
//		contact.setId(cursor.getLong(0));
//		contact.setName(cursor.getString(1));
//		contact.setPhoneNumber(cursor.getString(2));
		
		return contact;
	}
	
	
	public TblSetting getTblSetting() {
		
		  // String countQuery = "SELECT  * FROM " + dbHelper.getTABLE_NAMETblSetting();
		  // database = dbHelper.getReadableDatabase();
	      //  Cursor cursor = database.rawQuery(countQuery, null);
	        
		TblSetting tblSetting = new TblSetting();
		
	   
		 
		Cursor cursor = database.query(dbHelper.getTABLE_NAMETblSetting(),	null, null, null, null, null, null);
		cursor.moveToFirst();	
		tblSetting.setCompanyId(cursor.getInt(0));
		tblSetting.setSystemId(cursor.getInt(1));
		tblSetting.setUserId(cursor.getInt(2));
		return tblSetting;
	}
	
	private static final String COLUMN_Company     = "Company";
	private static final String COLUMN_User     = "User";
	private static final String COLUMN_System     = "System";
	private static final String COLUMN_MobileNumber     = "MobileNumber";
	public void insertTblSetting(TblSetting tblSetting)
	{
		
		database = dbHelper.getWritableDatabase();
			
		ContentValues values = new ContentValues();
		
		values.put(COLUMN_Company,  tblSetting.getCompanyId());
		values.put(COLUMN_System, tblSetting.getSystemId());
		values.put(COLUMN_User, tblSetting.getUserId());
		//values.put(COLUMN_MobileNumber, tblSetting.getMobileNumber());
		//cv.put(VALUE, tblSetting.getUserId());
		//cv.put(VALUE, tblSetting.getMobileNumber());
		database.insert(dbHelper.getTABLE_NAMETblSetting(), null, values);
		
		Log.i(TAG, "Contact added successfully.");
	}
}
