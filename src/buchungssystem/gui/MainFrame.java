package buchungssystem.gui;

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
import tests.Authorization;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	protected Font fontBtn;
	private JButton backBtn;
	private JPanel menu;
	private JButton profileBtn;
	private JPanel header;
	private JButton mitarbeiterBtn;
	private JButton kundenBtn;

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
		
		//Creating of a Box and adding Buttons into it
		Box box = Box.createVerticalBox();
		box.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Creating of an invisible component that's specified a size(X_AXIS) of the box
		menu.add(Box.createRigidArea(new Dimension(300, 0)));
		
		setProfileBtn(new JButton("User Profile"));
		box.add(Box.createVerticalStrut(20));
		box.add(getProfileBtn());
		
		mitarbeiterBtn = new JButton("Mitarbeiter");
		box.add(Box.createVerticalStrut(10));
		box.add(mitarbeiterBtn);
		
		kundenBtn = new JButton("Kunden");
		box.add(Box.createVerticalStrut(10));
		box.add(kundenBtn);
		
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
		
		//adding of the box to menu Panel
		menu.add(box);
		
		JPanel main = new JPanel();
		main.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.DARK_GRAY));
		contentPane.add(main, BorderLayout.CENTER);
		main.setBackground(Color.WHITE);
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
		
		//TODO add to separate class
		JPanel userProfile = new JPanel();
		userProfile.setVisible(false);
		userProfile.setBackground(Color.WHITE);
		userProfile.setLayout(null);
		main.add(userProfile);
		
		//adding of Login Panel to main Panel
		UserLogin UserLogin = new UserLogin(fontBtn, this);
		JPanel UserLoginPane =UserLogin.init();
		main.add(UserLoginPane);
		


		
		JPanel footer = new JPanel();
		footer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "@2018", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		contentPane.add(footer, BorderLayout.SOUTH);
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

	public JButton getMitarbeiterBtn() {
		return mitarbeiterBtn;
	}

	public void setMitarbeiterBtn(JButton mitarbeiterBtn) {
		this.mitarbeiterBtn = mitarbeiterBtn;
	}

	public JButton getKundenBtn() {
		return kundenBtn;
	}

	public void setKundenBtn(JButton kundenBtn) {
		this.kundenBtn = kundenBtn;
	}
	
}
