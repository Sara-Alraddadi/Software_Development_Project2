package asgn2Pizzas;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Sara Alraddadi/N8779333
 *
 */
public abstract class Pizza  {
	
	//The number of pizzas ordered 
	private int quantity;
	
	//The time that the pizza order was made and sent to the kitchen
	private LocalTime orderTime;
	
	//The time that the pizza was delivered to the customer
	private LocalTime deliveryTime;
	
	//A human understandable description of this Pizza type
	private String type;
	
	//The price that the pizza is sold to the customer
	private double price;
	
	//The cost of a pizza
	private double cost;
	
	//The restaurant sells three types of pizzas:  margherita, vegetarian and meat lovers. The 
	//toppings of each of the pizzas and prices are presented in Table 1. No
	private static final Map<String,List<PizzaTopping>> MAP_PIZZA_TOPPING=new HashMap<String,List<PizzaTopping>>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Margherita", Arrays.asList(PizzaTopping.CHEESE,PizzaTopping.TOMATO));
			put("Vegetarian", Arrays.asList(PizzaTopping.CHEESE,PizzaTopping.TOMATO,PizzaTopping.EGGPLANT,PizzaTopping.MUSHROOM,PizzaTopping.CAPSICUM));
			put("Meat Lovers", Arrays.asList(PizzaTopping.CHEESE,PizzaTopping.TOMATO,PizzaTopping.BACON,PizzaTopping.PEPPERONI,PizzaTopping.SALAMI));

		}
	};
	
	private static final Map<String,Double> MAP_PIZZA_PRICE=new HashMap<String, Double>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Margherita", 8.0);
			put("Vegetarian", 10.0);
			put("Meat Lovers", 12.0);

		}
	};
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		// TO DO	
		if(quantity<=0 || quantity>10){
			throw new PizzaException("The maximum number of pizzas in any one order is 10.");
		}
		//The restaurant begins taking orders at 7:00pm (when the kitchen opens) and stops taking 
		//orders at 11:00 pm (when the kitchen closes) Australian Eastern Standard Time.
		if(orderTime==null){
			throw new PizzaException("Order time invalid. Order time begin at 7:00pm  and stop at 11:00 pm");
		}else{
			int hours=orderTime.getHour();
			if(hours<19|| hours>23){
				throw new PizzaException("Order time invalid. Order time begin at 7:00pm  and stop at 11:00 pm");
			}
		}
		
		 //Deliveries may continue after 11:00 pm.  
		if(deliveryTime==null){
			throw new PizzaException("Delivery time invalid. Deliveries may continue after 11:00 pm.");
		}else{
			if(deliveryTime.isBefore(orderTime)){
				throw new PizzaException("Delivery time invalid. Deliveries may continue after 11:00 pm.");
			}
		}
		
		if(!MAP_PIZZA_PRICE.containsKey(type)){
			throw new PizzaException(" A human understandable description of this Pizza type invalid.");
		}
		this.quantity=quantity;
		this.orderTime=orderTime;
		this.deliveryTime=deliveryTime;
		this.type=type;
		this.price=price;
		
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		// TO DO
		//get list topping of this pizza
		this.cost=0;
		List<PizzaTopping> lstTopping=MAP_PIZZA_TOPPING.get(type);
		for(PizzaTopping p: lstTopping){
			this.cost+=p.getCost();
		}
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		// TO DO
		return cost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		// TO DO
		return MAP_PIZZA_PRICE.get(type);
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		// TO DO
		return getCostPerPizza()*this.quantity;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		// TO DO
		return getPricePerPizza()*this.quantity;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		// TO DO
		return getOrderPrice()-getOrderCost();
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		
		List<PizzaTopping> lstTopping=MAP_PIZZA_TOPPING.get(type);
		return lstTopping.contains(topping);
	
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		// TO DO
		return quantity;
		
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		// TO DO
		return type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
