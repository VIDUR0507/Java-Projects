package id_card_generator;

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

public class Login extends JDialog implements ActionListener {
	private JTextField u;
	private JPasswordField p;
	private JButton login;

	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblLogin.setBounds(251, 13, 122, 103);
		getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUsername.setBounds(43, 117, 187, 103);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPassword.setBounds(43, 233, 187, 103);
		getContentPane().add(lblPassword);
		
		u = new JTextField();
		u.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		u.setBounds(364, 129, 187, 55);
		getContentPane().add(u);
		u.setColumns(10);
		
		p = new JPasswordField();
		p.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		p.setBounds(364, 251, 187, 55);
		getContentPane().add(p);
		
		login = new JButton("LOGIN");
		login.setFont(new Font("Times New Roman", Font.BOLD, 19));
		login.setBounds(215, 368, 171, 48);
		getContentPane().add(login);
		setSize(679, 506);
		login.addActionListener(this);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==login) {
			Connection c=dbcon1.connect();
			String st="select * from login where username=? and password=?";
			String user=u.getText();
			String pass=new String(p.getPassword());
			try {
				PreparedStatement ps=c.prepareStatement(st);
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					new Home();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "error credential");
					p.setText("");
					u.setText("");
					p.requestFocusInWindow();
					
				}
			}
			 catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		
	}
	}
	
	}

