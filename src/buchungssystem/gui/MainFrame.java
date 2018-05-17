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
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

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
		Font fontBtn = new Font("Arial", Font.PLAIN, 20);
		
		/*
		 * Definition of 4 panels(top, left, bottom, right) according to BorderLayout
		 * |	header   |
		 * | menu |	main |
		 * |	footer   |
		 * 
		 */
		
		JPanel header = new JPanel();
		header.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new FlowLayout(FlowLayout.LEADING, 25, 5));
		
		JButton backBtn = new JButton("Zur\u00FCck");
		header.add(backBtn);
		backBtn.setBackground(Color.LIGHT_GRAY);         
		backBtn.setForeground(Color.BLACK);              
		backBtn.setMaximumSize(new Dimension(250, 50));  
		backBtn.setFont(fontBtn);                        
		backBtn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		JPanel menu = new JPanel();
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
		
		JButton profileBtn = new JButton("User Profile");
		box.add(Box.createVerticalStrut(20));
		box.add(profileBtn);
		
		JButton mitarbeiterBtn = new JButton("Mitarbeiter");
		box.add(Box.createVerticalStrut(10));
		box.add(mitarbeiterBtn);
		
		JButton kundenBtn = new JButton("Kunden");
		box.add(Box.createVerticalStrut(10));
		box.add(kundenBtn);
		
		//specifying of styles of all buttons in the box 
		for (Component c : box.getComponents()) {
			if (c.getClass().equals(JButton.class)) {
				c.setBackground(Color.LIGHT_GRAY);
				c.setForeground(Color.BLACK);
				c.setMaximumSize(new Dimension(250, 50));
				c.setFont(fontBtn);
				((JButton) c).setAlignmentX(Component.CENTER_ALIGNMENT);
			}
		}
		
		//box adding to menu Pane
		menu.add(box);
		
		JPanel main = new JPanel();
		main.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.DARK_GRAY));
		contentPane.add(main, BorderLayout.CENTER);
		main.setBackground(Color.WHITE);
		main.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JPanel userProfile = new JPanel();
		main.add(userProfile);
		
		JPanel footer = new JPanel();
		footer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "@2018", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		contentPane.add(footer, BorderLayout.SOUTH);
	}
}
