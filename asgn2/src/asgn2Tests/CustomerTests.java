package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer,
 * asgn2Customers.DriverDeliveryCustomer, asgn2Customers.DroneDeliveryCustomer
 * classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer
 * should be used to test the functionality of the asgn2Customers.Customer
 * abstract class.
 * 
 * @author Sara Alraddadi/N8779333
 * 
 *
 */
public class CustomerTests {
	// TO DO

	private DriverDeliveryCustomer deliveryCustomer = null;

	private DroneDeliveryCustomer droneDeliveryCustomer = null;

	private PickUpCustomer pickUpCustomer = null;

	@Before
	public void init() throws CustomerException {
		deliveryCustomer = new DriverDeliveryCustomer("Casey Jones", "0123456789", 5, 5);
		pickUpCustomer = new PickUpCustomer("Oroku Saki", "0111222333", 0, 0);
		droneDeliveryCustomer = new DroneDeliveryCustomer("April O'Neal", "0987654321", 3, 4);
	}

	/**
	 * Test create new instance customer <br>
	 * Expected exception because mobile number incorrect
	 * 
	 * @throws CustomerException
	 */
	@Test(expected = CustomerException.class)
	public void testCreateNewIntance() throws CustomerException {
		deliveryCustomer = new DriverDeliveryCustomer("Casey Jones", "A0123456789", 5, 5);

	}

	/**
	 * Test get customer name of customer type DriverDeliveryCustomer<br>
	 * Expected none exception and get name correct
	 */
	@Test
	public void getNameDriverDeliveryCustomerTest() {
		String actual = "Casey Jones";
		assertEquals(actual, deliveryCustomer.getName());
	}

	/**
	 * Test get customer name of customer type PickUpCustomer<br>
	 * Expected none exception and get name correct
	 */
	@Test
	public void getNamePickUpCustomerTest() {
		String actual = "Oroku Saki";
		assertEquals(actual, pickUpCustomer.getName());
	}

	/**
	 * Test get customer name of customer type DroneDeliveryCustomer<br>
	 * Expected none exception and get name correct
	 */
	@Test
	public void getNameDroneDeliveryCustomerTest() {
		String actual = "April O'Neal";
		assertEquals(actual, droneDeliveryCustomer.getName());
	}

	/**
	 * Test get customer mobile of customer type DriverDeliveryCustomer<br>
	 * Expected none exception and get mobile number correct
	 */
	@Test
	public void getMobileNumberOfDriverDeliveryCustomerTest() {
		String expected_mobile = "0123456789";
		assertEquals(expected_mobile, deliveryCustomer.getMobileNumber());
	}

	/**
	 * Test get customer mobile of customer type PickUpCustomer<br>
	 * Expected none exception and get mobile number correct
	 */
	@Test
	public void getMobileNumberOfPickUpCustomerTest() {
		String expected_mobile = "0111222333";
		assertEquals(expected_mobile, pickUpCustomer.getMobileNumber());
	}

	/**
	 * Test get customer mobile of customer type DroneDeliveryCustomer<br>
	 * Expected none exception and get mobile number correct
	 */
	@Test
	public void getMobileNumberOfDroneDeliveryCustomerTest() {
		String expected_mobile = "0987654321";
		assertEquals(expected_mobile, droneDeliveryCustomer.getMobileNumber());
	}

	/**
	 * Test get customer type Driver Delivery<br>
	 * Expected none exception and get correct customer types have defined.
	 */
	@Test
	public void getCustomerTypeDriverDeliveryCustomerTest() {
		String expected_customerType = "Driver Delivery";
		assertEquals(expected_customerType, deliveryCustomer.getCustomerType());
	}

	/**
	 * Test get customer type pickUpCustomer<br>
	 * Expected none exception and get correct customer types have defined.
	 */
	@Test
	public void getCustomerTypePickUpCustomerTest() {
		String expected_customerType = "Pick Up";
		assertEquals(expected_customerType, pickUpCustomer.getCustomerType());
	}

	/**
	 * Test get customer type DroneDeliveryCustomer<br>
	 * Expected none exception and get correct customer types have defined.
	 */
	@Test
	public void getCustomerTypeDroneDeliveryCustomerTest() {
		String expected_customerType = "Drone Delivery";
		assertEquals(expected_customerType, droneDeliveryCustomer.getCustomerType());
	}

	/**
	 * Test get location x of DriverDeliveryCustomer<br>
	 * Expected none exception and get correct location X of driver delivery
	 * customer
	 * 
	 * 
	 */
	@Test
	public void getLocationXDriverDeliveryCustomerTest() {
		int expected_location_x = 5;
		assertEquals(expected_location_x, deliveryCustomer.getLocationX());

	}

	/**
	 * Test get location x of PickUpCustomer<br>
	 * Expected none exception and get correct location X of pickup customer
	 * 
	 * 
	 */
	@Test
	public void getLocationXPickUpCustomerTest() {
		int expected_location_x = 0;
		assertEquals(expected_location_x, pickUpCustomer.getLocationX());

	}

	/**
	 * Test get location x of DroneDeliveryCustomer<br>
	 * Expected none exception and get correct location X of drone delivery
	 * customer
	 * 
	 * 
	 */
	@Test
	public void getLocationXDroneDeliveryCustomerTest() {
		int expected_location_x = 3;
		assertEquals(expected_location_x, droneDeliveryCustomer.getLocationX());

	}

	/**
	 * Test get location y of DriverDeliveryCustomer<br>
	 * Expected none exception and get correct location Y of driver delivery
	 * customer
	 * 
	 * 
	 */
	@Test
	public void getLocationYDriverDeliveryCustomerTest() {
		int expected_location_x = 5;
		assertEquals(expected_location_x, deliveryCustomer.getLocationY());

	}

	/**
	 * Test get location y of PickUpCustomer<br>
	 * Expected none exception and get correct location Y of pickup customer
	 * 
	 * 
	 */
	@Test
	public void getLocationYPickUpCustomerTest() {
		int expected_location_x = 0;
		assertEquals(expected_location_x, pickUpCustomer.getLocationY());

	}

	/**
	 * Test get location x of DroneDeliveryCustomer<br>
	 * Expected none exception and get correct location X of drone delivery
	 * customer
	 * 
	 * 
	 */
	@Test
	public void getLocationYDroneDeliveryCustomerTest() {
		int expected_location_x = 4;
		assertEquals(expected_location_x, droneDeliveryCustomer.getLocationY());

	}

	/**
	 * Test getDeliveryDistance between location of DriverDeliveryCustomer and
	 * restaurant.<br>
	 * Expected none exception and get delivery distance correct.
	 * 
	 */
	@Test
	public void getDeliveryDistanceDriverDeliveryCustomerTest() {
		double expected = 10.0;
		assertEquals(expected, deliveryCustomer.getDeliveryDistance(), 0);
	}

	/**
	 * Test getDeliveryDistance between location of PickUpCustomer and
	 * restaurant.<br>
	 * Expected none exception and get delivery distance correct.
	 */
	@Test
	public void getDeliveryDistancePickUpCustomerTest() {
		double expected = 0.0;
		assertEquals(expected, pickUpCustomer.getDeliveryDistance(), 0);
	}

	/**
	 * Test getDeliveryDistance between location of DroneDeliveryCustomer and
	 * restaurant.<br>
	 * Expected none exception and get delivery distance correct.
	 */
	@Test
	public void getDeliveryDistanceDroneDeliveryCustomerTest() {
		double expected = 5.0;
		assertEquals(expected, droneDeliveryCustomer.getDeliveryDistance(), 0);
	}
}
