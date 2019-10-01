package com.order.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.task.dao.DrinkDAO;
import com.order.task.model.Drink;

@Service
public class DrinkServiceImpl implements DrinkService {

	@Autowired
	private DrinkDAO drinkDAO;
	
	@Override
	public List<Drink> getDrinks() {
		return drinkDAO.getDrinks();
	}

	@Override
	public void addDrink(Drink drink) {
		drinkDAO.addDrink(drink);
	}

	@Override
	public void orderDrink(Long id) {
		drinkDAO.orderDrink(id);
	}

	@Override
	public List<Drink> getOrderedDrinks() {
		return drinkDAO.getOrderedDrinks();
	}

	@Override
	public void clearOrderedDrinks() {
		drinkDAO.clearOrderedDrinks();
	}

	@Override
	public void addDefaultDrinks() {
		drinkDAO.addDefaultDrinks();
	}

}
