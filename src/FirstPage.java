import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class FirstPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage frame = new FirstPage();
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
	public FirstPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton registerstud = new JButton("Register student");
		registerstud.setFont(new Font("Times New Roman", Font.BOLD, 17));
		registerstud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					RegisterStudent frame = new RegisterStudent();
					frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		registerstud.setBounds(272, 177, 179, 29);
		contentPane.add(registerstud);
		
		JButton registercomp = new JButton("Register company");
		registercomp.setFont(new Font("Times New Roman", Font.BOLD, 17));
		registercomp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					RegisterComp frame = new RegisterComp();
					frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		registercomp.setBounds(272, 232, 179, 29);
		contentPane.add(registercomp);
		
		JButton loginstud = new JButton("Login student");
		loginstud.setFont(new Font("Times New Roman", Font.BOLD, 17));
		loginstud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		loginstud.setBounds(272, 304, 179, 29);
		contentPane.add(loginstud);
		
		JButton logincomp = new JButton("Login Company");
		logincomp.setFont(new Font("Times New Roman", Font.BOLD, 17));
		logincomp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					LoginComp window = new LoginComp();
					window.frame.setVisible(true);
					dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		logincomp.setBounds(272, 368, 179, 29);
		contentPane.add(logincomp);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO INSEARCH");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel.setBounds(229, 53, 288, 37);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(162, 113, 454, 2);
		contentPane.add(separator);
	}
}
