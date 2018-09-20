

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel {

	JButton userProfileBtn;
	
	JButton kundenBtn;
	
	JButton mitarbeiterBtn;
	
	/**
	 * Create the panel.
	 */
	public Menu() {
		
		//setLayout(new GridLayout(0, 1, 0, 50));
		
		userProfileBtn = new JButton("User Profile");
		kundenBtn = new JButton("Kunden");
		mitarbeiterBtn = new JButton("Mitarbeiter");
		
		userProfileBtn.setAlignmentX(CENTER_ALIGNMENT);
		kundenBtn.setAlignmentX(CENTER_ALIGNMENT);
		mitarbeiterBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		userProfileBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		kundenBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		mitarbeiterBtn.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//set new Size of Buttons
		userProfileBtn.setMaximumSize(new Dimension(250, 50));
		userProfileBtn.setPreferredSize(userProfileBtn.getMaximumSize());
		
		kundenBtn.setMaximumSize(new Dimension(250, 50));           
		kundenBtn.setPreferredSize(kundenBtn.getMaximumSize());
		
		mitarbeiterBtn.setMaximumSize(new Dimension(250, 50));           
		mitarbeiterBtn.setPreferredSize(mitarbeiterBtn.getMaximumSize());
		
		userProfileBtn.setEnabled(false);
		mitarbeiterBtn.setEnabled(false);
		kundenBtn.setEnabled(false);
		
		Box box = Box.createVerticalBox();
		
		box.add(Box.createVerticalStrut(20));
		box.add(userProfileBtn);
		box.add(Box.createVerticalStrut(20));
		box.add(kundenBtn);
		box.add(Box.createVerticalStrut(20));
		box.add(mitarbeiterBtn);
		box.add(Box.createVerticalStrut(20));
		
		add(box);
		
//		add(userProfileBtn);
//		add(kundenBtn);
//		add(mitarbeiterBtn);
		
	}

	public JButton getUserProfileBtn() {
		return userProfileBtn;
	}

	public void setUserProfileBtn(JButton userProfileBtn) {
		this.userProfileBtn = userProfileBtn;
	}

	public JButton getKundenBtn() {
		return kundenBtn;
	}

	public void setKundenBtn(JButton kundenBtn) {
		this.kundenBtn = kundenBtn;
	}

	public JButton getMitarbeiterBtn() {
		return mitarbeiterBtn;
	}

	public void setMitarbeiterBtn(JButton mitarbeiterBtn) {
		this.mitarbeiterBtn = mitarbeiterBtn;
	}
	
	

}
