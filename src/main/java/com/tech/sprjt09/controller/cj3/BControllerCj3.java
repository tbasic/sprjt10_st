package com.tech.sprjt09.controller.cj3;

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
public class BControllerCj3 {
	BServiceInter bServiceInter;
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		//(글번호)해당글 조회
////		toss
//		model.addAttribute("request", request);
//		bServiceInter=new BContentViewService();
//		bServiceInter.execute(model);

		return "content_view";
	}
	@RequestMapping("/content_update")
	public String content_update(HttpServletRequest request, Model model) {
		System.out.println("content_update()");
		//(글번호)해당글 조회
////		toss
//		model.addAttribute("request", request);
//		bServiceInter=new BContentViewService();
//		bServiceInter.execute(model);

		return "content_update";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		//(글번호)해당글 수정
//		toss
//		String bid=request.getParameter("bid");
//		model.addAttribute("request",request);
//		bServiceInter=new BModifyService();
//		bServiceInter.execute(model);

//		return "redirect:content_view?bid="+bid;
		return "redirect:list";
	}


}
