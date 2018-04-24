package buchungssystem.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GlobalGui {
	
	private JFrame frame;
	private JTextField textField;
	
	public GlobalGui(boolean isAuthorized){
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Test");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(isAuthorized);
		panel.add(textField);
		textField.setColumns(10);
	}

}
	

