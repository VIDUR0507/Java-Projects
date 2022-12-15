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

public class Accountant_view extends JDialog

{
	JScrollPane jsp;
	int reg_id;
	public Accountant_view() 
	{
		this.reg_id=reg_id;
		setBackground(Color.BLUE);
		getContentPane().setBackground(new Color(245,255,250));
		setTitle("Table View");
		String st = "select * from accountant";
		try {
			Connection con = dbconnection2.connect();
			PreparedStatement ps = con.prepareStatement(st);
			//ps.setInt(1, reg_id);
			ResultSet rs = ps.executeQuery();
			String columns[] = new String[]{"a_id","Username","Password","Name","Contact_no","Gender"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			JTable table = new JTable();
			table.setFont(new Font("Tahoma",Font.BOLD,14));
			table.setBackground(new Color(255,228,181));
			table.setModel(model);
			table.setFillsViewportHeight(true);
			while(rs.next())
			{
				reg_id = rs.getInt("a_id");
				String Username = rs.getString("Username");
				String Password = rs.getString("Password");
				String Name = rs.getString("Name");
				String Contact_no = rs.getString("Contact_no");
				String Gender = rs.getString("Gender");
				
				model.addRow(new Object[]{reg_id,Username,Password,Name,Contact_no,Gender});
				jsp = new JScrollPane(table,JScrollPane.
						VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				
			}
			
		} catch (SQLException|NullPointerException se) 
		{
		
			se.printStackTrace();
			dispose();
		}
		getContentPane().add(jsp);
		setSize(659,403);
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
		btnclose.setBounds(254,309,119,33);
		setModal(true);
		setLocation(120,100);
		getContentPane().add(btnclose);
		setVisible(true);
	}
	public static void main(String ar[])
	{
		new Accountant_view();
	}
}
