public class Vehicle { // Maps data stored in the vehcile.sqlite database

	
	//ANAND PRAJAPATI - 17031142
	

//Declared the instance variables for each vehicle (data members of the class)
	
 private int vehicle_id; //vehicle id, which is the unique id given to each vehicle on the database
 private String make; //make, which is the manufacturer of the vehicle
 private String model; //model, which is a unique name given to each type of vehicle
 private int year; //year, which is the year the vehicle was released
 private int price; //price, how much the vehicle costs
 private String license_number; //the number plate for a vehicle
 private String colour; //the colour of the vehicle
 private int number_doors; //how many doors the vehicle has
 private String transmission; //whether its manual or automatic
 private int mileage; //distance travelled by the vehicle from its purchase date
 private String fuel_type; //whether its petrol or diesel 
 private int engine_size; //the size of the vehicle's engine
 private String body_style; //the shape and model of the vehicle
 private String condition; //whether is old, new or used
 private String notes; //any other information about the vehicle

 /*Constructor, which is a method used to initialise objects. 
   The name of the object is 'Vehicle', and it contains all the instance variables for each vehicle, which is used 
   to initialise the object's (Vehicle) state.*/
  
 public Vehicle(int vehicle_id, String make, String model, int year, int price, String license_number, String colour, int number_doors, String transmission, int mileage, String fuel_type,
  int engine_size, String body_style, String condition, String notes) {

/*Here I have set the instance variables of the class to the parameter of the constructor called Vehicle. 
 * The keyword 'this' refers to the instance variable belonging to the Vehicle class.
 *  For example, 'this.vehicle_id' refers to the instance variable of the Vehicle class, and equals 
 *  'vehicle_id', which is a parameter of the constructor. This applies to all the other instance variables too.*/
 
  this.vehicle_id = vehicle_id;
  this.make = make;
  this.model = model;
  this.year = year;
  this.price = price;
  this.license_number = license_number;
  this.colour = colour;
  this.number_doors = number_doors;
  this.transmission = transmission;
  this.mileage = mileage;
  this.fuel_type = fuel_type;
  this.engine_size = engine_size;
  this.body_style = body_style;
  this.condition = condition;
  this.notes = notes;
 }

 /*The String toString method has been used because it returns the string representation of the object. 
  Therefore, it returns a string that textually represents this object. For example, ' "Make = " + this.make ', 
   means that the string 'Make' will be printed from the object  'this.make'. This applies to all the other 
   instance variables too. */

 public Vehicle() {
	// TODO Auto-generated constructor stub
}

public String toString() {
  String s = "Vehicle ID = " + this.vehicle_id + '\n' +
   "Make = " + this.make + '\n' +
   "Model = " + this.model + '\n' +
   "Year = " + this.year + '\n' +
   "Price = " + this.price + '\n' +
   "License Number = " + this.license_number + '\n' +
   "Colour = " + this.colour + '\n' +
   "Number Doors = " + this.number_doors + '\n' +
   "Transmission = " + this.transmission + '\n' +
   "Mileage = " + this.mileage + '\n' +
   "Fuel Type = " + this.fuel_type + '\n' +
   "Engine Size = " + this.engine_size + '\n' +
   "Body Style = " + this.body_style + '\n' +
   "Condition = " + this.condition + '\n' +
   "Notes = " + this.notes;

  return s; //Returns the string which is called 's', which contains all the objects


 }

//Getter and setter methods - this is used to retrieve and update a variable
 //The 'get' methods are used to access the variables
 // The 'set' methods are used to set the values of these variables
 
 public void setVehicle_id(int vehicle_id) { //Setter method for Vehicle_id 

	  this.vehicle_id = vehicle_id;
 }
 public int getVehicle_id() { //Getter method for Vehicle_id 
  
	 return vehicle_id; //This returns the vehicle_id object 
 }


 public void setMake(String make) { //Setter method for make
	 this.make = make;
 }
 public String getMake() { //Getter method for make
  return make; //This returns the make object
 }


 public void setModel(String model) { //Setter method for model
	  this.model = model;
 }
 public String getModel() { //Getter method for model
  return model; //This returns the make object
 }


 public void setYear(int year) { //Setter method for year
	 this.year = year;
 }
 public int getYear() { //Getter method for year
  return year; //This returns the year object
 }


 public void setPrice(int price) { //Setter method for price
	 this.price = price;
 }
 public int getPrice() { //Getter method for price
  return price; //This returns the price object
 }


 public void setLicense_number(String license_number) { //Setter method for license_number
	 this.license_number = license_number;
 }
 public String getLicense_number() { //Getter method for license_number
  return license_number; //This returns the license_number object
 }


 public void setColour(String colour) { //Setter method for colour
	 this.colour = colour;
 }
 public String getColour() { //Getter method for colour
  return colour; //This returns the colour object
 }


 public void setNumber_doors(int number_doors) { //Setter method for number_doors
	 this.number_doors = number_doors;
 }
 public int getNumber_doors() { //Getter method for number_doors
  return number_doors; //This returns the number_doors object
 }


 public void setTransmission(String transmission) { //Setter method for transmission
	 this.transmission = transmission;
 }
 public String getTransmission() { //Getter method for transmission
  return transmission; //This returns the transmission object
 }


 public void setMileage(int mileage) { //Setter method for mileage
	 this.mileage = mileage;
 }
 public int getMileage() { //Getter method for mileage
  return mileage; //This returns the mileage object
 }


 public void setFuel_type(String fuel_type) { //Setter method for fuel_type
	 this.fuel_type = fuel_type;
 }
 public String getFuel_type() { //Getter method for fuel_type
  return fuel_type; //This returns the fuel_type object
 }


 public void setEngine_size(int engine_size) { //Setter method for engine_size
	 this.engine_size = engine_size;
 }
 public int getEngine_size() { //Getter method for engine_size
  return engine_size; //This returns the engine_size object
 }


 public void setBody_style(String body_style) { //Setter method for body_style
	 this.body_style = body_style;
 }
 public String getBody_style() { //Getter method for body_style
  return body_style; //This returns the body_style object
 }


 public void setCondition(String condition) { //Setter method for condition 
	 this.condition = condition;
 }
 public String getCondition() { //Getter method for condition
  return condition; //This returns the condition object
 }


 public void setNotes(String notes) { //Setter method for notes
	 this.notes = notes;
 }
 public String getNotes() { //Getter method for notes
  return notes; //This returns the notes object
 }


}