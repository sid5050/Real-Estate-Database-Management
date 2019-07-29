package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.SystemColor;
public class Loginpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);//450,300
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Loginpage lg  = new Loginpage();
				Adminlogin al = new Adminlogin();
				al.setVisible(true);
				//lg.setVisible(false);
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdmin.setBackground(new Color(51, 255, 255));
		btnAdmin.setForeground(new Color(0, 0, 0));
		btnAdmin.setBounds(31, 366, 90, 34);
		contentPane.add(btnAdmin);
		
		JLabel lblRealEstateManagment = new JLabel("REAL ESTATE MANAGMENT PORTAL");
		lblRealEstateManagment.setBackground(new Color(255, 255, 255));
		lblRealEstateManagment.setForeground(Color.RED);
		lblRealEstateManagment.setFont(new Font("Verdana", Font.BOLD, 15));
		lblRealEstateManagment.setBounds(81, 30, 338, 50);
		contentPane.add(lblRealEstateManagment);
		
		JLabel lblLoginPage = new JLabel("  LOGIN PAGE");
		lblLoginPage.setForeground(new Color(255, 255, 51));
		lblLoginPage.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		lblLoginPage.setBounds(178, 79, 167, 44);
		contentPane.add(lblLoginPage);
		
		JButton btnUser = new JButton("SELLER");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellIntro s1 = new SellIntro();
				s1.setVisible(true);
			}
		});
		btnUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUser.setBackground(new Color(0, 255, 255));
		btnUser.setBounds(201, 366, 102, 34);
		contentPane.add(btnUser);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusIntro1 c1 = new CusIntro1();
				c1.setVisible(true);
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCustomer.setBackground(Color.CYAN);
		btnCustomer.setBounds(357, 366, 102, 34);
		contentPane.add(btnCustomer);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/realestate.gif")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(52, 134, 367, 221);
		contentPane.add(label);
	}
}
