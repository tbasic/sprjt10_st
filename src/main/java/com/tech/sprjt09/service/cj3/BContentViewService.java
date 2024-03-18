package com.tech.sprjt09.service.cj3;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprjt09.dao.BoardDao;
import com.tech.sprjt09.dto.BoardDto;
import com.tech.sprjt09.service.cj1.BServiceInter;

public class BContentViewService implements BServiceInter {
	@Override
	public void execute(Model model) {
		System.out.println("BContentViewService>>>>>>>");
//		db에 접속 데이터 조회
		//map변환
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		//System.out.println("bid:"+bid);
		BoardDao dao=new BoardDao();
		BoardDto dto=dao.contentView(bid);
		//뷰단에서 해당글을 사용하도록 모델에 추가
		model.addAttribute("content_view",dto);

	}

}
