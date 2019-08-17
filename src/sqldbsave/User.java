package sqldbsave;

public class User {
	private int UserID;

	private String FirstName;
	private String LastName;
	private String Username;
	private String Password;
	private Boolean IsOnline;
	private	 String LastDateOnline;
	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Boolean getIsOnline() {
		return IsOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		IsOnline = isOnline;
	}

	public String getLastDateOnline() {
		return LastDateOnline;
	}

	public void setLastDateOnline(String lastDateOnline) {
		LastDateOnline = lastDateOnline;
	}

}
