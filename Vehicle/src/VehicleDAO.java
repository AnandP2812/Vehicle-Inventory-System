import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class VehicleDAO {
	
	//ANAND PRAJAPATI - 17031142

	/**This gets the database connection
	 *  
	 * @return This  returns statement object 
	 */

	private static Connection getDBConnection() {
		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC"); //Initialises the database
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()); //Prints out message if there is an exception
		}

		try {
			String url = "jdbc:sqlite:vehicles.sqlite"; //Stores the name of the database location within URL
			conn = DriverManager.getConnection(url); //Links the database with a connection 
		} catch (SQLException e) {
			System.out.println(e.getMessage()); //Returns a message
		}

		return conn;

	}


	/**
	 * Gets all the vehicles from the vehicles table
	 * 
	 * 
	 * @return Returns the list of all vehicles from the ArrayList called 'vehicleList'
	 * @throws SQLException
	 */
	public ArrayList < Vehicle > getAllVehicles() throws SQLException { //
		System.out.println("Retrieving all Vehicles..."); //Tells the user its retrieving all vehicles
		Connection dbConnection = null; //Sets the dbConnection to null
		Statement statement = null; //Sets the statement to null
		ResultSet result = null; //Sets result to null
		String query = "SELECT * FROM vehicles;"; //This is the SQL query to get all the vehicles
		Vehicle temp = null; //Sets temp to null
		ArrayList < Vehicle > vehicleList = new ArrayList < > (); /*Creates a new ArrayList called 'vehicleList'
		,which inherits information from the Vehicle class*/


		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query); //Prints the SQL query 
			result = statement.executeQuery(query);
			while (result.next()) {


				//The getters get the vehicle information for each vehicle on the database

				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");

				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");

				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");




				vehicleList.add(new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes));
			}
		} finally {
			if (result != null) { //If the result is not equal to null
				result.close(); //The result will close
			}
			if (statement != null) { //If the statement is not equal null
				statement.close(); //The statement will close
			}
			if (dbConnection != null) { //If the dbConnection is not equal to null
				dbConnection.close(); //The dbConnection will close
			}
		}
		return vehicleList; //returns the list of vehicles
	}




	/**
	 * 
	 * @param vehicle_id gets the vehicle id entered from the user
	 * @return a single vehicle from the id that was entered from the user
	 * @throws SQLException
	 */
	public Vehicle getVehicle(int vehicle_id) throws SQLException { //Stores the vehicle_id entered by the user

		Vehicle temp = null;
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;

		String query = "SELECT * FROM vehicles WHERE vehicle_id =" + vehicle_id + ";"; 
		//The SQL query which gets a single vehicle ID from the user's input

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery: " + query);
			// execute SQL query
			result = statement.executeQuery(query);

			while (result.next()) { //While there is something in result, it will get the vehicle information 

				//Gets the vehicle information
				
				int vehicle_id1 = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");

				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");

				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");



				//Creates a temporary vehicle object, containing the details of the vehicle searched by the user

				temp = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes);


			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return temp;
	}



	/**
	 * 
	 * @param in stores the new vehicle information to be inserted from the user
	 * @return ok boolean statement, which returns true
	 * @throws SQLException
	 */
	public boolean insertRecordIntoVehiclesTable(Vehicle in ) throws SQLException { 
		//'in' contains the new vehicle information from the user
		Connection dbConnection = null;
		Statement statement = null;


		//Gets the new vehicle information and inserts it into 'in', which contains the updated vehicle attributes
		//This is the SQL statement which inserts the new information
		String update = "INSERT INTO vehicles (vehicle_id, make, model, year, price, license_number, colour, number_doors, " +
				"transmission, mileage, fuel_type, engine_size, body_style, condition, notes)"

   +
   " VALUES (" + in .getVehicle_id() + ",' " + in .getMake() + " ',' " + in .getModel() + " '," 
   + in .getYear() + "," + in .getPrice() +

   ",' " + in .getLicense_number() + " ',' " + in .getColour() + " '," + in .getNumber_doors() 
   + ",' " + in .getTransmission() + " '," + in .getMileage() +

   ",' " + in .getFuel_type() + " '," + in .getEngine_size() + ",' " + in .getBody_style() + " ',' " 
   + in .getCondition() + " ',' " + in .getNotes() + " ');";



		boolean ok = false; //When boolean equals false, it gets the DB connection
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(update);
			// execute SQL query
			statement.executeUpdate(update); //Executes the update query
			ok = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) { //If the statement is not equal to null, then...
				statement.close(); //It ends the statement
			}
			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return ok;
	}


	/**
	 * 
	 * @param Vehicle contains the updated vehicle information
	 * @param vehicle_id_update gets the id of the vehicle that is going to be updated
	 * @return true
	 * @throws SQLException
	 */
	public Boolean updateVehicle(Vehicle Vehicle, int vehicle_id_update) throws SQLException { 
		//Holds the updated information and the vehicle id that will be updated (vehicle id is what the user inputs)
		Connection dbConnection = null;
		Statement statement = null;

		//This is the SQL query which gets the updated vehicle information from the user and updates it

		String query = "UPDATE vehicles " + "SET vehicle_id = ' " + Vehicle.getVehicle_id() + " '," +
				"make = ' " + Vehicle.getMake() + " ', " + "model = ' " + Vehicle.getModel() + " ', " 
				+ "year = ' " + Vehicle.getYear() +
				" ', " + "price = ' " + Vehicle.getPrice() + " ', " + "license_number = ' " 
				+ Vehicle.getLicense_number() + " ', " + "colour = ' " +
				Vehicle.getColour() + " ', " + "Number_doors = ' " + Vehicle.getNumber_doors() + " ', " 
				+ "Transmission = ' " +
				Vehicle.getTransmission() + " ', " + "Mileage = ' " + Vehicle.getMileage() + " ', " 
				+ "Fuel_type = ' " +
				Vehicle.getFuel_type() + " ', " + "engine_size = ' " + Vehicle.getEngine_size() + " ', " 
				+ "body_style = ' " +
				Vehicle.getBody_style() + " ', " + "condition = ' " + Vehicle.getCondition() + " ', " 
				+ "notes = ' " +
				Vehicle.getNotes() + " ' WHERE vehicle_id = ' " + vehicle_id_update + " ' ";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query); //Prints the SQL query
			// execute SQL update
			statement.executeUpdate(query); //Executes the SQL query

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return false; //Returns false

		} finally {

			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return true; 
	}



	/**
	 * 
	 * @param vehicle_id is id of the vehicle entered by the user which will be deleted
	 * @throws SQLException
	 */

	public Boolean deleteVehicle(int vehicle_id) throws SQLException {  
		//vehicle_id is what we are using to get the vehicle and delete it
		System.out.println("Deleting Vehicle"); //Tells the user the system is deleting the vehicle
		Connection dbConnection = null;
		Statement statement = null;
		int result = 0;


		//This is the SQL query which deletes a vehicle by using the vehicle_id

		String query = "DELETE FROM vehicles WHERE vehicle_id = " + vehicle_id + ";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			// This executes the SQL query
			result = statement.executeUpdate(query); //Executes the SQL query
		} finally {
			if (statement != null) { 
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		if (result == 1) { //If the result is equal to 1
			return true; //Returns true
		} else { 
			return false; 
		}
	}

}