package asgn2Tests;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Sara Alraddadi/N8779333
 *
 */
public class CustomerFactoryTests {

	// TO DO
	
	/**
	 * Test get new instance of customer <br>
	 * Expected none exception and receive customer with type PickUpCustomer
	 * @throws CustomerException
	 */
	@Test
	public void getCustomerPUCTest() throws CustomerException {
		Customer c = CustomerFactory.getCustomer("PUC", "Oroku Saki", "0111222333", 0, 0);
		Assert.assertThat(c, IsInstanceOf.instanceOf(PickUpCustomer.class) );

	}
	
	/**
	 * Test get new instance of customer <br>
	 * Expected none exception and receive customer with type DriverDeliveryCustomer
	 * @throws CustomerException
	 */
	@Test
	public void getCustomerDVCTest() throws CustomerException {
		Customer c = CustomerFactory.getCustomer("DVC", "Casey Jones", "0123456789",5, 5);
		Assert.assertThat(c, IsInstanceOf.instanceOf(DriverDeliveryCustomer.class) );

	}
	
	/**
	 * Test get new instance of customer <br>
	 * Expected none exception and receive customer with type DroneDeliveryCustomer
	 * @throws CustomerException
	 */
	@Test
	public void getCustomerDNCTest() throws CustomerException {
		Customer c = CustomerFactory.getCustomer("DNC", "April O'Neal", "0987654321",3, 4);
		Assert.assertThat(c, IsInstanceOf.instanceOf(DroneDeliveryCustomer.class) );

	}
	
	/**
	 * Test get new instance of customer <br>
	 * Expected receive exception (CustomerException)
	 * @throws CustomerException
	 */
	@Test(expected=CustomerException.class)
	public void getCustomerExceptionTest() throws CustomerException {
		CustomerFactory.getCustomer("TEST", "Casey Jones", "0123456789",5, 5);
	}
}
