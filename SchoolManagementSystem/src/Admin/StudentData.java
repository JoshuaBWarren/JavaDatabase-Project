package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Class representing a Student
 */
public class StudentData {
	
	private StringProperty ID;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty email;
	private StringProperty DOB;
	
	/*
	 * Constructor for class StudentData
	 */
	public StudentData(String id, String firstname, String lastname, String email, String dob) {
		
		this.ID = new SimpleStringProperty(id);
		this.firstName = new SimpleStringProperty(firstname);
		this.lastName = new SimpleStringProperty(lastname);
		this.email = new SimpleStringProperty(email);
		this.DOB = new SimpleStringProperty(dob);
	}

	/*
	 * Getter property for ID.
	 * 
	 * @return ID
	 */
	public StringProperty getID() {
		return ID;
	}

	/*
	 * Getter property for firstName.
	 * 
	 * @return firstName
	 */
	public StringProperty getFirstName() {
		return firstName;
	}

	/*
	 * Getter property for lastName.
	 * 
	 * @return lastName
	 */
	public StringProperty getLastName() {
		return lastName;
	}

	/*
	 * Getter property for email.
	 * 
	 * @return email
	 */
	public StringProperty getEmail() {
		return email;
	}

	/*
	 * Getter property for DOB.
	 * 
	 * @return DOB
	 */
	public StringProperty getDOB() {
		return DOB;
	}

	/*
	 * Setter property for ID
	 * 
	 * @param ID represents the property to change.
	 */
	public void setID(StringProperty ID) {
		this.ID = ID;
	}

	/*
	 * Setter property for firstName
	 * 
	 * @param firstName represents the property to change.
	 */
	public void setFirstName(StringProperty firstName) {
		this.firstName = firstName;
	}

	/*
	 * Setter property for lastName
	 * 
	 * @param lastName represents the property to change.
	 */
	public void setLastName(StringProperty lastName) {
		this.lastName = lastName;
	}

	/*
	 * Setter property for email
	 * 
	 * @param email represents the property to change.
	 */
	public void setEmail(StringProperty email) {
		this.email = email;
	}

	/*
	 * Setter property for DOB
	 * 
	 * @param DOB represents the property to change.
	 */
	public void setDOB(StringProperty DOB) {
		this.DOB = DOB;
	}

	/*
	 * Method for getting the ID for
	 * the idcolumn.
	 * 
	 * @return the ID
	 */
	public StringProperty IDProperty() {
		return ID;
	}
	
	/*
	 * Method for getting the firstName for
	 * the firstnamecolumn.
	 * 
	 * @return the ID
	 */
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	/*
	 * Method for getting the lastName for
	 * the lastnamecolumn.
	 * 
	 * @return the lastname
	 */
	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	/*
	 * Method for getting the email for
	 * the emailcolumn.
	 * 
	 * @return the email
	 */
	public StringProperty emailProperty() {
		return email;
	}
	
	/*
	 * Method for getting the DOB for
	 * the dobcolumn.
	 * 
	 * @return the DOB
	 */
	public StringProperty DOBProperty() {
		return DOB;
	}

	
	
	
	
}
