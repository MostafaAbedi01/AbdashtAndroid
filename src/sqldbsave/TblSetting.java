package sqldbsave;

import android.R.string;

public class TblSetting {


	private int CompanyId;
	private int UserId;
	private int SystemId;
	private string MobileNumber;

	
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getSystemId() {
		return SystemId;
	}
	public void setSystemId(int systemId) {
		SystemId = systemId;
	}
	public string getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(string mobileNumber) {
		MobileNumber = mobileNumber;
	}
	
	
	
}
