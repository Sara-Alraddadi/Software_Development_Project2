package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects
 * in the asgn2Restaurant.LogHander class.
 *
 * @author Sara Alraddadi/N8779333
 */
public class LogHandlerCustomerTests {
	// TO DO

	/**
	 * test get populate customer data set from file<br>
	 * expected none exception and receive list customer with size = 3
	 * 
	 * @throws CustomerException
	 * @throws LogHandlerException
	 */
	@Test
	public void populateCustomerDatasetTest() throws CustomerException, LogHandlerException {
		List<Customer> customers = LogHandler.populateCustomerDataset("logs/20170101.txt");
		int acctual_size = customers.size();
		assertEquals(3, acctual_size);
	}

	/**
	 * test get populate customer data set from file<br>
	 * expected: receive exception LogHandlerException because file not found
	 * 
	 * @throws CustomerException
	 * @throws LogHandlerException
	 */
	@Test(expected = LogHandlerException.class)
	public void populateCustomerDatasetExceptionTest() throws CustomerException, LogHandlerException {
		LogHandler.populateCustomerDataset("logs/2017@019.txt");
	}

	/**
	 * test create new customer from line text<br>
	 * expected none exception and created DriverDeliveryCustomer type
	 * 
	 * @throws CustomerException
	 * @throws LogHandlerException
	 */
	@Test
	public void createCustomerTest() throws CustomerException, LogHandlerException {
		String line = "21:17:00,21:27:00,Emma Brown,0602547760,DVC,-1,0,PZV,5";
		Customer c = LogHandler.createCustomer(line);
		Assert.assertThat(c, IsInstanceOf.instanceOf(DriverDeliveryCustomer.class));
	}

	/**
	 * test create new customer from line text<br>
	 * expected: receive exception because data in line invalid
	 * 
	 * @throws CustomerException
	 * @throws LogHandlerException
	 */
	@Test(expected = LogHandlerException.class)
	public void createCustomerExceptionTest() throws CustomerException, LogHandlerException {
		String line = "21:17:00,21:27:00,Emma Brown,0602547760,DPC,-1,0,PZV,5";
		LogHandler.createCustomer(line);
	}

}
