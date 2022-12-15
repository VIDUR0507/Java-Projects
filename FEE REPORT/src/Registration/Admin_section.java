package Registration;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Registration.Accountant_view;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Admin_section extends JDialog implements ActionListener {
	private JButton add;
	private JButton view;
	private JButton del;
	private JButton logout;

	public Admin_section() 
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin_section.class.getResource("/Registration/images/black-lamborghini-wallpaper-1680x1050-0022.jpg")));
		setTitle("ADMIN");
		getContentPane().setLayout(null);
		
		add = new JButton("ADD_ACCOUNTANT");
		add.setIcon(new ImageIcon(Admin_section.class.getResource("/Registration/images/add.jpg")));
		add.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add.setBounds(104, 11, 334, 70);
		getContentPane().add(add);
		
		view = new JButton("VIEW");
		view.setIcon(new ImageIcon(Admin_section.class.getResource("/Registration/images/images (1).jpg")));
		view.setFont(new Font("Times New Roman", Font.BOLD, 18));
		view.setBounds(45, 126, 157, 70);
		getContentPane().add(view);
		
		del = new JButton("DELETE");
		del.setIcon(new ImageIcon(Admin_section.class.getResource("/Registration/images/66630585-x-close-icon-x-close-website-button-on-white-background-.jpg")));
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		del.setFont(new Font("Times New Roman", Font.BOLD, 18));
		del.setBounds(331, 126, 170, 70);
		getContentPane().add(del);
		
		logout = new JButton("LOGOUT");
		logout.setIcon(new ImageIcon(Admin_section.class.getResource("/Registration/images/download (1).jpg")));
		logout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		logout.setBounds(155, 220, 197, 52);
		getContentPane().add(logout);
		setSize(566, 328);
		logout.addActionListener(this);
		add.addActionListener(this);
		view.addActionListener(this);
		del.addActionListener(this);
         setVisible(true);
	}

	public static void main(String[] args)
	{
		new Admin_section();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
	if(ob==add)
	{
		 new Accountant_add();
		 
	}
	if(ob==view)
	{ 
		new Accountant_view();
		
	}
	if(ob==del) 
	{
		String st=JOptionPane.showInputDialog(this, "id ?");
		try{
			int re=Integer.parseInt(st);
			delete(re);
		   }
		catch(NullPointerException|NumberFormatException nf)
		{
			nf.printStackTrace();
			System.out.println(nf.getMessage());
		}	

	}
	if(ob==logout) 
	{
		System.exit(0);	
	}
		
}

	void delete(int x)
	{
		String st="delete from accountant where a_id=?";
		Connection con=dbconnection2.connect();
		try {
			PreparedStatement ps=con.prepareStatement(st);
			ps.setInt(1, x);
			int aa=JOptionPane.showConfirmDialog(this, "delete");
			if(aa==0) {
			int w=ps.executeUpdate();
			if(w>0)
				JOptionPane.showMessageDialog(this, "deleted");
			else
				JOptionPane.showMessageDialog(this, "Id not Found");
		}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
	}

		
	}


