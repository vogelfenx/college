package buchungssystem.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class Employee extends JPanel implements Observer {

	/**
	 * Employee(Mitarbeiter) Panel
	 */
	
	JPanel actionspanel;
	
	JButton addEmployee;
	JButton deleteEmployee;
	JButton updateEmployee;
	
	JTable employeeTable;
	
	EmployeeTableModel employeeTableModel;
	
	public Employee() {
		setLayout(new BorderLayout());
		actionspanel = new JPanel();
		actionspanel.setLayout(new BoxLayout(actionspanel, BoxLayout.X_AXIS));
		
		employeeTableModel = new EmployeeTableModel();
		employeeTable = new JTable(employeeTableModel);
		
		addEmployee = new JButton("Hinzufügen");
		deleteEmployee = new JButton("Löschen");
		updateEmployee = new JButton("Ändern");
		actionspanel.add(addEmployee);
		actionspanel.add(deleteEmployee);
		actionspanel.add(updateEmployee);
		
		add(employeeTable, BorderLayout.CENTER);
		add(actionspanel, BorderLayout.NORTH);
		
		
		
	}
	
	/*
	 * Description of Employee Model
	 */
	
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
		
		public void addRow(Object []row) {
			dataArrayList.add(row);
		}
		
		public String getColumnName(int columnindex) {
			switch(columnindex) {
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
		CurrentUser currentUser = Authorization.getCurrentUser();
		//все остальные панели на false
		for (Component component : ((MainMenuController) o).getMainPane().getComponents()) {
			if ( component.getClass() != ((MainMenuController) o).getjPane().getClass() ) {
				component.setVisible(false);
			}
		}
		((MainMenuController) o).getjPane().setVisible(true);
		
		/*
		 	1. Get Employees from DB as a List 
		 	2. Pass it to array
		 	3. Add it to JTable Model
		 */
		for (buchungssystem.models.employee.Employee employee : currentUser.getAllEmployees()) {
			Object [] row = new Object[2];
			row[0] = employee.getFirstName();
			row[1] = employee.getLastName();
			employeeTableModel.addRow(row);
		}
		
	}

}
