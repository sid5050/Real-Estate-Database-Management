package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Adminp1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminp1 frame = new Adminp1();
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
	public Adminp1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewCustomer = new JButton("VIEW CUSTOMER");
		btnViewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCus vc = new ViewCus();
				vc.setVisible(true);
			}
		});
		btnViewCustomer.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnViewCustomer.setBounds(75, 42, 101, 24);
		contentPane.add(btnViewCustomer);
		
		JButton btnViewBuyer = new JButton("VIEW SELLER");
		btnViewBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSel vs = new ViewSel();
				vs.setVisible(true);
			}
		});
		btnViewBuyer.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnViewBuyer.setBounds(75, 108, 101, 24);
		contentPane.add(btnViewBuyer);
		
		JButton btnViewProperty = new JButton("VIEW PROPERTY");
		btnViewProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProp vp = new ViewProp();
				vp.setVisible(true);
			}
		});
		btnViewProperty.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnViewProperty.setBounds(75, 186, 101, 23);
		contentPane.add(btnViewProperty);
		
		JButton btnViewTransaction = new JButton("ADD TRANSACTION");
		btnViewTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTransac at = new AddTransac();
				at.setVisible(true);
			}
		});
		btnViewTransaction.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnViewTransaction.setBounds(329, 186, 122, 23);
		contentPane.add(btnViewTransaction);
		
		JButton btnAddCustomer = new JButton("ADD CUSTOMER");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCus ac = new AddCus();
				ac.setVisible(true);
			}
		});
		btnAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnAddCustomer.setBounds(329, 43, 101, 23);
		contentPane.add(btnAddCustomer);
		
		JButton btnAddSeller = new JButton("ADD SELLER");
		btnAddSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSel as = new AddSel();
				as.setVisible(true);
			}
		});
		btnAddSeller.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAddSeller.setBounds(329, 108, 101, 23);
		contentPane.add(btnAddSeller);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginpage lp1 = new Loginpage();
				lp1.setVisible(true);
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMainMenu.setBounds(188, 331, 101, 23);
		contentPane.add(btnMainMenu);
	}

}
