package buchungssystem.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import buchungssystem.gui.controller.LoginController;
import tests.Authorization;
import tests.login;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	
	private Authorization session;

	JLabel loginLabel;
	JLabel passwLabel;
	
	private JTextField loginField;
	JPasswordField passwordField;
	
	private JButton loginBtn;
	
	/**
	 * Create the panel.
	 */
	public Login() {
		loginLabel = new JLabel("Benutzer");
		passwLabel = new JLabel("Kennwort");
		
		setLoginField(new JTextField());
		passwordField = new JPasswordField();
		
		setLoginBtn(new JButton("Login in"));
		
		//set Listener
		LoginController loginController = new LoginController();
		setSession(loginController.loginBtn(loginBtn, this));
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 113, 320};
		setLayout(gridBagLayout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		//adding of login label
		c=new GridBagConstraints(1, 1, 1, 1, 0.1, 0.1, GridBagConstraints.EAST,
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 10, 10);
		add(loginLabel, c);
		
		//adding of login field
		c = new GridBagConstraints(2, 1, 1, 1, 0.1, 0.1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0);
		add(getLoginField(), c);
		
		//adding of password Field
		c = new GridBagConstraints(2, 2, 1, 1, 0.1, 0.1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0);
				
		add(passwordField, c);
		
		//adding of password Label
		c = new GridBagConstraints(1, 2, 1, 1, 0.1, 0.1, GridBagConstraints.EAST, 
				GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0);
		
		add(passwLabel, c);
		
		//adding of login button
		c = new GridBagConstraints(2, 3, 1, 1, 0.1, 0.1, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0);
		
		add(getLoginBtn(), c);
		
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}

	public Authorization getSession() {
		return session;
	}

	public void setSession(Authorization session) {
		this.session = session;
	}

	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public void setLoginLabel(JLabel loginLabel) {
		this.loginLabel = loginLabel;
	}

	public JLabel getPasswLabel() {
		return passwLabel;
	}

	public void setPasswLabel(JLabel passwLabel) {
		this.passwLabel = passwLabel;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	

}
