package com.order.task.dao;

import java.util.List;

import com.order.task.model.Meal;

public interface MealDAO {

	List<Meal> getMeals();
	List<Meal> getOrderedMeals();
	List<Meal> getMeal(Long cuisineId);
	void addMeal(Meal meal);
	void clearOrderedMeals();
	void orderMeal(Long id);
	boolean checkCuisineMeal(Long cuisineId);
}
