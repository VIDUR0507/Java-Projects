package id_card_generator;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.sarxos.webcam.Webcam;

public class studentadd extends JDialog implements ActionListener {
	int no;
	java.sql.Date date1=new java.sql.Date(new java.util.Date().getTime());
	private JTextField regno;
	private JTextField name;
	private JTextField fname;
	private JTextField mob;
	private JButton can;
	private JButton sub;
	private JRadioButton rm;
	private JRadioButton rf;
	private JButton take;
	private JLabel lblDate;
	private JTextField date;
	private JLabel lblCourse;
	private JComboBox course;
	private JTextArea ad;
	private JComboBox year;
	private final ButtonGroup bg = new ButtonGroup();
	private JLabel photo;
	Webcam webcam;
	Dimension [] nonStandardResolutions;
	InputStream img;
	private JButton reset;

	public studentadd() {
		setTitle("ADD NEW STUDENT");
		getContentPane().setLayout(null);

		JLabel lblRegno = new JLabel("Reg_No");
		lblRegno.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblRegno.setBounds(39, 87, 135, 46);
		getContentPane().add(lblRegno);

		JLabel lblAddNewStudent = new JLabel("ADD NEW STUDENT");
		lblAddNewStudent.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAddNewStudent.setBounds(39, 13, 281, 46);
		getContentPane().add(lblAddNewStudent);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblName.setBounds(39, 134, 135, 46);
		getContentPane().add(lblName);

		JLabel lblFathersname = new JLabel("Fathers_Name");
		lblFathersname.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblFathersname.setBounds(39, 226, 135, 46);
		getContentPane().add(lblFathersname);

		JLabel lblMobileno = new JLabel("Mobile_NO");
		lblMobileno.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblMobileno.setBounds(39, 339, 135, 46);
		getContentPane().add(lblMobileno);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblAddress.setBounds(39, 398, 135, 46);
		getContentPane().add(lblAddress);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblGender.setBounds(39, 181, 135, 46);
		getContentPane().add(lblGender);

		regno = new JTextField();
		regno.setEditable(false);
		regno.setText("0");
		regno.setHorizontalAlignment(SwingConstants.CENTER);
		regno.setFont(new Font("Times New Roman", Font.BOLD, 19));
		regno.setBounds(204, 100, 116, 22);
		getContentPane().add(regno);
		regno.setColumns(10);

		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		name.setColumns(10);
		name.setBounds(204, 147, 116, 22);
		getContentPane().add(name);

		fname = new JTextField();
		fname.setHorizontalAlignment(SwingConstants.CENTER);
		fname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		fname.setColumns(10);
		fname.setBounds(204, 239, 116, 22);
		getContentPane().add(fname);

		mob = new JTextField();
		mob.setHorizontalAlignment(SwingConstants.CENTER);
		mob.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mob.setColumns(10);
		mob.setBounds(204, 354, 116, 22);
		getContentPane().add(mob);

		ad = new JTextArea();
		ad.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		ad.setBounds(204, 413, 116, 105);
		getContentPane().add(ad);

		rm = new JRadioButton("Male",true);
		bg.add(rm);
		rm.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rm.setBounds(193, 189, 82, 32);
		getContentPane().add(rm);

		rf = new JRadioButton("Female");
		bg.add(rf);
		rf.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rf.setBounds(279, 189, 82, 32);
		getContentPane().add(rf);

		take = new JButton("Select_image");
		take.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getimage();
			}
		});
		take.setBounds(587, 280, 135, 25);
		getContentPane().add(take);

		sub = new JButton("SUBMIT");
		sub.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sub.setBounds(574, 412, 148, 32);
		getContentPane().add(sub);

		can = new JButton("CANCEL");
		can.setFont(new Font("Times New Roman", Font.BOLD, 20));
		can.setBounds(574, 486, 148, 32);
		getContentPane().add(can);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDate.setBounds(555, 25, 72, 22);
		getContentPane().add(lblDate);

		date = new JTextField(date1.toString());
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setEditable(false);
		date.setFont(new Font("Times New Roman", Font.BOLD, 18));
		date.setBounds(650, 28, 116, 22);
		getContentPane().add(date);
		date.setColumns(10);

		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblCourse.setBounds(39, 280, 135, 46);
		getContentPane().add(lblCourse);

		course = new JComboBox();
		course.setModel(new DefaultComboBoxModel(new String[] {"", "BCA", "BBA", "BSc", "ARTS"}));
		course.setBounds(204, 295, 72, 22);
		getContentPane().add(course);

		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblYear.setBounds(318, 280, 65, 46);
		getContentPane().add(lblYear);

		year = new JComboBox();
		year.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		year.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		year.setBounds(395, 295, 47, 22);
		getContentPane().add(year);
		
		photo = new JLabel("");
		photo.setBounds(574, 87, 185, 156);
		getContentPane().add(photo);
		
		reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		reset.setFont(new Font("Times New Roman", Font.BOLD, 19));
		reset.setBounds(574, 553, 148, 32);
		getContentPane().add(reset);
		setSize(840, 645);
		setModal(true);
		can.addActionListener(this);
		sub.addActionListener(this);
		getID();
		setVisible(true);

	}

	public static void main(String[] args) {
		new studentadd();
		//LocalDate today=LocalDate.now();
		//LocalDate validity=today.plusMonths(6);
		//System.out.println(today);
	//	System.out.println(validity);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==can) {
			dispose();
		}
		if(ob==sub){
			String Name=name.getText();
			if(Name==null || Name.trim().length()==0) {
				JOptionPane.showMessageDialog(this, "Name not valid");
				name.setText("");
				name.requestFocusInWindow();
				return;
			}
			
			String Gender=null;

			if(rm.isSelected())
				Gender="Male";
			else
				Gender="female";
			String Fathers_Name=fname.getText();
			String Course=course.getSelectedItem().toString();
			String Year=year.getSelectedItem().toString();
			String Mobile_No=mob.getText();
			String Address=ad.getText();
			String st="insert into student_info"
					+"(Reg_NO,Reg_date,Name,Gender,Fathers_name,Course,Year,Mobile_no,"
					+ "Address,Image)values(?,?,?,?,?,?,?,?,?,?)";
			Connection con=dbcon1.connect();
			try {
				img=new FileInputStream(new File("E:/Test.jpg"));
				PreparedStatement ps=con.prepareStatement(st);
				ps.setInt(1,no);
				ps.setDate(2,date1);
				ps.setString(3,Name);
				ps.setString(4,Gender);
				ps.setString(5,Fathers_Name);
				ps.setString(6,Course);
				ps.setString(7,Year);
				ps.setString(8,Mobile_No);
				ps.setString(9,Address);
				ps.setBinaryStream(10, img);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "info added");
				dispose();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(IOException se) {
				se.printStackTrace();
			}

		}

	}
	void getID() {
		String st="select max(Reg_NO) from student_info";
		Connection con=dbcon1.connect();

		try { PreparedStatement ps=con.prepareStatement(st);
		ResultSet rs=ps.executeQuery();
		rs.next();
		no=rs.getInt(1);	
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		++no;
		regno.setText(String.valueOf(no));
	}
	void getimage() {
		webcam = webcam.getDefault();
		webcam.setCustomViewSizes(new Dimension(176,144));
		webcam.setViewSize(new Dimension(176,144));
		webcam.open();
		
		BufferedImage image = webcam.getImage();
		webcam.close();
		try {
			 
			File f=new File("E:/Test.jpg");
			if(f.exists())
				f.delete();
			ImageIO.write(image, "JPG", f);
			BufferedImage bufImg=ImageIO.read(f);

			ImageIcon ii=new ImageIcon(bufImg);
			photo.setIcon(ii);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	void clear() {
		course.setSelectedIndex(0);
		year.setSelectedIndex(0);
		mob.setText("");
		name.setText("");
		fname.setText("");
		ad.setText("");
		bg.clearSelection();
		regno.setText("");
		photo.setIcon(null);
		photo.setText("");
		regno.requestFocusInWindow();
	}
}


