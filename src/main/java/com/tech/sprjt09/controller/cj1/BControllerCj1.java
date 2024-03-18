package com.tech.sprjt09.controller.cj1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.sprjt09.service.cj1.BListService;
import com.tech.sprjt09.service.cj1.BServiceInter;

@Controller
public class BControllerCj1 {
	
	BServiceInter bServiceInter;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
////		데이터 가져오기
//		master of master
//		bServiceInter=new BListService();
//		bServiceInter.execute(model);
		
		return "list";
	}
	

}
