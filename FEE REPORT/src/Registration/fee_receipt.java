package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class fee_receipt extends JDialog implements ActionListener{
	private JTextField reg_no;
	private JTextField name;
	private JTextField course;
	private JTextField rno;
	private JTextField amt;
	private JTextField rdate;
	int id;
	boolean found;
	private JPanel panel;
	public fee_receipt(int id) {
		getContentPane().setLayout(null);
		this.id=id;
		
		JLabel lblFeeReceipt = new JLabel("FEE RECEIPT");
		lblFeeReceipt.setBounds(274, 13, 89, 16);
		getContentPane().add(lblFeeReceipt);
		
		JLabel lblRegid = new JLabel("REG_ID");
		lblRegid.setBounds(33, 48, 56, 16);
		getContentPane().add(lblRegid);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(33, 85, 56, 16);
		getContentPane().add(lblName);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setBounds(33, 143, 83, 16);
		getContentPane().add(lblCourse);
		
		JLabel lblDate = new JLabel("ReceiptNo");
		lblDate.setBounds(389, 48, 83, 16);
		getContentPane().add(lblDate);
		
		JLabel lblReceiptdate = new JLabel("ReceiptDate");
		lblReceiptdate.setBounds(475, 13, 89, 16);
		getContentPane().add(lblReceiptdate);
		
		JLabel lblAmount = new JLabel("Amount_Paid");
		lblAmount.setBounds(389, 85, 56, 16);
		getContentPane().add(lblAmount);
		
		reg_no = new JTextField();
		reg_no.setBackground(Color.WHITE);
		reg_no.setEditable(false);
		reg_no.setBounds(141, 45, 116, 22);
		getContentPane().add(reg_no);
		reg_no.setColumns(10);
		
		name = new JTextField();
		name.setBackground(Color.WHITE);
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(141, 85, 116, 22);
		getContentPane().add(name);
		
		course = new JTextField();
		course.setBackground(Color.WHITE);
		course.setEditable(false);
		course.setColumns(10);
		course.setBounds(141, 140, 116, 22);
		getContentPane().add(course);
		
		rno = new JTextField();
		rno.setBackground(Color.WHITE);
		rno.setEditable(false);
		rno.setColumns(10);
		rno.setBounds(501, 45, 116, 22);
		getContentPane().add(rno);
		
		amt = new JTextField();
		amt.setBackground(Color.WHITE);
		amt.setEditable(false);
		amt.setColumns(10);
		amt.setBounds(501, 82, 116, 22);
		getContentPane().add(amt);
		
		rdate = new JTextField();
		rdate.setBackground(Color.WHITE);
		rdate.setEditable(false);
		rdate.setColumns(10);
		rdate.setBounds(597, 10, 116, 22);
		getContentPane().add(rdate);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setLayout(null);
		panel.setBounds(33, 194, 655, 385);
		getContentPane().add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 54, 655, 16);
		panel.add(separator);
		setSize(743, 658);
		fill_info();
		setVisible(true);
	
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	void fill_info(){
		String st="select * from student where reg_id=?";
		Connection con= dbconnection2.connect();
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				reg_no.setText(rs.getString("reg_id"));
				rdate.setText(rs.getString("reg_date"));
				course.setText(rs.getString("course"));
				name.setText(rs.getString("name"));
			}
			st="select * from feedetails where reg_id=?";
			ps=con.prepareStatement(st);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				rno.setText(rs.getString("Receiptno"));
				rdate.setText(rs.getString("ReceiptDate"));
				amt.setText(rs.getString("Amount_Paid"));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	public static void main(String ar[]) {
		new fee_receipt(1);
	}
	
}
