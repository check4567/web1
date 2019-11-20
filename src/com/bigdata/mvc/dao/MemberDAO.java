package com.bigdata.mvc.dao;

import java.sql.*;
import java.util.*;

import com.bigdata.mvc.vo.MemberVO;

public class MemberDAO {

	public Connection getConnection() {
		Connection conn = null; // DB에 접속하기 위한 connection 객체
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "bigdata";
		String pwd = "bigdata";

		try {
			Class.forName(driver); // new 개념이다. 동적할당이라는 개념으로 객체 생성 해줌.
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("driver load fail");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db connection fail");
			e.printStackTrace();
		}

		return conn;
	}

	public List<MemberVO> selectAll() {
		Connection conn = null; // DB 연결
		Statement stmt = null; // sql 등록
		ResultSet rs = null; // DB 결과값 담아옴
		List<MemberVO> mlist = null; // ResulstSet에서 나온 값을 리스트에 담아서 리턴

		try {
			conn = getConnection(); // DB 연결
			stmt = conn.createStatement(); // sql을 담을 준비완료 new랑 비슷한 개념
			String sql = "select * from member"; // sql을 담을 준비완료
			rs = stmt.executeQuery(sql); // sql 실행
			mlist = new ArrayList<MemberVO>(); // rs = > arraylist

			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddr(rs.getString("addr"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));

				mlist.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			try {
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (rs != null) {
//					rs.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			close(stmt, rs, conn);
		}
		return mlist;
	}

	public String selectLogin(String id, String pwd) {
		Connection conn = null; // DB 연결
		Statement stmt = null; // sql 등록, 실행
		ResultSet rs = null;
		String dbId = "";
		try {
			conn = getConnection(); // DB연결
			stmt = conn.createStatement(); // stmt 사용준비(객체선언)

			String sql = "select id from member " + "where id ='" + id + "' " + "and pwd ='" + pwd + "' ";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				dbId = rs.getString(1); // columm 순서에 따라서. id가 첫번째 이므로 1번인것이다. pwd가 도 연속적으로 출력했다면 2번이 되겠다.
//				dbId = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs, conn);
		}

		return dbId;
	}

	public static void main(String[] agrs) {
		MemberDAO jdbc = new MemberDAO();

		List<MemberVO> mlist = jdbc.selectAll();

		for (int i = 0; i < mlist.size(); i++) {

			System.out.print(mlist.get(i).getId() + " ");
			System.out.print(mlist.get(i).getPwd() + " ");
			System.out.print(mlist.get(i).getEmail() + " ");
			System.out.print(mlist.get(i).getPhone() + " ");
			System.out.print(mlist.get(i).getAddr() + " ");
			System.out.print(mlist.get(i).getGender() + " ");
			System.out.print(mlist.get(i).getAge() + "\n");

		}
	}

	public int memberRegist(MemberVO vo) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		int result=0;
		try {
			conn = getConnection();
			String sql = "insert into member (id,pwd,email,phone,addr,gender,age,joinDt) "
					+ "values (?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getGender());
			pstmt.setInt(7, vo.getAge());
					
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, null, conn);
		}
		return result;
	}
	
	
	public void close(Statement stmt, ResultSet rs, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
