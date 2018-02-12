package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Pizza objects in
 * the asgn2Restaurant.LogHander class.
 * 
 * @author Sara Alraddadi/N8779333
 * 
 */
public class LogHandlerPizzaTests {
	// TO DO
	/**
	 * test get populate pizza data set from file<br>
	 * expected none exception and receive list customer with size = 3
	 * 
	 * @throws PizzaException
	 * @throws LogHandlerException
	 */
	@Test
	public void populatePizzaDatasetTest() throws PizzaException, LogHandlerException {
		ArrayList<Pizza> pizzas = LogHandler.populatePizzaDataset("logs/20170101.txt");
		int acctual_size = pizzas.size();
		assertEquals(3, acctual_size);
	}

	/**
	 * test get populate pizza data set from file<br>
	 * expected: receive exception LogHandlerException because file not found
	 * 
	 * @throws PizzaException
	 * @throws LogHandlerException
	 */
	@Test(expected = LogHandlerException.class)
	public void populatePizzaDatasetExceptionTest() throws PizzaException, LogHandlerException {
		ArrayList<Pizza> pizzas = LogHandler.populatePizzaDataset("logs/2017@0101.txt");
		int acctual_size = pizzas.size();
		assertEquals(3, acctual_size);
	}

	/**
	 * test create new pizza from line text<br>
	 * expected none exception and created MargheritaPizza type
	 * 
	 * @throws PizzaException
	 * @throws LogHandlerException
	 */
	@Test
	public void createPizzaTest() throws PizzaException, LogHandlerException {
		String line = "21:05:00,21:34:00,Bella Chen,0265045495,PUC,0,0,PZM,1";
		Pizza p = LogHandler.createPizza(line);
		Assert.assertThat(p, IsInstanceOf.instanceOf(MargheritaPizza.class));

	}

	/**
	 * test create new pizza from line text<br>
	 * expected: receive exception LogHandlerException because data in line
	 * invalid
	 * 
	 * @throws PizzaException
	 * @throws LogHandlerException
	 */
	@Test(expected = LogHandlerException.class)
	public void createPizzaExceptionTest() throws PizzaException, LogHandlerException {
		String line = "";
		LogHandler.createPizza(line);
	}

}
