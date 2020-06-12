package kr.or.connect.reservation.dto;

public class DisplayInfoImage {//전시 이미지
	private String contentType;//파일확장자
	private String createDate;//생성일
	private boolean deleteFlag;//삭제여부
	private int displayInfoId;//전시 Id
	private int displayInfoImageId;//전시 이미지 Id
	private int fileId;//파일id
	private String fileName;//파일 이름
	private String modifyDate;//수정일
	private String saveFileName;//파일 저장위치 이름
	
	public DisplayInfoImage() {}

	public DisplayInfoImage(String contentType, String createDate, boolean deleteFlag, int displayInfoId,
			int displayInfoImageId, int fileId, String fileName, String modifyDate, String saveFileName) {
		super();
		this.contentType = contentType;
		this.createDate = createDate;
		this.deleteFlag = deleteFlag;
		this.displayInfoId = displayInfoId;
		this.displayInfoImageId = displayInfoImageId;
		this.fileId = fileId;
		this.fileName = fileName;
		this.modifyDate = modifyDate;
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

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getDisplayInfoImageId() {
		return displayInfoImageId;
	}

	public void setDisplayInfoImageId(int displayInfoImageId) {
		this.displayInfoImageId = displayInfoImageId;
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

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	@Override
	public String toString() {
		return "DisplayInfoImage [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag="
				+ deleteFlag + ", displayInfoId=" + displayInfoId + ", displayInfoImageId=" + displayInfoImageId
				+ ", fileId=" + fileId + ", fileName=" + fileName + ", modifyDate=" + modifyDate + ", saveFileName="
				+ saveFileName + "]";
	}

	
}
