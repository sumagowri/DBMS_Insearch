import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.CreateConnection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Studhomepage extends JFrame {

	private JPanel contentPane;
	private JTextField searchtext;
	private JTable table;
	DefaultTableModel model;
	Object[] row;
	int id;
	int appId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studhomepage frame = new Studhomepage(0);
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
	public Studhomepage(int id) {
		this.id = id;
		//System.out.println(id);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logout = new JLabel("");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					dispose();
				} catch (Exception eE) {
					eE.printStackTrace();
				}
			}
		});
		logout.setBounds(28, 105, 20, 30);
		Image img = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		logout.setIcon(new ImageIcon(img));
		contentPane.add(logout);
		
		JLabel feedback = new JLabel("");
		feedback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onFeedback();
			}
		});
		feedback.setBounds(28, 160, 32, 32);
		Image img3 = new ImageIcon(this.getClass().getResource("/comment (1).png")).getImage();
		feedback.setIcon(new ImageIcon(img3));
		contentPane.add(feedback);
		
		
		
		searchtext = new JTextField();
		searchtext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) onTags();
			}
		});
		searchtext.setBounds(183, 81, 182, 20);
		contentPane.add(searchtext);
		searchtext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setBounds(132, 83, 53, 17);
		contentPane.add(lblNewLabel);
		
		JLabel edit = new JLabel("");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				onEdit();
			}
		});
		edit.setForeground(new Color(255, 255, 255));
		Image img1 = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		edit.setIcon(new ImageIcon(img1));
		edit.setBounds(28, 48, 20, 30);
		contentPane.add(edit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setBounds(0, 0, 77, 573);
		contentPane.add(lblNewLabel_1);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(122, 63, 762, 2);
		contentPane.add(separator);
		
		JLabel search = new JLabel("");
		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				onTags();
			}
		});
		search.setBounds(375, 81, 27, 20);
		Image img2 = new ImageIcon(this.getClass().getResource("/loupe.png")).getImage();
		search.setIcon(new ImageIcon(img2));
		contentPane.add(search);
		
		JLabel lblNewLabel_5 = new JLabel("Recommendations:");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_5.setBounds(132, 135, 216, 30);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(121, 173, 182, 2);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 197, 825, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=table.getSelectedRow();
				TableModel model = table.getModel();
				appId=Integer.parseInt(model.getValueAt(index, 0).toString());
				onClick();
			}
		});
		model=new DefaultTableModel();
		Object[] column= {"App_id","Company Name","Decription","Start date","End date","Skills req"};
		row= new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("HOME PAGE  FOR STUDENTS");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_2.setBounds(324, 22, 305, 30);
		contentPane.add(lblNewLabel_2);
	}
	public void onTags() {
		CreateConnection c = new CreateConnection();
		Connection con = c.getConnection();
		
		try {
			String query = "SELECT APP_ID,COMP_NAME,DESCRIPT,START_DATE,END_DATE,SKILLSREQ FROM INTERNSHIP I,COMP_REG C WHERE I.REG_ID=C.REG_ID AND I.SKILLSREQ=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,searchtext.getText());
			ResultSet rs = pstmt.executeQuery();
			
			searchtext.setText("");
			while(rs.next()) {
				//System.out.println(rs.getString(1));
				row[0]= rs.getInt(1);
				row[1]= rs.getString(2);
				row[2]= rs.getString(3);
				row[3]= rs.getDate(4).toString();
				row[4]= rs.getDate(5).toString();
				row[5]= rs.getString(6);
				model.addRow(row);
			}
			
			con.close();
			//model.addRow(row);
			//table.setModel(resultSetToTableModel(rs));
		}catch(SQLException e) {
			e.printStackTrace(); 
			System.exit(1);
		}
		
		//row=null;
	}
	public void onEdit() {
		try {
			EditStudent frame = new EditStudent(id);
			frame.setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick() {
		try {
			InternshipView frame = new InternshipView(appId,id);
			frame.setVisible(true);
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onFeedback() {
		try {
			Feedback frame = new Feedback(appId,id);
			frame.setVisible(true);
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
