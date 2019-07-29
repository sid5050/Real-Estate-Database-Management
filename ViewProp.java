package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ViewProp extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProp frame = new ViewProp();
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
	public ViewProp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewProperty = new JButton("VIEW PROPERTY DETAILS");
		btnViewProperty.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewProperty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system", "siddh123");			
			        // step3 create the statement object			
			        Statement stmt = con.createStatement();			
			        // step4 execute query					        
			        ResultSet rs = stmt.executeQuery("SELECT * FROM Property");
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
		});
		btnViewProperty.setBounds(47, 27, 178, 29);
		contentPane.add(btnViewProperty);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 464, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminp1 ai2 = new Adminp1();
				ai2.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(284, 30, 89, 23);
		contentPane.add(btnBack);
	}

}
