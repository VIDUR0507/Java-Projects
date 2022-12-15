package Registration;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class Student_view extends JDialog

{
	JScrollPane jsp;
	int reg_id;
	java.sql.Date rdate=new java.sql.Date(new java.util.Date().getTime());

	public Student_view() 
	{
		getContentPane().setForeground(Color.BLUE);
		setForeground(Color.RED);
		this.reg_id=reg_id;
		setBackground(Color.BLUE);
		getContentPane().setBackground(Color.GRAY);
		setTitle("Table View");
		String st = "select * from student where reg_id";
		try {
			Connection con = dbconnection2.connect();
			PreparedStatement ps = con.prepareStatement(st);
			//ps.setInt(1, reg_id);
			ResultSet rs = ps.executeQuery();
			String columns[] = new String[]{"reg_id","reg_date","name","fathers_name","course",
					"address","mobile_no","e_mail","course_fee"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			JTable table = new JTable();
			table.setFont(new Font("Tahoma",Font.BOLD,11));
			table.setBackground(new Color(250,228,181));
			table.setModel(model);
			table.setFillsViewportHeight(true);
			while(rs.next())
			{
				reg_id = rs.getInt("reg_id");
				rdate=rs.getDate("reg_date");
				String Name = rs.getString("name");
				String Father_name = rs.getString("fathers_name");
				String Course = rs.getString("course");
				String Address = rs.getString("address");
				String Mobile_no = rs.getString("mobile_no");
				String E_mail = rs.getString("e_mail");
				String Course_fee = rs.getString("course_fee");
				model.addRow(new Object[]{reg_id,rdate,Name,Father_name,Course,Address,Mobile_no,E_mail,Course_fee});
				jsp = new JScrollPane(table,JScrollPane.
						VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				
			}
			
		} catch (SQLException|NullPointerException se) 
		{
			se.printStackTrace();
			dispose();
		}
		getContentPane().add(jsp);
		setSize(700,377);
		jsp.setBounds(44, 11, 550, 250);
		getContentPane().setLayout(null);
		JButton btnclose = new JButton("Close");
		btnclose.setForeground(new Color(255,255,255));
		btnclose.setBackground(new Color(255,0,0));
		btnclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();
			}
		});
		btnclose.setFont(new Font("Tahoma",Font.BOLD,20));
		btnclose.setBounds(251,282,119,33);
		setModal(true);
		setLocation(120,100);
		getContentPane().add(btnclose);
		setVisible(true);
	}
	public static void main(String ar[])
	{
		new Student_view();
	}
}
