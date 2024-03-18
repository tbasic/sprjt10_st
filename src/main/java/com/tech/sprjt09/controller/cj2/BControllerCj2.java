package com.tech.sprjt09.controller.cj2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.sprjt09.service.cj1.BServiceInter;
import com.tech.sprjt09.service.cj2.BWriteService;

@Controller
public class BControllerCj2 {
	
	BServiceInter bServiceInter;

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");

		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
//		글쓰기 진행
////		toss
//		model.addAttribute("request",request);
//		bServiceInter=new BWriteService();
//		bServiceInter.execute(model);

		return "redirect:list";
	}
//tom2

}
