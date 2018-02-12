package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer
 * objects in the asgn2Restaurant.PizzaRestaurant class as well as processLog
 * and resetDetails.
 * 
 * @author Sara Alraddadi/N8779333
 */
public class RestaurantCustomerTests {
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
	 * 
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
	 * Test the Customer object contained at the specified index of the
	 * customers field<br>
	 * Expected none exception
	 * 
	 * @throws CustomerException
	 */
	@Test
	public void getCustomerByIndexTest() throws CustomerException {
		Customer c = pizzaRestaurant.getCustomerByIndex(0);
		// 19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2
		Customer customer_actual = new DriverDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		assertEquals(c, customer_actual);
	}

	/**
	 * Test the number of objects contained in the customers field<br>
	 * Expected none exception and receive the number of customers is correct
	 */
	@Test
	public void getNumCustomerOrdersTest() {
		double total = pizzaRestaurant.getNumCustomerOrders();
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
