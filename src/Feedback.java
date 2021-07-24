import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CreateConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Feedback extends JFrame {

	private JPanel contentPane;
	int appId;
	int id;
	private JTextField feedback;
	private JTextField rating;
	private JTextField AppId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback(0,0);
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
	public Feedback(int appId,int id) {
		this.id=id;
		this.appId=appId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 600, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FEEDBACK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel.setBounds(210, 11, 160, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Feedback");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(101, 152, 102, 30);
		contentPane.add(lblNewLabel_1);
		
		feedback = new JTextField();
		feedback.setBounds(245, 152, 233, 30);
		contentPane.add(feedback);
		feedback.setColumns(10);
		
		rating = new JTextField();
		rating.setBounds(245, 211, 233, 30);
		contentPane.add(rating);
		rating.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setForeground(new Color(255, 255, 255));
		lblRating.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblRating.setBounds(101, 211, 102, 30);
		contentPane.add(lblRating);
		
		JButton submit = new JButton("Submit");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onSubmit();
			}
		});
		submit.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		submit.setBounds(256, 291, 102, 33);
		contentPane.add(submit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(136, 55, 282, 2);
		contentPane.add(separator);
		
		AppId = new JTextField();
		AppId.setColumns(10);
		AppId.setBounds(245, 90, 233, 30);
		contentPane.add(AppId);
		
		JLabel lblApplicationId = new JLabel("Application ID");
		lblApplicationId.setForeground(new Color(255, 255, 255));
		lblApplicationId.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblApplicationId.setBounds(95, 87, 124, 30);
		contentPane.add(lblApplicationId);
	}
	private void onSubmit() {
		CreateConnection c = new CreateConnection();
		Connection con = c.getConnection();
		
		try {
			String query = "UPDATE INTERN_FEEDBACK SET RATING=?,FEEDBACK=? WHERE APP_ID=? AND STUD_ID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(rating.getText()));
			pstmt.setString(2,feedback.getText());
			pstmt.setInt(3,Integer.parseInt(AppId.getText()));
			pstmt.setInt(4,id);
			pstmt.execute();
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Feedback Submitted.");
			Studhomepage frame = new Studhomepage(id);
			frame.setVisible(true);
			dispose();
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.exit(1);
		}
	
}
}
