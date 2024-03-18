package com.tech.sprjt09.service.cj1;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.tech.sprjt09.dao.BoardDao;
import com.tech.sprjt09.dto.BoardDto;

public class BListService implements BServiceInter {

	@Override
	public void execute(Model model) {
		System.out.println("BListService>>>>>>>");
//		db에 접속 데이터 조회
		BoardDao dao=new BoardDao();
		ArrayList<BoardDto> dtos=dao.list();
//		모델에 적재
		model.addAttribute("list",dtos);
	}

}
