package Registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {
	static double balfee=0;
	static double totalfee=0;
	public static double checkBalance(int reg_id) {
		double Amount_paid;
		Connection con=dbconnection2.connect();
		String st="select course_fee from student where reg_id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1, reg_id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			totalfee=rs.getDouble(1);

			st="select sum(Amount_paid) from feedetails where StudentID=?";
			ps=con.prepareStatement(st);
			ps.setInt(1,reg_id);
			rs=ps.executeQuery();
			rs.next();
			Amount_paid=rs.getDouble(1);
			
			balfee=totalfee-Amount_paid;
			System.out.println("Balance on balance view: "+balfee);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return balfee;
		}
	public static void main(String[] args) {
		checkBalance(1);
	}
	
}
