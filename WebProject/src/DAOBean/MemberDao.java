package DAOBean;

import java.sql.*;
import java.util.ArrayList;
import javax.sql.*;
import javax.naming.*;

public class MemberDao {
	private static MemberDao instance;

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	private MemberDao() {
	}

	// DB접속
	public Connection getConnection() throws Exception {
		Context cont = new InitialContext();
		DataSource ds = (DataSource) cont.lookup("java:comp/env/jdbc/OracleDB");
		Connection conn = ds.getConnection();
		return conn;
	}

	// 회원정보 입력
	public int insertMember(Member member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?,'b',sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setInt(5, member.getPort());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(9, member.getTel());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pstmt.close();
		conn.close();
		return result;
	}

	// 로그인
	public int userCheck(String id, String pass) throws Exception {
		int x = -1;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = String.format("select password from member where id='%s'", id);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String password = rs.getString(1);
				if (password.equals(pass))
					x = 1; // 아이디 있음, 비밀번호 일치
				else
					x = 0; // 아이디 있음, 비밀번호 불일치
			} else
				x = -1; // 아이디 없음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rs.close();
		stmt.close();
		conn.close();
		return x;
	}

	// 아이디 중복체크
	public int confirmId(String id) throws Exception {
		int x = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = String.format("select id from member where id='%s'", id);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				x = 1; // 아이디 있음
			else
				x = 0; // 아이디 없음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rs.close();
		stmt.close();
		conn.close();
		return x;
	}

	// 회원정보 불러오기
	public Member getMember(String id) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = getConnection();
			String sql = String.format("select * from member where id='%s'", id);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setGender(rs.getString(4));
				member.setPort(rs.getInt(5));
				member.setAddress1(rs.getString(6));
				member.setAddress2(rs.getString(7));
				member.setEmail(rs.getString(8));
				member.setTel(rs.getString(9));
				member.setGrade(rs.getString(10));
				member.setReg_date(rs.getDate(11));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rs.close();
		stmt.close();
		conn.close();
		return member;
	}

	// 회원목록
	public ArrayList<Member> showMembers() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Member> al = null;
		try {
			conn = getConnection();
			al = new ArrayList<Member>();
			String sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setGender(rs.getString(4));
				member.setPort(rs.getInt(5));
				member.setAddress1(rs.getString(6));
				member.setAddress2(rs.getString(7));
				member.setEmail(rs.getString(8));
				member.setTel(rs.getString(9));
				member.setGrade(rs.getString(10));
				member.setReg_date(rs.getDate(11));
				al.add(member);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rs.close();
		stmt.close();
		conn.close();
		return al;
	}

	// 수정된 회원정보 입력
	public int updateMember(Member member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();
			String sql = "update member set password=?,name=?,tel=?,"
					+ "port=?, address1=?, address2=?, email=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getTel());
			pstmt.setInt(4, member.getPort());
			pstmt.setString(5, member.getAddress1());
			pstmt.setString(6, member.getAddress2());
			pstmt.setString(7, member.getEmail());
			pstmt.setString(8, member.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pstmt.close();
		conn.close();
		return result;
	}

	// 회원탈퇴
	public int deleteMember(String id, String pass) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int x = 0;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql1 = "select password from member where id = ?";
			String sql2 = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String password = rs.getString(1);
				if (password.equals(pass)) {
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, id);
					x = pstmt.executeUpdate();	// 아이디 있음, 비밀번호 일치. 삭제수행
				} else
					x = 0;	// 비밀번호 불일치
			} else
				x = -1;		// 아이디 없음
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		rs.close();
		pstmt.close();
		conn.close();
		return x;
	}
}