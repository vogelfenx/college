package buchungssystem.gui.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import buchungssystem.gui.panels.Employee;
import buchungssystem.gui.panels.MainFrame;
import tests.Authorization;

public class MainMenuController extends Observable implements ActionListener  {
	
	JPanel jPane;
	JPanel MainPane;
	private MainFrame mainFrame;
	
	public MainMenuController() {
	}
	
	public void init(JPanel jPane, JPanel MainPane, MainFrame mainFrame) {
		this.jPane = jPane;
		this.MainPane = MainPane;
		this.setMainFrame(mainFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setChanged();
		addObserver((Observer) jPane);
		notifyObservers();
	}

	public JPanel getjPane() {
		return jPane;
	}

	public void setjPane(JPanel jPane) {
		this.jPane = jPane;
	}

	public JPanel getMainPane() {
		return MainPane;
	}

	public void setMainPane(JPanel mainPane) {
		MainPane = mainPane;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	

}
