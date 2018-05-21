


import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Authorization {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Authorization");
		
		//get the screen size of a user and set the size of this frame relative to the screen size.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width/3, screenSize.height/3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//center this Frame
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.setLayout(new GridBagLayout());
		
		//componenets
		JLabel loginLbl = new JLabel("Login");
		JLabel passwdLbl = new JLabel("Password");
		
		JTextField login = new JTextField(frame.getSize().width/50);
		JPasswordField passwd = new JPasswordField(frame.getSize().width/50);
		
		JButton loginBtn = new JButton("login");
		JButton cancelBtn = new JButton("cancel");
		
		//okButton.setSize(frame.getSize().width/5, frame.getSize().height/5);
		
		frame.add(loginBtn);
		frame.add(cancelBtn);
		frame.add(login);
		frame.add(passwd);
		frame.setVisible(true);
	}
}
