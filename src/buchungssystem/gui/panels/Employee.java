package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import buchungssystem.gui.controller.LoginController;
import buchungssystem.gui.controller.MainMenuController;
import buchungssystem.models.roles.CurrentUser;
import tests.Authorization;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.ActionListener;
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
	EmployeeTableModel employeeTableModel;
	JScrollPane employeeTableScrool;
	private JPanel fillerRight;

	private CurrentUser currentUser;
	private JPanel tablePanel;
	
	JDialog addEmployeeDialog;
	
	
	public Employee() {
		
		setLayout(new BorderLayout());
		actionspanel = new JPanel();
		actionspanel.setLayout(new BoxLayout(actionspanel, BoxLayout.X_AXIS));
		
		employeeTableModel = new EmployeeTableModel();
		
		addEmployee = new JButton("Hinzufügen");
		addEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TODO open JDialog
				addEmployeeDialog.setVisible(true);
				
				//refresh the Table
				initTable();
				MainFrame.thread.start();
				
			}
		});
		deleteEmployee = new JButton("Löschen");
		updateEmployee = new JButton("Ändern");
		
		Box actionsBox = Box.createHorizontalBox();
		
		actionsBox.add(addEmployee);
		actionsBox.add(deleteEmployee);
		actionsBox.add(updateEmployee);
		
		actionspanel.add(actionsBox);
		
		tablePanel = new JPanel();
		add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
		employeeTable = new JTable(employeeTableModel);
		employeeTableScrool = new JScrollPane(employeeTable);
		tablePanel.add(employeeTableScrool);
		add(actionspanel, BorderLayout.NORTH);
		//actionspanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{addEmployee, deleteEmployee, updateEmployee}));
		
		fillerRight = new JPanel();
		add(fillerRight, BorderLayout.EAST);
		fillerRight.setLayout(new BoxLayout(fillerRight, BoxLayout.Y_AXIS));
		Box fillerBox = Box.createVerticalBox();
		fillerBox.add(Box.createRigidArea(new Dimension(100,0)));
		fillerRight.add(fillerBox);
		
		/*
		 * Employee adding Dialog
		 */
		addEmployeeDialog = new AddEmployeeDialog();
		//center relative to table
		addEmployeeDialog.setLocationRelativeTo(tablePanel);
		
		
		
		//specifying of styles of all buttons in the box 
		for (Component c : actionsBox.getComponents()) {
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
	
	
	
	/*
	 * Description of Employee Model Table
	 */
	
	public JButton getAddEmployee() {
		return addEmployee;
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



	private class EmployeeTableModel extends AbstractTableModel {

		int columnCount = 2;
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
		
		initTable();
		
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
		Object [] row = new Object[4];
		if (employee.isValid() == true) {
			row[0] = employee.getFirstName();
			row[1] = employee.getLastName();
			employeeTableModel.addRow(row);
		}

	}
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("test");
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
