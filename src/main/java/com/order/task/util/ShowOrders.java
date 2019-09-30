package com.order.task.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.task.model.Drink;
import com.order.task.model.Meal;
import com.order.task.service.DrinkService;
import com.order.task.service.MealService;

@Component
public class ShowOrders {

	@Autowired
	private MealService mealService;
	@Autowired
	private DrinkService drinkService;
	@Autowired
	private ShowUserMenu showUserMenu;
	@Autowired
	private DrinkMethods drinkMethods;
	
	Scanner sc = new Scanner(System.in);
	
	List<Meal> meals = new ArrayList<Meal>();
	List<Drink> drinks = new ArrayList<Drink>();

	public void showOrders() {		
		
		meals = mealService.getOrderedMeals();
		drinks = drinkService.getOrderedDrinks();
		
		if (meals.isEmpty()) {
			System.out.println("There is no ordered meal in the list! Please order a meal!");
			showUserMenu.showMenu();
		} else if (drinks.isEmpty()) {
			System.out.println("There is no ordered drink in the list! You can order a drink");
			
			try {
				mealDrinkList();
				System.out.println("Please choose: \n1. Choose Drink \n2. Finish Order");
				int choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					drinkMethods.getDrinks();
					break;
				case 2:
					clearOrders();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				sc.close();
				e.printStackTrace();
			}
			
			showUserMenu.showMenu();
		} else {
			mealDrinkList();
		}
	}
	
	public void clearOrders() {
		showTotalAmount();
		System.out.println("Thanks for your order!");
		drinkService.clearOrderedDrinks();
		mealService.clearOrderedMeals();
	}
	
	private void mealDrinkList() {
		
		meals = mealService.getOrderedMeals();
		drinks = drinkService.getOrderedDrinks();
		
		System.out.println("Ordered Meals:");
		for (Meal meal : meals) {
			System.out.println("Cuisine: " + meal.getCuisine().getName() + ": " + meal.getName() 
					+ " --- " + meal.getPrice());
		}
		System.out.println("------------------------------------------");
		System.out.println("Ordered drinks:");
		for (Drink drink : drinks) {
			System.out.println(drink.getName() + " --- " + drink.getPrice());
		}
	}
	
	private void showTotalAmount() {
		meals = mealService.getOrderedMeals();
		drinks = drinkService.getOrderedDrinks();
		
		BigDecimal mealPrice = BigDecimal.ZERO;
		BigDecimal drinkPrice = BigDecimal.ZERO;
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		for(Meal meal : meals) {
			mealPrice = mealPrice.add(meal.getPrice());
		}
		
		for(Drink drink : drinks) {
			drinkPrice = drinkPrice.add(drink.getPrice());
		}
		
		System.out.println("Total price of meal: " + mealPrice);
		System.out.println("Total price of drink: " + drinkPrice);
		System.out.println("--------------------------");
		totalPrice = mealPrice.add(drinkPrice);
		System.out.println("Total price: " + totalPrice);
	}

	/*
	 * private void getOrderedMeals() {
	 * 
	 * List<Meal> meals = mealService.getOrderedMeals();
	 * 
	 * if (meals.isEmpty()) {
	 * System.out.println("There is no ordered meal in the list!");
	 * showUserMenu.showMenu(); } else { System.out.println("Ordered Meals:"); for
	 * (Meal meal : meals) { System.out.println("Cuisine: " +
	 * meal.getCuisine().getName() + ": " + meal.getName() + " --- " +
	 * meal.getPrice()); } } }
	 *
	 */ 
	 /* private void getOrderedDrinks() {

		List<Drink> drinks = drinkService.getDrinks();

		if (drinks.isEmpty()) {
			System.out.println("There is no ordered drink in the list!");
			showUserMenu.showMenu();
		} else {
			System.out.println("Ordered drinks:");
			for (Drink drink : drinks) {
				System.out.println(drink.getName() + " --- " + drink.getPrice());
			}
		}
	}
	*/

}
