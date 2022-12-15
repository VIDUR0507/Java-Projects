package Registration;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Accountant extends JDialog implements ActionListener{
	private JTextField username;
	private JLabel lblUSER_NAME;
	private JLabel lblPassword;
	private JButton login;
	private JPasswordField password;

	public Accountant() 
	{
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		lblUSER_NAME = new JLabel("USER_NAME");
		lblUSER_NAME.setIcon(new ImageIcon(Accountant.class.getResource("/Registration/images/download (2).jpg")));
		lblUSER_NAME.setHorizontalAlignment(SwingConstants.CENTER);
		lblUSER_NAME.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUSER_NAME.setBounds(24, 72, 171, 59);
		getContentPane().add(lblUSER_NAME);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setIcon(new ImageIcon(Accountant.class.getResource("/Registration/images/password.jpg")));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(24, 164, 171, 47);
		getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setBounds(304, 85, 236, 36);
		getContentPane().add(username);
		username.setColumns(10);
		
		login = new JButton("LOGIN");
		login.setIcon(new ImageIcon(Accountant.class.getResource("/Registration/images/login.jpg")));
		login.setFont(new Font("Times New Roman", Font.BOLD, 20));
		login.setBounds(186, 238, 191, 59);
		getContentPane().add(login);
		
		password = new JPasswordField();
		password.setBounds(304, 174, 236, 30);
		getContentPane().add(password);
		
		JLabel acclogin = new JLabel("ACCOUNTANT_LOGIN");
		acclogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		acclogin.setHorizontalAlignment(SwingConstants.CENTER);
		acclogin.setBounds(172, 11, 272, 52);
		getContentPane().add(acclogin);
		setSize(626, 360);
		login.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
     new Accountant();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	Object ob=e.getSource(); 
	 if(ob==login)
	 {
			Connection con=dbconnection2.connect();
			String st="select * from accountant where Username=? and Password=?";
			String USER_NAME=username.getText();
			String PASSWORD=new String(password.getPassword());
			try {
				PreparedStatement ps=con.prepareStatement(st);
				ps.setString(1,USER_NAME);
				ps.setString(2, PASSWORD);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) 
				{
					new Accountant_section();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid");
					password.setText("");
					username.setText("");
					password.requestFocusInWindow();
					}
			}
			 catch (SQLException e1) 
			{
				
				e1.printStackTrace();
			 }

		}
		
	}
}
