import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import dao.CreateConnection;
import javax.swing.JPasswordField;

public class RegisterStudent extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField clgname;
	private JTextField phno;
	private JTextField skills;
	private JTextField dep;
	private JTextField cgpa;
	private JTextField year;
	private JPasswordField password;
	private JPasswordField repassword;
	int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterStudent frame = new RegisterStudent();
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
	public RegisterStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton back = new JButton("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					FirstPage frame = new FirstPage();
					frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		back.setIcon(new ImageIcon(img));
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setBounds(79, 500, 100, 40);
		contentPane.add(back);
		
		JLabel studconpass = new JLabel("Confirm Password");
		studconpass.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studconpass.setForeground(new Color(255, 255, 255));
		studconpass.setBounds(55, 432, 160, 28);
		contentPane.add(studconpass);
		
		JLabel studpassword = new JLabel("Password");
		studpassword.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studpassword.setForeground(new Color(255, 255, 255));
		studpassword.setBounds(55, 392, 105, 28);
		contentPane.add(studpassword);
		
		JLabel RegasStud = new JLabel("Register as Student");
		RegasStud.setForeground(new Color(25, 25, 112));
		RegasStud.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		RegasStud.setHorizontalAlignment(SwingConstants.CENTER);
		RegasStud.setBounds(251, 11, 337, 42);
		contentPane.add(RegasStud);
		
		JLabel studName = new JLabel("Name");
		studName.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studName.setForeground(new Color(255, 255, 255));
		studName.setBounds(55, 74, 59, 28);
		contentPane.add(studName);
		
		JLabel studEmail = new JLabel("E-mail");
		studEmail.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studEmail.setForeground(new Color(255, 255, 255));
		studEmail.setBounds(55, 112, 59, 28);
		contentPane.add(studEmail);
		
		JLabel studClgname = new JLabel("College Name");
		studClgname.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studClgname.setForeground(new Color(255, 255, 255));
		studClgname.setBounds(55, 152, 105, 28);
		contentPane.add(studClgname);
		
		JLabel studPhone = new JLabel("Phone no.");
		studPhone.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studPhone.setForeground(new Color(255, 255, 255));
		studPhone.setBounds(55, 192, 78, 28);
		contentPane.add(studPhone);
		
		JLabel studSkills = new JLabel("Skills");
		studSkills.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studSkills.setForeground(new Color(255, 255, 255));
		studSkills.setBounds(55, 232, 46, 28);
		contentPane.add(studSkills);
		
		JLabel studDept = new JLabel("Department");
		studDept.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studDept.setForeground(new Color(255, 255, 255));
		studDept.setBounds(55, 272, 105, 28);
		contentPane.add(studDept);
		
		JLabel studCgpa = new JLabel("CGPA");
		studCgpa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studCgpa.setForeground(new Color(255, 255, 255));
		studCgpa.setBounds(55, 312, 46, 28);
		contentPane.add(studCgpa);
		
		JLabel studPassyear = new JLabel("Passing year");
		studPassyear.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studPassyear.setForeground(new Color(255, 255, 255));
		studPassyear.setBounds(55, 352, 105, 28);
		contentPane.add(studPassyear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 241, 571);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		name.setBounds(321, 74, 405, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		email.setBounds(321, 112, 405, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		clgname = new JTextField();
		clgname.setBackground(new Color(255, 255, 255));
		clgname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		clgname.setBounds(321, 152, 405, 28);
		contentPane.add(clgname);
		clgname.setColumns(10);
		
		phno = new JTextField();
		phno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		phno.setBounds(321, 192, 405, 28);
		contentPane.add(phno);
		phno.setColumns(10);
		
		skills = new JTextField();
		skills.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		skills.setBounds(321, 232, 405, 28);
		contentPane.add(skills);
		skills.setColumns(10);
		
		dep = new JTextField();
		dep.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		dep.setBounds(321, 272, 405, 28);
		contentPane.add(dep);
		dep.setColumns(10);
		
		cgpa = new JTextField();
		cgpa.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		cgpa.setBounds(321, 312, 405, 28);
		contentPane.add(cgpa);
		cgpa.setColumns(10);
		
		year = new JTextField();
		year.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		year.setBounds(321, 352, 405, 28);
		contentPane.add(year);
		year.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				onSubmit();
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		submit.setBackground(new Color(255, 255, 255));
		submit.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		submit.setForeground(new Color(0, 0, 0));
		submit.setBounds(615, 500, 111, 42);
		contentPane.add(submit);
		
		password = new JPasswordField();
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		password.setBounds(321, 392, 405, 28);
		contentPane.add(password);
		
		repassword = new JPasswordField();
		repassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		repassword.setBounds(321, 432, 405, 28);
		contentPane.add(repassword);
		//setUndecorated(true);
		setResizable(false);
		
	}
	
	private void onSubmit() {
		String pass = new String(password.getPassword());
		String rePass = new String(repassword.getPassword());
		if(phno.getText().length()!=10) {
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Invalid Phone number."); 
		}else if(!pass.equals(rePass)) {
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Password should be same");
		}
		else{
			CreateConnection c = new CreateConnection();
			Connection con = c.getConnection();
			
			try {
				Statement s = con.createStatement();
				String query = "INSERT INTO STUD_REG VALUES(STUDENT_ID_VAL.NEXTVAL,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,name.getText());
				pstmt.setString(2,email.getText());
				pstmt.setString(3,clgname.getText());
				pstmt.setLong(4,Long.parseLong(phno.getText()));
				//pstmt.setString(5,skills.getText());
				pstmt.setString(5,dep.getText());
				pstmt.setFloat(6,Float.parseFloat(cgpa.getText()));
				pstmt.setInt(7,Integer.parseInt(year.getText()));
				pstmt.setString(8,pass);
				pstmt.execute();
				
				String q = "SELECT STUD_ID FROM STUD_REG WHERE STUD_EMAIL=?";
				PreparedStatement p = con.prepareStatement(q);
				p.setString(1, email.getText());
				ResultSet rs=p.executeQuery();
				if(rs.next()) {
					int studid=rs.getInt(1);
					String skill=skills.getText();
					CallableStatement call = con.prepareCall("{call INSERT_STUDSKILLS(?,?)}");
					call.setInt(1, studid);
					call.setString(2, skill);
					call.executeUpdate();
				}
			}catch(SQLException e) {
				e.printStackTrace(); 
				System.exit(1);
			}
		}
	}
}
