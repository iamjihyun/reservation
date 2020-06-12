package kr.or.connect.reservation.dto;

public class ProductImage {//상품이미지 모델
	private String contentType;//파일확장자
	private String createDate;//생성일
	private boolean deleteFlag;//삭제여부
	private int fileInfoId;//파일id
	private String fileName;//파일 이름
	private String modifyDate;//수정일
	private int productId;//상품 id
	private int productImageId;//상품 이미지id
	private String saveFileName;//파일 저장위치 이름
	private String type;//이미지 타입(main, thumbnail, etc)
	
	public ProductImage() {}

	public ProductImage(String contentType, String createDate, boolean deleteFlag, int fileInfoId, String fileName,
			String modifyDate, int productId, int productImageId, String saveFileName, String type) {
		super();
		this.contentType = contentType;
		this.createDate = createDate;
		this.deleteFlag = deleteFlag;
		this.fileInfoId = fileInfoId;
		this.fileName = fileName;
		this.modifyDate = modifyDate;
		this.productId = productId;
		this.productImageId = productImageId;
		this.saveFileName = saveFileName;
		this.type = type;
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

	public int getFileInfoId() {
		return fileInfoId;
	}

	public void setFileInfoId(int fileInfoId) {
		this.fileInfoId = fileInfoId;
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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductImage [contentType=" + contentType + ", createDate=" + createDate + ", deleteFlag=" + deleteFlag
				+ ", fileInfoId=" + fileInfoId + ", fileName=" + fileName + ", modifyDate=" + modifyDate
				+ ", productId=" + productId + ", productImageId=" + productImageId + ", saveFileName=" + saveFileName
				+ ", type=" + type + "]";
	}
	
	
}
