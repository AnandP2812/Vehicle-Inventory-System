import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandlerProcessNewVehicle implements HttpHandler {
	
	
	//ANAND PRAJAPATI - 17031142

	
	@Override
	public void handle(HttpExchange he) throws IOException {
		
		
		/*Create an object called 'dao'. The VehicleDAO class is the subclass, and 
		 * inherits the attributes and methods from this class, HandlerProcessNewVehicle, which is the superclass.*/
		VehicleDAO dao = new VehicleDAO();
		
		
		HashMap<String,String> post = new HashMap<String,String>();
		//This goes and reads the request body 
		BufferedReader in = new BufferedReader(new InputStreamReader(he.getRequestBody()));
		String line = "";
		String request = "";
		while((line = in.readLine()) != null) {
			request = request + line;
		}
		System.out.println(request);

		//These are the individual key=value pairs are delimited by ampersands. 
		String[] pairs = request.split("&");					
		for(int i=0;i<pairs.length;i++) {
			//Therefore, each key=value pair is separated by an equals sign, and both halves require URL decoding.
			String pair = pairs[i];
			post.put(URLDecoder.decode(pair.split("=")[0],"UTF-8"),URLDecoder.decode(pair.split("=")[1],"UTF-8"));
		}					
		//This should then have a HashMap of data which is posted in the 'post' variable
		
		
		
		/*Here I have created a new object called 'ins' from the Vehicle class, which equals new Vehicle. This means,
		 * the Vehicle class is the subclass and inherits the methods from this class. */
		Vehicle ins = new Vehicle();
		

		
		/*This sets the instance variable to the user's input. It then gets posted or parsed, depending if its
		an integer or string. The object 'ins' inherits the vehicle instance variables*/
		
		ins.setVehicle_id(Integer.parseInt(post.get("vehicle_id")));
		ins.setMake(post.get("make"));
		ins.setModel(post.get("model"));
		ins.setYear(Integer.parseInt(post.get("year")));
		ins.setPrice(Integer.parseInt(post.get("price")));
		
		ins.setLicense_number(post.get("license_number"));
		ins.setColour(post.get("colour"));
		ins.setNumber_doors(Integer.parseInt(post.get("number_doors")));
		ins.setTransmission(post.get("transmission"));
		ins.setMileage(Integer.parseInt(post.get("mileage")));
		
		
		ins.setFuel_type(post.get("Fuel_type"));
		ins.setEngine_size(Integer.parseInt(post.get("engine_size")));
		ins.setBody_style(post.get("Body_style"));
		ins.setCondition(post.get("condition"));
		ins.setNotes(post.get("notes"));


		
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));					
		try { 
			dao.insertRecordIntoVehiclesTable(ins); /*Adds the new vehicle onto the database from the method in the 
			VehicleDAO class*/
			he.sendResponseHeaders(200, 0); //HTTP 200 (OK)
			
			//Indicates the vehicle has successfully been inserted
			out.write("<p>Success!</p> <a href=\"./\">Back to Anand's Vehicle Inventory System</a>");
		}
		catch(SQLException se) {
			 he.sendResponseHeaders(500, 0); //HTTP 500 (Internal Server Error)
			 out.write("Error Adding Vehicle");
		} finally {
			out.close();
		}
	}

}