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
////		������ ��������

//		master of master
//		master of master2
		bServiceInter=new BListService();
		bServiceInter.execute(model);

		bServiceInter=new BListService();
		bServiceInter.execute(model);		
		return "list";
	}
	

}
