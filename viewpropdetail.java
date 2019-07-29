package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class viewpropdetail extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField propid;
	private JLabel lblEnterPropertyId;
	private JTextField type;
	private JLabel lblType;
	private JLabel lblL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewpropdetail frame = new viewpropdetail();
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
	public viewpropdetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewCustomerDetails = new JButton("SHOW");
		btnViewCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "siddh123");			
			        // step3 create the statement object
			       // PreparedStatement stmt = con.prepareStatement("select * from property natural join ? where prop_id = ?");
			        Integer pid=Integer.parseInt(propid.getText());
			        String ty=type.getText();
			        
			       // Statement stmt = con.createStatement();
			        //stmt.setString(1, ty);
			       // stmt.setInt(2,pid);
			        
			        // step4 execute query					        
			        //ResultSet rs = stmt.executeQuery();
			        //PreparedStatement stmt = con.prepareStatement("SELECT * FROM purchase_request p1 natural join property p2 where sell_id = ?");
			        //System.out.println("connected");
			
			      //  table.setModel(DbUtils.resultSetToTableModel(rs));
			        /*while (rs.next())
			        {		
			        	lblDetails.setText(lblDetails.getText() + " " + rs.getInt(1) + "  " + rs.getString(2));
			        }*/
			        // step5 close the connection object			
			       // con.close();			
			        //if (//res) {
				        //PreparedStatement stmt = con.prepareStatement("SELECT prop_id,sell_id,price,area,parkingspace,bhk from Property natural join residential "
				        		//+ "where price<? and zipcode in (select zipcode from location where city=?) ");			
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
				        //stmt.setInt(1, pri);
				        //stmt.setString(2,city );
				        //ResultSet rs=stmt.executeQuery();
				        //table.setModel(DbUtils.resultSetToTableModel(rs));
				        //con.close();
				        //}
				        
				        if (ty.equals("Agriculture")) {
					        PreparedStatement stmt = con.prepareStatement("SELECT * from property natural join agriculture where prop_id=? ");			
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
					      //  stmt.setInt(1, pri);
					        //stmt.setString(2,city );
						       stmt.setInt(1,pid);
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        if (ty.equals("Industrial")) {
					        PreparedStatement stmt = con.prepareStatement("SELECT * from property natural join Industrial where prop_id=? ");			
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
					      //  stmt.setInt(1, pri);
					        //stmt.setString(2,city );
						       stmt.setInt(1,pid);
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        if (ty.equals("Office")) {
					        PreparedStatement stmt = con.prepareStatement("SELECT * from property natural join office where prop_id=? ");			
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
					      //  stmt.setInt(1, pri);
					        //stmt.setString(2,city );
						       stmt.setInt(1,pid);
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        if (ty.equals("Flat")) {
					        PreparedStatement stmt = con.prepareStatement("SELECT * from property natural join flat where prop_id=? ");			
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
					      //  stmt.setInt(1, pri);
					        //stmt.setString(2,city );
						       stmt.setInt(1,pid);
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        if (ty.equals("Bunglow")) {
					        PreparedStatement stmt = con.prepareStatement("SELECT * from property natural join bunglow where prop_id=? ");			
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
					      //  stmt.setInt(1, pri);
					        //stmt.setString(2,city );
						       stmt.setInt(1,pid);
					        ResultSet rs=stmt.executeQuery();
					        table.setModel(DbUtils.resultSetToTableModel(rs));
					        con.close();
					        }
				        else
				        {
				        	JOptionPane.showMessageDialog(contentPane, "Not Available!!");
							viewpropdetail ap4 = new viewpropdetail();
							ap4.setVisible(true);
				        }
				        
				        
			    } catch (SQLException ex) {
	
			        System.out.println(ex);
	
			    }catch (ClassNotFoundException ex) {
	
			        System.out.println(ex);			
			    }
			}
		});
		
		
		btnViewCustomerDetails.setBounds(308, 24, 89, 23);
		
		btnViewCustomerDetails.setBounds(308, 24, 89, 23);
		contentPane.add(btnViewCustomerDetails);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 100, 432, 311);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		propid = new JTextField();
		propid.setBounds(173, 25, 86, 20);
		contentPane.add(propid);
		propid.setColumns(10);
		
		lblEnterPropertyId = new JLabel("ENTER PROPERTY ID:");
		lblEnterPropertyId.setBounds(24, 28, 124, 14);
		contentPane.add(lblEnterPropertyId);
		
		type = new JTextField();
		type.setBounds(173, 67, 86, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		lblType = new JLabel("Property Type:");
		lblType.setBounds(24, 75, 101, 14);
		contentPane.add(lblType);
		
		lblL = new JLabel("l");
		lblL.setIcon(new ImageIcon(viewpropdetail.class.getResource("/dbsproject/hi.jpg")));
		lblL.setBounds(0, 0, 484, 436);
		contentPane.add(lblL);
	}
}
