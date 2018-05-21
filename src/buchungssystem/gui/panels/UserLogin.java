package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.GroupLayout.Alignment;

import buchungssystem.gui.controller.LoginController;
import buchungssystem.models.application.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class UserLogin extends JPanel {
	
	/**
	 * Create the panel.
	 */
	
	Font fontBtn;
	Dimension textSize;
	JTextField loginField;
	JPasswordField passwField;
	MainFrame parentPane;
	JButton anmeldenBtn;
	
	public UserLogin(Font fontBtn, MainFrame parentPane) {
		this.fontBtn = fontBtn;
		this.parentPane = parentPane;
		
		//initialize the userLogin Panel
		init();
	}
	
	//public JPanel init() {
	public void init() {
		
		/*
		 * adding Components to the userLogin Panel
		 */
		
		
		textSize = new Dimension(200, 50);
		
		//JPanel userLogin = new JPanel();
		//userLogin.
		setBackground(Color.WHITE);
		//userLogin.
		setLayout(null);
		
		JPanel registrationPanel = new JPanel();
		registrationPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Anmeldung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		registrationPanel.setBounds(344, 182, 424, 225);
		//userLogin.
		add(registrationPanel);
		registrationPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("Benutzername");
		loginLabel.setBounds(6, 18, 200, 50);
		registrationPanel.add(loginLabel);
		loginLabel.setFont(fontBtn);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel passwLabel = new JLabel("Kennwort");
		passwLabel.setBounds(6, 78, 200, 50);
		registrationPanel.add(passwLabel);
		passwLabel.setFont(fontBtn);
		passwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginField = new JTextField();
		loginField.setBounds(206, 18, 200, 50);
		registrationPanel.add(loginField);
		loginField.setHorizontalAlignment(SwingConstants.CENTER);
		loginField.setFont(fontBtn);
		
		passwField = new JPasswordField();
		passwField.setBounds(206, 78, 200, 50);
		registrationPanel.add(passwField);
		passwField.setHorizontalAlignment(SwingConstants.CENTER);
		passwField.setFont(fontBtn);
		
		anmeldenBtn = new JButton("Anmelden");
		anmeldenBtn.setBounds(128, 162, 200, 50);
		registrationPanel.add(anmeldenBtn);
		anmeldenBtn.setHorizontalAlignment(SwingConstants.CENTER);
		anmeldenBtn.setFont(fontBtn);
		
		/*
		 * Adding controllers to elements
		 */
		
		LoginController loginController = new LoginController(anmeldenBtn, this);
		anmeldenBtn.addActionListener(loginController);
		anmeldenBtn.addKeyListener(loginController);
		passwField.addKeyListener(loginController);
		
		
		//return userLogin;
	}

	public JPasswordField getPasswordField() {
		return passwField;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public Font getFontBtn() {
		return fontBtn;
	}

	public void setFontBtn(Font fontBtn) {
		this.fontBtn = fontBtn;
	}

	public Dimension getTextSize() {
		return textSize;
	}

	public void setTextSize(Dimension textSize) {
		this.textSize = textSize;
	}

	public JPasswordField getPasswField() {
		return passwField;
	}

	public void setPasswField(JPasswordField passwField) {
		this.passwField = passwField;
	}

	public MainFrame getParentPane() {
		return parentPane;
	}

	public void setParentPane(MainFrame parentPane) {
		this.parentPane = parentPane;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}
	

}
