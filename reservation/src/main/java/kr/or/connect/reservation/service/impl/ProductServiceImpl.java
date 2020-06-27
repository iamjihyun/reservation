package kr.or.connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentImage;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	// 실질적으로 데이터의 가공 하는 곳
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public ProductResponse getProducts(Integer start, Integer cate) {
		List<Product> list = productDao.selectAll(start, ProductService.LIMIT, cate);
		ProductResponse productResponse = new ProductResponse();
		System.out.println("서비스임플1");
		productResponse.setItems(list);
		
		//아래에 만들어놓은 메소드 호출.
		productResponse.setTotalCount(getCount(cate));
		System.out.println("서비스임플2");
		return productResponse;
	}

	
	//상세페이지로 보낼 DisplayInfoResponse
	public DisplayInfoResponse getDisplayInfoResponse(int displayInfoId) {
		DisplayInfoResponse response = new DisplayInfoResponse();
		
		////데이터 가져오기
		// 1. 전시정보 한 개 조회
		DisplayInfo displayInfo = getDisplayInfo(displayInfoId);
		
		// 2. 전시정보 이미지정보 조회
		DisplayInfoImage displayInfoImage = getDisplayInfoImage(displayInfoId);
		
		// 3. 한줄평 리스트 조회
		List<Comment> comments = getComments(displayInfo.getProductId());
		
		//int commentCount = getCommentListCount(displayInfo.getProductId()) ; 
		//한줄평 총 갯수
		getCommentListCount(displayInfo.getProductId());
		
		
		
		////세팅
		// 1. 전시정보 세팅
		response.setDisplayInfo(displayInfo);
		
		// 2. 전시정보 이미지 세팅
		response.setDisplayInfoImage(displayInfoImage);
		
		// 3. 한줄평리스트 셋팅
		response.setComments(comments);

		
		
		return response;
	}

	
	
	// 공연정보 한 개 셀렉
	@Override
	public DisplayInfo getDisplayInfo(int displayInfoId) {
		DisplayInfo displayInfo = productDao.selectOneDisplayInfo(displayInfoId);
		return displayInfo;
	}
	
	
	//한줄평 리스트 조회
	@Override
	public List<Comment> getComments(int productId) {
		
		//한줄평 리스트 조회
		List<Comment> comments = productDao.selectCommentList(productId, ProductService.COMMENT_LIMIT);
		//->세 개를 가져오겠지. 그러면 세개에 해당하는 이미지를 가져옴.
		//이미지 0~3개
		List<CommentImage> commentImages = new ArrayList<>();;
		for(int i = 0; i < comments.size(); i++) {
			//CommentImage commentImage = getCommentImage(comments.get(i).getCommentId());
			//commentImages.
		}
		//한줄평 댓글 이미지 조회는 어디서하는가?
		
		return comments;
	}

	//전시정보 이미지 셀렉
	private DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
		DisplayInfoImage displayInfoImage = productDao.selectOneDisplayInfoImage(displayInfoId);
		return displayInfoImage;
	}

	@Override
	public int getCount(Integer cate) {
		return productDao.selectCount(cate);
	}
	
	@Override
	public int getCommentListCount(int productId) {
		return productDao.getCommentListCount(productId);
	}
	
	
	@Override
	@Transactional(readOnly=false)
	public int deleteProduct(int id, String ip) {
		int deleteCount = productDao.deleteById(id);
		/*Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);*/
		return deleteCount;
	}

	//add의 리턴값은 void로
	@Override
	@Transactional(readOnly=false)
	public Product addProduct(Product p, String ip) {
		//p.setCreateDate(new Date());
		int id = productDao.insert(p);
		//p.setId(id);
		
/*		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);*/

		return p;
	}

}
