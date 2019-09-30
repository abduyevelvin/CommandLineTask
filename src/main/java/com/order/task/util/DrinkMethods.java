package com.order.task.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.task.model.Drink;
import com.order.task.service.DrinkService;

@Component
public class DrinkMethods {

	@Autowired
	private DrinkService drinkService;
	@Autowired
	private ShowUserMenu showUserMenu;

	Scanner sc = new Scanner(System.in);

	public void addDrink() {

		try {
			System.out.print("Please enter drink name: ");
			String name = sc.nextLine();
			System.out.print("Please enter drink price: ");
			BigDecimal price = sc.nextBigDecimal();
			sc.nextLine();
			Drink drink = new Drink(name, price);
			drinkService.addDrink(drink);
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}

	}

	public void getDrinks() {

		List<Drink> drinks = drinkService.getDrinks();

		if (drinks.isEmpty()) {
			System.out.println("There is no drink in the list!");
			showUserMenu.userMenu();
		} else {
			System.out.println("Drink List:");
			for (Drink drink : drinks) {
				System.out.println(drink);
			}
			chooseDrink();
		}
	}

	private void chooseDrink() {

		try {
			System.out.print("Please choose drink: ");
			Long id = sc.nextLong();
			drinkService.orderDrink(id);
			showUserMenu.userMenu();
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}
}
