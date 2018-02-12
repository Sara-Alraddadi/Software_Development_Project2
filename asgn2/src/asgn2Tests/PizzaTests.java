package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza,
 * asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. Note that
 * an instance of asgn2Pizzas.MeatLoversPizza should be used to test the
 * functionality of the asgn2Pizzas.Pizza abstract class.
 * 
 * @author Sara Alraddadi/N8779333
 *
 */
public class PizzaTests {
	// TO DO

	private MargheritaPizza margheritaPizza = null;
	private VegetarianPizza vegetarianPizza = null;
	private MeatLoversPizza meatLoversPizza = null;

	@Before
	public void init() throws PizzaException {
		margheritaPizza = new MargheritaPizza(10, LocalTime.of(20, 0, 0), LocalTime.of(20, 20, 10));
		vegetarianPizza = new VegetarianPizza(8, LocalTime.of(21, 0, 0), LocalTime.of(22, 20, 10));
		meatLoversPizza = new MeatLoversPizza(9, LocalTime.of(19, 0, 0), LocalTime.of(19, 30, 10));
	}

	/**
	 * Test calculates how much a pizza would cost to make calculated from its
	 * toppings.<br>
	 * Expected none exception
	 */
	@Test
	public void calculateCostPerPizzaMargheritaPizzaTest() {
		margheritaPizza.calculateCostPerPizza();
	}

	/**
	 * Test calculates how much a pizza would cost to make calculated from its
	 * toppings.<br>
	 * Expected none exception
	 */
	@Test
	public void calculateCostPerPizzaVegetarianPizzaTest() {
		vegetarianPizza.calculateCostPerPizza();
	}

	/**
	 * Test calculates how much a pizza would cost to make calculated from its
	 * toppings.<br>
	 * Expected none exception
	 */
	@Test
	public void calculateCostPerPizzaMeatLoversPizzaTest() {
		meatLoversPizza.calculateCostPerPizza();
	}

	/**
	 * Test the amount that an individual pizza costs to make MargheritaPizza.
	 * <br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getCostPerPizzaMargheritaPizzaTest() {
		margheritaPizza.calculateCostPerPizza();
		double expected_value = 1.5;
		assertEquals(expected_value, margheritaPizza.getCostPerPizza(), 0);
	}

	/**
	 * Test the amount that an individual pizza costs to make VegetarianPizza.
	 * <br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getCostPerPizzaVegetarianPizzaTest() {
		vegetarianPizza.calculateCostPerPizza();
		double expected_value = 5.5;
		assertEquals(expected_value, vegetarianPizza.getCostPerPizza(), 0);
	}

	/**
	 * Test the amount that an individual pizza costs to make MeatLoversPizza.
	 * <br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getCostPerPizzaMeatLoversPizzaTest() {
		meatLoversPizza.calculateCostPerPizza();
		double expected_value = 5.0;
		assertEquals(expected_value, meatLoversPizza.getCostPerPizza(), 0);
	}

	/**
	 * Test the amount that an individual pizza is sold to the customer
	 * MargheritaPizza.<br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getPricePerPizzaMargheritaPizzaTest() {
		margheritaPizza.calculateCostPerPizza();
		double expected_value = 8.0;
		assertEquals(expected_value, margheritaPizza.getPricePerPizza(), 0);
	}

	/**
	 * Test the amount that an individual pizza is sold to the customer
	 * VegetarianPizza.<br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getPricePerPizzaVegetarianPizzaTest() {
		vegetarianPizza.calculateCostPerPizza();
		double expected_value = 5.5;
		assertEquals(expected_value, vegetarianPizza.getCostPerPizza(), 0);
	}

	/**
	 * Test the amount that an individual pizza is sold to the customer
	 * MeatLoversPizza.<br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getPricePerPizzaMeatLoversPizzaTest() {
		meatLoversPizza.calculateCostPerPizza();
		double expected_value = 5.0;
		assertEquals(expected_value, meatLoversPizza.getCostPerPizza(), 0);
	}

	/**
	 * Test the amount that the entire order costs to make, taking into account
	 * the type and quantity of pizzas of MargheritaPizza<br>
	 * Expected none exception and matching amount with amount expected.
	 * 
	 */
	@Test
	public void getOrderCostMargheritaPizzaTest() {
		margheritaPizza.calculateCostPerPizza();
		double expected_value = 15.0;
		assertEquals(expected_value, margheritaPizza.getOrderCost(), 0);
	}

	/**
	 * Test the amount that the entire order costs to make, taking into account
	 * the type and quantity of pizzas of VegetarianPizza<br>
	 * Expected none exception and matching amount with amount expected.
	 * 
	 */
	@Test
	public void getOrderCostVegetarianPizzaTest() {
		vegetarianPizza.calculateCostPerPizza();
		double expected_value = 44.0;
		assertEquals(expected_value, vegetarianPizza.getOrderCost(), 0);
	}

	/**
	 * Test the amount that the entire order costs to make, taking into account
	 * the type and quantity of pizzas of MeatLoversPizza<br>
	 * Expected none exception and matching amount with amount expected.
	 * 
	 */
	@Test
	public void getOrderCostMeatLoversPizzaTest() {
		meatLoversPizza.calculateCostPerPizza();
		double expected_value = 45.0;
		assertEquals(expected_value, meatLoversPizza.getOrderCost(), 0);
	}

	/**
	 * Test the amount that the entire order is sold to the customer, taking
	 * into account the type and quantity of pizzas MargheritaPizza.<br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getOrderPriceMargheritaPizzaTest() {
		margheritaPizza.calculateCostPerPizza();
		double expected_value = 80.0;
		assertEquals(expected_value, margheritaPizza.getOrderPrice(), 0);
	}

	/**
	 * Test the amount that the entire order is sold to the customer, taking
	 * into account the type and quantity of pizzas VegetarianPizza.<br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getOrderPriceVegetarianPizzaTest() {
		vegetarianPizza.calculateCostPerPizza();
		double expected_value = 80.0;
		assertEquals(expected_value, vegetarianPizza.getOrderPrice(), 0);
	}

	/**
	 * Test the amount that the entire order is sold to the customer, taking
	 * into account the type and quantity of pizzas MeatLoversPizza.<br>
	 * Expected none exception and matching amount with amount expected.
	 */
	@Test
	public void getOrderPriceMeatLoversPizzaTest() {
		meatLoversPizza.calculateCostPerPizza();
		double expected_value = 108.0;
		assertEquals(expected_value, meatLoversPizza.getOrderPrice(), 0);
	}

	/**
	 * Test the profit made by the restaurant on the order of MargheritaPizza
	 * Expected none exception and matching amount with amount expected.
	 * 
	 */
	@Test
	public void getOrderProfitMargheritaPizzaTest() {
		margheritaPizza.calculateCostPerPizza();
		double expected_value = 108.0;
		assertEquals(expected_value, meatLoversPizza.getOrderProfit(), 0);
	}

	/**
	 * Test the profit made by the restaurant on the order of VegetarianPizza
	 * Expected none exception and matching amount with amount expected.
	 * 
	 */
	@Test
	public void getOrderProfitVegetarianPizzaTest() {
		vegetarianPizza.calculateCostPerPizza();
		double expected_value = 36.0;
		assertEquals(expected_value, vegetarianPizza.getOrderProfit(), 0);
	}

	/**
	 * Test the profit made by the restaurant on the order of MeatLoversPizza
	 * Expected none exception and matching amount with amount expected.
	 * 
	 */
	@Test
	public void getOrderProfitMeatLoversPizzaTest() {
		meatLoversPizza.calculateCostPerPizza();
		double expected_value = 63.0;
		assertEquals(expected_value, meatLoversPizza.getOrderProfit(), 0);
	}

	/**
	 * Test the pizza contains the specified pizza topping <br>
	 * Expected none exception and matching found
	 */
	@Test
	public void containsToppingFound() {
		PizzaTopping p = PizzaTopping.BACON;
		boolean expected_value = true;
		assertEquals(expected_value, meatLoversPizza.containsTopping(p));

	}

	/**
	 * Test the pizza contains the specified pizza topping <br>
	 * Expected none exception and not matching found
	 */
	@Test
	public void containsToppingNotFound() {
		PizzaTopping p = null;
		boolean expected_value = false;
		assertEquals(expected_value, meatLoversPizza.containsTopping(p));
	}

	/**
	 * Test the quantity of pizzas ordered MargheritaPizza <br>
	 * Expected none exception and matching with quantity have been ordered
	 * above.
	 * 
	 */
	@Test
	public void getQuantityMargheritaPizzaTest() {
		int expected_value = 10;
		assertEquals(expected_value, margheritaPizza.getQuantity());
	}

	/**
	 * Test the quantity of pizzas ordered VegetarianPizza <br>
	 * Expected none exception and matching with quantity have been ordered
	 * above.
	 * 
	 */
	@Test
	public void getQuantityVegetarianPizzaTest() {
		int expected_value = 8;
		assertEquals(expected_value, vegetarianPizza.getQuantity());
	}

	/**
	 * Test the quantity of pizzas ordered MeatLoversPizza <br>
	 * Expected none exception and matching with quantity have been ordered
	 * above.
	 * 
	 */
	@Test
	public void getQuantityMeatLoversPizzaTest() {
		int expected_value = 9;
		assertEquals(expected_value, meatLoversPizza.getQuantity());
	}

	/**
	 * Test get description of the Pizza's type MargheritaPizza. <br>
	 * Expected none exception and matching with pizza type have been defined.
	 */
	@Test
	public void getPizzaTypeMargheritaPizzaTest() {
		String expected_value = "Margherita";
		assertEquals(expected_value, margheritaPizza.getPizzaType());
	}

	/**
	 * Test get description of the Pizza's type VegetarianPizza. <br>
	 * Expected none exception and matching with pizza type have been defined.
	 */
	@Test
	public void getPizzaTypeVegetarianPizzaTest() {
		String expected_value = "Vegetarian";
		assertEquals(expected_value, vegetarianPizza.getPizzaType());
	}

	/**
	 * Test get description of the Pizza's type MeatLoversPizza. <br>
	 * Expected none exception and matching with pizza type have been defined.
	 */
	@Test
	public void getPizzaTypeMeatLoversPizzaTest() {
		String expected_value = "Meat Lovers";
		assertEquals(expected_value, meatLoversPizza.getPizzaType());
	}

	/**
	 * Test ompares *this* Pizza object with an instance of an *other* Pizza
	 * object<br>
	 * Expected none exception and they are equal.
	 * 
	 * 
	 * @throws PizzaException
	 */
	@Test
	public void testEqualMargheritaPizza() throws PizzaException {
		MargheritaPizza margheritaPizza_other = new MargheritaPizza(10, LocalTime.of(20, 0, 0),
				LocalTime.of(20, 20, 10));
		boolean expected_value = true;
		assertEquals(expected_value, margheritaPizza.equals(margheritaPizza_other));
	}

	/**
	 * Test ompares *this* Pizza object with an instance of an *other* Pizza
	 * object<br>
	 * Expected exception beacause time dev
	 * 
	 * 
	 * @throws PizzaException
	 */
	@Test
	public void testEqualMeatLoversPizza() throws PizzaException {
		MeatLoversPizza meatloverspizza_other = new MeatLoversPizza(2, LocalTime.of(19, 0, 0),
				LocalTime.of(19, 30, 10));
		boolean expected_value = false;
		assertEquals(expected_value, meatLoversPizza.equals(meatloverspizza_other));

	}

	/**
	 * Test ompares *this* Pizza object with an instance of an *other* Pizza
	 * object<br>
	 * Expected none exception and they aren't equal.
	 * 
	 * 
	 * @throws PizzaException
	 */
	@Test
	public void testEqualVegetarianPizza() throws PizzaException {
		VegetarianPizza vegetarianpizza_other = new VegetarianPizza(9, LocalTime.of(20, 0, 0),
				LocalTime.of(20, 20, 10));
		boolean expected_value = true;
		assertEquals(expected_value, vegetarianpizza_other.equals(vegetarianpizza_other));

	}

}
