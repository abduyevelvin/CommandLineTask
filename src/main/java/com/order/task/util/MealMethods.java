package com.order.task.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.task.model.Cuisine;
import com.order.task.model.Meal;
import com.order.task.service.CuisineService;
import com.order.task.service.MealService;

@Component
public class MealMethods {

	@Autowired
	private MealService mealService;
	@Autowired
	private CuisineService cuisineService;
	@Autowired
	private ShowAdminMenu showAdminMenu;

	Scanner sc = new Scanner(System.in);

	public void getMeals() {

		List<Meal> meals = mealService.getMeals();

		if (meals.isEmpty()) {
			System.out.println("There is no meal in the list!");
		} else {
			System.out.println("Meal List:");
			for (Meal meal : meals) {
				System.out.println(meal);
			}
		}
	}

	public void getMeal(Long id) {

		List<Meal> meals = mealService.getMeal(id);

		System.out.println("Meal List:");
		for (Meal meal : meals) {
			System.out.println(meal.getId() + ". " + meal.getName() + " --- " + meal.getPrice());
		}

	}

	public void addMeal() {
		List<Cuisine> cuisines = cuisineService.getCuisines();
		try {
			if (cuisines.isEmpty()) {
				System.out.println("Please first add cuisine!");
				showAdminMenu.adminMenu();
			} else {
				System.out.println("Please choose cuisine from the list: ");
				// sc.nextLine();
				showCuisines(cuisines);
				Long id = sc.nextLong();
				sc.nextLine();
				Cuisine cuisine = cuisineService.getCuisine(id);

				if (cuisine == null) {
					System.out.println("Please choose from above list!");
					showCuisines(cuisines);
				} else {
					System.out.print("Please enter meal name: ");
					String name = sc.nextLine();
					System.out.print("Please enter meal price: ");
					BigDecimal price = sc.nextBigDecimal();
					/*
					 * System.out.print("Please enter cuisine name: "); String cuisineName =
					 * sc.nextLine();
					 */
					Meal meal = new Meal(name, price, cuisine);
					mealService.addMeal(meal);
				}

			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	private void showCuisines(List<Cuisine> cuisines) {
		// sc.nextLine();
		System.out.println("Cuisine List:");
		for (Cuisine cuisine : cuisines) {
			System.out.println(cuisine);
		}
	}
}
