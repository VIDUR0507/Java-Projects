package id_card_generator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Home extends JFrame implements ActionListener{
	private JMenuItem ex;
	private JMenuItem id_gen;
	private JMenuItem update;
	private JMenuItem add;

	public Home() {
		getContentPane().setLayout(null);
		setSize(740, 516);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStudent = new JMenu("Student");
		mnStudent.setFont(new Font("Times New Roman", Font.BOLD, 19));
		menuBar.add(mnStudent);
		
		add = new JMenuItem("Add");
		add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		add.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mnStudent.add(add);
		
		update = new JMenuItem("Update");
		update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		update.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mnStudent.add(update);
		
		id_gen = new JMenuItem("Generate_id");
		id_gen.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mnStudent.add(id_gen);
		
		ex = new JMenuItem("Exit");
		ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		ex.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		mnStudent.add(ex);
		
		add.addActionListener(this);
		update.addActionListener(this);
		id_gen.addActionListener(this);
		ex.addActionListener(this);
		setVisible(true);
	
	}

	public static void main(String[] args) {
		new Home();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==add){
			new studentadd();
		}
		if(ob==update) {
			String st=JOptionPane.showInputDialog(this, "reg_No ?");
			try {
				int re=Integer.parseInt(st);
				new student_upd(re);
			}
			catch(NullPointerException|NumberFormatException nf)
			{
				nf.printStackTrace();
				System.out.println(nf.getMessage());
			}
		
	}
	
		if(ob==id_gen){
			String st=JOptionPane.showInputDialog(this, "reg_No ?");
			try {
				int re=Integer.parseInt(st);
				new id_generate(re);
			}
			catch(NullPointerException|NumberFormatException nf)
			{
				nf.printStackTrace();
				System.out.println(nf.getMessage());
			}
			
		}
		if(ob==ex) {
			dispose();
		}
		}
		
	}

