
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
import java.sql.Types;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Officedetail extends JFrame {
    public Integer propnumber=5015;
    //public int k = Class1.propnum;
	private JPanel contentPane;
	private JTextField pincode;
	private JTextField Pricetext;
	private JTextField areatext;
	private JTextField Status;
	private JTextField Housing;
	private JTextField sellidtext;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Officedetail frame = new Officedetail();
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
	public Officedetail() {
		setTitle("OFFICE DETAILS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZipcode = new JLabel("ZipCode");
		lblZipcode.setBounds(31, 41, 62, 14);
		contentPane.add(lblZipcode);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(31, 81, 62, 14);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel = new JLabel("Area");
		lblNewLabel.setBounds(31, 139, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(31, 189, 62, 14);
		contentPane.add(lblStatus);
		
		JLabel lblApprovalType = new JLabel("Housing Capacity");
		lblApprovalType.setBounds(10, 256, 83, 14);
		contentPane.add(lblApprovalType);
		
		pincode = new JTextField();
		pincode.setBounds(113, 38, 86, 20);
		contentPane.add(pincode);
		pincode.setColumns(10);
		
		Pricetext = new JTextField();
		Pricetext.setBounds(113, 78, 86, 20);
		contentPane.add(Pricetext);
		Pricetext.setColumns(10);
		
		areatext = new JTextField();
		areatext.setBounds(113, 136, 86, 20);
		contentPane.add(areatext);
		areatext.setColumns(10);
		
		Status = new JTextField();
		Status.setBounds(113, 186, 86, 20);
		contentPane.add(Status);
		Status.setColumns(10);
		
		Housing = new JTextField();
		Housing.setBounds(113, 253, 86, 20);
		contentPane.add(Housing);
		Housing.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer price,area,pin,sell;
				String status;
				int house;
				
				if(!Pricetext.getText().equals("") && !areatext.getText().equals("") && !pincode.getText().equals("") && !sellidtext.getText().equals("")) {
					
					price=Integer.parseInt(Pricetext.getText());
					area=Integer.parseInt(areatext.getText());
					pin=Integer.parseInt(pincode.getText());
					sell=Integer.parseInt(sellidtext.getText());
					status=Status.getText();
					house=Integer.parseInt(Housing.getText());
					JOptionPane.showMessageDialog(contentPane, "Successfully Added!!");
					Officedetail ap6= new Officedetail();
					ap6.setVisible(true);
					
					try {
						
						Class.forName("oracle.jdbc.driver.OracleDriver");			
				        // step2 create the connection object			
				        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","siddh123");
				        PreparedStatement stmt  = con.prepareStatement("call officeproc(?,?,?,?,?,?)");
				        //PreparedStatement stmt1  = con.prepareStatement("insert into Commercial values(?,?)");
				        //PreparedStatement stmt2  = con.prepareStatement("insert into Industrial values(?,?)");
				        //k = k+1;
				        //propnumber = propnumber+1;
				        //propid.prop +=1;
				   
				        //int num=propid.prop;
				        //stmt.setInt(1,num);
				        stmt.setInt(1,sell);
				        stmt.setInt(2, pin);
				        stmt.setInt(3, price);
				        stmt.setInt(4, area);
				        
				        if(status.equals(""))
				        {
				        	stmt.setNull(5, Types.VARCHAR);
				        }
				        else
				        {
				        	stmt.setString(5, status);
				        }
				        
				        if(status.equals(""))
				        {
				        	stmt.setInt(6, 0);
				        }
				        else
				        {
				        	stmt.setInt(6, house);
				        }
				        
				       //stmt1.setInt(1, num);
				      //stmt1.setString(2, status);
				        
				       //stmt2.setInt(1,num);
				        //stmt2.setString(2, approval);
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
				else
				{
					JOptionPane.showMessageDialog(null, "Integer fields cannot be empty");
				}	
			}
		});
		btnAdd.setBounds(191, 319, 89, 23);
		contentPane.add(btnAdd);
		
		sellidtext = new JTextField();
		sellidtext.setBounds(329, 38, 86, 20);
		contentPane.add(sellidtext);
		sellidtext.setColumns(10);
		
		JLabel lblSellerId = new JLabel("Seller ID");
		lblSellerId.setBounds(261, 41, 46, 14);
		contentPane.add(lblSellerId);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellIntro s1 = new SellIntro();
				s1.setVisible(true);
			}
		});
		btnBack.setBounds(313, 319, 89, 23);
		contentPane.add(btnBack);
		//k = Class1.propnum;
	}
}