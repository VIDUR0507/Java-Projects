package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;

import Registration.Balance;
import Registration.dbconnection2;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.UIManager;


public class FEESUBMISSION extends JDialog implements ActionListener
{
	java.sql.Date REGISTRATION_DATE=new java.sql.Date(new java.util.Date().getTime());

	private JTextField rnum;
	private JTextField balnc;
	private JTextField date;
	private JTextField amt;
	private JButton submit;
	private JButton cancel;
	private JLabel lblRegistrationNo;
	private JLabel lblBalance;
	private JLabel lblRegistrationno;
	private JLabel lblDate;
	private JButton check;
	private JLabel lblReceiptno;
	private JTextField receipt_no;
	int receipt_num;
	double balfee;
	private JLabel lblNewLabel;

	public FEESUBMISSION()
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("FEE_SUBMISSION");
		setModal(true);
		getContentPane().setLayout(null);
		
		lblRegistrationNo = new JLabel("AMOUNT");
		lblRegistrationNo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRegistrationNo.setBounds(10, 222, 119, 14);
		getContentPane().add(lblRegistrationNo);
		
		submit = new JButton("SUBMIT");
		submit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		submit.setBounds(97, 257, 89, 32);
		getContentPane().add(submit);
		
		lblRegistrationno = new JLabel("REGISTRATION_NO");
		lblRegistrationno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRegistrationno.setBounds(10, 44, 119, 14);
		getContentPane().add(lblRegistrationno);
		
		lblBalance = new JLabel("BALANCE");
		lblBalance.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBalance.setBounds(10, 185, 119, 14);
		getContentPane().add(lblBalance);
		
		check = new JButton("CHECK");
		check.setBackground(UIManager.getColor("Button.light"));
		check.setForeground(Color.BLACK);
		check.setFont(new Font("Times New Roman", Font.BOLD, 12));
		check.setBounds(166, 84, 101, 32);
		getContentPane().add(check);
		
		rnum = new JTextField();
		rnum.setColumns(10);
		rnum.setBounds(245, 41, 200, 20);
		getContentPane().add(rnum);
		
		balnc = new JTextField();
		balnc.setColumns(10);
		balnc.setBounds(245, 182, 200, 20);
		getContentPane().add(balnc);
		
		lblDate = new JLabel("DATE");
		lblDate.setBounds(399, 11, 46, 14);
		getContentPane().add(lblDate);
		
		date = new JTextField(REGISTRATION_DATE.toString());
		date.setEditable(false);
		date.setBackground(Color.WHITE);
		date.setBounds(437, 10, 94, 20);
		getContentPane().add(date);
		date.setColumns(10);
		
		amt = new JTextField();
		amt.setColumns(10);
		amt.setBounds(245, 219, 200, 20);
		getContentPane().add(amt);
		
		cancel = new JButton("CANCEL");
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cancel.setBounds(294, 257, 89, 32);
		getContentPane().add(cancel);
		
		lblReceiptno = new JLabel("RECEIPT_NO");
		lblReceiptno.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblReceiptno.setBounds(10, 145, 119, 14);
		getContentPane().add(lblReceiptno);
		
		receipt_no = new JTextField();
		receipt_no.setHorizontalAlignment(SwingConstants.CENTER);
		receipt_no.setText("0");
		receipt_no.setEditable(false);
		receipt_no.setColumns(10);
		receipt_no.setBounds(245, 142, 200, 20);
		getContentPane().add(receipt_no);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(565, 244, 235, 45);
		getContentPane().add(lblNewLabel);
		setModal(true);
		setSize(561,343);
		setLocation(250,200);
		check.addActionListener(this);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		generateReceipt();
		setVisible(true);
		}

	public static void main(String[] args)
	{
	  new FEESUBMISSION();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		if(ob==cancel){
			dispose();
		}
    int reg_id=Integer.parseInt(rnum.getText());
	if(ob==check)
	{
		balfee=Balance.checkBalance(reg_id);
	    balnc.setText(""+balfee);
	}
	else if(ob==submit) {
		double amount=Double.parseDouble(amt.getText());
		System.out.println("Balance Fee: "+balfee);
		System.out.println("For submission: "+amount);
		if(amount>balfee) {
			JOptionPane.showMessageDialog(this, "Invalid amount");
			return;
		}
	Connection con=dbconnection2.connect();
	String st="insert into feedetails(ReceiptNo,ReceiptDate,StudentID,Amount_paid)values(?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(st);
		ps.setInt(1, receipt_num);
		ps.setInt(3, reg_id);
		ps.setDate(2, REGISTRATION_DATE);
		ps.setDouble(4, amount);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(this, "Fee submitted");
		dispose();
	}
	catch(SQLException se){
		se.printStackTrace();
	    }	
	   }
	}
	void generateReceipt() {
		String st="select max(ReceiptNo) from feedetails";
		Connection con=dbconnection2.connect();
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ResultSet rs=ps.executeQuery();
			rs.next();
			receipt_num=rs.getInt(1);
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		 ++receipt_num;
		 receipt_no.setText(String.valueOf(receipt_num)); 
	}
}

