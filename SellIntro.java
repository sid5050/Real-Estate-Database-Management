package dbsproject;
/*
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SellIntro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellIntro frame = new SellIntro();
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
	/*public SellIntro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}*/





//package Firstdraft.commons;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SellIntro extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellIntro frame = new SellIntro();
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
	public SellIntro() {
		setTitle("Seller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterDetailsTo = new JLabel("Enter Details to Register new Property!");
		lblEnterDetailsTo.setBounds(10, 11, 301, 23);
		lblEnterDetailsTo.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		contentPane.add(lblEnterDetailsTo);
		
		JComboBox typebox = new JComboBox();
		typebox.setBounds(10, 95, 171, 23);
		typebox.addItem("Industry");
		typebox.addItem("Agriculture");
		typebox.addItem("Office");
		typebox.addItem("flat");
		typebox.addItem("Bunglow");
		contentPane.add(typebox);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 35, 46, 14);
		contentPane.add(label);
		
		JLabel lblPropertyType = new JLabel("Property type:");
		lblPropertyType.setBounds(10, 70, 79, 14);
		contentPane.add(lblPropertyType);
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=(String)typebox.getSelectedItem();
				//Integer price=Integer.parseInt(Pricetext.getText());
				//Integer area=Integer.parseInt(areatext.getText());
				//Integer pin=Integer.parseInt(pincode.getText());
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
			        PreparedStatement stmt  = con.prepareStatement("insert into purchase_request values(?,?,?,?)");
			        if (type.equals("Industry")) {
			        	
			        	Indusdetails idd = new Indusdetails();
			        	idd.setVisible(true);
			        	
			        };
			        if (type.equals("Office")) {
			        	Officedetail od = new Officedetail();
			        	od.setVisible(true);
			        };
			        if (type.equals("Agriculture")) {
			        	Agridetail agd = new Agridetail();
			        	agd.setVisible(true);
			        };
			        if (type.equals("flat")) {
			        	Flatdetail fd = new Flatdetail();
			        	fd.setVisible(true);
			        };
			        if (type.equals("Bunglow")) {
			        	Bunglowdetail bd = new Bunglowdetail();
			        	bd.setVisible(true);
			        };
			        stmt.executeUpdate();
			        con.close();
					}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
		});
		btnProceed.setBounds(46, 150, 89, 23);
		contentPane.add(btnProceed);
		
		JLabel lblEnterYourSeller = new JLabel("ENTER YOUR SELLER ID");
		lblEnterYourSeller.setBounds(272, 69, 198, 14);
		lblEnterYourSeller.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblEnterYourSeller.setForeground(Color.WHITE);
		contentPane.add(lblEnterYourSeller);
		
		textField_2 = new JTextField();
		textField_2.setBounds(272, 95, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnViewPurchaseRequests = new JButton("VIEW PURCHASE REQUESTS");
		btnViewPurchaseRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "siddh123");			
			        // step3 create the statement object			
			        PreparedStatement stmt = con.prepareStatement("SELECT * FROM purchase_request p1 natural join property p2 where sell_id = ?");			
			        // step4 execute query					        
			       
			        //System.out.println("connected");
			        String s1 = textField_2.getText();
			        Integer purc = Integer.parseInt(s1);
			        stmt.setInt(1,purc);
			        ResultSet rs = stmt.executeQuery();
			        table.setModel(DbUtils.resultSetToTableModel(rs));
			        
			        /*while (rs.next())
			        {		
			        	lblDetails.setText(lblDetails.getText() + " " + rs.getInt(1) + "  " + rs.getString(2));
			        }*/
			        // step5 close the connection object			
			        con.close();			
			    } catch (SQLException ex) {
	
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
	    }
			
		});
		btnViewPurchaseRequests.setBounds(272, 134, 183, 29);
		contentPane.add(btnViewPurchaseRequests);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(191, 174, 323, 210);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SellIntro.class.getResource("/dbsproject/138422822.jpg")));
		label_1.setBounds(0, 0, 546, 418);
		contentPane.add(label_1);
	}
}

