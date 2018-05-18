package buchungssystem.gui;

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
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserLogin extends JPanel  {
	
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
		
		init();
	}
	
	public JPanel init() {
		textSize = new Dimension(200, 50);
		
		JPanel userLogin = new JPanel();
		userLogin.setBackground(Color.WHITE);
		userLogin.setLayout(null);
		
		JLabel loginLabel = new JLabel("Benutzername");
		loginLabel.setFont(fontBtn);
		loginLabel.setSize(textSize);
		loginLabel.setBounds(350, 200, textSize.width, textSize.height);
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLogin.add(loginLabel);
		
		JLabel passwLabel = new JLabel("Kennwort");
		passwLabel.setFont(fontBtn);
		passwLabel.setSize(textSize);
		passwLabel.setBounds(350, 260, textSize.width, textSize.height);
		passwLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLogin.add(passwLabel);
		
		loginField = new JTextField();
		loginField.setHorizontalAlignment(SwingConstants.CENTER);
		loginField.setFont(fontBtn);
		loginField.setSize(textSize);
		loginField.setBounds(550, 200, textSize.width, textSize.height);
		userLogin.add(loginField);
		
		passwField = new JPasswordField();
		passwField.setHorizontalAlignment(SwingConstants.CENTER);
		passwField.setFont(fontBtn);
		passwField.setSize(textSize);
		passwField.setBounds(550, 260, textSize.width, textSize.height);
		userLogin.add(passwField);
		
		anmeldenBtn = new JButton("Anmelden");
		anmeldenBtn.setHorizontalAlignment(SwingConstants.CENTER);
		anmeldenBtn.setFont(fontBtn);
		anmeldenBtn.setSize(textSize);
		anmeldenBtn.setBounds(500, 350, textSize.width, textSize.height);
		userLogin.add(anmeldenBtn);
		
		LoginController loginController = new LoginController(anmeldenBtn, this);
		anmeldenBtn.addActionListener(loginController);
		anmeldenBtn.addKeyListener(loginController);
		
		
		return userLogin;
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
