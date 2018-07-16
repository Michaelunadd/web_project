package DAOBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SCDao {
	private static SCDao instance;

	private SCDao() {
	}

	public static SCDao getInstance() {
		if (instance == null) {	instance = new SCDao();}
		return instance;
	}

	// DB연결
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	// 공지사항 글 갯수 확인(게시판별)
	public int getSCCount(String dpt) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from servicecenter where dpt="+dpt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return count;
	}

	// 부서별 글 목록 불러오기
	public List<SC> getSCs(int start, int end, String dpt) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SC> scList = null;
		String sql = "select * from (select rownum rn, a.* from "
				   + "(select * from servicecenter where dpt=? order by ref desc) a)" 
				   + "where rn between ? and ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int k = start + end - 1;
			pstmt.setString(1, dpt);
			pstmt.setInt(2, start);
			pstmt.setInt(3, k);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				scList = new ArrayList<SC>();
				do {
					SC sc = new SC();
					sc.setNum(rs.getInt("num"));
					sc.setWriter(rs.getString("writer"));
					sc.setSubject(rs.getString("subject"));
					sc.setPasswd(rs.getString("password"));
					sc.setReg_date(rs.getDate("reg_date"));
					sc.setReadcount(rs.getInt("readcount"));
					sc.setRef(rs.getInt("ref"));
					sc.setContent(rs.getString("content"));
					scList.add(sc);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return scList;
	}

	// 글쓰기(답변포함)
	public int insert(SC sc, String dpt) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		int num = sc.getNum();
		int ref = sc.getRef();
		int number = 0;
		String sql = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from servicecenter");
			rs = pstmt.executeQuery();
			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;
			pstmt.close();

			if (num == 0) {
				ref = number;
			} 
			sql = "insert into servicecenter" 
				+ "(num,writer,subject,passwd,reg_date,ref,content,dpt)" 
				+ " values(?,?,?,?,sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, sc.getWriter());
			pstmt.setString(3, sc.getSubject());
			pstmt.setString(4, sc.getPasswd());
			pstmt.setInt(6, ref);
			pstmt.setString(7, sc.getContent());
			pstmt.setString(8, dpt);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return result;
	}

	// 수정된 글 내용 불러오기
	public SC updateGetSC(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SC sc = new SC();
		String sql = "select * from servicecenter where num =" + num;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sc.setNum(rs.getInt("num"));
				sc.setWriter(rs.getString("writer"));
				sc.setSubject(rs.getString("subject"));
				sc.setPasswd(rs.getString("passwd"));
				sc.setReg_date(rs.getDate("reg_date"));
				sc.setReadcount(rs.getInt("readcount"));
				sc.setRef(rs.getInt("ref"));
				sc.setContent(rs.getString("content"));
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return sc;
	}

	// 내용확인(조회수+1)
	public SC getSC(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SC sc = updateGetSC(num);
		String sql1 = "update servicecenter set readcount = readcount + 1 " 
					+ " where num=" + num;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return sc;
	}

	// 수정된 글 내용 저장
	public int update(SC sc) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		int num = sc.getNum();
		String password = sc.getPasswd();
		String sql1 = "select password from servicecenter where num=" + num;
		String sql2 = "update servicecenter set writer=?,subject=?," 
					+ "reg_date=sysdate,content=? where num=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPassword = rs.getString(1);
				if (dbPassword.equals(password)) {
					pstmt.close();
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, sc.getWriter());
					pstmt.setString(2, sc.getSubject());
					pstmt.setString(3, sc.getContent());
					pstmt.setInt(4, num);
					result = pstmt.executeUpdate();
				} else {
					result = -1;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return result;
	}

	// 글 삭제
	public int delete(int num, String password) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql1 = "select password from servicecenter where num=" + num;
		String sql2 = "delete from servicecenter where num=" + num;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPassword = rs.getString(1);
				if (dbPassword.equals(password)) {
					pstmt.close();
					pstmt = conn.prepareStatement(sql2);
					result = pstmt.executeUpdate();
				} else {
					result = -1;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {}
		}
		return result;
	}

}