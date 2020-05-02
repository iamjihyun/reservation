package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService rService;
	
	@RequestMapping("/mainpage")
	public String list() {
		
		return "mainpage";
	}
}
