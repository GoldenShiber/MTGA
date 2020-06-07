package DataBaseOperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 *  For future implementations the combat system will receive data from a database
 *  and a JSON database is most likely very easy to use in this case.
 */

public class BasicJson {

	// Easiest way to creata a Gson object
	Gson gson = new Gson();
	
	// An alternative way to create a Gson object by using a Gsonbuilder
	GsonBuilder builder = new GsonBuilder();
	Gson gsonWithBuilder = builder.create();
	
	
	// Parsing JSON Into Java Objects
	String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
	Car car = gson.fromJson(json, Car.class);
	
	public class Car {
	    public String brand = null;
	    public int    doors = 0;
	}
	
	// If you wanna do a pretty printing, using a builder is perfect!
	Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
	
	Car testCar = new Car();
	
	//String personJson = gson.toJson(person);

	//System.out.println(car);
}
