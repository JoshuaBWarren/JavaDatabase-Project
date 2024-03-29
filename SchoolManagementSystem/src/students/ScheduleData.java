package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Class representing a Schedule
 */
public class ScheduleData {

	private StringProperty classID;
	private StringProperty className;
	private StringProperty semester;
	private StringProperty year;
	
	/*
	 * Constructor for class ClassData
	 */
	public ScheduleData(String classID, String className, String semester, String year) {
		
		this.classID = new SimpleStringProperty(classID);
		this.className = new SimpleStringProperty(className);
		this.semester = new SimpleStringProperty(semester);
		this.year = new SimpleStringProperty(year);
	}

	/*
	 * Getter property for classID.
	 * 
	 * @return classID
	 */
	public StringProperty getClassID() {
		return classID;
	}

	/*
	 * Getter property for className.
	 * 
	 * @return className
	 */
	public StringProperty getClassName() {
		return className;
	}

	/*
	 * Getter property for semester.
	 * 
	 * @return semester
	 */
	public StringProperty getSemester() {
		return semester;
	}
	
	/*
	 * Getter property for year.
	 * 
	 * @return year
	 */
	public StringProperty getYear() {
		return year;
	}

	/*
	 * Setter property for classID
	 * 
	 * @param classID represents the property to change.
	 */
	public void setClassID(StringProperty classID) {
		this.classID = classID;
	}

	/*
	 * Setter property for className
	 * 
	 * @param className represents the property to change.
	 */
	public void setClassName(StringProperty className) {
		this.className = className;
	}

	/*
	 * Setter property for semester
	 * 
	 * @param semester represents the property to change.
	 */
	public void setSemester(StringProperty semester) {
		this.semester = semester;
	}
	
	/*
	 * Setter property for year
	 * 
	 * @param year represents the property to change.
	 */
	public void setYear(StringProperty year) {
		this.year = year;
	}
	
	/*
	 * Method for getting the classID for
	 * the classidcolumn.
	 * 
	 * @return the classID
	 */
	public StringProperty classIDProperty() {
		return classID;
	}
	
	/*
	 * Method for getting the className for
	 * the classnamecolumn.
	 * 
	 * @return the className
	 */
	public StringProperty classNameProperty() {
		return className;
	}
	
	/*
	 * Method for getting the semeseter for
	 * the semestercolumn.
	 * 
	 * @return the semester
	 */
	public StringProperty semesterProperty() {
		return semester;
	}
	
	/*
	 * Method for getting the year for
	 * the yearcolumn.
	 * 
	 * @return the year
	 */
	public StringProperty yearProperty() {
		return year;
	}
	

	

}

