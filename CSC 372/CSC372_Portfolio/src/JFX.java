/*
*	GREGORY NORRIS
*	PORTFOLIO ASSIGNMENT OPTION 1
*	CSC372-1, BASS
*	AUGUST 2 2019
*	COLORADO STATE UNIVERSITY GLOBAL CAMPUS
*
*
*	This program stores student data in an a linked list, sorts by proper name (last, first, middle, title)
*	and allows the user to save student data to a text document. Deletion by student number is allowed,
*	there was an option to modify existing student data, but it's not a requirement and I'm happy enough with
*	how this program operates.
*/
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.Date;
import java.util.LinkedList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.File;
import java.util.Random;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;


public class JFX extends Application 
{
	Stage stage1 = new Stage();
//&&&&&&&&&&&&&&&&&&&&&&&& LINKED LIST CONTAINS STUDENT DATA &&&&&&&&&&&&&&&&&&&&&&&&&&&&	
	private LinkedList<Student> students = new LinkedList<Student>();
//^^^^^^^^^^^^^^ MAIN AND EDIT MENU VALUES ^^^^^^^^^^^^^^^^^	
	TextField textfield = new TextField("");
	TextArea textResults = new TextArea();
	TextField sID_textField = new TextField("");
	TextField sName_textField = new TextField("");
	TextField sAddr_textField = new TextField("");
	TextField sGPA_textField = new TextField("");

// ****************** SAVE TO FILE **********************
	private void printToFile(Stage in_Stage) 
	{
		Stage stage1 = in_Stage;
		
		FileChooser saveFX = new FileChooser();
		saveFX.getExtensionFilters().addAll
		(
				new ExtensionFilter("Text File","*.txt")
		);
		File file = saveFX.showSaveDialog(stage1);
		
		if (file!= null) 
		{
			try 
			{
				PrintWriter writer = new PrintWriter(file);
				//timeList.forEach((n -> writer.println()));
				for (Student writeStu: students) {
					String sOut = writeStu.getContents();
					writer.write(sOut+System.lineSeparator());
				}
				writer.close();			
			}
			catch(IOException ex){}
		};
		System.out.println(file);
	}
//******************* ADD NEW STUDENT **********************
	private void addStudent(int sNum, String sName, String sAddr, Double sGPA) 
	{
		//return " ";
		Student tempStudent = new Student(sNum,sName,sAddr,sGPA);
		students.add(tempStudent);
	}
//************************ DELETE STUDENT ************************	
	private boolean deleteStudent (int sNumber) 
	{
		int i =0;
		boolean success = false;
		for(Student scanStu : students) 
		{
			int scanNum = scanStu.getStudentNumber();
			if (scanNum == sNumber) 
			{
				students.remove(i);
				System.out.println("Student "+scanNum+" removed.");
				success = true;
				return success;
			}
			i = i+1;
		}
		return success;
	}
//********************** MODIFY STUDENT *********************
// ***************** DISABLED CURRENTLY BECAUSE I'M LAZY AND IT ISN'T A REQUIREMENT
// ACTIVATE MENU ITEM BUTTON TO REACTIVATE THIS METHOD. IT HALF-WORKS-ISH
	private void modifyStudent (int sNumber) 
	{
		int i =0;
		for(Student scanStu : students) 
		{
			int scanNum = scanStu.getStudentNumber();
			if (scanNum == sNumber) 
			{
				//students.remove(i);
				System.out.println("Student "+scanNum+" modified.");
				break;
			}
			i = i+1;
		}
	}
//************************** MAKE NEW STUDENT ID *********************
	private int makeID() 
	{
		int newID = 0;
		int maxID=0;
		for(Student scanStu : students) 
		{
			int scanNum = scanStu.getStudentNumber();
			if (scanNum >= maxID) {maxID = scanNum;}
		}
		newID = maxID + 1;
		return newID;
	}
	
//********** RESET THE MAIN WINDOW STATE SETTINGS, CLEAR TEXT, REBUILD LIST******************
	private void resetStage() 
	{
		//RESET TEXT VALUES ON ALL FIELDS
		sID_textField.setText("");
		sName_textField.setText("");
		sAddr_textField.setText("");
		sGPA_textField.setText("");
		textResults.setText("");
		// REFILLS THE TEXT WINDOW CONTAINING LIST OF STUDENTS
		for (Student scanStu : students) 
		{
			String dispOut = scanStu.getContents();
			textResults.appendText(dispOut);
		}
	}
//*************** FILL STUDENTS ARRAY WITH SAMPLE DATA******************
	public void fillStudents() 
	{
		String[] nFill = new String[] {"Gregory Norris","Jessie Francis Pinkman","Walter Maurice White, PhD","Gus Fring","Saul Goodman"};
		String[] aFill = new String[] {"Littleton, CO","Los Vegas, NV","Moab, UT","Multiple locations.","Canon City, CO"};
		double[] gFill = new double[] {1.0,2.0,3.0,4.0,4.0};
		for (int j = 0; j<10; j++) {
		for (int i = 0; i<5;i++) 
		{
			int fID = makeID();
			addStudent(fID,j+nFill[i],aFill[i], gFill[i] );
		}}
		resetStage();
	}
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@ @OVERIDE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@	
	@Override
	public void start(Stage arg0) throws Exception 
	{
		//fillStudents(); ^^^^^ ENABLE FOR TESTING PURPOSES, AUTOFILL STUDENTS ARRAY ^^^^^^
		//textResults.prefHeight(400); Pretty sure this does nothing, not sure why.
		
//******************* MAIN MENU SCENE ITEMS ***************************
			Menu menu = new Menu("Menu");
			Button addStudent_button = new Button("Add Student");
			Button modifyStudent_button = new Button("Modify Student");
			Button delStudent_button = new Button("Delete Student");
			//Scroll Pane shows students in students<> linked list.
			ScrollPane scrollpane = new ScrollPane(textResults);
			scrollpane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
			scrollpane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
			scrollpane.fitToWidthProperty();
			scrollpane.setPrefSize(400, 500);
			textResults.setPrefSize(400, 500);
		
//************************** MENU ITEMS ************************	
			MenuItem menuSave = new MenuItem("Save to File");
			MenuItem menuQuit = new MenuItem("Quit");
			MenuItem menuSortList = new MenuItem("Sort List by Name");
			MenuItem menuPopulate = new MenuItem("Populate Sample Data");
			//Combine items into new menu
			menu.getItems().add(menuSave);
			menu.getItems().add(menuSortList);
			menu.getItems().add(menuPopulate);
			menu.getItems().add(menuQuit);
			
			//Combine menu into menu bar
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().add(menu);
			
//**************************** MAIN SCENE ***************************			
			GridPane gridpane = new GridPane();
			gridpane.setHgap(8);
			gridpane.setVgap(8);
			gridpane.add(addStudent_button,1,1);
			//gridpane.add(modifyStudent_button,2,1); ***** MODIFY STUDENT OPTION DISABLED DUE TO TIME CONTRAINTS ******
			gridpane.add(delStudent_button,3,1);
			
			gridpane.setBackground(null);
			//Color backColor = new Color(0,0,0,0);
			GridPane gridpane2 = new GridPane();
			gridpane2.setHgap(8);
			gridpane2.setVgap(8);
			gridpane2.add(scrollpane, 2, 2);
			gridpane2.setHalignment(scrollpane, HPos.CENTER);
			
			

//************************* EDIT WINDOW SCENE **************************		
		
		Label sID_label = new Label("Student ID");
		Label sAddr_label = new Label("Address");
		Label sName_label = new Label("Name");
		Label sGPA_label = new Label("GPA");
		Label nameFormat_label = new Label("First Middle Last Title (eg: Gregory John House, M.D.)");
		Label sError_label = new Label("");
		Button addAccept_button = new Button("Accept");
		Button sBack_button = new Button("Back");
		
		int newSID = makeID();
		sID_textField.setText(Integer.toString(newSID));
		sID_textField.setEditable(false);
		GridPane gridEdit = new GridPane();
		gridEdit.setHgap(8);
		gridEdit.setVgap(8);
		gridEdit.add(sID_label, 1, 1);
		gridEdit.add(sName_label, 1, 2);
		gridEdit.add(sAddr_label, 1, 4);
		gridEdit.add(sGPA_label, 1, 5);
		gridEdit.add(nameFormat_label, 2, 3);
		gridEdit.add(sID_textField, 2, 1);
		gridEdit.add(sName_textField, 2, 2);
		gridEdit.add(sAddr_textField, 2, 4);
		gridEdit.add(sGPA_textField, 2, 5);
		gridEdit.add(addAccept_button, 1, 6);
		gridEdit.add(sBack_button, 2, 6);
		gridEdit.add(sError_label, 2, 7);
		gridEdit.setBackground(null);

//************************ DELETE WINDOW SCENE*********************
		
		//Button delMod_button = new Button ("Modify");
		Button delete_button = new Button ("Delete");
		//Button confirmDelete_button = new Button ("Confirm Delete");
		Button delBack_button = new Button ("Cancel");
		Label  delID_label = new Label("Student ID ");
		Label delStatus_label = new Label("");
		GridPane gridDel = new GridPane();
		TextField delSel_textField = new TextField("");
		gridDel.setHgap(8);
		gridDel.setVgap(8);
		gridDel.add(delID_label, 0, 0);
		gridDel.add(delSel_textField, 1, 0);
		gridDel.add(delete_button, 0, 1);
		gridDel.add(delBack_button, 1, 1);
		gridDel.add(delStatus_label, 1, 2);
	
//************************ SELECT FOR MOD WINDOW SCENE*********************
		Label mSID_label = new Label("Student ID:");
		TextField mSID_textField = new TextField("");
		Button modSel_button = new Button ("Modify");
		Button modBack_button = new Button ("Cancel");
		GridPane modSelGrid = new GridPane();
		modSelGrid.setHgap(8);
		modSelGrid.setVgap(8);
		modSelGrid.add(mSID_label, 0, 1);
		modSelGrid.add(mSID_textField, 1, 1);
		modSelGrid.add(modSel_button, 0, 2);
		modSelGrid.add(modBack_button, 1, 2);		
		//vboxEdit.getChildren().add();
		

		
//make new VBox window. Attach Menubar and gridpane. Attach VBox to Scene. SCENE TO stage 
		
		VBox vboxEdit = new VBox(gridEdit);
		VBox vboxDel = new VBox(gridDel);
		VBox vboxModSel = new VBox(modSelGrid);
		VBox vboxMain = new VBox(menuBar, gridpane,gridpane2);
		Scene mainScene =  new Scene(vboxMain, 400,640);
		Scene editScene = new Scene(vboxEdit,400,640);
		Scene delScene = new Scene(vboxDel,400,640);
		Scene modSelScene = new Scene(vboxModSel,400,640);
		//Combine scene into state, set title, set stage as visible.
		//BorderPane borderpane = new BorderPane();

		stage1.setTitle("Portfolio Project - Gregory Norris");

		stage1.setScene(mainScene);
		stage1.show();
		/*
		  	addStudent
		  	modifyStudent
		  	delStudent
		  	acceptMod_button
			acceptDel_button
			Button selMod_button
			Button selDel_button
			
		*/		
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^  EVENT HANDLERS ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	
		// ****************  QUIT PROGRAM  *******************
		menuQuit.setOnAction
		(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{ System.exit(0); }
		});
		
		//*****************  ADD STUDENT SCENE  **********************
		addStudent_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				stage1.setScene(editScene);
			}
			
		});
		
		//**************** ADD STUDENT FROM USER INPUT ***********************
		addAccept_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				try 
			{
					int newSID     = makeID();
					String strNewSID = Integer.toString(newSID);
					String newName = sName_textField.getText();
					String newAddr = sAddr_textField.getText();
					double newGPS  = Double.parseDouble(sGPA_textField.getText());
					if ((newGPS>=0)&&(newGPS<=4)&&(!newName.isEmpty())&&(!newAddr.isEmpty())) 
					{
						addStudent(newSID,newName,newAddr,newGPS);
						sError_label.setText("Student "+newName+" added successfully");
						newSID = makeID();
						strNewSID = Integer.toString(newSID);
						sID_textField.setEditable(true);
						sID_textField.setText(strNewSID);
						sID_textField.setEditable(false);
						sAddr_textField.setText("");
						sName_textField.setText("");
						sGPA_textField.setText("");
					}
					else {sError_label.setText("Can not complete add. Check Parameters.\n Name can not be empty. GPA must be between 0-4");}
			} 	catch (NumberFormatException err) 
				{
					sError_label.setText("Can not complete add. Check Parameters.");
					//err.printStackTrace();
				}
			}
			
		});
		//*****************  MODIFY STUDENT  **********************
		modifyStudent_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				
				stage1.setScene(editScene);
			}
		});
		//****************** BACK TO MAIN ***********************
		sBack_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				resetStage();
				stage1.setScene(mainScene);
				
			}
		});
//******************************  DELETE STUDENT ****************************
		delStudent_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				stage1.setScene(delScene);
				
			}
		});
//************************ ACCEPT DELETION **************************
		delete_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				String delUI = delSel_textField.getText();
				try 
				{
					int delInt = Integer.parseInt(delUI);
					boolean delStats = deleteStudent(delInt);
					if (delStats) 
					{
						delStatus_label.setText("Deletion Successful");
						delSel_textField.setText("");
					}
					else{delStatus_label.setText("No match found. Check input.");}
				}
				catch (NumberFormatException err) 
					{
						delStatus_label.setText("Invalid Input.");
					}
				
				resetStage();
			}
		
		});	
//*********************** BACK TO MAIN ************************
		delBack_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				resetStage();
				stage1.setScene(mainScene);
			}
		
		});
//**************************** BACK TO MAIN ************************
		modBack_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				resetStage();
				stage1.setScene(mainScene);
			}
		
		});
//************************* MOD SELECT ***************************
		modifyStudent_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				stage1.setScene(modSelScene);
			}
		
		});	
		//modSel not used currently. Commented out on main scene.
		modSel_button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				try{int modID = Integer.parseInt(sID_textField.getText());}
				catch (Exception exp)
				{
					
				}
				stage1.setScene(modSelScene);
			}
		
		});
//*********************** MENU SAVE TO FILE **********************		
		menuSave.setOnAction
		(new EventHandler<ActionEvent>() 
		{
			
			public void handle(ActionEvent event) 
			{
				Stage fileStage = new Stage();
				printToFile(fileStage);
			}
		});
//********************* MENU SORT LIST *****************		
		menuSortList.setOnAction
		(new EventHandler<ActionEvent>() 
		{
			
			public void handle(ActionEvent event) 
			{
				SortName sortedClass = new SortName(students);
				students = sortedClass.getSorted();
				System.out.println("######################## FINAL SORTED LIST ########################");
				for (Student outStu : students) {System.out.println(outStu.getProperName());}
				resetStage();
			}
		});
//******************** POPULATE WITH SAMPLE DATA *********************		
		menuPopulate.setOnAction
		(new EventHandler<ActionEvent>() 
		{
			
			public void handle(ActionEvent event) 
			{
				fillStudents();
				resetStage();
			}
		});
	
	}//@OVERRIDE
}//END CLASS()
                                
