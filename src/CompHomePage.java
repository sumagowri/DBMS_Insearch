

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.CreateConnection;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompHomePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//private JTable table_1;
	DefaultTableModel model;
	Object[] row;
	String Regid;
	int Appid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompHomePage frame = new CompHomePage("0");
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
	public CompHomePage(String Regid) {
		this.Regid=Regid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 612);
		getContentPane().setLayout(null);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(new Color(25, 25, 112));
		separator.setBackground(new Color(25, 25, 112));
		separator.setBounds(266, 137, 634, 2);
		getContentPane().add(separator);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/build.png")));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setBounds(0, 0, 256, 697);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HOME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(491, 38, 164, 47);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to INSEARCH.......");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(633, 96, 247, 39);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add  internship details..");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Internship frame = new Internship (Regid);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(25, 25, 112));
		
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(679, 157, 221, 32);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 211, 646, 351);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=table.getSelectedRow();
				TableModel model = table.getModel();
				Appid = Integer.parseInt(model.getValueAt(index, 0).toString());
				onClick();
			}
		});
		model=new DefaultTableModel();
		Object[] column= {"Application id","Skill","Description","Start date","End date","Vacancies"};
		row= new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
			CreateConnection c = new CreateConnection();
			Connection con = c.getConnection();
			
			try {
				String query = "SELECT APP_ID,SKILLSREQ,DESCRIPT,START_DATE,END_DATE,NUM_SLOTS FROM INTERNSHIP WHERE REG_ID=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, Regid);
				ResultSet rs = pstmt.executeQuery();
				
				
				
				while(rs.next()) {
					//System.out.println(rs.getString(1));
					row[0]= rs.getString(1);
					row[1]= rs.getString(2);
					row[2]= rs.getString(3);
					row[3]= rs.getString(4);
					row[4]= rs.getString(5);
					row[5]= rs.getString(6);
					model.addRow(row);
				}
				//model.addRow(row);
				//table.setModel(resultSetToTableModel(rs));
			}catch(SQLException e) {
				e.printStackTrace(); 
				System.exit(1);
			}
			//row=null;
		}
	public void onClick() {
		StudInternView frame = new StudInternView(Regid,Appid);
		frame.setVisible(true);
		dispose();
		}
	}


