package asgn2Restaurant;


import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Sara Alraddadi/N8779333
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		// TO DO
		ArrayList<Customer> customers = new ArrayList<Customer>();
		// read file into stream, try-with-resources
		//order-time, delivery-time, customer-name, customer-mobile, customer-code, 
		//customer-x-location, customer-y-location, pizza-code, pizza-quantity 
		
		//example: 19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2
		try (Scanner scanner = new Scanner(new File(filename))) {

			while (scanner.hasNext()) {
				Customer c= createCustomer(scanner.nextLine());
				customers.add(c);
			}

		} catch (IOException e) {
			throw new  LogHandlerException(e);
		}
		return customers;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		// TO DO
		
		ArrayList<Pizza> pizzas=new ArrayList<Pizza>();
		
		// read file into stream, try-with-resources
		//order-time, delivery-time, customer-name, customer-mobile, customer-code, 
		//customer-x-location, customer-y-location, pizza-code, pizza-quantity 
		
		//example: 19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2
		try (Scanner scanner = new Scanner(new File(filename))) {

			while (scanner.hasNext()) {
				Pizza z= createPizza(scanner.nextLine());
				pizzas.add(z);
			}

		} catch (IOException e) {
			throw new  LogHandlerException(e);
		}
		return pizzas;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		try {
			String element[]=line.split(",");
			String customer_name=element[2];
			String customer_mobile=element[3];
			String customer_code=element[4];
			
			int locationX=Integer.parseInt(element[5]);
			int locationY=Integer.parseInt(element[6]);
			
			Customer c=CustomerFactory.getCustomer(customer_code, customer_name, customer_mobile, locationX, locationY);
			return c;
		
		}catch (Exception e){
			throw new LogHandlerException(e);
		}

	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		try {
			String element[]= line.split(",");
			
			LocalTime order_time=LocalTime.parse(element[0]);
			LocalTime delivery_time=LocalTime.parse(element[1]);
			
			String pizza_code=element[7];
			
			int quantity=Integer.parseInt(element[8]);
			
			Pizza z=PizzaFactory.getPizza(pizza_code, quantity, order_time, delivery_time);

			return z;
		} catch (Exception e) {
			throw new LogHandlerException(e);
		}
	}

}
