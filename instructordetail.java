package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class instructordetail extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructordetail frame = new instructordetail();
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
	public instructordetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInstructorDetails = new JButton("INSTRUCTOR DETAILS");
		btnInstructorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "siddh123");			
			        // step3 create the statement object			
			        Statement stmt = con.createStatement();			
			        // step4 execute query					        
			        ResultSet rs = stmt.executeQuery("SELECT * FROM section");
			        //System.out.println("connected");
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
			//}
		});
		btnInstructorDetails.setBounds(163, 11, 141, 23);
		contentPane.add(btnInstructorDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 442, 249);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
