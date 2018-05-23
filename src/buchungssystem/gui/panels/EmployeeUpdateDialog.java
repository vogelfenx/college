package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tests.Authorization;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeUpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JTextField telefonField;
	private Long employeeID;

	/**
	 * Create the dialog.
	 */
	public EmployeeUpdateDialog(Employee parent) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel vorNameLbl = new JLabel("Vorname*");
			vorNameLbl.setHorizontalAlignment(SwingConstants.TRAILING);
			vorNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
			vorNameLbl.setBounds(30, 32, 100, 25);
			contentPanel.add(vorNameLbl);
		}
		
		JLabel lblNachname = new JLabel("Nachname*");
		lblNachname.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNachname.setBounds(12, 67, 118, 25);
		contentPanel.add(lblNachname);
		
		JLabel lblEmail = new JLabel("Email*");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(30, 105, 100, 25);
		contentPanel.add(lblEmail);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefon.setBounds(30, 143, 100, 25);
		contentPanel.add(lblTelefon);
		
		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		firstNameField.setBounds(162, 32, 180, 25);
		contentPanel.add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lastNameField.setColumns(10);
		lastNameField.setBounds(162, 71, 180, 25);
		contentPanel.add(lastNameField);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		emailField.setColumns(10);
		emailField.setBounds(162, 109, 180, 25);
		contentPanel.add(emailField);
		
		telefonField = new JTextField();
		telefonField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		telefonField.setColumns(10);
		telefonField.setBounds(162, 147, 180, 25);
		contentPanel.add(telefonField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					private buchungssystem.models.employee.Employee employee;
					private boolean returnCode;

					public void actionPerformed(ActionEvent e) {
						
						if ( !firstNameField.getText().equals("") && !lastNameField.getText().equals("") && !emailField.getText().equals("") ) {
							employee = new buchungssystem.models.employee.Employee();
							employee.setFirstName(firstNameField.getText());
							employee.setLastName(lastNameField.getText());
							employee.setEmail(emailField.getText());
							employee.setPhoneNumber(telefonField.getText());
							
							returnCode = Authorization.getCurrentUser().updateEmployee(employeeID, employee);
						
							if (returnCode) {
								MainFrame.popupWindow("Mitarbeiter erfolgreich geändert!", 400, 100, Color.RED);
							} else {
								MainFrame.popupWindow("Mitarbeiter wurde nicht geändert!", 400, 100, Color.RED);
							} 
							
							parent.initTable();
							parent.getEmployeeTableModel().fireTableDataChanged();
							setVisible(false);

						} else {
							MainFrame.popupWindow("Bitte alle Felder mit '*' ausfüllen", 300, 100, Color.RED);
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
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
		
	}
}
