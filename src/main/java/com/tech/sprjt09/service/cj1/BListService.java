package com.tech.sprjt09.service.cj1;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.tech.sprjt09.dao.BoardDao;
import com.tech.sprjt09.dto.BoardDto;

public class BListService implements BServiceInter {

	@Override
	public void execute(Model model) {
		System.out.println("BListService>>>>>>>");
//		db�� ���� ������ ��ȸ
		BoardDao dao=new BoardDao();
		ArrayList<BoardDto> dtos=dao.list();
//		�𵨿� ����
		model.addAttribute("list",dtos);
	}

}
