package com.order.task.util;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.task.service.CuisineService;
import com.order.task.service.MealService;

@Component
public class ShowUserMenu {

	@Autowired
	private CuisineMethods cuisineMethods;
	@Autowired
	private CuisineService cuisineService;
	@Autowired
	private MealService mealService;
	@Autowired
	private MealMethods mealMethods;
	@Autowired
	private ShowRoleChoice showRoleChoice;
	@Autowired
	private DrinkMethods drinkMethods;
	@Autowired
	private ShowOrders showOrders;

	Scanner sc = new Scanner(System.in);

	public void showMenu() {

		try {
			System.out.println("Please choose function: \n1. Order Lunch \n2. Your Lunch \n3. Back");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				userMenu();
				break;
			case 2:
				orderedLunch();
				break;
			case 3:
				showRoleChoice.roleChoice();
				break;
			default:
				System.out.println("Please choose something from the menu!");
				showMenu();
				break;
			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	public void userMenu() {

		try {
			System.out.println("Please choose: \n1. Choose Cuisine \n2. Choose Drink \n3. Back");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				if (cuisineService.getCuisines().isEmpty()) {
					System.out.println("Please add cuisine to the list as an Admin User!");
					showRoleChoice.roleChoice();
				} else {
					cuisineMethods.getCuisines();
					chooseMeal();
				}
				break;
			case 2:
				drinkMethods.getDrinks();
				break;
			case 3:
				showMenu();
				break;
			default:
				System.out.println("Please choose something from the list!");
				userMenu();
				break;
			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	private void chooseMeal() {

		try {
			System.out.print("Please choose cuisine: ");
			Long cuisineId = sc.nextLong();
			sc.nextLine();

			if (!mealService.checkCuisineMeal(cuisineId)) {
				System.out.println("There is no meal for this cuisine. Please choose another cuisine!");
				// System.out.println(cuisine);
				userMenu();
			} else {
				System.out.println("Please choose meal:");
				mealMethods.getMeal(cuisineId);
				orderMeal();
			}

		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	private void orderMeal() {

		try {
			System.out.print("Please choose meal: ");
			Long id = sc.nextLong();
			mealService.orderMeal(id);
			userMenu();
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	private void orderedLunch() {

		try {
			System.out.println("Please choose: \n1. Check Your Lunch \n2. Back");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				showOrders.showOrders();
				finishOrder();
				break;
			case 2:
				showMenu();
				break;
			default:
				System.out.println("Please choose something from the list!");
				orderedLunch();
				break;
			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	private void finishOrder() {

		try {
			System.out.println("Please choose: \n1. Finish Order \n2. Continue Order");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				showOrders.clearOrders();
				break;
			case 2:
				userMenu();
				break;
			default:
				System.out.println("Please choose something from the list!");
				finishOrder();
				break;
			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}
}
