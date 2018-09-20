

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.PopupMenu;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tests.Authorization;

public class Application extends JFrame {

	private JPanel contentPane;
	
	private Authorization session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					
					//init Menu Form(Pane)
					
					Menu menu = new Menu();
					GridBagConstraints menuC = new GridBagConstraints(1, 
							GridBagConstraints.RELATIVE, 
							2, 1, 0.1, 1, 
							GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
							new Insets(0, 0, 0, 50), 0, 0);
					menu.setBorder(new LineBorder(Color.GRAY, 1, true));
				
					//init Login Form(Pane)
					Login login = new Login(); 
					
					GridBagConstraints loginC = new GridBagConstraints(GridBagConstraints.RELATIVE, 
							GridBagConstraints.RELATIVE, 
							1, 1, 1, 0, 
							GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
							new Insets(0, 0, 0, 0), 0, 0);
					
					
					//*//
					frame.add(menu, menuC);
					frame.add(login, loginC);
					
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
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//get the screen size of a user and set the size of this frame relative to the screen size.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		
		//center this Frame
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
		setContentPane(contentPane);
	
	}

	public Authorization getSession() {
		return session;
	}

	public void setSession(Authorization session) {
		this.session = session;
	}

}
