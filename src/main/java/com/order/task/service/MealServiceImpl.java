package com.order.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.task.dao.MealDAO;
import com.order.task.model.Meal;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealDAO mealDAO;
	
	@Override
	public List<Meal> getMeals() {
		return mealDAO.getMeals();
	}

	@Override
	public void addMeal(Meal meal) {
		mealDAO.addMeal(meal);
	}

	@Override
	public List<Meal> getMeal(Long cuisineId) {
		return mealDAO.getMeal(cuisineId);
	}

	@Override
	public void orderMeal(Long id) {
		mealDAO.orderMeal(id);
	}

	@Override
	public boolean checkCuisineMeal(Long cuisineId) {
		return mealDAO.checkCuisineMeal(cuisineId);
	}

	@Override
	public List<Meal> getOrderedMeals() {
		return mealDAO.getOrderedMeals();
	}

	@Override
	public void clearOrderedMeals() {
		mealDAO.clearOrderedMeals();
	}

	@Override
	public void addDefaultMeals() {
		mealDAO.addDefaultMeals();
	}

}
