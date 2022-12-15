package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import Registration.dbconnection2;
import java.awt.Toolkit;
import java.awt.Color;

public class newstudent extends JDialog implements ActionListener
{ int reg_id;
   java.sql.Date REGISTRATION_DATE=new java.sql.Date(new java.util.Date().getTime());
	private JTextField coursefee;
	private JTextField name;
	private JTextField rdate;
	private JTextField address;
	private JTextField city;
	private JTextField fname;
	private JTextField mobno;
	private JLabel lblRegistrationNo;
	private JLabel lblRegistrationDate;
	private JLabel lblRegistertionNo;
	private JLabel lblCourse;
	private JLabel lblCity;
	private JLabel lblMobile;
	private JLabel lblEmail;
	private JLabel lblFatherName;
	private JLabel lblCourseFee;
	private JButton submit;
	private JComboBox course;
	private JTextField rnum;
	private JButton cancel;
	private JTextField textField;
	private JLabel lblCoursefee;

	public newstudent() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(newstudent.class.getResource("/Registration/images/black-lamborghini-wallpaper-1680x1050-0022.jpg")));
		setTitle("STUDENT_REGISTRATION");
		getContentPane().setLayout(null);
		
		lblRegistertionNo = new JLabel("NAME");
		lblRegistertionNo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRegistertionNo.setBounds(10, 80, 144, 14);
		getContentPane().add(lblRegistertionNo);
		
		lblRegistrationNo = new JLabel("REGISTRATION_NO");
		lblRegistrationNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistrationNo.setBounds(10, 11, 144, 14);
		getContentPane().add(lblRegistrationNo);
		
		lblRegistrationDate = new JLabel("REGISTRATION_DATE");
		lblRegistrationDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRegistrationDate.setBounds(10, 45, 144, 14);
		getContentPane().add(lblRegistrationDate);
		
		lblCourseFee = new JLabel("MOBILE_NO");
		lblCourseFee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCourseFee.setBounds(10, 284, 130, 14);
		getContentPane().add(lblCourseFee);
		
		lblCourse = new JLabel("FATHER_NAME");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCourse.setBounds(10, 109, 144, 14);
		getContentPane().add(lblCourse);
		
		lblCity = new JLabel("COURSE");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCity.setBounds(10, 142, 144, 14);
		getContentPane().add(lblCity);
		
		lblMobile = new JLabel("CITY");
		lblMobile.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMobile.setBounds(10, 176, 144, 14);
		getContentPane().add(lblMobile);
		
		lblEmail = new JLabel("ADDRESS");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmail.setBounds(10, 212, 130, 14);
		getContentPane().add(lblEmail);
		
		lblFatherName = new JLabel("E_MAIL");
		lblFatherName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblFatherName.setBounds(10, 248, 130, 14);
		getContentPane().add(lblFatherName);
		
		coursefee = new JTextField();
		coursefee.setBounds(370, 281, 172, 20);
		getContentPane().add(coursefee);
		coursefee.setColumns(10);
		
		name = new JTextField();
		name.setBounds(370, 77, 172, 20);
		getContentPane().add(name);
		name.setColumns(10);
		
		rdate = new JTextField(REGISTRATION_DATE.toString());
		rdate.setColumns(10);
		rdate.setBounds(370, 42, 172, 20);
		getContentPane().add(rdate);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(370, 209, 172, 20);
		getContentPane().add(address);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(370, 106, 172, 20);
		getContentPane().add(city);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(370, 245, 172, 20);
		getContentPane().add(fname);
		
		course = new JComboBox<Object>();
		course.setModel(new DefaultComboBoxModel<Object>(new String[] {"BCA ", "B.SC", "BA", "B.COM", "B.TECH"}));
		course.setBounds(370, 139, 172, 20);
		getContentPane().add(course);
		
		mobno = new JTextField();
		mobno.setColumns(10);
		mobno.setBounds(370, 173, 172, 20);
		getContentPane().add(mobno);
		
		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		submit.setBounds(108, 338, 89, 23);
		getContentPane().add(submit);
		
		rnum = new JTextField();
		rnum.setColumns(10);
		rnum.setBounds(370, 9, 172, 20);
		getContentPane().add(rnum);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		cancel.setBounds(259, 338, 98, 23);
		getContentPane().add(cancel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(370, 312, 172, 20);
		getContentPane().add(textField);
		
		lblCoursefee = new JLabel("COURSE_FEE");
		lblCoursefee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCoursefee.setBounds(10, 313, 130, 14);
		getContentPane().add(lblCoursefee);
		setModal(true);
		setSize(595,411);
		setLocation(250,200);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		getID();
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new newstudent();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{ 
		Object ob=e.getSource();
		if(ob==cancel)
		{
			dispose();
		}
		else if(ob==submit){
			String NAME=name.getText();
			String FATHER_NAME=fname.getText();
			String COURSE=course.getSelectedItem().toString();
			String CITY=city.getText();
			String ADDRESS=address.getText();
			String E_MAIL=address.getText();
			String MOBILE_NO=mobno.getText();
			String COURSE_FEE=coursefee.getText();
			String st="insert into student"+"(reg_id,reg_date,name,fathers_name,course,city,address,mobile_no,e_mail,course_fee)"
			+"values(?,?,?,?,?,?,?,?,?,?)";
			Connection con=dbconnection2.connect();
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1,reg_id);
			ps.setDate(2,REGISTRATION_DATE);
			ps.setString(3,NAME);
			ps.setString(4,FATHER_NAME);
			ps.setString(5,COURSE);
			ps.setString(6, CITY);
			ps.setString(7, ADDRESS);
			ps.setString(8,MOBILE_NO);
			ps.setString(9,E_MAIL );
			ps.setString(10,COURSE_FEE);
			
			ps.executeUpdate();
			JOptionPane.showMessageDialog(this, "info added");
			dispose();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}			
	}
	}
	void getID()
	{
		String st="select max(reg_id) from student";
		Connection con=dbconnection2.connect();
		
		try {
		PreparedStatement ps=con.prepareStatement(st);
		ResultSet rs=ps.executeQuery();
		rs.next();
		reg_id=rs.getInt(1);	
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		++reg_id;
		rnum.setText(String.valueOf(reg_id));
	}
}
