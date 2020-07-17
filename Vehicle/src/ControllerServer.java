import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sun.net.httpserver.*;

public class ControllerServer {

	//ANAND PRAJAPATI - 17031142	
	
	public static void main(String[] args) {

		//This is the GET operation		
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);

			//list all the vehicles on the database
			server.createContext("/", new HandlerHome());

			//This is opens the page to add a new vehicle on the HTML form		
			server.createContext("/add_vehicle",new HandlerAddNewVehicleForm());

			// This processes the add new vehicle form data when submitted
			server.createContext("/add_write", new HandlerProcessNewVehicle());

			//Tells the user on the console the server is up and running
			System.out.println("The server is up and running on port 8000");	

			//This starts the server
			server.start();
		}
		catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage() + "  " + ioe.getStackTrace());
		}

	}
}