package pkg.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntroFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroFrame frame = new IntroFrame();
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
	public IntroFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\images.jpg"));
		setForeground(new Color(0, 191, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 395);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To The Management System");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 25));
		lblNewLabel.setBounds(86, 22, 445, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NEXT");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\pexels-janko-ferlic-590493 (2).jpg"));
		lblNewLabel_1.setBounds(179, 78, 220, 196);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to move to the next frame
				StudentFrame sf = new StudentFrame();
				sf.setVisible(true);
				IntroFrame.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(496, 306, 89, 23);
		contentPane.add(btnNewButton);
	}
}
