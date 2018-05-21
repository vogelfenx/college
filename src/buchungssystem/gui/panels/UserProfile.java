package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buchungssystem.gui.controller.LoginController;
import buchungssystem.gui.controller.MainMenuController;
import buchungssystem.models.roles.CurrentUser;

import javax.swing.JTextField;
import java.awt.Color;

public class UserProfile extends JPanel implements Observer {
	private JTextField loginName;
	private JPanel info;
	private JLabel loginNameLabel;
	
	/**
	 * Create the panel.
	 */
	public UserProfile() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		JLabel testLabel = new JLabel("USER PROFILEE");
		testLabel.setBounds(50, 50, 100, 100);
		add(testLabel, BorderLayout.NORTH);
		
		info = new JPanel();
		info.setBackground(Color.WHITE);
		add(info, BorderLayout.CENTER);
		info.setLayout(null);
		
		loginNameLabel = new JLabel("Benutzername");
		loginNameLabel.setBounds(12, 3, 82, 27);
		info.add(loginNameLabel);
		
		loginName = new JTextField();
		loginName.setBounds(129, 5, 99, 22);
		info.add(loginName);
		loginName.setEditable(false);
	}

	@Override
	public void update(Observable o, Object arg) {
		//disable all Components in Main Panel
		for (Component component : ((MainMenuController) o).getMainPane().getComponents()) {
			if ( component.getClass() != ((MainMenuController) o).getjPane().getClass() ) {
				component.setVisible(false);
			}
		}
		((MainMenuController) o).getjPane().setVisible(true);
	}

	public JTextField getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName.setText(loginName);
	}

	public JPanel getInfo() {
		return info;
	}

	public void setInfo(JPanel info) {
		this.info = info;
	}

	public JLabel getLoginNameLabel() {
		return loginNameLabel;
	}

	public void setLoginNameLabel(String loginNameLabel) {
		this.loginNameLabel.setText(loginNameLabel);
	}
	
	
}
