package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;


	@RestController
	@RequestMapping(path = "api/products")
	public class ProductApiController {
		//풀네임
		@Autowired
		ProductService ProductService;

		@GetMapping // guestbooks URL로 요청이 들어올 때, GET방식으로 들어오면 아래 메소드 실행.
		public Map<String, Object> list(@RequestParam(name = "start", required = false, defaultValue = "1") int start,
				@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
			System.out.println("categoryId : " + categoryId + " / start : " + start);
			//start가 1인이유 : start부터 4개 가져오기 쿼리문 limit사용하기때문
			//전체 데이터 가져오기.
			ProductResponse productResponse = ProductService.getProducts(start, categoryId);			

			Map<String, Object> map = new HashMap<>();
			map.put("list", productResponse);

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

