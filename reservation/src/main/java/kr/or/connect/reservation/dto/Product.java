package kr.or.connect.reservation.dto;

public class Product {
	
	private int displayInfoId;
	private String placeName;
	private String content;
	private String description;
	private int productId;
	private String fileName;
	
	public Product() {}

	public Product(int displayInfoId, String placeName, String content, String description, int productId,
			String fileName) {
		super();
		this.displayInfoId = displayInfoId;
		this.placeName = placeName;
		this.content = content;
		this.description = description;
		this.productId = productId;
		this.fileName = fileName;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Product [displayInfoId=" + displayInfoId + ", placeName=" + placeName + ", content=" + content
				+ ", description=" + description + ", productId=" + productId + ", fileName=" + fileName + "]";
	}

	
}
