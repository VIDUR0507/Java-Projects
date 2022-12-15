package id_card_generator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class id_generate extends JDialog implements	ActionListener{
	private JTextField reg_no;
	private JTextField name;
	private JTextField fname;
	private JTextField gender;
	private JTextField course;
	private JTextField vf;
	private JTextField ad;
	private JTextField year;
	private JTextField vt;
	boolean found;
	int id;
	private JLabel img;
	
	

	public id_generate(int id) {
		this.id=id;
	LocalDate today=LocalDate.now();
	LocalDate validity=today.plusYears(1);
		getContentPane().setLayout(null);
		
		JLabel lblXyzCollege = new JLabel("XYZ COLLEGE");
		lblXyzCollege.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblXyzCollege.setBounds(201, 0, 270, 65);
		getContentPane().add(lblXyzCollege);
		
		JLabel lblIdentityCard = new JLabel("IDENTITY CARD");
		lblIdentityCard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIdentityCard.setBounds(261, 61, 155, 24);
		getContentPane().add(lblIdentityCard);
		
		JLabel lblRegid = new JLabel("Reg_ID");
		lblRegid.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRegid.setBounds(23, 106, 75, 16);
		getContentPane().add(lblRegid);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblName.setBounds(23, 135, 75, 16);
		getContentPane().add(lblName);
		
		JLabel lblFathersname = new JLabel("Fathers_Name");
		lblFathersname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblFathersname.setBounds(23, 168, 115, 16);
		getContentPane().add(lblFathersname);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblGender.setBounds(23, 197, 75, 16);
		getContentPane().add(lblGender);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblCourse.setBounds(23, 226, 75, 16);
		getContentPane().add(lblCourse);
		
		JLabel lblValidfrom = new JLabel("Valid-From");
		lblValidfrom.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblValidfrom.setBounds(23, 255, 94, 17);
		getContentPane().add(lblValidfrom);
		
		JLabel lblValidto = new JLabel("Valid_to");
		lblValidto.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblValidto.setBounds(300, 255, 75, 16);
		getContentPane().add(lblValidto);
		
		JLabel lblValidto_1 = new JLabel("Address");
		lblValidto_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblValidto_1.setBounds(23, 284, 75, 16);
		getContentPane().add(lblValidto_1);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblYear.setBounds(300, 226, 75, 16);
		getContentPane().add(lblYear);
		
		img = new JLabel("");
		img.setBounds(540, 107, 165, 165);
		getContentPane().add(img);
		
		reg_no = new JTextField();
		reg_no.setHorizontalAlignment(SwingConstants.CENTER);
		reg_no.setFont(new Font("Times New Roman", Font.BOLD, 17));
		reg_no.setEditable(false);
		reg_no.setText("0");
		reg_no.setBounds(155, 104, 116, 22);
		getContentPane().add(reg_no);
		reg_no.setColumns(10);
		
		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Times New Roman", Font.BOLD, 17));
		name.setColumns(10);
		name.setBounds(155, 133, 116, 22);
		getContentPane().add(name);
		
		fname = new JTextField();
		fname.setHorizontalAlignment(SwingConstants.CENTER);
		fname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		fname.setColumns(10);
		fname.setBounds(155, 166, 116, 22);
		getContentPane().add(fname);
		
		gender = new JTextField();
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		gender.setFont(new Font("Times New Roman", Font.BOLD, 17));
		gender.setColumns(10);
		gender.setBounds(155, 195, 116, 22);
		getContentPane().add(gender);
		
		course = new JTextField();
		course.setHorizontalAlignment(SwingConstants.CENTER);
		course.setFont(new Font("Times New Roman", Font.BOLD, 17));
		course.setColumns(10);
		course.setBounds(155, 224, 116, 22);
		getContentPane().add(course);
		
		vf = new JTextField();
		vf.setHorizontalAlignment(SwingConstants.CENTER);
		vf.setFont(new Font("Times New Roman", Font.BOLD, 17));
		vf.setColumns(10);
		vf.setBounds(155, 253, 116, 22);
		getContentPane().add(vf);
		
		ad = new JTextField();
		ad.setHorizontalAlignment(SwingConstants.CENTER);
		ad.setFont(new Font("Times New Roman", Font.BOLD, 17));
		ad.setColumns(10);
		ad.setBounds(155, 282, 261, 36);
		getContentPane().add(ad);
		
		year = new JTextField();
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setFont(new Font("Times New Roman", Font.BOLD, 17));
		year.setColumns(10);
		year.setBounds(387, 224, 116, 22);
		getContentPane().add(year);
		
		vt = new JTextField(validity.toString());
		vt.setHorizontalAlignment(SwingConstants.CENTER);
		vt.setFont(new Font("Times New Roman", Font.BOLD, 17));
		vt.setEditable(false);
		vt.setColumns(10);
		vt.setBounds(387, 252, 116, 22);
		getContentPane().add(vt);
		setSize(735, 378);
		fill_info();
		
		if(!found)
		{
			JOptionPane.showMessageDialog(this, "Id not found");
			dispose();
			return;
		}
		setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	void fill_info(){
		String st="select * from student_info where reg_NO=?";
		Connection con= dbcon1.connect();
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();

			while (rs.next())
			{
				found=true;
				reg_no.setText(rs.getString("Reg_No"));
				name.setText(rs.getString("Name"));
				fname.setText(rs.getString("fathers_name"));
				gender.setText(rs.getString("Gender"));
				course.setText(rs.getString("Course"));
				year.setText(rs.getString("Year"));
				vf.setText(rs.getString("Reg_Date"));
				
				ad.setText(rs.getString("Address"));
				Blob blob=rs.getBlob("Image");
				File tmpFile = new File("E:/Test.jpg");
				FileOutputStream fos = new FileOutputStream(tmpFile);
				fos.write(blob.getBytes(1L, (int)blob.length()) );
				fos.close();
				if(tmpFile.length()>0) {
					ImageIcon ii=new ImageIcon("E:/Test.jpg");
					img.setIcon(ii);
				}
				else {
					img.setText("Image Not Found");
				}
				
			}

		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(IOException se) {
			se.printStackTrace();
		}
	}


public static void main(String[] args) {
	new id_generate(1);
}
}

