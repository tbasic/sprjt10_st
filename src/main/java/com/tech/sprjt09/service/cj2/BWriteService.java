package com.tech.sprjt09.service.cj2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprjt09.dao.BoardDao;
import com.tech.sprjt09.service.cj1.BServiceInter;

public class BWriteService implements BServiceInter {

	@Override
	public void execute(Model model) {
		System.out.println("BWriteService>>>>>>>");
//		model���� request�� �����
//		������ ��ȯ
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		//System.out.println("bname : "+bname);
		
//		db�� ���� ������ ����
		BoardDao dao=new BoardDao();
		dao.write(bname,btitle,bcontent);

	}

}
