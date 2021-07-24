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

public class EditStudent extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField clgname;
	private JTextField phno;
	private JTextField skills;
	private JTextField dep;
	private JTextField cgpa;
	private JTextField year;
	int id;
	String Sname;
	String Sclgname;
	String Sphno;
	String Skills;
	String Dept;
	String CGPA;
	String passyear;
	String Email;
	private JTextField email;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent(0);
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
	public EditStudent(int id) {
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblEmail.setBounds(55, 462, 105, 28);
		contentPane.add(lblEmail);
		
		JLabel RegasStud = new JLabel("Edit Student");
		RegasStud.setForeground(new Color(25, 25, 112));
		RegasStud.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		RegasStud.setHorizontalAlignment(SwingConstants.CENTER);
		RegasStud.setBounds(251, 11, 337, 42);
		contentPane.add(RegasStud);
		
		JLabel studName = new JLabel("Name");
		studName.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studName.setForeground(new Color(255, 255, 255));
		studName.setBounds(55, 109, 59, 28);
		contentPane.add(studName);
		
		JLabel studClgname = new JLabel("College Name");
		studClgname.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studClgname.setForeground(new Color(255, 255, 255));
		studClgname.setBounds(55, 162, 105, 28);
		contentPane.add(studClgname);
		
		JLabel studPhone = new JLabel("Phone no.");
		studPhone.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studPhone.setForeground(new Color(255, 255, 255));
		studPhone.setBounds(55, 212, 78, 28);
		contentPane.add(studPhone);
		
		JLabel studSkills = new JLabel("Skills");
		studSkills.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studSkills.setForeground(new Color(255, 255, 255));
		studSkills.setBounds(55, 262, 46, 28);
		contentPane.add(studSkills);
		
		JLabel studDept = new JLabel("Department");
		studDept.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studDept.setForeground(new Color(255, 255, 255));
		studDept.setBounds(55, 312, 105, 28);
		contentPane.add(studDept);
		
		JLabel studCgpa = new JLabel("CGPA");
		studCgpa.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studCgpa.setForeground(new Color(255, 255, 255));
		studCgpa.setBounds(55, 362, 46, 28);
		contentPane.add(studCgpa);
		
		JLabel studPassyear = new JLabel("Passing year");
		studPassyear.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		studPassyear.setForeground(new Color(255, 255, 255));
		studPassyear.setBounds(55, 412, 105, 28);
		contentPane.add(studPassyear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 241, 571);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		name.setBounds(321, 112, 405, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		clgname = new JTextField();
		clgname.setBackground(new Color(255, 255, 255));
		clgname.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		clgname.setBounds(321, 162, 405, 28);
		contentPane.add(clgname);
		clgname.setColumns(10);
		
		phno = new JTextField();
		phno.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		phno.setBounds(321, 212, 405, 28);
		contentPane.add(phno);
		phno.setColumns(10);
		
		skills = new JTextField();
		skills.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		skills.setBounds(321, 262, 405, 28);
		contentPane.add(skills);
		skills.setColumns(10);
		
		dep = new JTextField();
		dep.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		dep.setBounds(321, 312, 405, 28);
		contentPane.add(dep);
		dep.setColumns(10);
		
		cgpa = new JTextField();
		cgpa.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		cgpa.setBounds(321, 362, 405, 28);
		contentPane.add(cgpa);
		cgpa.setColumns(10);
		
		year = new JTextField();
		year.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		year.setBounds(321, 412, 405, 28);
		contentPane.add(year);
		year.setColumns(10);
		
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
		submit.setBounds(615, 500, 111, 42);
		contentPane.add(submit);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		email.setBounds(321, 461, 405, 28);
		contentPane.add(email);
		//setUndecorated(true);
		setResizable(false);
		//connection setting
		CreateConnection c = new CreateConnection();
		Connection con = c.getConnection();
		//get all details for id
		try {
			String query = "SELECT STUD_NAME,STUD_EMAIL,STUD_CLG,STUD_PHNO,STUD_SKILLS,STUD_DEPT,STUD_CGPA,STUD_PASSYEAR FROM STUD_REG S,STUD_SKILL SS WHERE S.STUD_ID=SS.STUD_ID AND S.STUD_ID='"+id+"'";
			Statement s = con.createStatement();
			ResultSet set = s.executeQuery(query);
			if(set.next()) {
				Sname=set.getString(1);
				Email=set.getString(2);
				Sclgname=set.getString(3);
				Sphno=set.getString(4);
				Skills=set.getString(5);
				Dept=set.getString(6);
				CGPA=set.getString(7);
				passyear=set.getString(8);
				
				name.setText(Sname);
				email.setText(Email);
				clgname.setText(Sclgname);
				phno.setText(Sphno);
				skills.setText(Skills);
				dep.setText(Dept);
				cgpa.setText(CGPA);
				year.setText(passyear);
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace(); 
			System.exit(1);
		}
		
		//set all the date to respective fields
		
	}
	
	private void onSubmit() {
		if(phno.getText().length()!=10) {
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Invalid Phone number."); 
		}
		else if(!Email.contains("@")) {
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Invalid Email."); 
		}
		else{
			CreateConnection c = new CreateConnection();
			Connection con = c.getConnection();
			
			try {
				if(Sname.equals(name.getText()) && Email.equals(email.getText()) && Sclgname.equals(clgname.getText()) && Sphno.equals(phno.getText()) && Skills.equals(skills.getText()) && Dept.equals(dep.getText()) && CGPA.equals(cgpa.getText()) && passyear.equals(year.getText())) {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"No changes made");
				}
				else {
					Statement s = con.createStatement();
					String query = "UPDATE STUD_REG SET STUD_NAME=?,STUD_EMAIL=?,STUD_CLG=?,STUD_PHNO=?,STUD_DEPT=?,STUD_CGPA=?,STUD_PASSYEAR=? WHERE STUD_ID='"+id+"'";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1,name.getText());
					pstmt.setString(2,email.getText());
					pstmt.setString(3,clgname.getText());
					pstmt.setLong(4,Long.parseLong(phno.getText()));
					//pstmt.setString(5,skills.getText());
					pstmt.setString(5,dep.getText());
					pstmt.setFloat(6,Float.parseFloat(cgpa.getText()));
					pstmt.setInt(7,Integer.parseInt(year.getText()));
					pstmt.execute();
					String q = "UPDATE STUD_SKILL SET STUD_SKILLS=? WHERE STUD_ID='"+id+"'";
					PreparedStatement prstmt =con.prepareStatement(q);
					prstmt.setString(1,skills.getText());
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"changes made");
				}
				Studhomepage comp = new Studhomepage(id);
				comp.setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}catch(SQLException e) {
				e.printStackTrace(); 
				System.exit(1);
			}
		}
	}
}
