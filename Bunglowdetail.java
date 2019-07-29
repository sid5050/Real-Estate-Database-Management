package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Bunglowdetail extends JFrame {

	private JPanel contentPane;
	private JTextField pincode;
	private JTextField areatext;
	private JTextField Pricetext;
	private JTextField sellidtext;
	private JTextField bhktext;
	private JTextField pspace;
	private JTextField lawn;
	private JTextField storey;
	private JLabel lblEnterDetailsFor;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bunglowdetail frame = new Bunglowdetail();
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
	public Bunglowdetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Zipcode");
		lblNewLabel.setBounds(10, 55, 52, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblArea = new JLabel("area");
		lblArea.setBounds(20, 80, 46, 14);
		contentPane.add(lblArea);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 117, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblSellerId = new JLabel("Seller ID");
		lblSellerId.setBounds(10, 148, 46, 14);
		contentPane.add(lblSellerId);
		
		JLabel lblBhk = new JLabel("BHK");
		lblBhk.setBounds(10, 179, 46, 14);
		contentPane.add(lblBhk);
		
		JLabel lblParkingSpace = new JLabel("Parking space");
		lblParkingSpace.setBounds(225, 23, 92, 14);
		contentPane.add(lblParkingSpace);
		
		JLabel lblLawn = new JLabel("Lawn");
		lblLawn.setBounds(254, 73, 46, 14);
		contentPane.add(lblLawn);
		
		JLabel lblStorey = new JLabel("Storey");
		lblStorey.setBounds(254, 128, 46, 14);
		contentPane.add(lblStorey);
		
		pincode = new JTextField();
		pincode.setBounds(66, 52, 86, 20);
		contentPane.add(pincode);
		pincode.setColumns(10);
		
		areatext = new JTextField();
		areatext.setBounds(66, 83, 86, 20);
		contentPane.add(areatext);
		areatext.setColumns(10);
		
		Pricetext = new JTextField();
		Pricetext.setBounds(66, 114, 86, 20);
		contentPane.add(Pricetext);
		Pricetext.setColumns(10);
		
		sellidtext = new JTextField();
		sellidtext.setBounds(66, 145, 86, 20);
		contentPane.add(sellidtext);
		sellidtext.setColumns(10);
		
		bhktext = new JTextField();
		bhktext.setBounds(66, 176, 86, 20);
		contentPane.add(bhktext);
		bhktext.setColumns(10);
		
		pspace = new JTextField();
		pspace.setBounds(322, 23, 86, 20);
		contentPane.add(pspace);
		pspace.setColumns(10);
		
		lawn = new JTextField();
		lawn.setBounds(322, 70, 86, 20);
		contentPane.add(lawn);
		lawn.setColumns(10);
		
		storey = new JTextField();
		storey.setBounds(322, 125, 86, 20);
		contentPane.add(storey);
		storey.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer price=Integer.parseInt(Pricetext.getText());
				Integer area=Integer.parseInt(areatext.getText());
				Integer pin=Integer.parseInt(pincode.getText());
				Integer sell=Integer.parseInt(sellidtext.getText());
				Integer bhk=Integer.parseInt(bhktext.getText());
				Integer papace=Integer.parseInt(pspace.getText());
				String lan=lawn.getText();
				Integer stor=Integer.parseInt(storey.getText());
				
				try {
					JOptionPane.showMessageDialog(contentPane, "Successfully Added!!");
					Bunglowdetail ap3 = new Bunglowdetail();
					ap3.setVisible(true);
					
					Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
			        PreparedStatement stmt  = con.prepareStatement("call p2(?,?,?,?,?,?)");
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
			        stmt.setString(5, lan);
			        stmt.setInt(6, stor);
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
		btnAdd.setBounds(95, 227, 89, 23);
		contentPane.add(btnAdd);
		
		lblEnterDetailsFor = new JLabel("ENTER DETAILS FOR BUNGLOW");
		lblEnterDetailsFor.setBounds(10, 23, 164, 14);
		contentPane.add(lblEnterDetailsFor);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellIntro s1 = new SellIntro();
				s1.setVisible(true);
			}
		});
		btnBack.setBounds(228, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
