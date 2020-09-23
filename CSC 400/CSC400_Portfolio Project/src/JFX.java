import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JFX extends Application 
{
//  @@@@@@@@@@@@@@@@ QUEUE CONTAINING PEOPLE INFORMATION @@@@@@@@@@@@@@@@@@
	private PQueue<Person> people = new PQueue<Person>();
	
	Stage stage1 = new Stage();
//^^^^^^^^^^^^^^ MAIN AND EDIT MENU VALUES ^^^^^^^^^^^^^^^^^	
		TextField textfield = new TextField("");
		TextArea textResults = new TextArea();
		TextField sFirst_textField = new TextField("");
		TextField sLast_textField = new TextField("");
		TextField sAge_textField = new TextField("");

//******************* ADD NEW Person **********************
		private void addPerson(String iFirst, String iLast, int iAge) 
		{
			//return " ";
			Person tempPerson = new Person(iFirst,iLast,iAge);
			people.enqueue(tempPerson);
		}
		private void resetStage(boolean display) 
		{
			//RESET TEXT VALUES ON ALL FIELDS
			sFirst_textField.setText("");
			sLast_textField.setText("");
			sAge_textField.setText("");
			textResults.setText("");
			// REFILLS THE TEXT WINDOW CONTAINING LIST OF STUDENTS
			if (display) 
			{
				PQueue<Person> tempQ = new PQueue<Person>();
				tempQ = people;
				while (tempQ.notEmpty()) 
				{
					Person tempP = people.dequeue();
					System.out.println("\n"+tempP.toString());
					textResults.appendText("\n"+tempP.toString());
				}
			}
		}
// @@@@@@@@@@@@@@@@@   START(STAGE ARG0) @@@@@@@@@@@@@@@@@	
		@Override
	public void start(Stage arg0) throws Exception {

//******************* MAIN MENU SCENE ITEMS ***************************
		Menu menu = new Menu("Menu");
		Button addPerson_button = new Button("Add Person");
		Button sortAge_button = new Button("Sort by Age");
		Button sortName_button = new Button("Sort by Last Name");
		Button printQueue_button = new Button("Print Queue");
		//Scroll Pane shows students in students<> linked list.
		ScrollPane scrollpane = new ScrollPane(textResults);
		scrollpane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollpane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollpane.fitToWidthProperty();
		scrollpane.setPrefSize(400, 500);
		textResults.setPrefSize(400, 500);
	
//************************** MENU BAR ITEMS ************************	
		//MenuItem menuSave = new MenuItem("Save to File");
		MenuItem menuQuit = new MenuItem("Quit");
		MenuItem menuPopulate = new MenuItem("Populate Sample Data");
		//Combine items into new menu
		//menu.getItems().add(menuSave);
		menu.getItems().add(menuPopulate);
		menu.getItems().add(menuQuit);
		
		//Combine menu into menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(menu);
		
//**************************** MAIN SCENE ***************************			
		GridPane gridpane = new GridPane();
		gridpane.setHgap(8);
		gridpane.setVgap(8);
		gridpane.add(addPerson_button,1,1);
		gridpane.add(sortAge_button,2,1);
		gridpane.add(sortName_button,3,1);
		gridpane.add(printQueue_button,4,1);
		gridpane.setBackground(null);
		//Color backColor = new Color(0,0,0,0);
		GridPane gridpane2 = new GridPane();
		gridpane2.setHgap(8);
		gridpane2.setVgap(8);
		gridpane2.add(scrollpane, 2, 2);
		gridpane2.setHalignment(scrollpane, HPos.CENTER);
		

		//************************* EDIT WINDOW SCENE **************************		
		
		Label sFirst_label = new Label("First Name");
		Label sLast_label = new Label("Last Name");
		Label sAge_label = new Label("Age");
		Label sError_label = new Label("");
		Button addAccept_button = new Button("Accept");
		Button sBack_button = new Button("Back");
		
		GridPane gridAdd = new GridPane();
		gridAdd.setHgap(8);
		gridAdd.setVgap(8);
		gridAdd.add(sFirst_label, 1, 1);
		gridAdd.add(sLast_label, 1, 2);
		gridAdd.add(sAge_label, 1, 4);
		gridAdd.add(sFirst_textField, 2, 1);
		gridAdd.add(sLast_textField, 2, 2);
		gridAdd.add(sAge_textField, 2, 4);
		gridAdd.add(addAccept_button, 1, 6);
		gridAdd.add(sBack_button, 2, 6);
		gridAdd.add(sError_label, 2, 7);
		gridAdd.setBackground(null);
		//make new VBox window. Attach Menubar and gridpane. Attach VBox to Scene. SCENE TO stage 
		
		VBox vboxAdd = new VBox(gridAdd);
		VBox vboxMain = new VBox(menuBar,gridpane,gridpane2);
		Scene mainScene =  new Scene(vboxMain, 400,640);
		Scene addScene = new Scene(vboxAdd,400,640);
		//Combine scene into state, set title, set stage as visible.
		//BorderPane borderpane = new BorderPane();

		stage1.setTitle("CSC400 Portfolio Project - Gregory Norris");

		stage1.setScene(mainScene);
		stage1.show();
				
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
// ^^^^^^^^^^^^^^^^^^^^^^^^^^^  EVENT HANDLERS ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
	
		// ****************  QUIT PROGRAM  *******************
		menuQuit.setOnAction
		(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{ System.exit(0); }
		});
//*****************  ADD STUDENT SCENE  **********************
addPerson_button.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) 
	{
		stage1.setScene(addScene);
	}
	
});

//****************** BACK TO MAIN ***********************
sBack_button.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) 
	{
		resetStage(false);
		stage1.setScene(mainScene);
		
	}
});		
//****************** PRINT QUEUE ***********************
printQueue_button.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) 
	{
		resetStage(true);
		stage1.setScene(mainScene);
	}
});
//****************** SORT BY AGE ***********************
sortAge_button.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) 
	{
		QSortAge sortAge = new QSortAge();
		sortAge.qSortByAge(people);
		
	}
});
//****************** SORT BY NAME ***********************
sortAge_button.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) 
	{
		QSortFName sortFirst = new QSortFName();
		QSortLName sortLast  = new QSortLName();
		sortFirst.qSortByFirst(people);
		 sortLast.qSortByLast(people);
		
	}
});

//**************** ADD PERSON FROM USER INPUT ***********************
addAccept_button.setOnAction(new EventHandler<ActionEvent>() {
	public void handle(ActionEvent event) 
	{
		try 
	{
			String newFirst = sFirst_textField.getText();
			String newLast = sLast_textField.getText();
			String newAge = sAge_textField.getText();
			int newAgeInt = Integer.parseInt(newAge);
			if (!newFirst.isEmpty()&&!newLast.isEmpty()&&(newAgeInt>=0)) 
			{
				addPerson(newFirst,newLast,newAgeInt);
				sError_label.setText("Person "+newFirst+" added successfully");
				sFirst_textField.setText("");
				sAge_textField.setText("");
				sLast_textField.setText("");
			}
			else {sError_label.setText("Can not complete add. Check Parameters.\n Name can not be empty. Age must be positive integer.");}
	} 	catch (NumberFormatException err) 
		{
			sError_label.setText("Can not complete add. Check Parameters.");
			//err.printStackTrace();
		}
	}
	
});
	}
}
