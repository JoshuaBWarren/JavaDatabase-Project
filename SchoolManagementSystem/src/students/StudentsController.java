package students;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import Admin.AdminController;

/*
 * Represents the class for StudentsController
 */
public class StudentsController implements Initializable {

	@FXML
	private TextField scheduleid;
	
	@FXML
	private TextField scheduleclassname;
	
	@FXML
	private TextField schedulesemester;
	
	@FXML
	private TextField scheduleyear;
	
	
	@FXML
	private TableView<ScheduleData> scheduletable;
	
	
	@FXML
	private TableColumn<ScheduleData, String> scheduleidcolumn;
	
	@FXML 
	private TableColumn<ScheduleData, String> scheduleclassnamecolumn;
	
	@FXML
	private TableColumn<ScheduleData, String> schedulesemestercolumn;
	
	@FXML
	private TableColumn<ScheduleData, String> scheduleyearcolumn;
	
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
	
	
	
	private dbConnection dc;
	
	
	private ObservableList<ScheduleData> data;
	private ObservableList<ClassData> classData;
	
	
	private String sqlSchedule = "SELECT * FROM schedule";
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
	 * GIVEN: an action event (from clicking Load Data)
	 * RETURNS: class data from the database
	 */
	@FXML
	public void loadClassData(ActionEvent event) {
		
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
	
	
	public void loadScheduleData() {
		
		try {
			
			// get connection
			Connection conn = dbConnection.getConnection();
			
			this.data = FXCollections.observableArrayList();
			
			// execute our query
			ResultSet rs = conn.createStatement().executeQuery(sqlSchedule);
			
			// while we have more table data
			while(rs.next()) {
				
				// add the data to each column
				this.data.add(new ScheduleData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				
			}
			
			conn.close();
			
		} catch (SQLException ex) {
			
			System.err.println("Error" + ex);
		}
		
		//display data to the tables
		this.scheduleidcolumn.setCellValueFactory(new PropertyValueFactory<ScheduleData, String>("classID"));
		this.scheduleclassnamecolumn.setCellValueFactory(new PropertyValueFactory<ScheduleData, String>("className"));
		this.schedulesemestercolumn.setCellValueFactory(new PropertyValueFactory<ScheduleData, String>("semester"));
		this.scheduleyearcolumn.setCellValueFactory(new PropertyValueFactory<ScheduleData, String>("year"));
		
		this.scheduletable.setItems(null);
		this.scheduletable.setItems(this.data);
		
	}
	
	/*
	 * Signature
	 * addClass : ActionEvent -> empty
	 * Purpose
	 * GIVEN: an action event (from clicking addClass)
	 * RETURNS: an empty form
	 */
	@FXML
	private void addClass(ActionEvent event) {
		
		String sqlInsert = "INSERT INTO schedule(scheduleidcolumn,scheduleclassnamecolumn,schedulesemestercolumn,scheduleyearcolumn) VALUES (?,?,?,?)";
		
		ArrayList<String> classToInsert = selectClass();
		
		String tempClassID = classToInsert.get(0);
		String tempClassName = classToInsert.get(1);
		String tempSemester = classToInsert.get(2);
		String tempYear = classToInsert.get(3);
		
		try {
			
			Connection conn = dbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			
			// add the data in the right column
			stmt.setString(1, tempClassID);
			stmt.setString(2, tempClassName);
			stmt.setString(3, tempSemester);
			stmt.setString(4, tempYear);
			
			stmt.execute();
			conn.close();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		// update the table after adding
		loadScheduleData();
		
	}
	
	/*
	 * Signature
	 * selectStudent : Integer -> String
	 * Purpose
	 * GIVEN: an Integer Index from the database table
	 * RETURNS: a String representation of the row selected 
	 */
	private ArrayList<String> selectClass() {
		
		// initial value for result to return
		ArrayList<String> result = new ArrayList<String>();
		
		// grab the index of the row selected on the table
		int initial = classtable.getSelectionModel().getSelectedIndex();

		try {

			// SELECT query to execute
			String sqlSelect = "SELECT * FROM classes";

			Connection conn = dbConnection.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sqlSelect);

			// while there's a next row
			while(rs.next()) {

				// get the row id - 1 since we start at 0
				int temp1 = rs.getRow() - 1;
				
				// if temp1 is equal to the index we selected
				if(temp1 == initial) {
					
					String classIDTemp = rs.getString("classid");
					String classNameTemp = rs.getString("classname");
					String semesterTemp = rs.getString("semester");
					String yearTemp = rs.getString("year");
					
					result.add(classIDTemp);
					result.add(classNameTemp);
					result.add(semesterTemp);
					result.add(yearTemp);

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
	private void removeClassFromSchedule(ActionEvent event) {

		try {
			
			// sql query to delete data from the database
			String sqlRemove = "DELETE FROM schedule WHERE scheduleidcolumn = ?";
			
			// open a connection to the database and use PreparedStatement to 
			// initialize the query.
			Connection conn = dbConnection.getConnection();
			PreparedStatement delete = conn.prepareStatement(sqlRemove);

			// information needed to delete the row
			delete.setString(1, selectClassID());
			
			// execute and delete
			delete.executeUpdate();
			
			// close the connection
			conn.close();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		// update table after deleting
		loadScheduleData();
		
	}
	
	
	/*
	 * Signature
	 * selectClass : Integer -> String
	 * Purpose
	 * GIVEN: an Integer Index from the database table
	 * RETURNS: a String representation of the row selected 
	 */
	private String selectClassID() {

		// initial value for result to return
		String result = "";
		
		// grab the index of the row selected on the table
		int initial = classtable.getSelectionModel().getSelectedIndex();

		try {

			// SELECT query to execute
			String sqlSelect = "SELECT scheduleidcolumn FROM schedule";

			Connection conn = dbConnection.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sqlSelect);

			// while there's a next row
			while(rs.next()) {

				// set temp to equal the id rs.next() is currently on
				String temp = rs.getString("scheduleidcolumn");
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
