package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buchungssystem.models.application.User;
import buchungssystem.models.application.UserRole;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddUserDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField loginField;
	private JPasswordField passwordField;
	private Properties ComboBoxproperties;
	private Properties comboBoxProperties;
	private Long employeeID;

	/**
	 * Create the dialog.
	 */
	public AddUserDialog(buchungssystem.gui.panels.Employee parent) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel loginLabel = new JLabel("Benutzername");
			loginLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			loginLabel.setBounds(54, 33, 129, 25);
			loginLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			contentPanel.add(loginLabel);
		}
		
		loginField = new JTextField();
		loginField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginField.setBounds(215, 30, 167, 31);
		contentPanel.add(loginField);
		loginField.setColumns(10);
		
		JLabel passwLabel = new JLabel("Kennwort");
		passwLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwLabel.setBounds(54, 101, 129, 25);
		contentPanel.add(passwLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 101, 167, 31);
		contentPanel.add(passwordField);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRole.setBounds(54, 159, 129, 25);
		contentPanel.add(lblRole);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Bitte die Rolle wählen");
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				initComboBox(comboBox);
			}
		});
		comboBox.setBounds(215, 163, 167, 22);
		
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					private boolean returnCode;

					public void actionPerformed(ActionEvent arg0) {
						User user = new User();
						user.setLogin(loginField.getText());
						user.setPassword(passwordField.getText());
						String choose = (String) comboBox.getSelectedItem();
						Long userRoleID = Long.valueOf(comboBoxProperties.getProperty(choose));
						user.setUserRoleID(userRoleID);
						Authorization.getCurrentUser().addUser(user);
						user = Authorization.getCurrentUser().getUserByLogin(loginField.getText());
						
						returnCode = Authorization.getCurrentUser().adaptUserToEmployee(user.getId(), employeeID);
						
						if (returnCode == true) {
							MainFrame.popupWindow("User erfolgreich erstellt", 300, 100, Color.RED);
						} else {
							MainFrame.popupWindow("User existiert bereits", 300, 100, Color.RED);
						}
						
						//refresh table
						parent.initTable();
						parent.getEmployeeTableModel().fireTableDataChanged();
						setVisible(false);
						
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

	private void initComboBox(JComboBox comboBox) {
		comboBox.removeAllItems();
		comboBoxProperties = new Properties();
		List<UserRole> userRoleList = Authorization.getCurrentUser().getAllUserRole();
		for (UserRole userRole : userRoleList) {
			comboBox.addItem(userRole.getRole());
			comboBoxProperties.setProperty(userRole.getRole(), userRole.getId().toString());
		}
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
}
