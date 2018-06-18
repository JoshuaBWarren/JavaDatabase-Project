package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {
	
	private StringProperty ID;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty DOB;
	
	public StudentData(String id, String firstname, String lastname, String email, String dob) {
		
		this.ID = new SimpleStringProperty(id);
		this.firstName = new SimpleStringProperty(firstname);
		this.lastName = new SimpleStringProperty(lastname);
		this.email = new SimpleStringProperty(email);
		this.DOB = new SimpleStringProperty(dob);
	}

	/*
	 * Getter and Setter methods
	 */
	public StringProperty getID() {
		return ID;
	}

	public StringProperty getFirstName() {
		return firstName;
	}

	public StringProperty getLastName() {
		return lastName;
	}

	public StringProperty getEmail() {
		return email;
	}

	public StringProperty getDOB() {
		return DOB;
	}

	public void setID(StringProperty iD) {
		ID = iD;
	}

	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public void setDOB(StringProperty dOB) {
		DOB = dOB;
	}
	
	
	
	public StringProperty idProperty() {
		return this.ID;
	}
	
	public StringProperty firstNameProperty() {
		return this.firstName;
	}
	
	public StringProperty lastNameProperty() {
		return this.lastName;
	}
	
	public StringProperty emailProperty() {
		return this.email;
	}
	
	public StringProperty dobProperty() {
		return this.DOB;
	}
	
	
	
	
}
