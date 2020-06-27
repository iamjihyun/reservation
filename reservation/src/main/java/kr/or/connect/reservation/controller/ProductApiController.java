package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.DisplayInfo;
import kr.or.connect.reservation.dto.DisplayInfoResponse;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductResponse;
import kr.or.connect.reservation.service.ProductService;


	@RestController
	@RequestMapping(path = "api/products")
	public class ProductApiController {
		//풀네임
		@Autowired
		ProductService productService;

		@GetMapping // guestbooks URL로 요청이 들어올 때, GET방식으로 들어오면 아래 메소드 실행.
		public Map<String, Object> getProducts(@RequestParam(name = "start", required = false, defaultValue = "1") int start,
				@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {
			System.out.println("categoryId : " + categoryId + " / start : " + start);
			//start가 1인이유 : start부터 4개 가져오기 쿼리문 limit사용하기때문
			
			start = 4*(start-1);
			//1 : 0~3 4*0
			//2 : 4~7 4*1
			//3 : 8~11 4*2
			//4 : 12~16 4*3
			System.out.println("작동?");
			//전체 데이터 가져오기.
			ProductResponse productResponse = productService.getProducts(start, categoryId);			

			Map<String, Object> map = new HashMap<>();
			map.put("list", productResponse);

			return map;
		}
		
		// 상세정보 조회
		@RequestMapping(path = "/{displayInfoId}")
		public DisplayInfoResponse getDisplayInfo(@RequestParam(name = "displayInfoId", required = false, defaultValue = "1") int displayInfoId){
			System.out.println("displayInfoId : " + displayInfoId);

			//맵쓰지말기!!!!!!!!!!!!!!!!!
			DisplayInfoResponse response = productService.getDisplayInfoResponse(displayInfoId);

			return response;
		}
	}

