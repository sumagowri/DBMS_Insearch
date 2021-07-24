import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CreateConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InternshipView extends JFrame {

	private JPanel contentPane;
	int id;
	int appId;
	int APPId;
	int ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternshipView frame = new InternshipView(0,0);
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
	public InternshipView(int appId,int id) {
		this.id=id;
		this.appId=appId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back = new JButton("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Studhomepage frame = new Studhomepage(id);
					frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setBounds(84, 499, 56, 30);
		contentPane.add(back);
		
		JLabel lblNewLabel_2 = new JLabel("Company name");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(35, 111, 176, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAvailableSlots = new JLabel("Available slots");
		lblAvailableSlots.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblAvailableSlots.setForeground(new Color(255, 255, 255));
		lblAvailableSlots.setBounds(35, 411, 176, 30);
		contentPane.add(lblAvailableSlots);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setBounds(35, 171, 176, 30);
		contentPane.add(lblDescription);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblStartDate.setForeground(new Color(255, 255, 255));
		lblStartDate.setBounds(35, 291, 176, 30);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblEndDate.setForeground(new Color(255, 255, 255));
		lblEndDate.setBounds(35, 351, 176, 30);
		contentPane.add(lblEndDate);
		
		JLabel lblSkillsRequired = new JLabel("Skills Required");
		lblSkillsRequired.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblSkillsRequired.setForeground(new Color(255, 255, 255));
		lblSkillsRequired.setBounds(35, 231, 176, 30);
		contentPane.add(lblSkillsRequired);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 139));
		lblNewLabel.setBounds(0, 0, 263, 561);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Internship Details");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 27));
		lblNewLabel_1.setBounds(273, 22, 310, 39);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(261, 72, 253, 2);
		contentPane.add(separator);
		
		JLabel compname = new JLabel("");
		compname.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		compname.setBounds(307, 111, 420, 30);
		contentPane.add(compname);
		
		
		JLabel desc = new JLabel("");
		desc.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		desc.setBounds(307, 171, 420, 30);
		contentPane.add(desc);
		
		JLabel skills = new JLabel("");
		skills.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		skills.setBounds(307, 231, 420, 30);
		contentPane.add(skills);
		
		JLabel start = new JLabel("");
		start.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		start.setBounds(307, 291, 420, 30);
		contentPane.add(start);
		
		JLabel end = new JLabel("");
		end.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		end.setBounds(307, 351, 420, 30);
		contentPane.add(end);
		
		JLabel slots = new JLabel("");
		slots.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		slots.setBounds(307, 411, 420, 30);
		contentPane.add(slots);
		
		JButton btnNewButton = new JButton("APPLY");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				onApply();
			}
		});
		btnNewButton.setBounds(642, 499, 98, 30);
		contentPane.add(btnNewButton);
		
		
		getDetails(compname,desc,skills,start,end,slots);
	}
	public void getDetails(JLabel comp,JLabel desc,JLabel skills,JLabel start,JLabel end,JLabel slots) {
		CreateConnection c = new CreateConnection();
		Connection con = c.getConnection();
		
		try {
			String query = "SELECT COMP_NAME,DESCRIPT,START_DATE,END_DATE,SKILLSREQ,NUM_SLOTS FROM INTERNSHIP I,COMP_REG C WHERE I.REG_ID=C.REG_ID AND I.APP_ID=? AND NUM_SLOTS>0";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, appId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				comp.setText(rs.getString(1));
				desc.setText(rs.getString(2));
				start.setText(rs.getDate(3).toString());
				end.setText(rs.getDate(4).toString());
				skills.setText(rs.getString(5));
				slots.setText(rs.getInt(6)+"");
			}
			
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.exit(1);
		}
	}
	public void onApply() {
		CreateConnection c=new CreateConnection();
		Connection con = c.getConnection();
		try {
			String q="SELECT STUD_ID,APP_ID FROM INTERN_FEEDBACK WHERE APP_ID=? AND STUD_ID=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, appId);
			pstmt.setInt(2, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				JFrame fr=new JFrame();
				JOptionPane.showMessageDialog(fr,"Already Applied");
			}
			else{
				String query="INSERT INTO INTERN_FEEDBACK(STUD_ID,APP_ID) VALUES(?,?)";
				PreparedStatement prstmt = con.prepareStatement(query);
				prstmt.setInt(1, id);
				prstmt.setInt(2, appId);
				prstmt.execute();
				JFrame f=new JFrame();
				JOptionPane.showMessageDialog(f,"Applied");
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.exit(1);
		}
	}
}
