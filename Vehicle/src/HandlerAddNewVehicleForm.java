import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HandlerAddNewVehicleForm implements HttpHandler {

	//ANAND PRAJAPATI - 17031142
	
	@Override
	public void handle(HttpExchange he) throws IOException {

		//This outputs the HTML form
		he.sendResponseHeaders(200, 0); 
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(he.getResponseBody()));


		//This line of code processes the new vehicle information from the form

		out.write("<html><head></head><body><form method=\"POST\" action=\"/add_write\">");


		//out.write prints the form information on the HTML page, allowing the user to enter vehicle information

		out.write("Vehicle ID:<input name=\"vehicle_id\"><br>");
		out.write("Make:<input name=\"make\"><br>");
		out.write("Model:<input name=\"model\"><br>");
		out.write("Year:<input name=\"year\"><br>");
		out.write("Price:<input name=\"price\"><br>");

		out.write("License_number:<input name=\"license_number\"><br>");
		out.write("Colour:<input name=\"colour\"><br>");
		out.write("Number Doors:<input name=\"number_doors\"><br>");
		out.write("transmission:<input name=\"transmission\"><br>");

		out.write("Mileage:<input name=\"mileage\"><br>");
		out.write("Fuel type:<input name=\"Fuel_type\"><br>");
		out.write("Engine size:<input name=\"engine_size\"><br>");
		out.write("Body style:<input name=\"Body_style\"><br>");
		out.write("Condition:<input name=\"condition\"><br>");
		out.write("Notes:<input name=\"notes\"><br>");


		//This allows the user to submit the new vehicle information on the form

		out.write("<input type=\"submit\" value=\"Submit\">");
		out.write("</form></body></html>");
		out.close();

	}

}