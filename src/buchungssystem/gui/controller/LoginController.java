package buchungssystem.gui.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buchungssystem.gui.Login;
import buchungssystem.gui.Menu;
import buchungssystem.gui.UserLogin;
import buchungssystem.models.application.User;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;

public class LoginController implements Observer, ActionListener, KeyListener {
	
	Authorization session;
	JButton anmeldenBtn;
	UserLogin userLogin;
	User user;
	
	public LoginController(JButton anmeldenBtn, UserLogin userLogin) {
		this.anmeldenBtn = anmeldenBtn;
		this.userLogin = userLogin;
	}
	
	//if observable model object changed -> perform this statement   
	@Override
	public void update(Observable model, Object arg) {
		userLogin.getParentPane().getProfileBtn().setEnabled(true);
		
		userLogin.getParentPane().getUserLoginPane().setVisible(false);
		userLogin.getParentPane().getUserProfile().setVisible(true);
		JLabel testLabel = new JLabel("USER PROFILE");
		testLabel.setBounds(50, 50, 100, 100);
		userLogin.getParentPane().getUserProfile().add(testLabel);
		userLogin.getParentPane().getProfileBtn().setBackground(Color.blue);
		userLogin.getParentPane().getProfileBtn().setForeground(Color.WHITE);
		
		//check permissions of a Current User 
		if ( Boolean.valueOf(session.getPermissions().getProperty("readCustomerTable")) ) {
			userLogin.getParentPane().getKundenBtn().setEnabled(true);
		}
		
		if ( Boolean.valueOf(session.getPermissions().getProperty("readEmployeeTable")) ) {
			userLogin.getParentPane().getMitarbeiterBtn().setEnabled(true);
		}
		
	}

	public void setSession(Authorization session) {
		//observable was changed
		this.session = session;
	}

	public Authorization getSession() {
		return session;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buttonIsInvoke();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_ENTER) {
			buttonIsInvoke();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	//check if user exists or not
	private void buttonIsInvoke() {
		session = new Authorization(userLogin.getLoginField().getText(), new String(userLogin.getPasswordField().getPassword()));	
		user = session.getUser();
		if (user == null) {
			System.out.println("Password oder Login ist falsch");
		} else {
			user.addObserver(this);
			user.notifyObservers();
		}
	}
	
}
