package kr.or.connect.reservation.dto;

public class CommentImage {//상품평이미지
	private String contentType;//파일확장자
	private String createDate;//생성일
	private boolean deleteFlag;//삭제여부
	private int fileId;//파일id
	private String fileName;//파일 이름
	private int imageId;//이미지 Id
	private String modifyDate;//수정일
	private int reservationInfoId;//예약 Id
	private int reservationUserCommentId;//예약자상품평 Id
	private String saveFileName;//파일 저장위치 이름
	
	public CommentImage() {}

	public CommentImage(String contentType, String createDate, boolean deleteFlag, int fileId, String fileName,
			int imageId, String modifyDate, int reservationInfoId, int reservationUserCommentId, String saveFileName) {
		super();
		this.contentType = contentType;
		this.createDate = createDate;
		this.deleteFlag = deleteFlag;
		this.fileId = fileId;
		this.fileName = fileName;
		this.imageId = imageId;
		this.modifyDate = modifyDate;
		this.reservationInfoId = reservationInfoId;
		this.reservationUserCommentId = reservationUserCommentId;
		this.saveFileName = saveFileName;
	}

	

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getReservationUserCommentId() {
		return reservationUserCommentId;
	}

	public void setReservationUserCommentId(int reservationUserCommentId) {
		this.reservationUserCommentId = reservationUserCommentId;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	@Override
	public String toString() {
		return "CommentImage [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag=" + deleteFlag
				+ ", fileId=" + fileId + ", fileName=" + fileName + ", imageId=" + imageId + ", modifyDate="
				+ modifyDate + ", reservationInfoId=" + reservationInfoId + ", reservationUserCommentId="
				+ reservationUserCommentId + ", saveFileName=" + saveFileName + "]";
	}
	
	
}
