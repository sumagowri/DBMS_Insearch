import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.CreateConnection;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;

public class LoginComp extends JFrame {

	JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginComp window = new LoginComp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
//	public Login() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public LoginComp() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(25, 25, 112));
		frame.getContentPane().setBackground(new Color(25, 25, 112));
		frame.setBounds(200, 200, 529, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(215, 158, 197, 30);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LOGIN  COMPANY");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/login.png")));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 27));
		lblNewLabel.setBounds(118, 74, 294, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Studusername = new JLabel("Username");
		Studusername.setForeground(Color.WHITE);
		Studusername.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		Studusername.setBounds(118, 158, 78, 34);
		frame.getContentPane().add(Studusername);
		
		JLabel Studpassword = new JLabel("Password");
		Studpassword.setForeground(Color.WHITE);
		Studpassword.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		Studpassword.setBounds(118, 221, 87, 30);
		frame.getContentPane().add(Studpassword);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 128));
		separator.setBounds(117, 142, 295, 2);
		frame.getContentPane().add(separator);
		
		JButton signup = new JButton("REGISTER");
		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RegisterComp fr = new RegisterComp();
				fr.setVisible(true);
				frame.dispose();
			}
		});
		signup.setBackground(new Color(255, 255, 255));
		signup.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		signup.setBounds(140, 309, 101, 32);
		frame.getContentPane().add(signup);
		
		JButton login = new JButton("LOGIN");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				onLogin();
			}
		});
		login.setForeground(new Color(0, 0, 0));
		login.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		login.setBackground(new Color(255, 255, 255));
		login.setBounds(311, 309, 101, 32);
		frame.getContentPane().add(login);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 128));
		separator_1.setBounds(117, 285, 295, 2);
		frame.getContentPane().add(separator_1);
		
		password = new JPasswordField();
		password.setBounds(215, 228, 197, 30);
		frame.getContentPane().add(password);
	}
	private void onLogin() {
		String pass = new String(password.getPassword());
		String user = new String(username.getText());
		
		CreateConnection c = new CreateConnection();
		Connection con = c.getConnection();		
		try {
			String query = "SELECT REG_ID FROM COMP_REG WHERE COMP_EMAIL='"+user+"' AND COMP_PASSWORD='"+pass+"'";
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(query);
			if(set.next()) {
				CompHomePage comp = new CompHomePage(set.getString("REG_ID"));
				comp.setVisible(true);
				frame.dispose();
			}
			else {
				JFrame fr=new JFrame();
				JOptionPane.showMessageDialog(fr,"Password or email is incorrect");
			}
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.exit(1);
		}
	}
}