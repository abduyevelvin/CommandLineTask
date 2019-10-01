package com.order.task.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.order.task.model.Cuisine;
import com.order.task.model.Meal;

@Repository
public class MealDAOImpl implements MealDAO {

	private List<Meal> meals = new ArrayList<Meal>();
	private List<Meal> orderedMeals = new ArrayList<>();
	private List<Meal> cuisineMeals = new ArrayList<>();
	
	@Override
	public void addDefaultMeals() {
		Meal polish = new Meal("Zrazy", new BigDecimal(12.7), new Cuisine());
		polish.setId(1L);
		Cuisine polishCuisine = new Cuisine("Polish");
		polishCuisine.setId(1L);
		polish.setCuisine(polishCuisine);
		Meal mexican = new Meal("Enchiladas", new BigDecimal(7.8), new Cuisine());
		mexican.setId(2L);
		Cuisine mexicanCuisine = new Cuisine("Mexican");
		mexicanCuisine.setId(2L);
		mexican.setCuisine(mexicanCuisine);
		Meal italian = new Meal("Pasta", new BigDecimal(5.3), new Cuisine());
		italian.setId(3L);
		Cuisine italianCuisine = new Cuisine("Italian");
		italianCuisine.setId(3L);
		italian.setCuisine(italianCuisine);
		
		meals.add(polish);
		meals.add(mexican);
		meals.add(italian);
	}
	
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
