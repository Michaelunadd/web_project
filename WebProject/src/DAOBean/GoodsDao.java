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

public class GoodsDao {
	private static GoodsDao instance;

	private GoodsDao() {
	}

	public static GoodsDao getInstance() {
		if (instance == null) {
			instance = new GoodsDao();
		}
		return instance;
	}

	// db연결
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

	// 등록된 상품 갯수 확인
	public int getGoodsCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from goods");
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
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return count;
	}

	// 상품정보 불러오기
	public List<Goods> getGoodss(int start, int end) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Goods> goodsList = null;
		String sql = "select * from (select rownum rn, a.* from " + "(select * from goods order by ref desc) a)"
				+ "where rn between ? and ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			int k = start + end - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, k);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				goodsList = new ArrayList<Goods>();
				do {
					Goods goods = new Goods();
					goods.setNum(rs.getInt("num"));
					goods.setName(rs.getString("name"));
					goods.setGroup1(rs.getString("G_1"));
					goods.setGroup2(rs.getString("G_2"));
					goods.setGroup3(rs.getString("G_3"));
					goods.setCost(rs.getInt("cost"));
					goods.setReg_date(rs.getDate("reg_date"));
					goods.setQty(rs.getInt("qty"));
					goods.setThumb(rs.getBlob("thumb"));
					goods.setJpg(rs.getBlob("jpg"));
					goods.setText(rs.getString("text"));
					goodsList.add(goods);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return goodsList;
	}

	// 상품정보 입력
	public int insert(Goods goods) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		int number = 0;
		String sql1 = "";
		String sql2 = "";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select max(num) from goods");
			rs = pstmt.executeQuery();
			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;
			pstmt.close();

			sql1 = "insert into goods"
					+ "(num,name,g_1,g_2,g_3,cost,reg_date,qty)"
					+ " values(?,?,?,?,?,?,sysdate,?)";
			sql2 = "insert into goodsinfo values(?,?,?,?)"; 
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, number);
			pstmt.setString(2, goods.getName());
			pstmt.setString(3, goods.getGroup1());
			pstmt.setString(4, goods.getGroup2());
			pstmt.setString(5, goods.getGroup3());
			pstmt.setInt(6, goods.getCost());
			pstmt.setDate(7, goods.getReg_date());
			pstmt.setInt(8, goods.getQty());
			result = pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, number);
			pstmt.setBlob(2, goods.getThumb());
			pstmt.setBlob(3, goods.getJpg());
			pstmt.setString(4, goods.getText());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return result;
	}

	// 상품수정
	public Goods updateGetGoods(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = new Goods();
		String sql = "select * from servicecenter where num =" + num;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				goods.setNum(rs.getInt("num"));
				goods.setName(rs.getString("name"));
				goods.setGroup1(rs.getString("G_1"));
				goods.setGroup2(rs.getString("G_2"));
				goods.setGroup3(rs.getString("G_3"));
				goods.setCost(rs.getInt("cost"));
				goods.setReg_date(rs.getDate("reg_date"));
				goods.setQty(rs.getInt("qty"));
				goods.setThumb(rs.getBlob("thumb"));
				goods.setJpg(rs.getBlob("jpg"));
				goods.setText(rs.getString("text"));
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return goods;
	}

	// 내용확인(조회수+1)
	public Goods getGoods(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = updateGetGoods(num);
		String sql1 = "update servicecenter set readcount = readcount + 1 " + " where num=" + num;
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
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return goods;
	}

	// 상품정보 수정 --수정중
	public int update(Goods goods) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		int num = goods.getNum();
		String sql1 = "select num from goodsinfo where num=" + num;
		String sql2 = "update goodsinfo set thumb=?,jpg=?,text=? where num=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int dbGoodsInfo = rs.getInt(1);
				if (dbGoodsInfo == num) {
					pstmt.close();
					pstmt = conn.prepareStatement(sql2);
					pstmt.setBlob(1, goods.getThumb());
					pstmt.setBlob(2, goods.getJpg());
					pstmt.setString(3, goods.getText());
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
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return result;
	}

	// 상품 삭제
	public int delete(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql1 = "select num from goods where num=" + num;
		String sql2 = "delete from goods where num=" + num + "cascade";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbNum = rs.getString(1);
				if (dbNum.equals(num)) {
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
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return result;
	}

}