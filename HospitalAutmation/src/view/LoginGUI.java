package view;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Bashekim;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import helper.*;
public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField txtOlol;
	private JTextField txtElcin;
	private JTextField fld_doctortc;
	private JPasswordField fld_doctorpass;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);
	
	    
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("Plus.png")));
		lbl_logo.setBounds(177, 0, 65, 58);
		w_pane.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("Xəstəxana İdarəetmə Sisteminə Xoş gəlmisiniz !");
		lblNewLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 58, 311, 28);
		w_pane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 86, 414, 164);
		w_pane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Xəstə qeydiyyatı", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblTcNmrniz = new JLabel("T.C. Nömrəniz:");
		lblTcNmrniz.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblTcNmrniz.setBounds(17, 23, 107, 28);
		panel.add(lblTcNmrniz);
		
		JLabel lblifr = new JLabel("Şifrə:");
		lblifr.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblifr.setBounds(17, 61, 92, 28);
		panel.add(lblifr);
		
		txtOlol = new JTextField();
		txtOlol.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		txtOlol.setBounds(133, 23, 243, 20);
		panel.add(txtOlol);
		txtOlol.setColumns(10);
		
		txtElcin = new JTextField();
		txtElcin.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		txtElcin.setColumns(10);
		txtElcin.setBounds(133, 61, 243, 20);
		panel.add(txtElcin);
		
		JButton btn_register = new JButton("Qeydiyyatdan keçin");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_register.setBounds(48, 91, 150, 34);
		panel.add(btn_register);
		
		JButton btn_xestelogin = new JButton("Daxil olun");
		btn_xestelogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_xestelogin.setBounds(209, 91, 150, 34);
		panel.add(btn_xestelogin);
		
		JPanel w_doctorlogin = new JPanel();
		w_doctorlogin.setBackground(Color.WHITE);
		tabbedPane.addTab("Doktor Girişi", null, w_doctorlogin, null);
		w_doctorlogin.setLayout(null);
		
		JLabel lblTcNmrniz_1 = new JLabel("T.C. Nömrəniz:");
		lblTcNmrniz_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblTcNmrniz_1.setBounds(21, 25, 107, 28);
		w_doctorlogin.add(lblTcNmrniz_1);
		
		fld_doctortc = new JTextField();
		fld_doctortc.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		fld_doctortc.setColumns(10);
		fld_doctortc.setBounds(138, 24, 243, 20);
		w_doctorlogin.add(fld_doctortc);
		
		JLabel lblifr_1 = new JLabel("Şifrə:");
		lblifr_1.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		lblifr_1.setBounds(21, 62, 92, 28);
		w_doctorlogin.add(lblifr_1);
		
		JButton btn_doctorlogin = new JButton("Daxil olun");
		btn_doctorlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(fld_doctortc.getText().length() == 0 || fld_doctorpass.getText().length() == 0)  {
				Helper.showingMsg("fill");
				
			}else {
					
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT + FROM user");
					    while(rs.next()) {
					    	if(fld_doctortc.getText().equals(rs.getString("Tcno")) && fld_doctorpass.getText().equals(rs.getString("Password"))) {
					    		Bashekim bhekim = new Bashekim();
					    		bhekim.setID(rs.getInt("ID"));
					    		bhekim.setPassword("Password");
					    		bhekim.setName(rs.getString("Name"));
					    		bhekim.setTcno(rs.getString("Tcno"));
					    		bhekim.setType(rs.getString("Type"));
					    	    System.out.println(bhekim.getName());
					    	}
					    }
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					}
			}
					
		});
		btn_doctorlogin.setBounds(21, 92, 360, 34);
		w_doctorlogin.add(btn_doctorlogin);
		
		fld_doctorpass = new JPasswordField();
		fld_doctorpass.setBounds(138, 62, 243, 20);
		w_doctorlogin.add(fld_doctorpass);
		
		 
	}
}
