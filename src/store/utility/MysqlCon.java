package store.utility;
import java.sql.*;
import store.business.*;

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
	
	public static User getUser(String email) {
		User returnVal = null;
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL get_user(?)}");
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
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
				returnVal = new User();
				/* But WHY zero-args? */
				returnVal.setFirstName(first_name);
				returnVal.setLastName(last_name);
				returnVal.setEmail(ret_email);
				returnVal.setAddress(address);
				returnVal.setCity(city);
				returnVal.setState(state);
				returnVal.setZip(zip);
				returnVal.setCountry(country);
				returnVal.setRole_id(role_id);
			}
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return returnVal;
	}
	
	public static Boolean insert_user(String first_name, String last_name, String email, String password,
			String address, String city, String state, String zip, String country) {
		// return false if it doesn't work
		try{
			Connection con = MysqlCon.connectMysqlConnection();
			CallableStatement statement = con.prepareCall("{CALL insert_users(?,?,?,?,?,?,?,?,?)}");
			statement.setString(1, first_name);
			statement.setString(2, last_name);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.setString(5, address);
			statement.setString(6, city);
			statement.setString(7, state);
			statement.setString(8, zip);
			statement.setString(9, country);
			
			statement.executeQuery();
			con.close();
		} catch(Exception e){
			System.out.println(e);
		}
		return true;
	}
}