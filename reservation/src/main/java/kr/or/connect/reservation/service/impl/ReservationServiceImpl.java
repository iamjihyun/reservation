package kr.or.connect.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ReservationDao;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationDao rDao;
	
	@Override
	@Transactional
	public List<Product> getProducts(Integer start, Integer cate) {
		List<Product> list = rDao.selectAll(start, ReservationService.LIMIT, cate);
		return list;
	}

	@Override
	@Transactional(readOnly=false)
	public int deleteProduct(int id, String ip) {
		int deleteCount = rDao.deleteById(id);
		/*Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegdate(new Date());
		logDao.insert(log);*/
		return deleteCount;
	}

	@Override
	@Transactional(readOnly=false)
	public Product addProduct(Product p, String ip) {
		p.setCreateDate(new Date());
		int id = rDao.insert(p);
		p.setId(id);
		
/*		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		logDao.insert(log);*/

		return p;
	}

	@Override
	public int getCount(Integer cate) {
		return rDao.selectCount(cate);
	}

}
