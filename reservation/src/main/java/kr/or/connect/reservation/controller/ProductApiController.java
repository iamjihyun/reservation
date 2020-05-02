package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;


	@RestController
	@RequestMapping(path = "api/products")
	public class ProductApiController {
		//풀네임
		@Autowired
		ProductService ProductService;

		@GetMapping // guestbooks URL로 요청이 들어올 때, GET방식으로 들어오면 아래 메소드 실행.
		public Map<String, Object> list(@RequestParam(name = "start", required = false, defaultValue = "1") int start,
				@RequestParam(name = "cate", required = false, defaultValue = "0") int cate) {
			System.out.println("들어온 start값 : " + start + ", 들어온 cate값 : " + cate);
			//start가 1인이유 : start부터 4개 가져오기 쿼리문 limit사용하기때문
			//전체 데이터 가져오기.
			List<Product> list = ProductService.getProducts(start, cate);
			//System.out.println("셀렉해온 리스트 : " + list);
			
			//해당카테고리의 전체 데이터 갯수 가져오기
			int count = ProductService.getCount(cate);
			
			
			///////페이징처리...?..../////
			//전체데이터가 8개면 8/4 = 2 => 2+1 = 3
			int pageCount = count / ProductService.LIMIT;
			if (count % ProductService.LIMIT > 0)
				pageCount++;

			// 페이지카운트=3 0, 1, 2 -> 0, 4, 8
			List<Integer> pageStartList = new ArrayList<>();
			for (int i = 0; i < pageCount; i++) {
				//전체 데이터갯수가 8개면 8/4 = 0, 4를
				pageStartList.add(i * ProductService.LIMIT);
			}

			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("count", count);
			map.put("pageStartList", pageStartList);

			return map;
		}
		
		
		@RequestMapping(path = "/{productid}")
		public Map<String, Object> selectOneProduct(@RequestParam(name = "productid", required = false, defaultValue = "1") int productid){
			
			System.out.println("productid : " + productid);
			//product 한 개 조회.
			Product product = ProductService.selectOneProduct(productid);
			
			Map<String, Object> map = new HashMap<>();
			
			map.put("product", product);

			return map;
		}
	}

