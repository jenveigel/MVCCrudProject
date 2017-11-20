package com.skilldistillery.xmasList.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class XmasListDBDAOImpl implements XmasListDAO {
	private static final String url = "jdbc:mysql://localhost:3306/omg";
	private String user = "giver";
	private String pwd = "giver";
	private List<XmasList> xl = new ArrayList<>();

	public XmasListDBDAOImpl() {  
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("error loading MySQL Driver");
		}
	}

	@Override
	public XmasList getXmasListById(int id) {
		XmasList xl = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT id, recipient, giftItem, reason, cost " + " FROM omg WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
				String recipient = rs.getString(2);
				String giftItem = rs.getString(3);
				String reason = rs.getString(4);
				Double cost = rs.getDouble(5);
				xl = new XmasList(id, recipient, giftItem, reason, cost);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xl;
	}

	@Override
	public List<XmasList> getAllXmasLists() {
		xl = new ArrayList();
		XmasList xmasList = null;
		int id = 1;
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT id, recipient, giftItem, reason, cost FROM omg";
			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
				String recipient = rs.getString(2);
				String giftItem = rs.getString(3);
				String reason = rs.getString(4);
				Double cost = rs.getDouble(5);
				xmasList = new XmasList(id, recipient, giftItem, reason, cost);
				xl.add(xmasList);
				System.out.println(xmasList);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xl;
	}
	
	@Override
	public void addXmasList(XmasList x) {
		Connection conn = null;
		String sql;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			conn.setAutoCommit(false);
			sql = "INSERT INTO omg (id, recipient, giftItem, reason, cost) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, x.getId());
			st.setString(2, x.getRecipient());
 			st.setString(3, x.getGiftItem());
 			st.setString(4, x.getReason());
 			st.setDouble(5, x.getCost());
 			st.executeUpdate();
 			
 			ResultSet keys = st.getGeneratedKeys();
 			if (keys.next()) {
 				int id = keys.getInt(1);
 				x.setId(id);
 			}
 			conn.commit();
 		}
		catch (SQLException e) {
			System.err.println("Error during inserts.");
			System.err.println("SQL Error: " + e.getErrorCode() + ": " + e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
	}

//	@Override
//	// void or return type XmasList?
//	public XmasList addXmasList(XmasList x) {
//		Connection conn = null;
//		String sql;
//		ResultSet rs = null;
//		XmasList xl = null;
//		try {
//			conn = DriverManager.getConnection(url, user, pwd);
//			conn.setAutoCommit(false);
//			sql = "INSERT INTO omg (id, recipient, giftItem, reason, cost) VALUES (?, ?, ?, ?, ?)";
//			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			st.setInt(1, x.getId());
//			st.setString(2, x.getRecipient());
//			st.setString(3, x.getGiftItem());
//			st.setString(4, x.getReason());
//			st.setDouble(5, x.getCost());
//			st.executeUpdate();
//
//			ResultSet keys = st.getGeneratedKeys();
//			if (keys.next()) {
//				int id = keys.getInt(1);
//				x.setId(id);
//				sql = "SELECT id, recipient, giftItem, reason, cost FROM omg WHERE id = ?";
//				rs = st.executeQuery();
//				st.setInt(1, id);
//				if (rs.next()) {
//					id = rs.getInt(1);
//					String recipient = rs.getString(2);
//					String giftItem = rs.getString(3);
//					String reason = rs.getString(4);
//					Double cost = rs.getDouble(5);
//					xl = new XmasList(id, recipient, giftItem, reason, cost);
//				}
//			}
//			conn.commit();
//			rs.close();
//			st.close();
//			conn.close();
//		} catch (SQLException e) {
//			System.err.println("Error during inserts.");
//			System.err.println("SQL Error: " + e.getErrorCode() + ": " + e.getMessage());
//			System.err.println("SQL State: " + e.getSQLState());
//			if (conn != null) {
//				try {
//					conn.rollback();
//				} catch (SQLException e1) {
//					System.err.println("Error rolling back.");
//					e1.printStackTrace();
//				}
//			}
//		}
//		return xl;
//		
//	}

	@Override
	public void updateXmasList(XmasList x) {
		Connection conn = null;
		String sql;
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			conn.setAutoCommit(false);
			sql = "UPDATE omg SET recipient = ?, giftItem = ?, reason = ?, cost = ? WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, x.getRecipient());
			st.setString(2, x.getGiftItem());
			st.setString(3, x.getReason());
			st.setDouble(4, x.getCost());
			st.setInt(5, x.getId());
			st.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			System.err.println("Error during inserts.");
			System.err.println("SQL Error: " + e.getErrorCode() + ": " + e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public XmasList deleteXmasList(int id) {
		XmasList xmasListDelete = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
				conn.setAutoCommit(false);
				String sql = "DELETE from omg WHERE id = ?";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
				xmasListDelete = getXmasListById(id);
				
				conn.commit();
				st.close();
				conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return xmasListDelete;
	}

	@Override
	public List<XmasList> returnList() {
		// TODO Auto-generated method stub
		return xl;
	}

	@Override
	public XmasList findXmasListById(int id) {
		XmasList x = null;
		for (XmasList xmasList : xl) {
			if (xmasList.getId() == id) {
				x = xmasList;
			}
		}
		return x;
	}

//	@Override
//	public void deleteXmasList(int id) {
//		int num = 0;
//		for (XmasList xmasList : xl) {
//			if (xmasList.getId() == id) {
//				num = xl.indexOf(xmasList);
//			}
//		}
//		xl.remove(num);
//	}
}
