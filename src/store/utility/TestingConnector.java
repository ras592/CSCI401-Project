package store.utility;

import store.business.*;

public class TestingConnector {
	public static void main(String[] args) {
		if (MysqlCon.validateUser("example1@email.com", "pass1")) {
			System.out.println("Validated");
		} else {
			System.out.println("Not valid");
		}
		
		//MysqlCon.insert_user("Richard", "Sharrott", "rasharrott@gmail.com", "pass1234", "1 Anystreet Rd", "Anytown", "NY", "10002", "US");
		
		//User retUser = MysqlCon.getUser("rasharrott@gmail.com");
		//System.out.println(retUser.getEmail());
	}
}

