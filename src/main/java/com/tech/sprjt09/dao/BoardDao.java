package com.tech.sprjt09.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tech.sprjt09.dto.BoardDto;

public class BoardDao {
	DataSource dataSource;
	public BoardDao() {
		//System.out.println("db접속 생성자");
		try {
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/springxe");
			//System.out.println("db success");
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
	public ArrayList<BoardDto> list() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		
		try {
			con=dataSource.getConnection();
			String sql="select bid,bname,btitle," + 
					"bcontent,bdate,bhit," + 
					"bgroup,bstep,bindent " + 
					"from replyboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
//			dtos에 담기
			while (rs.next()) {
				int bid=rs.getInt("bid");
				String bname=rs.getString("bname");
				String btitle=rs.getString("btitle");
				String bcontent=rs.getString("bcontent");
				Timestamp bdate=rs.getTimestamp("bdate");
				
				int bhit=rs.getInt("bhit");
				int bgroup=rs.getInt("bgroup");
				int bstep=rs.getInt("bstep");
				int bindent=rs.getInt("bindent");
				BoardDto dto=new BoardDto(bid, bname,
						btitle, bcontent, bdate, 
						bhit, bgroup, bstep, bindent);
				//리스트에 담기
				dtos.add(dto);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}		
		return dtos;
	}
	public void write(String bname,
			String btitle,String bcontent) {
//		db연결 insert실행
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			String sql="insert into replyboard values(" + 
					"replyboard_seq.nextval,?,?,?," + 
					"sysdate,0,replyboard_seq.currval,0,0)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			int rn=pstmt.executeUpdate();
			System.out.println("rnnnnn:"+rn);	
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}
	public BoardDto contentView(String sbid) {
		upHit(sbid);
		
		//bid 번호 레코드 조회
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDto dto=null;
		
		try {
			con=dataSource.getConnection();
			String sql="select bid,bname,btitle," + 
					"bcontent,bdate,bhit," + 
					"bgroup,bstep,bindent " + 
					"from replyboard where bid=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			rs=pstmt.executeQuery();
//			rs를 dto에 셋팅
			if(rs.next()) {
				int bid=rs.getInt("bid");
				String bname=rs.getString("bname");
				String btitle=rs.getString("btitle");
				String bcontent=rs.getString("bcontent");
				Timestamp bdate=rs.getTimestamp("bdate");
				
				int bhit=rs.getInt("bhit");
				int bgroup=rs.getInt("bgroup");
				int bstep=rs.getInt("bstep");
				int bindent=rs.getInt("bindent");
				
				dto=new BoardDto(bid, bname, btitle, 
						bcontent, bdate, bhit, 
						bgroup, bstep, bindent);	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	public void upHit(String sbid) {
		Connection con=null;
		PreparedStatement pstmt=null;

		try {
			con=dataSource.getConnection();
			String sql="update replyboard " + 
					"set bhit=bhit+1 " + 
					"where bid=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	public void modify(String sbid,String bname,
			String btitle,String bcontent) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			String sql="update replyboard " + 
					"set bname=?,btitle=?," + 
					"bcontent=? where bid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, Integer.parseInt(sbid));
//			업데이트 실행
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void delete(String sbid ) {
		//bid를 조건으로 db에서 해당글 삭제
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			String sql="delete from replyboard where bid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
//			삭제 실행
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
