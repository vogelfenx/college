package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buchungssystem.models.employee.Employee;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstName;
	private JTextField nachName;
	private JTextField email;

	/**
	 * Create the dialog.
	 * @param employee 
	 */
	public AddEmployeeDialog(buchungssystem.gui.panels.Employee parent) {
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel firstNameLabel = new JLabel("Vorname");
			firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			firstNameLabel.setBounds(80, 128, 102, 16);
			contentPanel.add(firstNameLabel);
		}
		{
			JLabel nachNameLabel = new JLabel("Nachname");
			nachNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nachNameLabel.setBounds(80, 177, 102, 16);
			contentPanel.add(nachNameLabel);
		}
		{
			JLabel emailLabel = new JLabel("Email");
			emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			emailLabel.setBounds(80, 225, 102, 16);
			contentPanel.add(emailLabel);
		}
		{
			firstName = new JTextField();
			firstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			firstName.setBounds(208, 121, 171, 31);
			contentPanel.add(firstName);
			firstName.setColumns(10);
		}
		{
			nachName = new JTextField();
			nachName.setFont(new Font("Tahoma", Font.PLAIN, 20));
			nachName.setColumns(10);
			nachName.setBounds(208, 170, 171, 31);
			contentPanel.add(nachName);
		}
		{
			email = new JTextField();
			email.setFont(new Font("Tahoma", Font.PLAIN, 20));
			email.setColumns(10);
			email.setBounds(208, 214, 171, 31);
			contentPanel.add(email);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					private boolean retrunCode;

					public void actionPerformed(ActionEvent e) {
						if (!getFirstName().getText().equals("") && !getNachName().getText().equals("") && !getEmail().getText().equals("")) {
							Employee employee = new Employee();
							employee.setFirstName(getFirstName().getText());
							employee.setLastName(getNachName().getText());
							employee.setEmail(getEmail().getText());
							
							retrunCode = Authorization.getCurrentUser().addEmployeeToDB(employee.getFirstName(), employee.getLastName(), employee.getEmail());
							
							//set AddEmployeeDialog Window invisible
							setVisible(false);
							
							if (retrunCode == true) {
								MainFrame.popupWindow("Mitarbeiter erfolgreich erstellt", 300, 100, Color.RED);
							} else {
								MainFrame.popupWindow("Mitarbeiter existiert bereits", 300, 100, Color.RED);
							}
							
							//refresh the Table
							//MainFrame.thread.start();
							parent.initTable();
							parent.getEmployeeTableModel().fireTableDataChanged();
							
							
						} else {
							MainFrame.popupWindow("Bitte alle Felder ausfüllen", 300, 100, Color.RED);
						}
					}
					
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}

	public JTextField getNachName() {
		return nachName;
	}

	public void setNachName(JTextField nachName) {
		this.nachName = nachName;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}
	
}
