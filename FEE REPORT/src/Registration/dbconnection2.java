package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection2 {
	static Connection con;
	static Connection connect() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/fee report","root","7843839368");
		System.out.println("Connected");
	}
	catch(ClassNotFoundException se) {
		se.printStackTrace();
	}
	catch(SQLException se) {
		se.printStackTrace();
	}
	return con;
}

	public static void main(String[] args)
	{
     connect();
	}

}
