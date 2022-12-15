package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Registration.dbconnection2;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Color;

public class StudentUpdate extends JDialog implements ActionListener{
	private JTextField name;
	private JTextField fname;
	private JTextField address;
	private JTextField mob_no;
	private JTextField email;
	private JTextField course_fee;
	private JLabel lblName;
	private JLabel lblFathersname;
	private JLabel lblCourse;
	private JLabel lblAddress;
	private JLabel lblMobileno;
	private JLabel lblEmail;
	private JLabel lblCoursefee;
	private JButton update;
	private JButton cancel;
	private JComboBox course;
    int id;
    boolean found;
    private JLabel lblCity;
    private JTextField city;
	public StudentUpdate(int id) 
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentUpdate.class.getResource("/Registration/images/black-lamborghini-wallpaper-1680x1050-0022.jpg"))); this.id=id;
		setTitle("STUDENT_UPDATE");
		getContentPane().setLayout(null);
		
		lblName = new JLabel("NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName.setBounds(10, 30, 119, 14);
		getContentPane().add(lblName);
		
		lblFathersname = new JLabel("FATHER_NAME");
		lblFathersname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblFathersname.setBounds(10, 76, 119, 14);
		getContentPane().add(lblFathersname);
		
		lblCourse = new JLabel("COURSE");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCourse.setBounds(10, 123, 119, 14);
		getContentPane().add(lblCourse);
		
		lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddress.setBounds(10, 194, 119, 14);
		getContentPane().add(lblAddress);
		
		lblMobileno = new JLabel("MOBILE_NO");
		lblMobileno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblMobileno.setBounds(10, 236, 119, 14);
		getContentPane().add(lblMobileno);
		
		lblEmail = new JLabel("E_MAIL");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmail.setBounds(10, 276, 119, 14);
		getContentPane().add(lblEmail);
		
		name = new JTextField();
		name.setBounds(249, 27, 220, 20);
		getContentPane().add(name);
		name.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(249, 73, 220, 20);
		getContentPane().add(fname);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(249, 191, 220, 20);
		getContentPane().add(address);
		
		mob_no = new JTextField();
		mob_no.setColumns(10);
		mob_no.setBounds(249, 233, 220, 20);
		getContentPane().add(mob_no);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(249, 273, 220, 20);
		getContentPane().add(email);
		
		lblCoursefee = new JLabel("COURSE_FEE");
		lblCoursefee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCoursefee.setBounds(10, 318, 119, 14);
		getContentPane().add(lblCoursefee);
		
		course_fee = new JTextField();
		course_fee.setColumns(10);
		course_fee.setBounds(249, 315, 220, 20);
		getContentPane().add(course_fee);
		
		update = new JButton("UPDATE");
		update.setFont(new Font("Times New Roman", Font.BOLD, 13));
		update.setBounds(94, 343, 98, 30);
		getContentPane().add(update);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		cancel.setBounds(274, 342, 98, 33);
		getContentPane().add(cancel);
		
		course = new JComboBox();
		course.setModel(new DefaultComboBoxModel(new String[] {"BCA", "B.SC ", "BA", "B.COM ", "B.TECH"}));
		course.setBounds(249, 123, 220, 20);
		getContentPane().add(course);
		
		lblCity = new JLabel("CITY");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCity.setBounds(10, 160, 119, 14);
		getContentPane().add(lblCity);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(249, 157, 220, 20);
		getContentPane().add(city);
	    setModal(true);
		setSize(548, 423);
		update.addActionListener(this);
		cancel.addActionListener(this);
		update();
		setVisible(true);
	}
    @Override
	public void actionPerformed(ActionEvent e)
	{
  
	Object ob=e.getSource();
	if(ob==cancel)
	{
		dispose();
	}
    if(ob==update)
	{
	String Name=name.getText();
	String FATHER_NAME=fname.getText();
	String COURSE=course.getSelectedItem().toString();
	String ADDRESS=address.getText();
	String MOBILE_NO=mob_no.getText();
	String E_MAIL=email.getText();
	String COURSE_FEE=course_fee.getText();
	String st="update student set Course=?,Address=?,mobile_no=?,e_mail=?,course_fee=? where reg_id=?";
	Connection con=dbconnection2.connect();
	try {
		PreparedStatement ps=con.prepareStatement(st);
		ps.setString(1, COURSE);
		ps.setString(2, ADDRESS);
		ps.setString(3, MOBILE_NO);
		ps.setString(4, E_MAIL);
		ps.setString(5, COURSE_FEE);
		ps.setInt(6, id);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(this, "updated");
		dispose();
	}
	catch(SQLException se){
		se.printStackTrace();
	}

	}
		
	}
    void update()
    {
    	String st="select * from student where reg_id=?";
		Connection con= dbconnection2.connect();
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();

			while (rs.next())
			{
				found=true;
				name.setText(rs.getString("name"));
				fname.setText(rs.getString("fathers_name"));
				course.setSelectedItem(rs.getString("Course"));
				city.setText(rs.getString("city"));
				address.setText(rs.getString("address"));
				mob_no.setText(rs.getString("mobile_no"));
				email.setText(rs.getString("e_mail"));
				course_fee.setText(rs.getString("course_fee"));
			}

		}
		catch(SQLException se) {
			se.printStackTrace();
		}
    }
		
	
	public static void main(String[] args)
	{
		new StudentUpdate(1);
	}
}
