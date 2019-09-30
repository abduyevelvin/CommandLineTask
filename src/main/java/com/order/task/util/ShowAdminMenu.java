package com.order.task.util;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAdminMenu {

	@Autowired
	private CuisineMethods cuisineMethods;
	@Autowired
	private DrinkMethods drinkMethods;
	@Autowired
	private MealMethods mealMethods;
	@Autowired
	private ShowRoleChoice showRoleChoice;
	
	Scanner sc = new Scanner(System.in);

	public void showMenu() {

		try {
			System.out.println("Please choose function: \n1. Administrative \n2. Back");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				adminMenu();
				break;
			case 2:
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

	public void adminMenu() {
		
		try {
			System.out.println("Please choose function: \n1. Add Cuisine \n2. Add Meal \n3. Add Drink \n4. Back");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				cuisineMethods.addCuisine();
				adminMenu();
				break;
			case 2:
				mealMethods.addMeal();
				adminMenu();
				break;
			case 3:
				drinkMethods.addDrink();
				adminMenu();
			case 4:
				showMenu();
				break;
			default:
				System.out.println("Please choose something from the list!");
				adminMenu();
				break;
			}
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}
}