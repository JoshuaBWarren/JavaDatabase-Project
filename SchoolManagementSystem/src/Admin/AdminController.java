package Admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import dbUtil.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import students.ClassData;

/*
 * Class representing an AdminController
 */
public class AdminController implements Initializable {
	
	/*
	 * A TextField is a TextField
	 * INTERP: represents the location in which data is taken as input
	 */
	@FXML
	private TextField id; // represents the TextField of Admin.fxml document with fx:id of id
	@FXML
	private TextField firstname; // represents the TextField of Admin.fxml document with fx:id of firstname
	@FXML
	private TextField lastname; // represents the TextField of Admin.fxml document with fx:id of lastname
	@FXML
	private TextField email; // represents the TextField of Admin.fxml document with fx:id of email
	@FXML
	private DatePicker dob; // represents the TextField of Admin.fxml document with fx:id of dob
	
	/*
	 * A studenttable is a TableView
	 * INTERP: represents the location to display data within the database.
	 * fx:id = studenttable
	 */
	@FXML
	private TableView<StudentData> studenttable;
	
	/*
	 * A TableColumn<StudentData, String> is a TableColumn
	 * INTERP: represents the location to display data within database.
	 */
	@FXML
	private TableColumn<StudentData, String> idcolumn; // represents the TableColumn of Admin.fxml document with fx:id of idcolumn
	@FXML
	private TableColumn<StudentData, String> firstnamecolumn; // represents the TableColumn of Admin.fxml document with fx:id of firstnamecolumn
	@FXML
	private TableColumn<StudentData, String> lastnamecolumn; // represents the TableColumn of Admin.fxml document with fx:id of lastnamecolumn
	@FXML
	private TableColumn<StudentData, String> emailcolumn; // represents the TableColumn of Admin.fxml document with fx:id of emailcolumn
	@FXML
	private TableColumn<StudentData, String> dobcolumn; // represents the TableColumn of Admin.fxml document with fx:id of dobcolumn
	
	/*
	 * A TextField is a TextField
	 * INTERP: represents the location in which data is taken as input
	 */
	@FXML
	private TextField classid; // represents the TextField of Admin.fxml document with fx:id of classid
	@FXML
	private TextField classname; // represents the TextField of Admin.fxml document with fx:id of classname
	@FXML
	private TextField semester; // represents the TextField of Admin.fxml document with fx:id of semester
	@FXML
	private TextField year; // represents the TextField of Admin.fxml document with fx:id of year
	
	/*
	 * A classtable is a TableView
	 * INTERP: represents the location to display data within the database.
	 * fx:id = studenttable
	 */
	@FXML
	private TableView<ClassData> classtable; // represents the TableColumn of Admin.fxml document with fx:id of classtable
	
	/*
	 * A TableColumn<StudentData, String> is a TableColumn
	 * INTERP: represents the location to display data within database.
	 */
	@FXML
	private TableColumn<ClassData, String> classidcolumn; // represents the TableColumn of Admin.fxml document with fx:id of classcolumn
	@FXML
	private TableColumn<ClassData, String> classnamecolumn; // represents the TableColumn of Admin.fxml document with fx:id of classnamecolumn
	@FXML
	private TableColumn<ClassData, String> semestercolumn; // represents the TableColumn of Admin.fxml document with fx:id of semestercolumn
	@FXML
	private TableColumn<ClassData, String> yearcolumn; // represents the TableColumn of Admin.fxml document with fx:id of yearcolumn
	
	/*
	 * A StudentData is a Student
	 * Deconstructor
	 * student-fn: Student -> ???
	 * (define (student-fn student)
	 * ... (StringProperty ID) ...
	 * ... (StringProperty firstName) ...
	 * ... (StringProperty lastName) ...
	 * ... (StringProperty email) ...
	 * ... (StringProperty DOB) ...
	 */
	
	/*
	 * A ClassData is a Class
	 * Deconstructor
	 * class-fn: Class -> ???
	 * (define (class-fn class)
	 * ... (StringProperty classID) ...
	 * ... (StringProperty className) ...
	 * ... (StringProperty semester) ...
	 * ... (StringProperty year) ...
	 */
	
	
	/*
	 * A dc is a Connection
	 * INTERP: represents a connection session with a specific database.
	 */
	private dbConnection dc;
	
	/*
	 * An ObservableList<StudentData>/ObservableList<ClassData> is one of:
	 * - null
	 * - ListChangeListener
	 * INTERP: represents a list of listeners that track changes
	 */
	private ObservableList<StudentData> data;
	private ObservableList<ClassData> classData;
	
	/*
	 * a sqlStudents/sqlClasses is a QUERY command
	 * INTERP: represents a specific command to a database
	 */
	private String sqlStudents = "SELECT * FROM students";
	private String sqlClasses = "SELECT * FROM classes";
	
	/*
	 * Signature
	 * initialize : URL ResourceBundle -> Connection
	 * Purpose
	 * GIVEN: a url and locale sensitive texts/components
	 * RETURNS: a Connection to a specific database
	 */
	public void initialize(URL url, ResourceBundle rb) {
		
		this.dc = new dbConnection();
	}
	
	/*
	 * Signature
	 * loadStudentData : ActionEvent -> Data
	 * Purpose
	 * GIVEN: an action event 
	 * RETURNS: student data from the database
	 */
	@FXML
	private void loadStudentData(ActionEvent event) {
		
		try {
			
			// get connection
			Connection conn = dbConnection.getConnection();
			
			this.data = FXCollections.observableArrayList();
			
			// execute our query
			ResultSet rs = conn.createStatement().executeQuery(sqlStudents);
			
			// while we have more table data
			while(rs.next()) {
				
				// add the data to each column
				this.data.add(new StudentData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				
			}
			
			conn.close();
			
		} catch (SQLException ex) {
			
			System.err.println("Error" + ex);
		}
		
		//display data to the tables
		this.idcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("ID"));
		this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("firstName"));
		this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("lastName"));
		this.emailcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("email"));
		this.dobcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("DOB"));
		
		this.studenttable.setItems(null);
		this.studenttable.setItems(this.data);
		
	}
	
	/*
	 * Signature
	 * loadStudentData : ActionEvent -> Data
	 * Purpose
	 * GIVEN: an action event (from clicking Load Data)
	 * RETURNS: class data from the database
	 */
	@FXML
	private void loadClassData(ActionEvent event) {
		
		try {
			
			// get connection
			Connection conn = dbConnection.getConnection();
			
			this.classData = FXCollections.observableArrayList();
			
			// execute our query
			ResultSet rs = conn.createStatement().executeQuery(sqlClasses);
			
			// while we have more table data
			while(rs.next()) {
				
				// add the data to each column
				this.classData.add(new ClassData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				
			}
			
			conn.close();
			
		} catch (SQLException ex) {
			
			System.err.println("Error" + ex);
		}
		
		//display data to the tables
		this.classidcolumn.setCellValueFactory(new PropertyValueFactory<ClassData, String>("classID"));
		this.classnamecolumn.setCellValueFactory(new PropertyValueFactory<ClassData, String>("className"));
		this.semestercolumn.setCellValueFactory(new PropertyValueFactory<ClassData, String>("semester"));
		this.yearcolumn.setCellValueFactory(new PropertyValueFactory<ClassData, String>("year"));
		
		this.classtable.setItems(null);
		this.classtable.setItems(this.classData);
		
	}

	/*
	 * Signature
	 * addStudent : ActionEvent -> Database
	 * Purpose
	 * GIVEN: an action event (from clicking Add Student)
	 * RETURNS: an updated database with a new student added
	 */
	@FXML
	private void addStudent(ActionEvent event) {
		
		// sql query to insert data into students at ID, first name, last name, email and DOB
		String sqlInsert = "INSERT INTO students(id,fname,lname,email,DOB) VALUES (?,?,?,?,?)";
		
		try {
			
			Connection conn = dbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			
			// add the data in the right column
			stmt.setString(1, this.id.getText());
			stmt.setString(2, this.firstname.getText());
			stmt.setString(3, this.lastname.getText());
			stmt.setString(4, this.email.getText());
			stmt.setString(5, this.dob.getEditor().getText());
			
			stmt.execute();
			conn.close();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
	
		}
		// update the table after adding and clear fields
		loadStudentData(event);
		clearStudentFields(event);
		
	}
	
	/*
	 * Signature
	 * addClass : ActionEvent -> Database
	 * Purpose
	 * GIVEN: an action event (from clicking Add Class)
	 * RETURNS: an updated database with a new class added
	 */
	@FXML
	private void addClass(ActionEvent event) {
		
		// sql query to insert data into classes
		String sqlInsert = "INSERT INTO classes(classid,classname,semester,year) VALUES (?,?,?,?)";
		
		try {
			
			Connection conn = dbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			
			// add the data in the right column
			stmt.setString(1, this.classid.getText());
			stmt.setString(2, this.classname.getText());
			stmt.setString(3, this.semester.getText());
			stmt.setString(4, this.year.getText());
			
			stmt.execute();
			conn.close();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		// update the table after adding and clear fields
		loadClassData(event);
		clearClassFields(event);

	}
	
	
	/*
	 * Signature
	 * clearStudentFields : ActionEvent -> empty
	 * Purpose
	 * GIVEN: an action event (from clicking Clear Form)
	 * RETURNS: an empty form
	 */
	@FXML
	private void clearStudentFields(ActionEvent event) {
		this.id.setText("");
		this.firstname.setText("");
		this.lastname.setText("");
		this.email.setText("");
		this.dob.setValue(null);
	}
	
	/*
	 * Signature
	 * clearClassFields : ActionEvent -> empty
	 * Purpose
	 * GIVEN: an action event (from clicking Clear Form)
	 * RETURNS: an empty form
	 */
	@FXML
	private void clearClassFields(ActionEvent event) {
	this.classid.setText("");
	this.classname.setText("");
	this.semester.setText("");
	this.year.setText("");
	}
	
	/*
	 * Signature
	 * removeStudent : ActionEvent -> Database
	 * Purpose
	 * GIVEN: an action event (from clicking Delete Student)
	 * RETURNS: an updated database with a student removed
	 */
	@FXML
	private void removeStudent(ActionEvent event) {
		
		try {
			
			// sql query to delete data from the database
			String sqlRemove = "DELETE FROM students WHERE id = ?";
			
			// open a connection to the database and use PreparedStatement to 
			// initialize the query.
			Connection conn = dbConnection.getConnection();
			PreparedStatement delete = conn.prepareStatement(sqlRemove);

			// information needed to delete the row
			delete.setString(1, selectStudent());
			
			// execute and delete
			delete.executeUpdate();
			
			// close the connection
			conn.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// update table after deleting
		loadStudentData(event);
		
	}
	
	/*
	 * Signature
	 * selectStudent : Integer -> String
	 * Purpose
	 * GIVEN: an Integer Index from the database table
	 * RETURNS: a String representation of the row selected 
	 */
	private String selectStudent() {
		
		// initial value for result to return
		String result = "";
		
		// grab the index of the row selected on the table
		int initial = studenttable.getSelectionModel().getSelectedIndex();

		try {

			// SELECT query to execute
			String sqlSelect = "SELECT id FROM students";

			Connection conn = dbConnection.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sqlSelect);

			// while there's a next row
			while(rs.next()) {

				// set temp to equal the id rs.next() is currently on
				String temp = rs.getString("id");
				// get the row id - 1 since we start at 0
				int temp1 = rs.getRow() - 1;
				
				// if temp1 is equal to the index we selected
				if(temp1 == initial) {
					
					// make it equal to result
					result = temp;
				}
			}

			// close the connection
			conn.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		// return the row to delete
		return result;
	}
	
	/*
	 * Signature
	 * removeClass : ActionEvent -> Database
	 * Purpose
	 * GIVEN: an action event (from clicking Delete Student)
	 * RETURNS: an updated database with a class removed
	 */
	@FXML
	private void removeClass(ActionEvent event) {

		try {
			
			// sql query to delete data from the database
			String sqlRemove = "DELETE FROM classes WHERE classid = ?";
			
			// open a connection to the database and use PreparedStatement to 
			// initialize the query.
			Connection conn = dbConnection.getConnection();
			PreparedStatement delete = conn.prepareStatement(sqlRemove);

			// information needed to delete the row
			delete.setString(1, selectClass());
			
			// execute and delete
			delete.executeUpdate();
			
			// close the connection
			conn.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// update table after deleting
		loadClassData(event);
		
	}
	
	/*
	 * Signature
	 * selectClass : Integer -> String
	 * Purpose
	 * GIVEN: an Integer Index from the database table
	 * RETURNS: a String representation of the row selected 
	 */
	private String selectClass() {

		// initial value for result to return
		String result = "";
		
		// grab the index of the row selected on the table
		int initial = classtable.getSelectionModel().getSelectedIndex();

		try {

			// SELECT query to execute
			String sqlSelect = "SELECT classid FROM classes";

			Connection conn = dbConnection.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sqlSelect);

			// while there's a next row
			while(rs.next()) {

				// set temp to equal the id rs.next() is currently on
				String temp = rs.getString("classid");
				// get the row id - 1 since we start at 0
				int temp1 = rs.getRow() - 1;
				
				// if temp1 is equal to the index we selected
				if(temp1 == initial) {
					
					// make it equal to result
					result = temp;
				}
			}

			// close the connection
			conn.close();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		// return the row to delete
		return result;
	}
}
