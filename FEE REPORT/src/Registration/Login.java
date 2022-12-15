package Registration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import Registration.Login;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Login extends JDialog implements ActionListener{
	private JButton accountant;
	private JButton admin;

	public Login() 
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 11));
		setTitle("LOGIN");
		setSize(500, 304);
		getContentPane().setLayout(null);
		
		admin = new JButton("ADMIN_LOGIN");
		admin.setHorizontalAlignment(SwingConstants.LEFT);
		admin.setIcon(new ImageIcon(Login.class.getResource("/Registration/images/admin.png")));
		admin.setBackground(UIManager.getColor("Button.light"));
		admin.setForeground(new Color(0, 0, 0));
		admin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		admin.setBounds(106, 36, 271, 75);
		getContentPane().add(admin);
		
		accountant = new JButton("ACCOUNTANT_LOGIN");
		accountant.setHorizontalAlignment(SwingConstants.LEFT);
		accountant.setIcon(new ImageIcon(Login.class.getResource("/Registration/images/accountant.png")));
		accountant.setBackground(UIManager.getColor("Button.light"));
		accountant.setForeground(Color.BLACK);
		accountant.setFont(new Font("Times New Roman", Font.BOLD, 16));
		accountant.setBounds(106, 149, 271, 75);
		getContentPane().add(accountant);
		admin.addActionListener(this);
		accountant.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new Login();
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object ob=e.getSource();
		if(ob==admin)
		{
			new Admin();
		}
		if(ob==accountant){
			new Accountant();
			
			}
		}
}
