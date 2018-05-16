package buchungssystem.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buchungssystem.gui.Login;
import buchungssystem.gui.Menu;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;

public class LoginController {
	
	Authorization session;
	
	public LoginController() {
		
	}
	
	public Authorization loginBtn(JButton loginBtn, Login login) {
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			session = new Authorization(login.getLoginField().getText(), new String(login.getPasswordField().getPassword()));
			
			
			CurrentUser currentUser = session.getCurrentUser();
			
			if (currentUser.getLogin() != null) {
				loginBtn.setEnabled(false);
				login.revalidate();
				login.repaint();
			}
			
//			if (session.getPermissions().getProperty("addUser") == "true") {
//				System.out.println("tescht");
//		
//			}
			}
		});
		return session;
	}

}
