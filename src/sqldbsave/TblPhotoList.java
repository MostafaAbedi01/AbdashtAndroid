package sqldbsave;

public class TblPhotoList {

	private int TblPhotoListId;
	private int ItemId;
	private String Title;
	private String ImageUrl;
	private String ThumbnailImageUrl;
	private String Comment;
	private String NameSender;
	private String GuidKey;

	public int getTblPhotoListId() {
		return TblPhotoListId;
	}

	public void setTblPhotoListId(int tblPhotoListId) {
		TblPhotoListId = tblPhotoListId;
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getThumbnailImageUrl() {
		return ThumbnailImageUrl;
	}

	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		ThumbnailImageUrl = thumbnailImageUrl;
	}

	public String getNameSender() {
		return NameSender;
	}

	public void setNameSender(String nameSender) {
		NameSender = nameSender;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getGuidKey() {
		return GuidKey;
	}

	public void setGuidKey(String guidKey) {
		this.GuidKey = guidKey;
	}

}
