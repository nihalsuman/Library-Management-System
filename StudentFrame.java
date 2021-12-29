package pkg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkg.db.DBConnector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfRoll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
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
	public StudentFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 431);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setForeground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(135, 52, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(135, 119, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		tfName = new JTextField();
		tfName.setBounds(214, 40, 377, 38);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfRoll = new JTextField();
		tfRoll.setBounds(212, 113, 379, 38);
		contentPane.add(tfRoll);
		tfRoll.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(430, 284, 102, -8);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VERIFY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText().toString();
				int roll = Integer.parseInt(tfRoll.getText().toString());
				
				verification(name, roll);
			}
		});
		btnNewButton_1.setBounds(478, 199, 113, 38);
		contentPane.add(btnNewButton_1);
	}

	protected void verification(String name, int roll) {
		DBConnector db=new DBConnector();
		Connection con=db.connect();
		String sql ="SELECT * FROM student WHERE roll_num = "+roll+ " AND name = '"+name+"'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql); 
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "verified");
			}
			else {
				JOptionPane.showMessageDialog(null, "not verified");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
