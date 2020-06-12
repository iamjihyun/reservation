package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public static final Integer COMMENT_LIMIT = 3;

	public ProductResponse getProducts(Integer start, Integer cate);

	public int deleteProduct(int id, String ip);

	public Product addProduct(Product p, String ip);

	public int getCount(Integer cate);

	// 공연정보 한 개 조회
	public DisplayInfo getDisplayInfo(int displayInfoId);
	
	// 한줄평 리스트 조회
	public 	List<Comment> getComments(int productId);

	// 상세페이지
	public DisplayInfoResponse getDisplayInfoResponse(int displayInfoId);

	int getCommentListCount(int productId);

}
