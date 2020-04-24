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
import kr.or.connect.reservation.service.ReservationService;

public class ReservationApiController {
	@RestController
	@RequestMapping(path = "/products")
	public class GuestbookApiController {
		@Autowired
		ReservationService rService;

		@GetMapping // guestbooks URL로 요청이 들어올 때, GET방식으로 들어오면 아래 메소드 실행.
		public Map<String, Object> list(@RequestParam(name = "start", required = false, defaultValue = "0") int start,
				@RequestParam(name = "cate", required = false, defaultValue = "0") int cate) {
			System.out.println("들어온 start값 : " + start + ", 들어온 cate값 : " + cate);
			
			List<Product> list = rService.getProducts(start, cate);
			System.out.println("셀렉해온 리스트 : " + list);
			int count = rService.getCount(cate);
			int pageCount = count / ReservationService.LIMIT;
			if (count % ReservationService.LIMIT > 0)
				pageCount++;

			List<Integer> pageStartList = new ArrayList<>();
			for (int i = 0; i < pageCount; i++) {
				pageStartList.add(i * ReservationService.LIMIT);
			}

			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("count", count);
			map.put("pageStartList", pageStartList);

			return map;
		}
	}
}
