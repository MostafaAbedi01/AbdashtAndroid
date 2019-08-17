package sqldbsave;

public class TblDocumentTree {

	private int TblDocumentTreeId;

	private double Latitude;
	private double Longitude;
	private String DateSabt;
	private String Address;
	private int TblUserId;
	private int MantagheShahrdari;
	private double Pelak;
	private int TreeType;
	private int YearPlanting;
	private double Space;
	private String TreeTypeTitle;

	public int getTblDocumentTreeId() {
		return TblDocumentTreeId;
	}

	public void setTblDocumentTreeId(int tblDocumentTreeId) {
		TblDocumentTreeId = tblDocumentTreeId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public int getTblUserId() {
		return TblUserId;
	}

	public void setTblUserId(int tblUserId) {
		TblUserId = tblUserId;
	}

	public int getTreeType() {
		return TreeType;
	}

	public void setTreeType(int treeType) {
		TreeType = treeType;
	}

	public int getYearPlanting() {
		return YearPlanting;
	}

	public void setYearPlanting(int yearPlanting) {
		YearPlanting = yearPlanting;
	}

	public int getMantagheShahrdari() {
		return MantagheShahrdari;
	}

	public void setMantagheShahrdari(int mantagheShahrdari) {
		MantagheShahrdari = mantagheShahrdari;
	}

	public double getPelak() {
		return Pelak;
	}

	public void setPelak(double pelak) {
		Pelak = pelak;
	}

	public String getDateSabt() {
		return DateSabt;
	}

	public void setDateSabt(String dateSabt) {
		DateSabt = dateSabt;
	}

	public double getSpace() {
		return Space;
	}

	public void setSpace(double space) {
		Space = space;
	}

	public String getTreeTypeTitle() {
		return TreeTypeTitle;
	}

	public void setTreeTypeTitle(String treeTypeTitle) {
		TreeTypeTitle = treeTypeTitle;
	}

}
