package dbsproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

public class CusIntro1 extends JFrame {

	int req=10;
	
	private JPanel frmRetail;
	private Container buttonGroup;
	private JTable table;
	private JTextField textField;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusIntro1 frame = new CusIntro1();
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
	
	public CusIntro1() {
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 457);
		frmRetail = new JPanel();
		frmRetail.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frmRetail);
		frmRetail.setLayout(null);
		//frmRetail.setForeground(Color.PINK);
		//frmRetail.setBackground(Color.PINK);
		//frmRetail.setBounds(100, 100, 799, 457);
		//frmRetail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frmRetail.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("    Welcome ,Search for your desired property!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(45, 1, 287, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("MAX. PRICE");
		lblPrice.setBounds(5, 78, 87, 20);
		getContentPane().add(lblPrice);
		
		JTextField maxtext = new JTextField();
		maxtext.setBounds(86, 78, 86, 20);
		getContentPane().add(maxtext);
		maxtext.setColumns(10);
		
		JLabel lblCity = new JLabel("CIty");
		lblCity.setBounds(15, 112, 28, 14);
		getContentPane().add(lblCity);
		
		JTextField citytext = new JTextField();
		citytext.setBounds(86, 109, 86, 20);
		getContentPane().add(citytext);
		citytext.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(15, 157, 34, 14);
		getContentPane().add(lblType);
		
		JLabel label = new JLabel("");
		label.setBounds(177, 157, 46, 14);
		getContentPane().add(label);
		
		JRadioButton rdbres = new JRadioButton("Residential");
		rdbres.setBounds(98, 153, 109, 23);
		buttonGroup_1.add(rdbres);
		getContentPane().add(rdbres);
		
		JRadioButton rdbcom = new JRadioButton("Commercial");
		rdbcom.setBounds(98, 178, 109, 23);
		buttonGroup_1.add(rdbcom);
		getContentPane().add(rdbcom);
		
		JRadioButton rdbagr = new JRadioButton("Agricultural");
		rdbagr.setBounds(98, 205, 109, 23);
		buttonGroup_1.add(rdbagr);
		getContentPane().add(rdbagr);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(22, 260, 97, 35);
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String city= citytext.getText();
				String highprice=maxtext.getText();
				Boolean res,agr,com;
				res=rdbres.isSelected();
				com=rdbcom.isSelected();
				Integer pri=Integer.parseInt(highprice);
				
				
				//off=rdboff.isSelected();
				agr=rdbagr.isSelected();
				  try {
						
				        // step1 load the driver class			
				        Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");			
				        // step3 create the statement object
				        if (res) {
				        PreparedStatement stmt = con.prepareStatement("SELECT prop_id,sell_id,price,area,parkingspace,bhk from Property natural join residential "
				        		+ "where price<? and zipcode in (select zipcode from location where city=?) ");			
				        // step4 execute query	
				       // if (res) {
				      /*  ResultSet rs = stmt.executeQuery("SELECT prop_id,sell_id,price,area,parkingspace,bhk from Property natural join residential "
				        		+ "S"
				        		+ "where price<? and S.zipcode in (select zipcode from location where city=? ");
				        }
				       // while (rs.next())
				       // {		
				       // 	lblDetails.setText(lblDetails.getText() + " " + rs.getInt(1) + "  " + rs.getString(2));
				       // }
				        // step5 close the connection object	*/	
				        stmt.setInt(1, pri);
				        stmt.setString(2,city );
				        ResultSet rs=stmt.executeQuery();
				        table.setModel(DbUtils.resultSetToTableModel(rs));
				        con.close();
				        }
				        
				        if (com) {
					        PreparedStatement stmt = con.prepareStatement("SELECT prop_id,sell_id,price,area,status from Property natural join Commercial "
					        		+ "where price<? and zipcode in (select zipcode from location where city=?) ");			
					        // step4 execute query	
					       // if (res) {
					      /*  ResultSet rs = stmt.executeQuery("SELECT prop_id,sell_id,price,area,parkingspace,bhk from Property natural join residential "
					        		+ "S"
					        		+ "where price<? and S.zipcode in (select zipcode from location where city=? ");
					        }
					       // while (rs.next())
					       // {		
					       // 	lblDetails.setText(lblDetails.getText() + " " + rs.getInt(1) + "  " + rs.getString(2));
					       // }
					        // step5 close the connection object	*/	
					        stmt.setInt(1, pri);
					        stmt.setString(2,city );
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        
				        
				        if (agr) {
					        PreparedStatement stmt = con.prepareStatement("SELECT prop_id,sell_id,price,area,soiltype from Property natural join Agriculture "
					        		+ "where price<? and zipcode in (select zipcode from location where city=?) ");			
					        // step4 execute query	
					       // if (res) {
					      /*  ResultSet rs = stmt.executeQuery("SELECT prop_id,sell_id,price,area,parkingspace,bhk from Property natural join residential "
					        		+ "S"
					        		+ "where price<? and S.zipcode in (select zipcode from location where city=? ");
					        }
					       // while (rs.next())
					       // {		
					       // 	lblDetails.setText(lblDetails.getText() + " " + rs.getInt(1) + "  " + rs.getString(2));
					       // }
					        // step5 close the connection object	*/	
					        stmt.setInt(1, pri);
					        stmt.setString(2,city );
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        
				   }
				        catch (SQLException ex) {
		
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
		    
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(371, 11, 380, 180);
		panel.setBorder(new TitledBorder(null, "title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase Request");
		lblNewLabel_1.setBounds(124, 0, 143, 47);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		panel.add(lblNewLabel_1);
		
		JLabel lblPropertyId = new JLabel("PROPERTY ID");
		lblPropertyId.setBounds(19, 68, 89, 14);
		panel.add(lblPropertyId);
		
		JTextField proidtext = new JTextField();
		proidtext.setBounds(134, 65, 115, 20);
		panel.add(proidtext);
		proidtext.setColumns(10);
		
		
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID");
		lblCustomerId.setBounds(19, 104, 97, 14);
		panel.add(lblCustomerId);
		
		JTextField custidtext = new JTextField();
		custidtext.setBounds(135, 96, 132, 20);
		panel.add(custidtext);
		custidtext.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(132, 133, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Buy/Rent");
		lblNewLabel_2.setBounds(19, 129, 75, 20);
		panel.add(lblNewLabel_2);
		
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");			
		        // step2 create the connection object			
		        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
		        PreparedStatement stmt  = con.prepareStatement("insert into purchase_request values(?,?,?,?)");
		        
		        Integer purc = Integer.parseInt(proidtext.getText());
		        Integer cust = Integer.parseInt(custidtext.getText());
		        req++;
		        String typ = textField.getText();
		        stmt.setInt(1, req);
		        stmt.setInt(2, cust);
		        stmt.setInt(3, purc);
		        stmt.setString(4, typ);
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
		btnConfirm.setBounds(278, 146, 89, 23);
		panel.add(btnConfirm);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CusIntro1.class.getResource("/dbsproject/get-money.png")));
		label_1.setBounds(0, 11, 400, 158);
		panel.add(label_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 208, 561, 199);
		frmRetail.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnViewDetails = new JButton("VIEW DETAILS ");
		btnViewDetails.setBounds(10, 327, 109, 23);
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewpropdetail od = new viewpropdetail();
	        	od.setVisible(true);
			}
		});
		frmRetail.add(btnViewDetails);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loginpage lg = new Loginpage();
				lg.setVisible(true);
			}
		});
		btnBack.setBounds(15, 384, 89, 23);
		frmRetail.add(btnBack);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CusIntro1.class.getResource("/dbsproject/photo-1513584684374-8bab748fbf90.jpg")));
		label_2.setBounds(0, 0, 784, 407);
		frmRetail.add(label_2);

	}
}
