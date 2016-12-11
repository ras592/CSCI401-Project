package store.utility;
import java.sql.*;

import store.business.*;

/**
 * TODO Add stores table
 * @author richardsharrott
 *
 */
public class MysqlCon {
	private static String MYSQL_PASS = "pass1234";
	private static String MYSQL_URL = "jdbc:mysql://localhost:3306/";
	private static String MYSQL_DATABASE_NAME = "fastrsale";
	private static String MYSQL_USERNAME = "root";
	
	public static Connection connectMysqlConnection() throws Exception {
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
}