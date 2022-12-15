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

public class Admin extends JDialog implements ActionListener 
{
	private JTextField username;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel adminlogin;
	private JPasswordField password;
	private JButton login;

	public Admin()
	{
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		adminlogin = new JLabel("ADMIN LOGIN");
		adminlogin.setHorizontalAlignment(SwingConstants.CENTER);
		adminlogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		adminlogin.setBounds(160, 11, 230, 49);
		getContentPane().add(adminlogin);
		
		lblUsername = new JLabel("USER_NAME");
		lblUsername.setIcon(new ImageIcon(Admin.class.getResource("/Registration/images/download (2).jpg")));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(23, 55, 183, 62);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setIcon(new ImageIcon(Admin.class.getResource("/Registration/images/password.jpg")));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(23, 146, 170, 49);
		getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(283, 71, 218, 36);
		getContentPane().add(username);
		
		password = new JPasswordField();
		password.setBounds(283, 153, 218, 36);
		getContentPane().add(password);
		
		login = new JButton("LOGIN");
		login.setIcon(new ImageIcon(Admin.class.getResource("/Registration/images/login.jpg")));
		login.setFont(new Font("Times New Roman", Font.BOLD, 18));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		login.setBounds(160, 223, 177, 62);
		getContentPane().add(login);
		setSize(549, 335);
		login.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Admin();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==login) 
		{
		Connection con=dbconnection2.connect();
		String st="select * from admin where Username=? and Password=?";
		String USER_NAME=username.getText();
		String PASSWORD=new String(password.getPassword());
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setString(1, USER_NAME);
			ps.setString(2, PASSWORD);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				new Admin_section();
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid");
				password.setText("");
				username.setText("");
				password.requestFocusInWindow();
				
			     }
		}
		 catch (SQLException e1) {
		
			e1.printStackTrace();
		}
	}
}
}
