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

public class AddSel extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField gender;
	private JTextField city;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSel frame = new AddSel();
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
	public AddSel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setBounds(21, 45, 69, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(21, 105, 69, 14);
		contentPane.add(lblLastName);
		
		JLabel lblGendermf = new JLabel("Gender(M/F)");
		lblGendermf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGendermf.setBounds(10, 166, 80, 14);
		contentPane.add(lblGendermf);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCity.setBounds(21, 221, 46, 14);
		contentPane.add(lblCity);
		
		fname = new JTextField();
		fname.setBounds(125, 42, 86, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(125, 102, 86, 20);
		contentPane.add(lname);
		lname.setColumns(10);
		
		gender = new JTextField();
		gender.setBounds(125, 163, 86, 20);
		contentPane.add(gender);
		gender.setColumns(10);
		
		city = new JTextField();
		city.setBounds(125, 218, 86, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//public void actionPerformed(ActionEvent e) {
					//Integer fm=Integer.parseInt(Pricetext.getText());
					//Integer area=Integer.parseInt(areatext.getText());
					//Integer pin=Integer.parseInt(pincode.getText());
					//Integer sell=Integer.parseInt(sellidtext.getText());
					//Integer bhk=Integer.parseInt(bhktext.getText());
					//Integer papace=Integer.parseInt(pspace.getText());
					String fe=fname.getText();
					String le=lname.getText();
					String cy=city.getText();
					String gen=gender.getText();
					//Integer stor=Integer.parseInt(Floor.getText());
					//Integer lan=Integer.parseInt(balcony.getText());
					
					try {
						JOptionPane.showMessageDialog(contentPane, "Successfully Registered!!");
						AddSel ap2 = new AddSel();
						ap2.setVisible(true);
						Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
				        PreparedStatement stmt  = con.prepareStatement("call addsel(?,?,?,?)");
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
				        stmt.setString(1,fe);
				        stmt.setString(2, le);
				        stmt.setString(3, gen);
				        stmt.setString(4, cy);
				        //stmt.setString(5, bhk);
				        //stmt.setString(6, papace);
				       // stmt.setInt(7, lan);
				       // stmt.setInt(8, stor);
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
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setBounds(125, 286, 89, 23);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminp1 ai3 = new Adminp1();
				ai3.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(278, 286, 89, 23);
		contentPane.add(btnBack);
	}

}
