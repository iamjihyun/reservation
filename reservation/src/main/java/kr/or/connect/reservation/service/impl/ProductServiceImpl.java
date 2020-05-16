package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	// 실질적으로 데이터의 가공 하는 곳
	@Autowired
	ProductDao ProductDao;
	
	@Override
	@Transactional
	public ProductResponse getProducts(Integer start, Integer cate) {
		List<Product> list = ProductDao.selectAll(start, ProductService.LIMIT, cate);
		ProductResponse productResponse = new ProductResponse();
		
		productResponse.setItems(list);
		
		//아래에 만들어놓은 메소드 호출.
		productResponse.setTotalCount(getCount(cate));
		
		return productResponse;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteProduct(int id, String ip) {
		int deleteCount = ProductDao.deleteById(id);
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
		int id = ProductDao.insert(p);
		//p.setId(id);
		
/*		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);*/

		return p;
	}

	@Override
	public int getCount(Integer cate) {
		return ProductDao.selectCount(cate);
	}

	// 공연정보 한 개 셀렉
	@Override
	public Product selectOneProduct(int productid) {
		return ProductDao.selectOneProduct(productid);
	}

}
