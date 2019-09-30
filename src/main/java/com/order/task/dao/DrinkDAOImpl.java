package com.order.task.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.order.task.model.Drink;

@Repository
public class DrinkDAOImpl implements DrinkDAO {
	
	private List<Drink> drinks = new ArrayList<Drink>();
	private List<Drink> orderedDrinks = new ArrayList<>();

	@Override
	public List<Drink> getDrinks() {
		return drinks;
	}
	
	@Override
	public List<Drink> getOrderedDrinks() {
		return orderedDrinks;
	}

	@Override
	public void addDrink(Drink drink) {
		
		if(drinks.isEmpty()) {
			drink.setId(1L);
			drinks.add(drink);
			System.out.println("Drink is added successfully!");
		} else {
			Drink dr = drinks.stream().filter(d -> drinks.contains(drink)).findAny().orElse(null);
			
			if (dr == null) {

				long id = drinks.get(drinks.size() - 1).getId() + 1;

				drink.setId(id);
				drinks.add(drink);
				
				System.out.println("Drink is added successfully!");
			}
			else {
				System.out.println("Drink is already exists!");
			}
		}
	}

	@Override
	public void orderDrink(Long id) {
		
		for(Drink drink : drinks) {
			if(drink.getId() == id) {
				orderedDrinks.add(drink);
				System.out.println("The drink is added to the ordered list!");
			}
		}
	}

	@Override
	public void clearOrderedDrinks() {
		orderedDrinks.clear();
	}

}
