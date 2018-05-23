package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import buchungssystem.gui.controller.LoginController;
import buchungssystem.gui.controller.MainMenuController;
import buchungssystem.models.application.User;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Employee extends JPanel implements Observer, Runnable {

	/**
	 * Employee(Mitarbeiter) Panel
	 */
	
	JPanel actionspanel;
	
	JButton addEmployee;
	JButton deleteEmployee;
	JButton updateEmployee;
	
	JTable employeeTable;
	private EmployeeTableModel employeeTableModel;
	JScrollPane employeeTableScrool;
	private JPanel fillerRight;

	private CurrentUser currentUser;
	private JPanel tablePanel;
	
	private JButton btnImport;
	private JButton btnUserAnlegen;

	private AddUserDialog addUserDialog;
	JDialog addEmployeeDialog;
	private EmployeeUpdateDialog employeeUpdateDialog;

	
	
	public Employee() {
		
		setLayout(new BorderLayout());
		actionspanel = new JPanel();
		actionspanel.setLayout(new BoxLayout(actionspanel, BoxLayout.X_AXIS));
		
		employeeTableModel = new EmployeeTableModel();
		
		addEmployee = new JButton("Hinzufügen");
		addEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//DONE open JDialog
				addEmployeeDialog.setVisible(true);
			}
		});
		deleteEmployee = new JButton("Löschen");
		deleteEmployee.addActionListener(new ActionListener() {
			private boolean returnCode;

			public void actionPerformed(ActionEvent e) {
				//get id of selected Employee
				Long id = (Long) employeeTable.getValueAt(employeeTable.getSelectedRow(), 6);
				buchungssystem.models.employee.Employee employee = new buchungssystem.models.employee.Employee(id);
				String firstName = (String) employeeTable.getValueAt(employeeTable.getSelectedRow(), 0);
				if ( !firstName.equals("Superadmin") ) {
					returnCode = currentUser.SoftDeleteEmployee(employee);
				} else {
					MainFrame.popupWindow("Admin kann nicht gelöscht werden", 400, 100, Color.RED);
				}
				
				if (returnCode) {
					initTable();
					getEmployeeTableModel().fireTableDataChanged();
					MainFrame.popupWindow("Mitarbeiter erfolgreich gelöscht", 300, 100, Color.RED);
				}
			}
		});
		updateEmployee = new JButton("Ändern");
		updateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//get id of selected Employee
				String firstName = (String) employeeTable.getValueAt(employeeTable.getSelectedRow(), 0);
				Long employeeID = (Long) employeeTable.getValueAt(employeeTable.getSelectedRow(), 6);
				if ( !firstName.equals("Superadmin") ) {
					employeeUpdateDialog.setEmployeeID(employeeID);
					employeeUpdateDialog.setVisible(true);
				} else {
					MainFrame.popupWindow("Superadmin darf nicht geändert werden", 400, 100, Color.RED);
				}
			}
		});
		btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			private boolean returnCode;

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileFilter(new FileNameExtensionFilter(null, "csv"));
				jFileChooser.showOpenDialog(null);
				File file = jFileChooser.getSelectedFile();
				
				int lastRowCount = getEmployeeTableModel().getRowCount();
				
				if ( file != null ) {
					returnCode = currentUser.importEmployeesToDB(file.getPath());
					initTable();
				}
				int RowCountNow = getEmployeeTableModel().getRowCount();
				System.out.println(">>>>>>>>>>>>>>>" + RowCountNow + " | " + lastRowCount);
				if ( lastRowCount < RowCountNow  ) {
					getEmployeeTableModel().fireTableDataChanged();
					MainFrame.popupWindow("Mitarbeiter erfolgreich importiert", 300, 100, Color.RED);
				}
				
			}
		});
		Box actionsBox = Box.createHorizontalBox();
		
		actionsBox.add(addEmployee);
		actionsBox.add(deleteEmployee);
		actionsBox.add(updateEmployee);
		actionsBox.add(btnImport);
		
		actionspanel.add(actionsBox);
		
		tablePanel = new JPanel();
		add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
		
		employeeTable = new JTable(employeeTableModel);
		employeeTable.setFont(MainFrame.fontBtn);
		employeeTable.setRowHeight(30);
		employeeTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		employeeTableScrool = new JScrollPane(employeeTable);
		
		tablePanel.add(employeeTableScrool);
		add(actionspanel, BorderLayout.NORTH);
		
		fillerRight = new JPanel();
		add(fillerRight, BorderLayout.EAST);
		fillerRight.setLayout(new BoxLayout(fillerRight, BoxLayout.Y_AXIS));
		
		Box fillerBox = Box.createVerticalBox();
		fillerBox.add(Box.createRigidArea(new Dimension(100,0)));

		btnUserAnlegen = new JButton("User anlegen");
		btnUserAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//open 'User anlegen' Dialog
				Long employeeID = (Long) employeeTable.getValueAt(employeeTable.getSelectedRow(), 6);
				addUserDialog.setEmployeeID(employeeID);
				addUserDialog.setVisible(true);
			}
		});
		
		fillerBox.add(btnUserAnlegen);
		fillerRight.add(fillerBox);
		
		/*
		 * Employee adding Dialog
		 */
		addEmployeeDialog = new AddEmployeeDialog(this);
		//center relative to table
		addEmployeeDialog.setLocationRelativeTo(tablePanel);
		
		/*
		 * adding of 'User anlegen' Dialog
		 */
		addUserDialog = new AddUserDialog(this);
		addUserDialog.setLocationRelativeTo(tablePanel);
		
		/*
		 *  adding of EmployeeUpdateDialog
		 */
		employeeUpdateDialog = new EmployeeUpdateDialog(this);
		
		//set styles for Buttons
		stylizeButtons(actionsBox);
		stylizeButtons(fillerBox);
		
	}
	
	//getters && setters
	
	
	public JButton getAddEmployee() {
		return addEmployee;
	}

	public JButton getBtnImport() {
		return btnImport;
	}

	public void setBtnImport(JButton btnImport) {
		this.btnImport = btnImport;
	}

	public JButton getBtnUserAnlegen() {
		return btnUserAnlegen;
	}

	public void setBtnUserAnlegen(JButton btnUserAnlegen) {
		this.btnUserAnlegen = btnUserAnlegen;
	}

	public void setAddEmployee(JButton addEmployee) {
		this.addEmployee = addEmployee;
	}

	public JButton getDeleteEmployee() {
		return deleteEmployee;
	}

	public void setDeleteEmployee(JButton deleteEmployee) {
		this.deleteEmployee = deleteEmployee;
	}

	public JButton getUpdateEmployee() {
		return updateEmployee;
	}

	public void setUpdateEmployee(JButton updateEmployee) {
		this.updateEmployee = updateEmployee;
	}

	public EmployeeTableModel getEmployeeTableModel() {
		return employeeTableModel;
	}

	public void setEmployeeTableModel(EmployeeTableModel employeeTableModel) {
		this.employeeTableModel = employeeTableModel;
	}

	
	
	/*
	 * Description of Employee Model Table
	 */

	public class EmployeeTableModel extends AbstractTableModel {

		int columnCount = 7;
		private ArrayList<Object []> dataArrayList;
		
		public EmployeeTableModel() {
			dataArrayList = new ArrayList<Object []>();
		}
		
		@Override
		public int getColumnCount() {
			return columnCount;
		}
		
		public void setColumnCount(int columnCount) {
			this.columnCount = columnCount;
		}

		@Override
		public int getRowCount() {
			return dataArrayList.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object []rows = dataArrayList.get(rowIndex);
			return rows[columnIndex];
		}
		
		public void addRow(Object[] row) {
			dataArrayList.add(row);
		}
		
		public void clearTable() {
			dataArrayList.clear();
		}
		
		@Override
		public String getColumnName(int columnIndex) {
			switch(columnIndex) {
			case 0: return "Vorname";
			case 1: return "Nachname";
			case 2: return "E-mail";
			case 3: return "Telefon";
			case 4: return "Funktion als Mitarbeiter";
			case 5: return "Login";
			case 6: return "ID";
			}
			return null;
		}

		public ArrayList<Object []> getDataArrayList() {
			return dataArrayList;
		}

		public void setDataArrayList(ArrayList<Object []> list) {
			this.dataArrayList = list;
		}	
	}
	
	public void initTable() {
		/*
		 	1. clear the Table
		 	2. Get Employees from DB as a List 
		 	3. Pass the list to array
		 	4. Add it to JTable Model
		*/
	
		employeeTableModel.clearTable();
		for (buchungssystem.models.employee.Employee employee : currentUser.getAllEmployees()) {
			Object [] row = new Object[7];
			if (employee.isValid() == true) {
				row[0] = employee.getFirstName();
				row[1] = employee.getLastName();
				row[2] = employee.getEmail();
				row[3] = employee.getPhoneNumber();			
				row[4] = currentUser.getEmployeeRoleByID(employee.getRoleID()).getRole();
				if (employee.getUserID() != null) {
					row[5] = currentUser.getUserByID(employee.getUserID()).getLogin();
				} else {
					row[5] = "keinen User angelegt";
				}
				row[6] = employee.getId();
				employeeTableModel.addRow(row);
			}

		}
		//hide the Column with the Employee ID
		employeeTable.getColumnModel().getColumn(6).setMinWidth(0);
		employeeTable.getColumnModel().getColumn(6).setMaxWidth(0);
		//employeeTable.removeColumn(employeeTable.getColumnModel().getColumn(6));
	}

	@Override
	public void update(Observable o, Object arg) {
		currentUser = Authorization.getCurrentUser();
		//все остальные панели на false
		for (Component component : ((MainMenuController) o).getMainPane().getComponents()) {
			if ( component.getClass() != ((MainMenuController) o).getjPane().getClass() ) {
				component.setVisible(false);
			}
		}
		
		//show the selected Panel
		((MainMenuController) o).getjPane().setVisible(true);
		
		//check permissions and set enable for buttons
		if ( Boolean.valueOf(LoginController.session.getPermissions().getProperty("addUser")) ) {
			((Employee) ((MainMenuController) o).getjPane()).getAddEmployee().setEnabled(true);
		}
		
		if ( Boolean.valueOf(LoginController.session.getPermissions().getProperty("deleteCustomer")) ) {
			((Employee) ((MainMenuController) o).getjPane()).getDeleteEmployee().setEnabled(true);
		}
		
		if ( Boolean.valueOf(LoginController.session.getPermissions().getProperty("updateCustomer")) ) {
			((Employee) ((MainMenuController) o).getjPane()).getUpdateEmployee().setEnabled(true);
		}
		
		if ( Boolean.valueOf(LoginController.session.getPermissions().getProperty("addUser")) ) {
			((Employee) ((MainMenuController) o).getjPane()).getBtnUserAnlegen().setEnabled(true);
		}
		
		if ( Boolean.valueOf(LoginController.session.getPermissions().getProperty("importCustomers")) ) {
			((Employee) ((MainMenuController) o).getjPane()).getBtnImport().setEnabled(true);
		}
		
		//update the table of employees
		initTable();
		
	}
	
	public void stylizeButtons(Container container) {
		//specifying of styles of all buttons in the box 
		for (Component c : container.getComponents()) {
			if (c.getClass().equals(JButton.class)) {
				c.setBackground(Color.LIGHT_GRAY);
				c.setForeground(Color.BLACK);
				c.setMaximumSize(new Dimension(250, 50));
				c.setFont(MainFrame.fontBtn);
				c.setEnabled(false);
				((JButton) c).setAlignmentX(Component.CENTER_ALIGNMENT);
			}
		}
	}

	public void run() {
		/*
		while (true) {
			try {
				System.out.println("test");
				initTable();
				employeeTable.columnAdded(null);
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
	}

}
