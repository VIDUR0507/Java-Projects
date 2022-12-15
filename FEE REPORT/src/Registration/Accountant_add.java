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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Accountant_add extends JDialog implements ActionListener {
	private JTextField id;
	private JTextField username;
	private JTextField password;
	private JTextField name;
	private JTextField con_no;
	private JRadioButton male;
	private JRadioButton female;
	private JButton submit;
	private JButton cancel;
	private JLabel lblContactno;
	private JLabel lblGender;
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblUsername;
	private JLabel lblNewLabel;
    int reg_id;
	public Accountant_add()
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("ADD_ACCOUNTANT");
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 17, 94, 26);
		getContentPane().add(lblNewLabel);
		
		lblUsername = new JLabel("USER_NAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUsername.setBounds(10, 60, 94, 14);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(10, 97, 94, 14);
		getContentPane().add(lblPassword);
		
		lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblName.setBounds(10, 135, 94, 14);
		getContentPane().add(lblName);
		
		lblGender = new JLabel("GENDER");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGender.setBounds(10, 172, 94, 14);
		getContentPane().add(lblGender);
		
		lblContactno = new JLabel("CONTACT_NO");
		lblContactno.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactno.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContactno.setBounds(10, 215, 106, 18);
		getContentPane().add(lblContactno);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(212, 21, 224, 20);
		getContentPane().add(id);
		id.setColumns(10);
		
		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		submit.setBounds(92, 267, 116, 27);
		getContentPane().add(submit);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cancel.setBounds(259, 267, 116, 27);
		getContentPane().add(cancel);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(212, 58, 224, 20);
		getContentPane().add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(212, 95, 224, 20);
		getContentPane().add(password);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(212, 133, 224, 20);
		getContentPane().add(name);
		
		con_no = new JTextField();
		con_no.setColumns(10);
		con_no.setBounds(212, 213, 224, 20);
		getContentPane().add(con_no);
		
		male = new JRadioButton("MALE");
		male.setFont(new Font("Tahoma", Font.PLAIN, 12));
		male.setBounds(222, 168, 65, 23);
		getContentPane().add(male);
		
		female = new JRadioButton("FEMALE");
		female.setFont(new Font("Tahoma", Font.PLAIN, 12));
		female.setBounds(336, 168, 91, 23);
		getContentPane().add(female);
		setSize(517,351);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		getID();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Accountant_add();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		if(ob==cancel) 
		{
			dispose();
		}
		else if (ob==submit)
		{
			String USER_NAME=username.getText();
			String PASSWORD=password.getText();
			String NAME=name.getText();
			String GENDER=null;
			if(male.isSelected())
				GENDER="Male";
			else
				GENDER="female";
			String CONTACT_NO=con_no.getText();
			String st="insert into accountant"
			         +"(a_id,Username,Password,Name,Contact_no,Gender)"
					 +"values(?,?,?,?,?,?)";
			Connection con=dbconnection2.connect();
			try {
				PreparedStatement ps=con.prepareStatement(st);
				ps.setInt(1,reg_id);
				ps.setString(2, USER_NAME);
				ps.setString(3, PASSWORD);
				ps.setString(4, NAME);
				ps.setString(5, CONTACT_NO);
				ps.setString(6, GENDER);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "Accountant added");
				dispose();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}		
		
			
		}
		
	}
	void getID() {
		String st="select max(a_id) from accountant";
		Connection con=dbconnection2.connect();
		
		try { PreparedStatement ps=con.prepareStatement(st);
		ResultSet rs=ps.executeQuery();
		rs.next();
		reg_id=rs.getInt(1);	
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		++reg_id;
		id.setText(String.valueOf(reg_id));
	}

	
}
