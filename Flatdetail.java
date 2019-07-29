package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Flatdetail extends JFrame {

	private JPanel contentPane;
	//private JPanel contentPane;
	private JTextField pincode;
	private JTextField areatext;
	private JTextField Pricetext;
	private JTextField sellidtext;
	private JTextField bhktext;
	private JTextField pspace;
	private JTextField balcony;
	private JTextField Floor;
	private JButton btnAdd;
	private JButton btnBack;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flatdetail frame = new Flatdetail();
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
	public Flatdetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Zipcode");
		lblNewLabel.setBounds(10, 23, 52, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblArea = new JLabel("area");
		lblArea.setBounds(10, 48, 46, 14);
		contentPane.add(lblArea);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 73, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblSellerId = new JLabel("Seller ID");
		lblSellerId.setBounds(10, 98, 46, 14);
		contentPane.add(lblSellerId);
		
		JLabel lblBhk = new JLabel("BHK");
		lblBhk.setBounds(10, 164, 46, 14);
		contentPane.add(lblBhk);
		
		JLabel lblParkingSpace = new JLabel("Parking space");
		lblParkingSpace.setBounds(217, 164, 92, 14);
		contentPane.add(lblParkingSpace);
		
		JLabel lblLawn = new JLabel("BALCONY");
		lblLawn.setBounds(10, 198, 46, 14);
		contentPane.add(lblLawn);
		
		JLabel lblStorey = new JLabel("Floor");
		lblStorey.setBounds(10, 236, 46, 14);
		contentPane.add(lblStorey);
		
		pincode = new JTextField();
		pincode.setBounds(66, 20, 86, 20);
		contentPane.add(pincode);
		pincode.setColumns(10);
		
		areatext = new JTextField();
		areatext.setBounds(66, 45, 86, 20);
		contentPane.add(areatext);
		areatext.setColumns(10);
		
		Pricetext = new JTextField();
		Pricetext.setBounds(66, 70, 86, 20);
		contentPane.add(Pricetext);
		Pricetext.setColumns(10);
		
		sellidtext = new JTextField();
		sellidtext.setBounds(66, 95, 86, 20);
		contentPane.add(sellidtext);
		sellidtext.setColumns(10);
		
		bhktext = new JTextField();
		bhktext.setBounds(66, 161, 86, 20);
		contentPane.add(bhktext);
		bhktext.setColumns(10);
		
		pspace = new JTextField();
		pspace.setBounds(319, 161, 86, 20);
		contentPane.add(pspace);
		pspace.setColumns(10);
		
		balcony = new JTextField();
		balcony.setBounds(66, 195, 86, 20);
		contentPane.add(balcony);
		balcony.setColumns(10);
		
		Floor = new JTextField();
		Floor.setBounds(66, 233, 86, 20);
		contentPane.add(Floor);
		Floor.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Integer price=Integer.parseInt(Pricetext.getText());
				Integer area=Integer.parseInt(areatext.getText());
				Integer pin=Integer.parseInt(pincode.getText());
				Integer sell=Integer.parseInt(sellidtext.getText());
				Integer bhk=Integer.parseInt(bhktext.getText());
				Integer papace=Integer.parseInt(pspace.getText());
				//String lan=balcony.getText();
				Integer stor=Integer.parseInt(Floor.getText());
				Integer lan=Integer.parseInt(balcony.getText());
				JOptionPane.showMessageDialog(contentPane, "Successfully Added!!");
				Flatdetail ap4 = new Flatdetail();
				ap4.setVisible(true);
				
				try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
			        PreparedStatement stmt  = con.prepareStatement("call flatproc(?,?,?,?,?,?,?,?)");
			        //PreparedStatement stmt1  = con.prepareStatement("insert into Residential values(?,?,?)");
			        //PreparedStatement stmt2  = con.prepareStatement("insert into Bunglow values(?,?,?)");
			        //k = k+1;
			        //propnumber = propnumber+1;
			       // propid.setval(14);
			       // int n=propid.getval();
			       // n++;
			       // propid.setval(n);
			        //System.out.println(n);
			        //int num=n;
			        //stmt.setInt(1,sell);
			        stmt.setInt(1,sell);
			        stmt.setInt(2, pin);
			        stmt.setInt(3, price);
			        stmt.setInt(4, area);
			        stmt.setInt(5, bhk);
			        stmt.setInt(6, papace);
			        stmt.setInt(7, lan);
			        stmt.setInt(8, stor);
			       //stmt1.setInt(1, num);
			      //stmt1.setInt(2, bhk);
			      //stmt1.setInt(3,papace );
			      
			        
			       //stmt2.setInt(1,num);
			        //stmt2.setString(2,lan);
			        //stmt2.setInt(3, stor);
			        stmt.executeUpdate();
			        //stmt1.executeUpdate();
			        //stmt2.executeUpdate();
			        con.close();
					}
					catch (SQLException ex) {
						
				        System.out.println(ex);
		
				    }catch (ClassNotFoundException ex) {
		
				        System.out.println(ex);			
				    }
			}
				
				
				
			
		});
		btnAdd.setBounds(191, 232, 89, 23);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellIntro s1 = new SellIntro();
				s1.setVisible(true);
			
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(319, 232, 89, 23);
		contentPane.add(btnBack);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Flatdetail.class.getResource("/dbsproject/financial-center-skyscraper-faded-digital-illustration-tall-modern-building-view-below-cloudy-sky-above-86645204.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
	}


