import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandlerHome implements HttpHandler {

	//ANAND PRAJAPATI - 17031142
	
	
	@Override
	public void handle(HttpExchange he) throws IOException {

		//Create an object called 'dao'
		/*The VehicleDAO class is the subclass, and inherits the attributes and methods from this class, HandlerHome, 
		 * which is the superclass.*/
		VehicleDAO dao = new VehicleDAO();


		//This is the HTML code which displays the column titles on the table - which are the vehicle variable names
		String head = "<html><head></head><body><h1>Anand's Vehicle Inventory System</h1>"
				+ "<table border=\"1\"> <tr><th>Vehicle ID</th><th>Make</th> "
				+ "<th>Model</th> <th>Year</th> <th>Price</th> <th>License Number</th> <th>Colour</th> "
				+ "<th>Number Doors</th> <th>Transmission</th> <th>Mileage</th><th>Fuel Type</th> "
				+ "<th>Engine Size</th> <th>Body Style</th> <th>Condition</th> <th>Notes</th></tr>";



		//This is closes the HTML code tags
		String foot = "</table></body></html>";
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));


		/*This ArrayList stores the Vehicle class, which contains the vehicle instance variables. It is called
		 * vehicles. It is set to null, which means it cannot be empty*/
		ArrayList<Vehicle> vehicles = null;



		//The try method runs the SQL exception, used to retrieve data from the database
		//The catch method will run if the try method doesn't retrieve anything

		try {
			vehicles = dao.getAllVehicles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		he.sendResponseHeaders(200, 0); // This must send the Http response, or it will not work 
		out.write(head);



		/*The for loop goes through the 'vehicles' local variable, which equals the getAllVehicles 
		 method from the VehicleDAO class, and then gets the vehicle information from the getters, 
		  so it gets inserted into the table.*/
		for (Vehicle ins : vehicles) {
			out.write("<tr> " + "<td>" + ins.getVehicle_id() + "</td> " + "<td>" + ins.getMake() 
			+ "</td> " + "<td>" + ins.getModel() +
			"</td> " + "<td>" + ins.getYear() + "</td> " + "<td>"

				    +
				    ins.getPrice() + "</td> " + "<td>" + ins.getLicense_number() + "</td> " + "<td>"

				    +
				    ins.getColour() + "</td> " + "<td>" + ins.getNumber_doors() + "</td> " + "<td>"

				    +
				    ins.getTransmission() + "</td> " + "<td>" + ins.getMileage() + "</td> " + "<td>"

				    +
				    ins.getFuel_type() + "</td> " + "<td>" + ins.getEngine_size() + "</td> " + "<td>"

				    +
				    ins.getBody_style() + " </td> " + " <td> " + ins.getCondition() + "</td> " + "<td>" +
				    ins.getNotes());




		}

		out.write(foot);

		out.close();
	}

}