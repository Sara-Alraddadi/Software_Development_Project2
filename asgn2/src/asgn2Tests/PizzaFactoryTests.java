package asgn2Tests;

import java.time.LocalTime;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Sara Alraddadi/N8779333
 * 
 */
public class PizzaFactoryTests {
	// TO DO

	/**
	 * Test get new instance of pizza <br>
	 * Expected none exception and receive new pizza with type MargheritaPizza
	 * 
	 * @throws PizzaException
	 */
	@Test
	public void getPizzaPZMTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20, 0);
		Pizza pizza = PizzaFactory.getPizza("PZM", 10, orderTime, deliveryTime);
		Assert.assertThat(pizza, IsInstanceOf.instanceOf(MargheritaPizza.class));
	}

	/**
	 * Test get new instance of pizza <br>
	 * Expected none exception and receive new pizza with type VegetarianPizza
	 * 
	 * @throws PizzaException
	 */
	@Test
	public void getPizzaPZVTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20, 0);
		Pizza pizza = PizzaFactory.getPizza("PZV", 10, orderTime, deliveryTime);
		Assert.assertThat(pizza, IsInstanceOf.instanceOf(VegetarianPizza.class));
	}

	/**
	 * Test get new instance of pizza <br>
	 * Expected none exception and receive new pizza with type MeatLoversPizza
	 * 
	 * @throws PizzaException
	 */
	@Test
	public void getPizzaPZLTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20, 0);
		Pizza pizza = PizzaFactory.getPizza("PZL", 10, orderTime, deliveryTime);
		Assert.assertThat(pizza, IsInstanceOf.instanceOf(MeatLoversPizza.class));
	}

	/**
	 * Test get new instance of pizza <br>
	 * Expected receive exception (PizzaException)
	 * 
	 * @throws PizzaException
	 */
	@Test(expected = PizzaException.class)
	public void getPizzaExceptionTest() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 0, 0);
		LocalTime deliveryTime = LocalTime.of(19, 20, 0);
		Pizza pizza = PizzaFactory.getPizza("PZL1", 10, orderTime, deliveryTime);
		Assert.assertThat(pizza, IsInstanceOf.instanceOf(MeatLoversPizza.class));
	}
}
