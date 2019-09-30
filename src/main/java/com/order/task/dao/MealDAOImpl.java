package com.order.task.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.order.task.model.Meal;

@Repository
public class MealDAOImpl implements MealDAO {

	private List<Meal> meals = new ArrayList<Meal>();
	private List<Meal> orderedMeals = new ArrayList<>();
	private List<Meal> cuisineMeals = new ArrayList<>();
	
	@Override
	public List<Meal> getMeals() {
		return meals;
	}
	
	@Override
	public List<Meal> getOrderedMeals() {
		return orderedMeals;
	}

	@Override
	public void addMeal(Meal meal) {
		
		if(meals.isEmpty()) {
			meal.setId(1L);
			meals.add(meal);
			System.out.println("Meal is added successfully!");
		} else {
			
			Meal ml = meals.stream().filter(m -> meals.contains(meal)).findAny().orElse(null);
			
			if(ml == null) {
				
				long id = meals.get(meals.size() - 1).getId() + 1;
				
				meal.setId(id);
				meals.add(meal);
				System.out.println("Meal is added successfully!");
				
			} else {
				System.out.println("Meal is already exists!");
			}
		}
	}

	@Override
	public List<Meal> getMeal(Long cuisineId) {
		
		cuisineMeals.clear();
		
		for(Meal meal : meals) {
			if(meal.getCuisine().getId() == cuisineId && !cuisineMeals.contains(meal)) {
				cuisineMeals.add(meal);
			}
		}
		
		return cuisineMeals;
	}

	@Override
	public void orderMeal(Long id) {
		
		for(Meal meal : cuisineMeals) {
			if(meal.getId() == id) {
				orderedMeals.add(meal);
				System.out.println("The meal is added to the ordered list!");
			}
		}
		
	}

	@Override
	public boolean checkCuisineMeal(Long cuisineId) {
		boolean res = false;
		
		for(Meal meal : meals) {
			if(meal.getCuisine().getId() == cuisineId) {
				res = true;
			}
		}

		return res;
	}

	@Override
	public void clearOrderedMeals() {
		orderedMeals.clear();
	}

}
