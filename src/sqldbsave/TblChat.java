package sqldbsave;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TblChat {
	private int TblChatId;
	private int TblUserIdFrom;
	private int TblUserIdTo;
	private String TextChat;
	private String FirstName;
	private String LastName;
	private String DateSabt;
	private Date DateSabtMain;
	private Boolean IsRead;

	public int getTblChatId() {
		return TblChatId;
	}

	public void setTblChatId(int tblChatId) {
		TblChatId = tblChatId;
	}

	public String getTextChat() {
		return TextChat;
	}

	public void setTextChat(String textChat) {
		TextChat = textChat;
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

	public String getDateSabt() {
		return DateSabt;
	}

	public void setDateSabt(String dateSabt) {
		DateSabt = dateSabt;
	}

	public int getTblUserIdFrom() {
		return TblUserIdFrom;
	}

	public void setTblUserIdFrom(int tblUserIdFrom) {
		TblUserIdFrom = tblUserIdFrom;
	}

	public int getTblUserIdTo() {
		return TblUserIdTo;
	}

	public void setTblUserIdTo(int tblUserIdTo) {
		TblUserIdTo = tblUserIdTo;
	}

	public Boolean getIsRead() {
		return IsRead;
	}

	public void setIsRead(Boolean isRead) {
		IsRead = isRead;
	}

	public Date getDateSabtMain() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			DateSabtMain = sdf.parse(DateSabt);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return DateSabtMain;
	}

	public void setDateSabtMain(Date dateSabtMain) {
		DateSabtMain = dateSabtMain;
	}

	public static final String TblChatId_Col = "TblChatId";
	public static final String TextChat_Col = "TextChat";

}
