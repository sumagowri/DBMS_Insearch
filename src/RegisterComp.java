import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import dao.CreateConnection;
import javax.swing.JPasswordField;

public class RegisterComp extends JFrame {

	private JPanel contentPane;
	private JTextField reg_id;
	private JTextField name;
	private JTextField domain;
	private JTextField address;
	private JTextField phno;
	private JTextField email;
	private JPasswordField password;
	private JPasswordField repassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterComp frame = new RegisterComp();
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
	public RegisterComp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("<--");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					FirstPage frame = new FirstPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(69, 474, 107, 42);
		contentPane.add(btnNewButton);
		
		JLabel RegasStud = new JLabel("Register as Company");
		RegasStud.setForeground(new Color(25, 25, 112));
		RegasStud.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		RegasStud.setHorizontalAlignment(SwingConstants.CENTER);
		RegasStud.setBounds(251, 22, 350, 55);
		contentPane.add(RegasStud);
		
		JLabel comp_reg_id = new JLabel("Company Reg_id");
		comp_reg_id.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		comp_reg_id.setForeground(new Color(255, 255, 255));
		comp_reg_id.setBounds(49, 117, 131, 28);
		contentPane.add(comp_reg_id);
		
		JLabel compname = new JLabel("Name");
		compname.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compname.setForeground(new Color(255, 255, 255));
		compname.setBounds(49, 155, 59, 28);
		contentPane.add(compname);
		
		JLabel compDomain = new JLabel("Domain");
		compDomain.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compDomain.setForeground(new Color(255, 255, 255));
		compDomain.setBounds(49, 195, 78, 28);
		contentPane.add(compDomain);
		
		JLabel compAddress = new JLabel("Address");
		compAddress.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compAddress.setForeground(new Color(255, 255, 255));
		compAddress.setBounds(49, 235, 78, 28);
		contentPane.add(compAddress);
		
		JLabel compPhno = new JLabel("Phone no.");
		compPhno.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compPhno.setForeground(new Color(255, 255, 255));
		compPhno.setBounds(49, 275, 105, 28);
		contentPane.add(compPhno);
		
		JLabel compEmail = new JLabel("E-mail");
		compEmail.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compEmail.setForeground(new Color(255, 255, 255));
		compEmail.setBounds(49, 315, 105, 28);
		contentPane.add(compEmail);
		
		JLabel compPassword = new JLabel("Password");
		compPassword.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compPassword.setForeground(new Color(255, 255, 255));
		compPassword.setBounds(49, 355, 105, 28);
		contentPane.add(compPassword);
		
		JLabel compRepass = new JLabel("Confirm password");
		compRepass.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		compRepass.setForeground(new Color(255, 255, 255));
		compRepass.setBounds(49, 395, 148, 28);
		contentPane.add(compRepass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 241, 571);
		contentPane.add(lblNewLabel);
		
		reg_id = new JTextField();
		reg_id.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		reg_id.setBounds(315, 117, 405, 28);
		contentPane.add(reg_id);
		reg_id.setColumns(10);
		
		name = new JTextField();
		name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		name.setBounds(315, 155, 405, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		domain = new JTextField();
		domain.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		domain.setBounds(315, 195, 405, 28);
		contentPane.add(domain);
		domain.setColumns(10);
		
		address = new JTextField();
		address.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		address.setBounds(315, 235, 405, 28);
		contentPane.add(address);
		address.setColumns(10);
		
		phno = new JTextField();
		phno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		phno.setBounds(315, 275, 405, 28);
		contentPane.add(phno);
		phno.setColumns(10);
		
		email = new JTextField();
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		email.setBounds(315, 315, 405, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				onSubmit();
			}
		});
		submit.setBackground(new Color(255, 255, 255));
		submit.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		submit.setForeground(new Color(0, 0, 0));
		submit.setBounds(613, 474, 107, 42);
		contentPane.add(submit);
		
		password = new JPasswordField();
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		password.setBounds(315, 355, 405, 28);
		contentPane.add(password);
		
		repassword = new JPasswordField();
		repassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		repassword.setBounds(315, 395, 405, 28);
		contentPane.add(repassword);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(108, 35, 46, 14);
		contentPane.add(lblNewLabel_1);
		//setUndecorated(true);
		setResizable(false);
		
	}
	
	private void onSubmit() {
		String pass = new String(password.getPassword());
		String repass = new String(repassword.getPassword());
		if(phno.getText().length()!=10) {
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Invalid Phone number."); 
		}else if(!pass.equals(repass)) {
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Password should be same.");
		}
		else{
			CreateConnection c = new CreateConnection();
			Connection con = c.getConnection();
			
			try {
				Statement s = con.createStatement();
				String query = "INSERT INTO COMP_REG VALUES(?,?,?,?,?,?,?,1)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,reg_id.getText());
				pstmt.setString(2,name.getText());
				pstmt.setString(3,domain.getText());
				pstmt.setString(4,address.getText());
				pstmt.setLong(5,Long.parseLong(phno.getText()));
				pstmt.setString(6,email.getText());
				pstmt.setString(7,pass);
				pstmt.execute();
				try {
					LoginComp window = new LoginComp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}catch(SQLException e) {
				e.printStackTrace(); 
				System.exit(1);
			}
		}
	}
}
