package kr.or.connect.reservation.dto;

public class ProductPrice {//상품가격
	private String createDate;//생성일
	private double discountRate;//할인율
	private String modifyDate;//수정일
	private int price;//가격
	private String priceTypeName;//가격 타입명
	private int productId;//상품id
	private int productPriveId;//상품가격 id
	
	public ProductPrice() {}

	public ProductPrice(String createDate, double discountRate, String modifyDate, int price, String priceTypeName,
			int productId, int productPriveId) {
		super();
		this.createDate = createDate;
		this.discountRate = discountRate;
		this.modifyDate = modifyDate;
		this.price = price;
		this.priceTypeName = priceTypeName;
		this.productId = productId;
		this.productPriveId = productPriveId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPriceTypeName() {
		return priceTypeName;
	}

	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductPriveId() {
		return productPriveId;
	}

	public void setProductPriveId(int productPriveId) {
		this.productPriveId = productPriveId;
	}

	@Override
	public String toString() {
		return "ProductPrice [createDate=" + createDate + ", discountRate=" + discountRate + ", modifyDate="
				+ modifyDate + ", price=" + price + ", priceTypeName=" + priceTypeName + ", productId=" + productId
				+ ", productPriveId=" + productPriveId + "]";
	}
	
	
}
