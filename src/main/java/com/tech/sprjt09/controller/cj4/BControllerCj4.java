package com.tech.sprjt09.controller.cj4;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sprjt09.service.cj1.BServiceInter;
import com.tech.sprjt09.service.cj3.BContentViewService;
import com.tech.sprjt09.service.cj3.BDeleteService;
import com.tech.sprjt09.service.cj3.BModifyService;

@Controller
public class BControllerCj4 {
	BServiceInter bServiceInter;

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,
			Model model) {
		System.out.println("delete()");
////		db에 데이터 삭제
//		//toss
//		tom3 comment
//		model.addAttribute("request",request);
//		bServiceInter=new BDeleteService();
//		bServiceInter.execute(model);
//		
		return "redirect:list";
	}

}
