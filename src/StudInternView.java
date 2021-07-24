import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.CreateConnection;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudInternView extends JFrame {

	private JPanel contentPane;
	String Regid;
	int Appid;
	private JTable table;
	DefaultTableModel model;
	Object[] row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudInternView frame = new StudInternView("0",0);
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
	public StudInternView(String Regid,int Appid) {
		this.Regid=Regid;
		this.Appid=Appid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DETAILS");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_1.setBounds(330, 24, 106, 30);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(265, 62, 215, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Students Applied:");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel.setBounds(44, 91, 264, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(43, 124, 173, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 160, 698, 311);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		model=new DefaultTableModel();
		Object[] column= {"Application id","Studen id","Student name","Student Email","Student skills","Student Phone no."};
		row= new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton back = new JButton("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CompHomePage frame = new CompHomePage(Regid);
				frame.setVisible(true);
				dispose();
			}
		});
		back.setBounds(56, 502, 71, 30);
		Image img = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		back.setIcon(new ImageIcon(img));
		contentPane.add(back);
		
		CreateConnection c = new CreateConnection();
		Connection con = c.getConnection();
		
		try {
			String query = "SELECT UNIQUE I.APP_ID,S.STUD_ID,STUD_NAME,STUD_EMAIL,STUD_SKILLS,STUD_PHNO FROM STUD_REG S,INTERN_FEEDBACK F,INTERNSHIP I,STUD_SKILL SS WHERE S.STUD_ID=F.STUD_ID AND S.STUD_ID=SS.STUD_ID AND I.APP_ID=F.APP_ID AND I.REG_ID=? and I.APP_ID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, Regid);
			pstmt.setInt(2, Appid);
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
	}
}
