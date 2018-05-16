package buchungssystem.models.product;

import java.util.GregorianCalendar;

import buchungssystem.models.Model;

public class Department extends Model {
	
	/* 
	 * Folgende Eigenschaften übernimmt Model.java
	 * 
	 * private Long id; 
	 * private Long lastID;
	 * private GregorianCalendar validFrom;
	 * private GregorianCalendar validTill;
	 * private boolean isValid;
	 * 
	 */
	
	private String title;
	
	public Department() {
		super();
	}

	public Department(Long id) {
		super(id);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Department [title=" + title + "]";
	}
	
	
	
	
}
