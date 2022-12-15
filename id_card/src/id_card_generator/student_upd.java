package id_card_generator;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
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

public class student_upd extends JDialog implements ActionListener{
	int id;
	boolean found;
	private JTextField name;
	private JTextField fname;
	private JTextField mob;
	private JButton can;
	private JButton upd;
	private JRadioButton rm;
	private JRadioButton rf;
	private JLabel lblCourse;

	private JComboBox course;
	private JTextArea ad;
	private JComboBox comboBox;
	private JLabel lblYear;
	private JComboBox year;
	private JLabel photo;
	Webcam webcam;
	Dimension [] nonStandardResolutions;
	InputStream img;

	public student_upd(int id) {
		setTitle("UPDATE INFO");
		this.id=id;

		JLabel lblAddNewStudent = new JLabel("UPDATE STUDENT");
		lblAddNewStudent.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAddNewStudent.setBounds(39, 13, 281, 46);
		getContentPane().add(lblAddNewStudent);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblName.setBounds(39, 86, 135, 46);
		getContentPane().add(lblName);

		JLabel lblFathersname = new JLabel("Fathers_Name");
		lblFathersname.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblFathersname.setBounds(39, 202, 135, 46);
		getContentPane().add(lblFathersname);

		JLabel lblMobileno = new JLabel("Mobile_NO");
		lblMobileno.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblMobileno.setBounds(39, 328, 135, 46);
		getContentPane().add(lblMobileno);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblAddress.setBounds(39, 398, 135, 46);
		getContentPane().add(lblAddress);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblGender.setBounds(39, 145, 135, 46);
		getContentPane().add(lblGender);

		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		name.setColumns(10);
		name.setBounds(204, 99, 116, 22);
		getContentPane().add(name);

		fname = new JTextField();
		fname.setHorizontalAlignment(SwingConstants.CENTER);
		fname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		fname.setColumns(10);
		fname.setBounds(204, 215, 116, 22);
		getContentPane().add(fname);

		mob = new JTextField();
		mob.setHorizontalAlignment(SwingConstants.CENTER);
		mob.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mob.setColumns(10);
		mob.setBounds(204, 341, 116, 22);
		getContentPane().add(mob);

		ad = new JTextArea();
		ad.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		ad.setBounds(204, 413, 116, 105);
		getContentPane().add(ad);

		rm = new JRadioButton("Male");
		rm.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rm.setBounds(193, 153, 82, 32);
		getContentPane().add(rm);

		rf = new JRadioButton("Female");
		rf.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rf.setBounds(279, 153, 82, 32);
		getContentPane().add(rf);

		JButton sel = new JButton("Select_image");
		sel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getimage();
			}
		});
		sel.setBounds(587, 280, 135, 25);
		getContentPane().add(sel);

		upd = new JButton("UPDATE");
		upd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		upd.setBounds(574, 412, 148, 32);
		getContentPane().add(upd);

		can = new JButton("CANCEL");
		can.setFont(new Font("Times New Roman", Font.BOLD, 20));
		can.setBounds(574, 486, 148, 32);
		getContentPane().add(can);

		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblCourse.setBounds(39, 261, 135, 46);
		getContentPane().add(lblCourse);

		course = new JComboBox();
		course.setModel(new DefaultComboBoxModel(new String[] {"", "BCA", "BBA", "BSc", "ARTS"}));
		course.setBounds(203, 276, 72, 22);
		getContentPane().add(course);




		lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblYear.setBounds(301, 266, 60, 46);
		getContentPane().add(lblYear);

		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		year.setBounds(370, 276, 72, 22);
		getContentPane().add(year);
		getContentPane().setLayout(null);
		
		photo = new JLabel("");
		photo.setBounds(574, 88, 174, 149);
		getContentPane().add(photo);
		setSize(826, 639);
		fill_info();
		upd.addActionListener(this);
		can.addActionListener(this);
		
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
		Object ob=e.getSource();
		if(ob==can){
			dispose();
		}
		if(ob==upd){
			String Name=name.getText();
			
			
			String Fathers_Name=fname.getText();
			String Course=course.getSelectedItem().toString();
			String Year=year.getSelectedItem().toString();
			String Mobile_no=mob.getText();
			String Address=ad.getText();
			String st="update student_info set Course=?,Year=?,Address=?,mobile_no=?,Image=? where reg_NO=?";
			Connection con=dbcon1.connect();
			try {
				img=new FileInputStream(new File("E:/Test.jpg"));
				PreparedStatement ps=con.prepareStatement(st);
				ps.setString(1, Course);
				ps.setString(2, Year);
				ps.setString(3, Address);
				ps.setString(4, Mobile_no);
				ps.setBinaryStream(5, img);
				ps.setInt(6, id);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this, "updated");
				dispose();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(IOException se){
				se.printStackTrace();
			}

		}
	}
	void getimage() {
		webcam = webcam.getDefault();
		webcam.setCustomViewSizes(new Dimension(176,144));
		webcam.setViewSize(new Dimension(176,144));
		webcam.open();
		
		BufferedImage image = webcam.getImage();
		webcam.close();
		try {
			 
			File f=new File("E:/Test1.jpg");
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
				name.setText(rs.getString("Name"));
				fname.setText(rs.getString("fathers_name"));
				course.setSelectedItem(rs.getString("Course"));
				year.setSelectedItem(rs.getString("Year"));
				ad.setText(rs.getString("Address"));
				mob.setText(rs.getString("Mobile_no"));
				Blob blob=rs.getBlob("Image");
				File tmpFile = new File("E:/Test.jpg");
				FileOutputStream fos = new FileOutputStream(tmpFile);
				fos.write(blob.getBytes(1L, (int)blob.length()) );
				fos.close();
				if(tmpFile.length()>0) {
					ImageIcon ii=new ImageIcon("E:/Test.jpg");
					photo.setIcon(ii);
				}
				else {
					photo.setText("Image Not Found");
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

	public static void main(String ar[]) {
		new student_upd(1);

	}
}



