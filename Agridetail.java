package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Agridetail extends JFrame {

	private JPanel soiltext;
	private JTextField pincode;
	private JTextField Pricetext;
	private JTextField areatext;
	private JTextField soiltext1;
	private JTextField sellidtext;
	private JButton btnBack;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agridetail frame = new Agridetail();
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
	public Agridetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 380);
		soiltext = new JPanel();
		soiltext.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(soiltext);
		soiltext.setLayout(null);
		
		//propid.prop++;
		JLabel lblZipCode = new JLabel("ZIP Code");
		lblZipCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZipCode.setBounds(10, 47, 57, 14);
		soiltext.add(lblZipCode);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setBounds(10, 98, 46, 14);
		soiltext.add(lblPrice);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArea.setBounds(10, 148, 46, 14);
		soiltext.add(lblArea);
		
		JLabel lblSoilType = new JLabel("Soil Type");
		lblSoilType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoilType.setBounds(10, 198, 57, 14);
		soiltext.add(lblSoilType);
		
		JLabel lblSellerId = new JLabel("Seller ID");
		lblSellerId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSellerId.setBounds(10, 254, 57, 14);
		soiltext.add(lblSellerId);
		
		pincode = new JTextField();
		pincode.setBounds(90, 44, 86, 20);
		soiltext.add(pincode);
		pincode.setColumns(10);
		
		Pricetext = new JTextField();
		Pricetext.setBounds(90, 95, 86, 20);
		soiltext.add(Pricetext);
		Pricetext.setColumns(10);
		
		areatext = new JTextField();
		areatext.setBounds(90, 145, 86, 20);
		soiltext.add(areatext);
		areatext.setColumns(10);
		
		soiltext1 = new JTextField();
		soiltext1.setBounds(90, 195, 86, 20);
		soiltext.add(soiltext1);
		soiltext1.setColumns(10);
		
		JButton btnCreate = new JButton("ADD");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(soiltext, "Successfully Added!!");
				Agridetail ap1 = new Agridetail();
				ap1.setVisible(true);
				Integer price=Integer.parseInt(Pricetext.getText());
				Integer area=Integer.parseInt(areatext.getText());
				Integer pin=Integer.parseInt(pincode.getText());
				Integer sell=Integer.parseInt(sellidtext.getText());
				String soil=soiltext1.getText();
			try {	Class.forName("oracle.jdbc.driver.OracleDriver");			
		        // step2 create the connection object			
		        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
		        //PreparedStatement stmt  = con.prepareStatement("insert into property values(?,?,?,?,?)");
		        //PreparedStatement stmt1  = con.prepareStatement("insert into Agriculture values(?,?)");
		       // PreparedStatement stmt2  = con.prepareStatement("insert into Industrial values(?,?)");
		        //k = k+1;
		        //propnumber = propnumber+1;
		        PreparedStatement stmt  = con.prepareStatement("call p1(?,?,?,?,?)");
		        //PreparedStatement stmt1  = con.prepareStatement("execute p1");
		       // int n=propid.prop;
		       // n++;
		       // propid.setval(n);
		      //  System.out.println(propid.prop);
		       // int num=propid.prop;
		       // stmt.setInt(1,num);
		        stmt.setInt(1,sell);
		        stmt.setInt(2, pin);
		        stmt.setInt(3, price);
		        stmt.setInt(4, area);
		        stmt.setString(5, soil);
		       //stmt1.setInt(1, num);
		      //stmt1.setString(2, soil);
		        
		     //  stmt2.setInt(1,num);
		     //   stmt2.setString(2, approval);
		        stmt.executeUpdate();
		        //stmt1.executeUpdate();
		       // stmt2.executeUpdate();
		        con.close();
		        
				}
				catch (SQLException ex) {
					
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
			}
			
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreate.setBounds(90, 307, 89, 23);
		soiltext.add(btnCreate);
		
		sellidtext = new JTextField();
		sellidtext.setBounds(90, 251, 86, 20);
		soiltext.add(sellidtext);
		sellidtext.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellIntro s1 = new SellIntro();
				s1.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(255, 307, 89, 23);
		soiltext.add(btnBack);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Agridetail.class.getResource("/dbsproject/price-tag.png")));
		label.setBounds(0, 0, 514, 341);
		soiltext.add(label);
	}
}
