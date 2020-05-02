package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;

	public List<Product> getProducts(Integer start, Integer cate);

	public int deleteProduct(int id, String ip);

	public Product addProduct(Product p, String ip);

	public int getCount(Integer cate);

	// 공연정보 한 개 조회
	public Product selectOneProduct(int productid);
}
