package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import buchungssystem.gui.controller.LoginController;
import buchungssystem.gui.controller.MainMenuController;
import tests.Authorization;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.CardLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static Font fontBtn;
	private JButton backBtn;
	private JPanel menu;
	private JButton profileBtn;
	private JPanel header;
	private JButton employeeBtn;
	private JButton kundenBtn;
	private JPanel userProfile;
	private JPanel employeePane;
	private JPanel main;
	private JPanel userLoginPane;
	private JButton warenBtn;
	private Component verticalStrut;
	public static Thread thread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		/*
		 * 
		 * Creating & defining of parameters of the contentPanel and of the MainFrame
		 * 
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//get the screen size of a user and set the size of this frame relative to the screen size.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		
		//center this Frame and fix it
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 5));
		
		//styles variable
		fontBtn = new Font("Arial", Font.PLAIN, 20);
		
		/*
		 * Definition of 4 panels(top, left, bottom, right) according to BorderLayout
		 * |	header   |
		 * | menu |	main |
		 * |	footer   |
		 * 
		 */
		
		header = new JPanel();
		header.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 5));
		
		backBtn = new JButton("Zur\u00FCck");
		header.add(backBtn);
		backBtn.setBackground(Color.LIGHT_GRAY);         
		backBtn.setForeground(Color.BLACK);              
		backBtn.setMaximumSize(new Dimension(250, 50));  
		backBtn.setFont(fontBtn);                        
		backBtn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		menu = new JPanel();
		contentPane.add(menu, BorderLayout.WEST);
		menu.setForeground(Color.BLACK);
		menu.setBorder(new LineBorder(Color.ORANGE, 1, true));
		menu.setBackground(Color.WHITE);
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		
		//Creating controller of for a buttons in menu
		//mainMenuController mainMenuController = new mainMenuController();
		
		//Creating of a Box and adding Buttons into it
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Creating of an invisible component that's specified a size(X_AXIS) of the box
		menu.add(Box.createRigidArea(new Dimension(300, 0)));
		
		profileBtn = new JButton("User Profile");
		MainMenuController mainMenuControllerUserProfile = new MainMenuController();
		profileBtn.addActionListener(mainMenuControllerUserProfile);
		box.add(Box.createVerticalStrut(20));
		box.add(profileBtn);
		
		employeeBtn = new JButton("Mitarbeiter");
		MainMenuController mainMenuControllerEmployee = new MainMenuController();
 		employeeBtn.addActionListener(mainMenuControllerEmployee);
		box.add(Box.createVerticalStrut(10));
		box.add(employeeBtn);
		
		kundenBtn = new JButton("Kunden"); 
		//kundenBtn.addActionListener(mainMenuController);
		box.add(Box.createVerticalStrut(10));
		box.add(kundenBtn);
		
		verticalStrut = Box.createVerticalStrut(10);
		box.add(verticalStrut);
		
		warenBtn = new JButton("Waren");
		box.add(warenBtn);
		
		//adding of the box to menu Panel
		menu.add(box);
		
		//specifying of styles of all buttons in the box 
		for (Component c : box.getComponents()) {
			if (c.getClass().equals(JButton.class)) {
				c.setBackground(Color.LIGHT_GRAY);
				c.setForeground(Color.BLACK);
				c.setMaximumSize(new Dimension(250, 50));
				c.setFont(fontBtn);
				c.setEnabled(false);
				((JButton) c).setAlignmentX(Component.CENTER_ALIGNMENT);
			}
		}
		
		main = new JPanel();
		main.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.DARK_GRAY));
		contentPane.add(main, BorderLayout.CENTER);
		main.setBackground(Color.WHITE);
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		
		//adding of userLogin panel to Main Panel
		//UserLogin userLogin = new UserLogin(fontBtn, this);
		//userLoginPane = userLogin.init();
		userLoginPane = new UserLogin(fontBtn, this);
		main.add(userLoginPane);
		
		//adding of Employee panel to Main panel
		employeePane = new Employee();
		employeePane.setVisible(false);
		main.add(employeePane);
		mainMenuControllerEmployee.init(employeePane, this.getMain(), this);
		
		//TODO add to separate class
		userProfile = new UserProfile();
		main.add(userProfile);
		userProfile.setVisible(false);
		userProfile.setBackground(Color.WHITE);
		mainMenuControllerUserProfile.init(userProfile, this.getMain(), this);
		
		JPanel footer = new JPanel();
		footer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Warensystem@2018", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		contentPane.add(footer, BorderLayout.SOUTH);
		
		thread = new Thread((Runnable) employeePane);
		
	}
	
	public static void popupWindow(String messageText, int x, int y, Color textColor) {
		JDialog message = new JDialog();
		message.getContentPane().setLayout(new BorderLayout());
		
		JLabel messageLabel = new JLabel(messageText);
		messageLabel.setFont(MainFrame.fontBtn);
		messageLabel.setForeground(textColor);
		messageLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		message.getContentPane().add(messageLabel, BorderLayout.CENTER);
		message.setSize(x, y);
		message.setLocationRelativeTo(null);
		message.setVisible(true);
	}

	public JButton getProfileBtn() {
		return profileBtn;
	}

	public void setProfileBtn(JButton profileBtn) {
		this.profileBtn = profileBtn;
	}

	public Font getFontBtn() {
		return fontBtn;
	}

	public void setFontBtn(Font fontBtn) {
		this.fontBtn = fontBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JPanel getMenu() {
		return menu;
	}

	public void setMenu(JPanel menu) {
		this.menu = menu;
	}

	public JPanel getHeader() {
		return header;
	}

	public void setHeader(JPanel header) {
		this.header = header;
	}

	public JButton getEmployeeBtn() {
		return employeeBtn;
	}

	public void setEmployeeBtn(JButton employeeBtn) {
		this.employeeBtn = employeeBtn;
	}

	public JButton getKundenBtn() {
		return kundenBtn;
	}

	public void setKundenBtn(JButton kundenBtn) {
		this.kundenBtn = kundenBtn;
	}

	public JPanel getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(JPanel userProfile) {
		this.userProfile = userProfile;
	}

	public JPanel getMain() {
		return main;
	}

	public void setMain(JPanel main) {
		this.main = main;
	}

	public JPanel getUserLoginPane() {
		return userLoginPane;
	}

	public void setUserLoginPane(JPanel userLoginPane) {
		this.userLoginPane = userLoginPane;
	}

	public JPanel getEmployeePane() {
		return employeePane;
	}

	public void setEmployeePane(JPanel employeePane) {
		this.employeePane = employeePane;
	}

	public JButton getWarenBtn() {
		return warenBtn;
	}

	public void setWarenBtn(JButton warenBtn) {
		this.warenBtn = warenBtn;
	}
	
	
}
