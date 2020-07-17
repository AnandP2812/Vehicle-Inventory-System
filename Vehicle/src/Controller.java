import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner; //Imports the scanner class

public class Controller { //Name of the class

	
	//ANAND PRAJAPATI - 17031142
	
	

	public static void main(String[] args) throws SQLException {



		Scanner selectOption = new Scanner(System.in); //Creates a scanner object called 'selectOption'


		while(true) { //The while loop keeps looping the program because its always true



			System.out.println("-----------------------------------"); //Prints out a dotted line 
			System.out.println(" Anand's Vehicle Inventory System"); //Prints the title
			System.out.println(" Please select an option below "); //Tells the user to select an option
			System.out.println("-----------------------------------");  

			System.out.println("1. Retrieve all vehicles"); //Prints out option 1, to retrieve all the vehicles
			System.out.println("2. Search for vehicle"); //Prints out option 2, to search for a vehicle
			System.out.println("3. Insert new vehicle into database"); //Prints out option 3, to insert a new vehicle
			System.out.println("4. Update existing vehicle details"); //Prints out option 4, to update a vehicle
			System.out.println("5. Delete vehicle from database"); //Prints out option 5, to delete a vehicle
			System.out.println("6. Exit"); //Prints out option 6, to exit the the program

			System.out.println("-----------------------------------"); 


			System.out.println("Enter choice: "); //Prompts the user to enter a choice



			int choice = selectOption.nextInt(); 
			//Reads the user's input from the keyboard, which is an integer called 'choice' 


			VehicleDAO dao = new VehicleDAO(); 
			//Create an object called 'dao'
			/*The VehicleDAO class is the subclass, and inherits the attributes and methods from this class, Controller, 
			 * which is the superclass.*/

			switch (choice) { /*The user's input, 'choice', is passed through this switch statement, which has six cases. 
			Each case has a number; and depending on the user's input, a different case will be executed. 
			For example, if they input the number 6, the code in case 6 will be executed.*/

			case 1: //Retrieves all vehicles

				System.out.println("Retrieving all vehicles...."); /*Tells the user that the program is retrieving 
				all the vehicles */


				ArrayList < Vehicle > allVehicles = null;  /* This returns all the vehicles stored on the database. 
				The ArrayList is called allVehicles and holds the vehicle data variables stored in the Vehicle class, 
				and is set to null, meaning it cannot be empty.*/

				System.out.println("-----------------------------------"); 
				System.out.println("1. Retrieve all vehicles"); //Tells the user what option they have selected
				System.out.println("-----------------------------------"); 

				allVehicles = dao.getAllVehicles(); 
				/*Assigns the method to get all the vehicles from the VehicleDAO class*/
				
				for (Vehicle v: allVehicles) { //This loops through the Vehicle class ArrayList
					System.out.println("-----------------------------------"); 
					System.out.println(v); //Prints all the vehicles
				}




				break; //Terminates a case in the switch statement


			case 2: //Retrieves single vehicle



				Scanner searchVehicle = new Scanner(System.in);
				System.out.println("-----------------------------------");
				System.out.println("2. Search for vehicle");
				System.out.println("-----------------------------------");
				System.out.println("Enter vehicle ID: "); //Tells the user to enter a vehicle id
				int searchID = searchVehicle.nextInt(); //Gets the user's input
				System.out.println(dao.getVehicle(searchID)); /*getVehicle is the method which returns a single 
				vehicle once the user's input has been received, through the VehicleDAO class.*/




				break;


			case 3: //Inserts a new vehicle

				System.out.println("-----------------------------------");
				System.out.println("3. Insert new vehicle");
				System.out.println("-----------------------------------");


				Scanner vehicle_id = new Scanner(System.in); //Creates scanner object
				System.out.println("Enter ID:"); //Tells the user to enter the new information
				int new_vehicle_id = vehicle_id.nextInt();//Gets the user input

				Scanner make = new Scanner(System.in);
				System.out.println("Enter Make:");
				String new_make = make.nextLine();

				Scanner model = new Scanner(System.in);
				System.out.println("Enter Model:");
				String new_model = model.nextLine();

				Scanner year = new Scanner(System.in);
				System.out.println("Enter Year:");
				int new_year = year.nextInt();

				Scanner price = new Scanner(System.in);
				System.out.println("Enter Price:");
				int new_price = price.nextInt();

				Scanner license_number = new Scanner(System.in);
				System.out.println("Enter License Number:");
				String new_license_number = license_number.nextLine();

				Scanner colour = new Scanner(System.in);
				System.out.println("Enter Colour:");
				String new_colour = colour.nextLine();

				Scanner number_doors = new Scanner(System.in);
				System.out.println("Enter Number of Doors:");
				int new_number_doors = number_doors.nextInt();

				Scanner transmission = new Scanner(System.in);
				System.out.println("Enter Transmission:");
				String new_transmission = transmission.nextLine();

				Scanner mileage = new Scanner(System.in);
				System.out.println("Enter Mileage:");
				int new_mileage = mileage.nextInt();

				Scanner fuel_type = new Scanner(System.in);
				System.out.println("Enter Fuel Type:");
				String new_fuel_type = fuel_type.nextLine();

				Scanner engine_size = new Scanner(System.in);
				System.out.println("Enter Engine Size:");
				int new_engine_size = engine_size.nextInt();

				Scanner body_style = new Scanner(System.in);
				System.out.println("Enter Body Style:");
				String new_body_style = body_style.nextLine();

				Scanner condition = new Scanner(System.in);
				System.out.println("Enter Condition:");
				String new_condition = condition.nextLine();

				Scanner notes = new Scanner(System.in);
				System.out.println("Enter Notes:");
				String new_notes = notes.nextLine();


				//Creates a new constructor with the new vehicle details entered by the user. 

				Vehicle in = new Vehicle(new_vehicle_id, new_make, new_model, new_year, new_price, new_license_number,
						new_colour, new_number_doors, new_transmission, new_mileage, new_fuel_type, new_engine_size,
						new_body_style, new_condition, new_notes);

				
				
				dao.insertRecordIntoVehiclesTable( in ); 
				/*insertRecordIntoVehiclesTable is the method executed from the VehicleDAO  class, which executes 
				the code to add a new vehicle*/
				// 'in' is the variable which stores the new vehicle information

				allVehicles = dao.getAllVehicles(); 
				//Assigns the method to get all the vehicles from the VehicleDAO class
				
				for (Vehicle v: allVehicles) { //Loops through the Vehicle class
					System.out.println("_____________");
					System.out.println(v); //Prints the new vehicle information
				}







				break;


			case 4: //Update Vehicle


				System.out.println("-----------------------------------");
				System.out.println("4. Update vehicle");
				System.out.println("-----------------------------------");


				Scanner userInput = new Scanner(System.in); //Creates scanner object

				System.out.println("Enter vehicle ID:  "); //Tells user to enter vehicle id

				int update_vehicle_id = userInput.nextInt(); //Gets the vehicle id to update

				System.out.println("-----------------------------------");
				System.out.println("Enter updated details: ");
				System.out.println("-----------------------------------");

				Scanner Vehicle = new Scanner(System.in); //Creates scanner object
				System.out.print("New ID: "); //Tells the user to enter new information 
				int new_vehicle2 = Vehicle.nextInt(); //Gets the new information and stores it in a new variable name

				Scanner make1 = new Scanner(System.in);
				System.out.print("New Make: ");
				String new_make2 = make1.nextLine();

				Scanner model1 = new Scanner(System.in);
				System.out.print("New Model: ");
				String new_model2 = model1.nextLine();

				Scanner year1 = new Scanner(System.in);
				System.out.print("New Year: ");
				int new_year2 = year1.nextInt();

				Scanner price1 = new Scanner(System.in);
				System.out.print("New Price: ");
				int new_price2 = price1.nextInt();

				Scanner license_number1 = new Scanner(System.in);
				System.out.print("New License Number: ");
				String new_license_number2 = license_number1.nextLine();

				Scanner colour1 = new Scanner(System.in);
				System.out.print("New Colour: ");
				String new_colour2 = colour1.nextLine();

				Scanner number_doors1 = new Scanner(System.in);
				System.out.print("New Number Doors: ");
				int new_number_doors2 = number_doors1.nextInt();

				Scanner transmission1 = new Scanner(System.in);
				System.out.print("New Transmission: ");
				String new_transmission2 = transmission1.nextLine();

				Scanner mileage1 = new Scanner(System.in);
				System.out.print("New Mileage: ");
				int new_mileage2 = mileage1.nextInt();

				Scanner fuel_type1 = new Scanner(System.in);
				System.out.print("New Fuel Type: ");
				String new_fuel_type2 = fuel_type1.nextLine();

				Scanner engine_size1 = new Scanner(System.in);
				System.out.print("New Engine Size: ");
				int new_engine_size2 = engine_size1.nextInt();

				Scanner body_style1 = new Scanner(System.in);
				System.out.print("New Body Style: ");
				String new_body_style2 = body_style1.nextLine();

				Scanner condition1 = new Scanner(System.in);
				System.out.print("New Condition: ");
				String new_condition2 = condition1.nextLine();

				Scanner notes1 = new Scanner(System.in);
				System.out.print("New Notes: ");
				String new_notes2 = notes1.nextLine();


				//Created a new constructor which stores the updated information
				Vehicle updatedDetails = new Vehicle(new_vehicle2, new_make2, new_model2, new_year2, new_price2, new_license_number2,
						new_colour2, new_number_doors2, new_transmission2, new_mileage2, new_fuel_type2, new_engine_size2, new_body_style2,
						new_condition2, new_notes2);


				/*'UpdateVehicle' is the name of the method from the VehicleDAO which executes the code to 
				update a vehicle*/
				/*The 'updateVehicle' method stores the parameters with the updated vehicle information and 
				the vehicle id the user wants to update*/
				dao.updateVehicle(updatedDetails, update_vehicle_id);


				System.out.println(" ");
				System.out.println("-----------------------------------");
				System.out.println("Vehicle has been updated"); //Tells the user the vehicle has been updated
				System.out.println("-----------------------------------");





				break;



			case 5: //Delete Vehicle

				System.out.println("-----------------------------------");
				System.out.println("5. Delete vehicle");
				System.out.println("-----------------------------------");

				Scanner deleteVehicle = new Scanner(System.in); //Creates new scanner

				System.out.println("Enter vehicle ID: "); //Tells the user to enter a vehicle id
				int del = deleteVehicle.nextInt(); //Gets the vehicle id entered by the user
				System.out.println(dao.deleteVehicle(del)); /*deleteVehicle is the method which deletes a vehicle, 
				through the VehicleDAO class from the user's input 'del'.*/

				System.out.println("-----------------------------------");
				System.out.println("Vehicle " + del + " has been DELETED");
				System.out.println("-----------------------------------");





				break;

			case 6: //Exits the database


				System.out.println("-----------------------------------");
				System.out.println("You have exited the database");
				System.out.println("-----------------------------------");
				System.exit(0); //0 indicates successful termination


			}


		}

	}


}