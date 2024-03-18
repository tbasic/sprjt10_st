package com.tech.sprjt09.service.cj3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprjt09.dao.BoardDao;
import com.tech.sprjt09.dto.BoardDto;
import com.tech.sprjt09.service.cj1.BServiceInter;

public class BModifyService implements BServiceInter {
	@Override
	public void execute(Model model) {
		System.out.println("BModifyService>>>>>>>");
//		db에 접속 데이터 수정
		//map변환
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		BoardDao dao=new BoardDao();
		dao.modify(bid,bname,btitle,bcontent);

	}

}
