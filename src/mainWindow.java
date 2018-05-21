

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import tests.Authorization;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;

public class mainWindow {

	private JFrame frmBuchungssystem;
	private JTextField login;
	Properties permissions;
	private Authorization session;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
		initAuthorizationPanel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuchungssystem = new JFrame();
		frmBuchungssystem.getContentPane().setBackground(Color.WHITE);
		frmBuchungssystem.setType(Type.UTILITY);
		frmBuchungssystem.setTitle("Buchungssystem");
		frmBuchungssystem.setBounds(100, 100, 450, 300);
		frmBuchungssystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuchungssystem.setVisible(true);
		
		session = new Authorization();
		permissions = session.getPermissions();
	}
	
	private void initAuthorizationPanel(){
		JPanel authorizationPanel = new JPanel();
		authorizationPanel.setBackground(Color.WHITE);
		frmBuchungssystem.getContentPane().add(authorizationPanel);
		
		login = new JTextField();
		login.setBounds(41, 5, 114, 20);
		login.setBackground(UIManager.getColor("Button.light"));
		login.setToolTipText("Ihre Login");
		login.setForeground(Color.GRAY);
		login.setFont(new Font("Dialog", Font.ITALIC, 12));
		login.setHorizontalAlignment(SwingConstants.LEFT);
		authorizationPanel.setLayout(null);
		authorizationPanel.add(login);
		login.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(160, 7, 58, 16);
		authorizationPanel.add(passwordLabel);
		
		password = new JPasswordField();
		password.setBounds(223, 5, 67, 20);
		password.setEditable(Boolean.valueOf(permissions.getProperty("write")));
		authorizationPanel.add(password);
		
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setBounds(0, 0, 31, 16);
		authorizationPanel.add(loginLabel);
	
	} 
}
