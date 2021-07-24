
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
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Internship extends JFrame {

	private JPanel contentPane;
	private JTextField END_DATE;
	private JTextField COM_REG;
	private JTextField SKILL;
	private JTextField STARTDATE;
	private JTextField DESCRIPTION;
	private JTextField slots;
	String Regid;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Internship frame = new Internship ("");
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
	public Internship(String Regid) {
		this.Regid=Regid;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSlots = new JLabel("Slots");
		lblSlots.setForeground(Color.WHITE);
		lblSlots.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblSlots.setBounds(55, 405, 99, 28);
		contentPane.add(lblSlots);
		
		JLabel RegasStud = new JLabel("Internship Details");
		RegasStud.setForeground(new Color(25, 25, 112));
		RegasStud.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		RegasStud.setHorizontalAlignment(SwingConstants.CENTER);
		RegasStud.setBounds(251, 11, 337, 42);
		contentPane.add(RegasStud);
		
		JLabel Com_reg1 = new JLabel("Registration ID");
		Com_reg1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Com_reg1.setForeground(new Color(255, 255, 255));
		Com_reg1.setBounds(55, 111, 159, 35);
		contentPane.add(Com_reg1);
		
		JLabel skill1 = new JLabel("Skill Required");
		skill1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		skill1.setForeground(new Color(255, 255, 255));
		skill1.setBounds(55, 166, 159, 28);
		contentPane.add(skill1);
		
		JLabel description1 = new JLabel("Description");
		description1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		description1.setForeground(new Color(255, 255, 255));
		description1.setBounds(55, 219, 105, 28);
		contentPane.add(description1);
		
		JLabel start1 = new JLabel("Start Date");
		start1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		start1.setForeground(new Color(255, 255, 255));
		start1.setBounds(55, 283, 141, 28);
		contentPane.add(start1);
		
		JLabel End1 = new JLabel("End Date");
		End1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		End1.setForeground(new Color(255, 255, 255));
		End1.setBounds(55, 343, 99, 28);
		contentPane.add(End1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 241, 571);
		contentPane.add(lblNewLabel);
		
		END_DATE = new JTextField();
		END_DATE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(END_DATE.getText().equals("dd-mm-yyyy")) {
					END_DATE.setText("");
					END_DATE.setForeground(new Color(0,0,0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(END_DATE.getText().equals("")) {
					END_DATE.setText("dd-mm-yyyy");
					END_DATE.setForeground(new Color(169,169,169));
				}
			}
		});
		END_DATE.setForeground(new Color(169, 169, 169));
		END_DATE.setText("dd-mm-yyyy");
		END_DATE.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		END_DATE.setBounds(309, 345, 405, 28);
		contentPane.add(END_DATE);
		END_DATE.setColumns(10);
		
		COM_REG = new JTextField();
		COM_REG.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		COM_REG.setBounds(309, 116, 405, 28);
		contentPane.add(COM_REG);
		COM_REG.setColumns(10);
		
		SKILL = new JTextField();
		SKILL.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		SKILL.setBounds(309, 168, 405, 28);
		contentPane.add(SKILL);
		SKILL.setColumns(10);
		
		STARTDATE = new JTextField();
		STARTDATE.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			if(STARTDATE.getText().equals("dd-mm-yyyy")) {
				STARTDATE.setText("");
				STARTDATE.setForeground(new Color(0,0,0));
			}
			}
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if(STARTDATE.getText().equals("")) {
					STARTDATE.setText("dd-mm-yyyy");
					STARTDATE.setForeground(new Color(169,169,169));
				}	
			}
		});
		STARTDATE.setForeground(new Color(169, 169, 169));
		STARTDATE.setText("dd-mm-yyyy");
		STARTDATE.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		STARTDATE.setBounds(309, 285, 405, 28);
		contentPane.add(STARTDATE);
		STARTDATE.setColumns(10);
		
		DESCRIPTION = new JTextField();
		DESCRIPTION.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		DESCRIPTION.setBounds(309, 221, 405, 28);
		contentPane.add(DESCRIPTION);
		DESCRIPTION.setColumns(10);
		
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
		submit.setBounds(619, 484, 111, 42);
		contentPane.add(submit);
		
		slots = new JTextField();
		slots.setColumns(10);
		slots.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(112, 128, 144)));
		slots.setBounds(309, 409, 405, 28);
		contentPane.add(slots);
		//setUndecorated(true);
		setResizable(false);
		
	}
	
	private void onSubmit() {
			//Date date=new SimpleDateFormat("DD-MM-YYYY").parse(STARTDATE.getText());
			CreateConnection c = new CreateConnection();
			Connection con = c.getConnection();
			
			try {
				Statement s = con.createStatement();
				String query = "INSERT INTO INTERNSHIP VALUES(APP_ID_VAL.NEXTVAL,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,DESCRIPTION.getText());
				pstmt.setString(2,SKILL.getText());
				String[] tdate=STARTDATE.getText().split("-");
				String[] edate = END_DATE.getText().split("-");
				pstmt.setDate(3,Date.valueOf(tdate[2]+"-"+tdate[1]+"-"+tdate[0]));
				pstmt.setDate(4,Date.valueOf(edate[2]+"-"+edate[1]+"-"+edate[0]));
				pstmt.setInt(5,Integer.parseInt(slots.getText()));
				pstmt.setString(6,COM_REG.getText());
				
				if(Regid.equals(COM_REG.getText())) {
					pstmt.execute();
					CompHomePage frame = new CompHomePage(Regid);
					frame.setVisible(true);
					dispose();
				}
				else {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"Enter a correct Registration ID");
				}
				con.close();
			}catch(SQLException e) {
				e.printStackTrace(); 
				System.exit(1);
			}
	}
}
