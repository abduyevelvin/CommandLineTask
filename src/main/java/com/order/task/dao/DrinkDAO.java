package com.order.task.dao;

import java.util.List;

import com.order.task.model.Drink;

public interface DrinkDAO {

	List<Drink> getDrinks();
	List<Drink> getOrderedDrinks();
	void clearOrderedDrinks();
	void addDrink(Drink drink);
	void orderDrink(Long id);
	void addDefaultDrinks();
}
