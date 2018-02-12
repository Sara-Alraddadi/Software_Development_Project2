package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in
 * the asgn2Restaurant.PizzaRestaurant class as well as processLog and
 * resetDetails.
 * 
 * @author Sara Alraddadi/N8779333
 *
 */
public class RestaurantPizzaTests {
	// TO DO
	private PizzaRestaurant pizzaRestaurant = null;

	@Before
	public void init() throws CustomerException, PizzaException, LogHandlerException {
		pizzaRestaurant = new PizzaRestaurant();
		boolean issuccess = pizzaRestaurant.processLog("logs/20170101.txt");
		assertEquals(true, issuccess);
	}

	/**
	 * Test process log from input file<br>
	 * Expected none exception because file existed and correct format
	 * @throws CustomerException
	 * @throws PizzaException
	 * @throws LogHandlerException
	 */
	@Test
	public void processLogTest() throws CustomerException, PizzaException, LogHandlerException {
		boolean issuccess = pizzaRestaurant.processLog("logs/20170102.txt");
		assertEquals(true, issuccess);
	}

	/**
	 * Test the Pizza object contained at the specified index of the pizzas field.<br>
	 * Expected none exception 
	 * @throws PizzaException 
	 */
	@Test
	public void getPizzaByIndexTest() throws PizzaException {
		Pizza p= pizzaRestaurant.getPizzaByIndex(1);
		
		//20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1
		LocalTime orderTime=LocalTime.of(20, 0, 0);
		LocalTime deliveryTime=LocalTime.of(20, 25, 0);
		Pizza pizza_actual=new MargheritaPizza(1, orderTime, deliveryTime);
		
		assertEquals(p,pizza_actual);
		
	}

	/**
	 * Test the number of objects contained in the pizzas field<br>
	 * Expected none exception and receive the number of pizza ordered is
	 * correct.
	 */
	@Test
	public void getNumPizzaOrdersTest() {
		double total = pizzaRestaurant.getNumPizzaOrders();
		assertEquals(3, total, 0);
	}

	/**
	 * Test the total delivery distance for all of the customers.<br>
	 * Expected none exception and receive the total delivery distance is
	 * correct
	 */
	@Test
	public void getTotalDeliveryDistanceTest() {
		double total = pizzaRestaurant.getTotalDeliveryDistance();
		assertEquals(15.0, total, 0);
	}

	/**
	 * Test the total profit for all of the pizza orders.<br>
	 * Expected none exception and receive the total profit is correct
	 */
	@Test
	public void getTotalProfitTest() {
		double profit = pizzaRestaurant.getTotalProfit();
		assertEquals(64.0, profit, 0);
	}

	/**
	 * Test reset detail<br>
	 * Expected none exception and The pizzas and customers fields are set to
	 * their initial empty states
	 */
	@Test
	public void resetDetailTest() {
		pizzaRestaurant.resetDetails();
		int size_customer = pizzaRestaurant.getNumCustomerOrders();
		int size_pizza = pizzaRestaurant.getNumPizzaOrders();
		assertEquals(0, size_customer);
		assertEquals(0, size_pizza);

	}
}
