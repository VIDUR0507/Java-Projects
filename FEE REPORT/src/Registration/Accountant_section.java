package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Registration.Student_view;
import Registration.StudentUpdate;
import Registration.Accountant_add;
import Registration.FEESUBMISSION;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Accountant_section extends JDialog implements ActionListener{
	private JButton add;
	private JButton view;
	private JButton checkdue;
	private JButton update;
	private JButton logout;

	public Accountant_section()
	{
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("ACCOUNTANT");
		getContentPane().setLayout(null);
		
		add = new JButton("ADD");
		add.setIcon(new ImageIcon(Accountant_section.class.getResource("/Registration/images/add.jpg")));
		add.setFont(new Font("Times New Roman", Font.BOLD, 18));
		add.setBounds(53, 38, 168, 69);
		getContentPane().add(add);
		
		view = new JButton("VIEW");
		view.setIcon(new ImageIcon(Accountant_section.class.getResource("/Registration/images/images (1).jpg")));
		view.setFont(new Font("Times New Roman", Font.BOLD, 18));
		view.setBounds(358, 38, 176, 69);
		getContentPane().add(view);
		
		update = new JButton("UPDATE");
		update.setIcon(new ImageIcon(Accountant_section.class.getResource("/Registration/images/5.jpg")));
		update.setFont(new Font("Times New Roman", Font.BOLD, 18));
		update.setBounds(348, 175, 201, 60);
		getContentPane().add(update);
		
		checkdue = new JButton("CHECK_DUE");
		checkdue.setIcon(new ImageIcon(Accountant_section.class.getResource("/Registration/images/500_F_186480720_r7UgjLU0byLPg4lDsD6kKyrtEJHCYl1G.jpg")));
		checkdue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		checkdue.setFont(new Font("Times New Roman", Font.BOLD, 18));
		checkdue.setBounds(32, 178, 216, 54);
		getContentPane().add(checkdue);
		
		logout = new JButton("LOGOUT");
		logout.setIcon(new ImageIcon(Accountant_section.class.getResource("/Registration/images/download (1).jpg")));
		logout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		logout.setBounds(198, 266, 176, 54);
		getContentPane().add(logout);
		setSize(625, 382);
        add.addActionListener(this);
		view.addActionListener(this);
		checkdue.addActionListener(this);
		update.addActionListener(this);
		logout.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args)
	{
	 new Accountant_section();	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object ob=e.getSource();
		if(ob==add)
		{
		 new newstudent();	
		}	
		
		if(ob==view) 
		{
			String st=JOptionPane.showInputDialog(this, "reg_id ?");
			try 
			{
				int re=Integer.parseInt(st);
				new Student_view();
				
		    }
			catch(NullPointerException|NumberFormatException nf)
			{
				nf.printStackTrace();
				System.out.println(nf.getMessage());
			}
			
		}
		
		if(ob==checkdue)
		{
			new FEESUBMISSION();
		}
		
		if(ob==update)
		{
			String st=JOptionPane.showInputDialog(this, "reg_id ?");
			try {
				int re=Integer.parseInt(st);
				new StudentUpdate(re);
				
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

		}
