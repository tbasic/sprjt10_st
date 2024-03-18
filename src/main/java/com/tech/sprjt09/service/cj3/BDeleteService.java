package com.tech.sprjt09.service.cj3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprjt09.dao.BoardDao;
import com.tech.sprjt09.service.cj1.BServiceInter;

public class BDeleteService implements BServiceInter{

	@Override
	public void execute(Model model) {
		System.out.println("BDeleteService>>>>>>>");

		Map<String, Object> map=model.asMap();

		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		
		BoardDao dao=new BoardDao();
		dao.delete(bid);
	}

}
