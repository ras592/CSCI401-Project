package store.utility;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.business.*;

/**
 * TODO Add stores table
 * TODO Change how db connections are handled
 * @author richardsharrott
 *
 */
public class MysqlCon {
	private static String MYSQL_PASS = "pass1234";
	private static String MYSQL_URL = "jdbc:mysql://localhost:3306/";
	private static String MYSQL_DATABASE_NAME = "fastrsale";
	private static String MYSQL_USERNAME = "root";
	
	public static Connection connectMysqlConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = DriverManager.getConnection(  
				MysqlCon.MYSQL_URL + MysqlCon.MYSQL_DATABASE_NAME,
				MysqlCon.MYSQL_USERNAME,
				MysqlCon.MYSQL_PASS);
		return con;
	}
	
	public static void getUsers() {
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL select_users()}");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				System.out.println(String.format("%s, %s",
					rs.getString("first_name"),
					rs.getString("last_name")));
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static Boolean validateUser(String email, String password) {
		Boolean returnVal = false;
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL validate_user(?, ?)}");
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if (rs.getInt(1) == 1) {
					returnVal = true;
				}
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return returnVal;
	}
	
	public static Boolean validateStoreName(String store_name) {
		Boolean returnVal = false;
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL validate_store_name(?)}");
			statement.setString(1, store_name);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if (rs.getInt(1) == 1) {
					returnVal = true;
				}
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return returnVal;
	}
	
	public static User getUser(String email) {
		User returnVal = null;
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL get_user(?)}");
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String ret_email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String zip = rs.getString("zip");
				String country = rs.getString("country");
				int role_id = rs.getInt("role_id");
				/*System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %d\n", 
						first_name, last_name, ret_email, address,
						city, state, zip, country, role_id);*/
				returnVal = new User(userId, first_name, last_name, ret_email,
						address, city, state, zip, country, role_id);
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return returnVal;
	}
	
	public static Store getStores(String store_name) {
		Store returnVal = null;
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL get_store(?)}");
			statement.setString(1, store_name);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				int storeId = rs.getInt("id");
				String ret_store_name = rs.getString("store_name");
				int userId = rs.getInt("user_id");
				/*System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %d\n", 
						first_name, last_name, ret_email, address,
						city, state, zip, country, role_id);*/
				returnVal = new Store(storeId, ret_store_name, userId);
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return returnVal;
	}
	
	public static Boolean insert_user(String first_name, String last_name, String email, String password,
			String address, String city, String state, String zip, String country, int role_id) {
		// return false if it doesn't work
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL insert_users(?,?,?,?,?,?,?,?,?,?)}");
			statement.setString(1, first_name);
			statement.setString(2, last_name);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setString(5, address);
			statement.setString(6, city);
			statement.setString(7, state);
			statement.setString(8, zip);
			statement.setString(9, country);
			statement.setInt(10, role_id);
			
			statement.executeQuery();
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return true;
	}
	
	public static Boolean insert_store(int user_id, String store_name) {
		// return false if it doesn't work
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL insert_store(?,?)}");
			statement.setString(1, store_name);
			statement.setInt(2, user_id);
			
			statement.executeQuery();
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return true;
	}
	
	public static Product getProductById(int product_id) {
		Product returnVal = null;
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL get_product_by_id(?)}");
			statement.setInt(1, product_id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				returnVal = new Product(rs.getInt("id"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("quantity"), rs.getString("image_urls"),
						rs.getInt("store_id"), rs.getInt("category_id"));
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return returnVal;
	}
	
	/*
		Note this code was written even though I created a stored procedure to make sure
		I know how to do all types of queries.
	 */
	public static ArrayList<Category> getAllCategories() {
		Connection con = null;
		ArrayList<Category> result = new ArrayList<Category>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM `FastrSale`.`categories`";
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int categoryId = rs.getInt("id");
				String categoryName = rs.getString("category_name");
				String categoryImage = rs.getString("category_image");
				
				result.add(new Category(categoryId, categoryName, categoryImage));
			}
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closeResultSet(rs);
			MysqlCon.closeStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		return result;
	}
	
	public static ArrayList<Product> getAllProducts() {
		Connection con = null;
		ArrayList<Product> result = new ArrayList<Product>();
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM `FastrSale`.`products`";
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				result.add(new Product(rs.getInt("id"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("quantity"), rs.getString("image_urls"),
						rs.getInt("store_id"), rs.getInt("category_id")));
			}
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closeResultSet(rs);
			MysqlCon.closeStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		return result;
	}
	
	public static ArrayList<Product> getAllProductsByStore(int id) {
		Connection con = null;
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM `FastrSale`.`products` WHERE store_id=?";
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				result.add(new Product(rs.getInt("id"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("quantity"), rs.getString("image_urls"),
						rs.getInt("store_id"), rs.getInt("category_id")));
			}
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closeResultSet(rs);
			MysqlCon.closeStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		return result;
	}
	
	public static ArrayList<Product> getAllProductsByCategory(int id) {
		Connection con = null;
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM `FastrSale`.`products` WHERE category_id=?";
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				result.add(new Product(rs.getInt("id"), rs.getString("product_name"), rs.getString("description"),
						rs.getDouble("price"), rs.getInt("quantity"), rs.getString("image_urls"),
						rs.getInt("store_id"), rs.getInt("category_id")));
			}
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closeResultSet(rs);
			MysqlCon.closeStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		return result;
	}
	
	public static void removeProduct(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		String query = "DELETE FROM `FastrSale`.`products` WHERE id=?";
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			Boolean success = stmt.execute();
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closePreparedStatement(stmt);
			MysqlCon.freeConnection(con);
		}
	}
	
	public static Store getStoreByUserId(int userId) {
		Connection con = null;
		Store result = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM `FastrSale`.`stores` WHERE user_id=?";
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int storeId = rs.getInt("id");
				String storeName = rs.getString("store_name");
				userId = rs.getInt("user_id");
				
				result = new Store(storeId, storeName, userId);
			}
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closeResultSet(rs);
			MysqlCon.closePreparedStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		return result;
	}
	
	public static Boolean insertProduct(String productName, String description,
			double price, int quantity, String imageURL, int storeId, int categoryId) {
		Connection con = null;
		Store result = null;
		CallableStatement stmt = null;
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareCall("{CALL insert_product(?, ?, ?, ?, ?, ?, ?)}");
			stmt.setString(1, productName);
			stmt.setString(2, description);
			stmt.setDouble(3, price);
			stmt.setInt(4, quantity);
			stmt.setString(5, imageURL);
			stmt.setInt(6, storeId);
			stmt.setInt(7, categoryId);
			
			stmt.executeQuery();
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closePreparedStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		return true;
	}
	
	private static void closeResultSet(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	private static void closeStatement(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	private static void closePreparedStatement(Statement ps) {
		try {
			if(ps != null) {
				ps.close();
			}
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}

	private static void freeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}

	public static void removeFromCartById(int id, int userId) {
		Connection con = null;
		PreparedStatement stmt = null;
		String query = "DELETE FROM `FastrSale`.`carts` WHERE product_id=? AND user_id=?";
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setInt(2, userId);
			Boolean success = stmt.execute();
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closePreparedStatement(stmt);
			MysqlCon.freeConnection(con);
		}
	}

	public static List<Product> getAllProductsFromCart(int userId) {
		Connection con = null;
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT product_id FROM `FastrSale`.`carts` WHERE user_id=?";
		ArrayList<Integer> next_query = new ArrayList<Integer>();
		
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				next_query.add(rs.getInt("product_id"));
			}
			
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closeResultSet(rs);
			MysqlCon.closeStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		
		for(int i = 0; i < next_query.size(); i++) {
			result.add(getProductById(next_query.get(i)));
		}
		
		return result;
	}

	public static List<Product> addProductToCart(int id, int userId) {
		Connection con = null;
		PreparedStatement stmt = null;
		String query = "INSERT INTO `FastrSale`.`carts` (product_id, user_id) VALUES(?, ?)";
		try {
			con = MysqlCon.connectMysqlConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setInt(2, userId);
			Boolean success = stmt.execute();
		} catch(SQLException ex1) {
			System.out.println(ex1);
		} catch (ClassNotFoundException ex2) { 
			System.out.println(ex2);
		} finally {
			MysqlCon.closePreparedStatement(stmt);
			MysqlCon.freeConnection(con);
		}
		return getAllProductsFromCart(userId);
	}
}