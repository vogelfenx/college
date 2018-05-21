package buchungssystem.gui.controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import buchungssystem.gui.panels.UserLogin;
import buchungssystem.gui.panels.UserProfile;
import buchungssystem.models.application.User;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;

public class LoginController implements Observer, ActionListener, KeyListener {
	
	/*
	 * Checking if user exists or not
	 */
	
	public static Authorization session;
	JButton anmeldenBtn;
	UserLogin userLogin;

	User user;
	
	public LoginController(JButton anmeldenBtn, UserLogin userLogin) {
		this.anmeldenBtn = anmeldenBtn;
		this.userLogin = userLogin;
	}
	
	//The 'anmelden' button is invoke
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
	
	/*
	 * If observable model object was changed -> perform this statement
	 * Observable object is Model.java and User.java in buchungssystem.models 
	 */
	@Override
	public void update(Observable model, Object arg) {
		userLogin.getParentPane().getProfileBtn().setEnabled(true);
		
		//userLogin.getParentPane().getUserLoginPane().setVisible(false);
		userLogin.getParentPane().getMain().remove(userLogin.getParentPane().getUserLoginPane());
		userLogin.getParentPane().getMain().repaint();
		
		userLogin.getParentPane().getUserProfile().setVisible(true);
		
		userLogin.getParentPane().getProfileBtn().setBackground(Color.blue);
		userLogin.getParentPane().getProfileBtn().setForeground(Color.WHITE);
		
		//check permissions of a Current User 
		if ( Boolean.valueOf(session.getPermissions().getProperty("readCustomerTable")) ) {
			userLogin.getParentPane().getKundenBtn().setEnabled(true);
		}
		
		if ( Boolean.valueOf(session.getPermissions().getProperty("readEmployeeTable")) ) {
			userLogin.getParentPane().getEmployeeBtn().setEnabled(true);
		}
		
		//HIER KANN ICH User Profile befüllen
		UserProfile userProfile = (UserProfile) userLogin.getParentPane().getUserProfile();
		userProfile.setLoginName(user.getLogin());
		
	}

	/*
	 *Actions was performed 
	 */
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
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	/*
	 *getters & setters 
	 */
	public void setSession(Authorization session) {
		this.session = session;
	}

	public Authorization getSession() {
		return session;
	}
	
}
