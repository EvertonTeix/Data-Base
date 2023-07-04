package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connecting {
	
	private static Connecting conexaoUtil;

	public static Connecting getInstance() {
		if (conexaoUtil == null) {
			conexaoUtil = new Connecting();
		}

		return conexaoUtil;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school", "root", "");
	}
	
	public static void main(String[] args) {
		
		try {
		System.out.println(getInstance().getConnection());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
