package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddTransac extends JFrame {

	private JPanel contentPane;
	private JTextField cusidtext;
	private JTextField propidtext;
	private JTextField datetext;
  int trans=304;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTransac frame = new AddTransac();
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
	public AddTransac() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seller ID");
		lblNewLabel.setBounds(10, 36, 66, 19);
		contentPane.add(lblNewLabel);
		
		JTextArea sellidtext = new JTextArea();
		sellidtext.setBounds(86, 33, 81, 22);
		contentPane.add(sellidtext);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(10, 94, 66, 22);
		contentPane.add(lblCustomerId);
		
		cusidtext = new JTextField();
		cusidtext.setBounds(86, 95, 86, 20);
		contentPane.add(cusidtext);
		cusidtext.setColumns(10);
		
		JLabel lblPropertyId = new JLabel("Property ID");
		lblPropertyId.setBounds(10, 163, 66, 19);
		contentPane.add(lblPropertyId);
		
		propidtext = new JTextField();
		propidtext.setBounds(81, 162, 86, 20);
		contentPane.add(propidtext);
		propidtext.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  int cus=Integer.parseInt(cusidtext.getText());
                 trans=trans+1;
                 int sell=Integer.parseInt(sellidtext.getText());
                 int prop=Integer.parseInt(propidtext.getText());
                 String date=datetext.getText();
                 JOptionPane.showMessageDialog(contentPane, "Successfully Added!!");
					AddTransac ap6= new AddTransac();
					ap6.setVisible(true);
	try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
			      //  PreparedStatement stmt  = con.prepareStatement("");
			        PreparedStatement stmt = con.prepareStatement("insert into Transaction values(?,?,?,?,?)");
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
			        stmt.setInt(1,trans);
			        stmt.setInt(2, sell);
			        stmt.setInt(3, cus);
			        stmt.setInt(4, prop);
			        stmt.setString(5, date);
			        //stmt.setInt(6, papace);
			        //stmt.setInt(7, lan);
			        //stmt.setInt(8, stor);
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
		btnAdd.setBounds(135, 269, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 222, 46, 14);
		contentPane.add(lblDate);
		
		datetext = new JTextField();
		datetext.setBounds(81, 219, 86, 20);
		contentPane.add(datetext);
		datetext.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminp1 ap4  =new Adminp1();
				ap4.setVisible(true);
			}
		});
		btnBack.setBounds(297, 269, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblDdmonyyyy = new JLabel("dd-mon-yyyy");
		lblDdmonyyyy.setBounds(236, 222, 71, 14);
		contentPane.add(lblDdmonyyyy);
	}
}
