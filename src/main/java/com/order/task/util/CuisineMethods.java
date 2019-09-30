package com.order.task.util;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.task.model.Cuisine;
import com.order.task.service.CuisineService;

@Component
public class CuisineMethods {

	@Autowired
	private CuisineService cuisineService;

	Scanner sc = new Scanner(System.in);

	public void addCuisine() {
		try {
			System.out.print("Please enter cuisine name: ");
			String name = sc.nextLine();
			Cuisine cuisine = new Cuisine(name);
			cuisineService.addCuisine(cuisine);
		} catch (Exception e) {
			sc.close();
			e.printStackTrace();
		}
	}

	public void getCuisines() {

		List<Cuisine> cuisines = cuisineService.getCuisines();

		if (cuisines.isEmpty()) {
			System.out.println("There is no cuisine in the list!");
		} else {
			System.out.println("Cuisine List:");
			for (Cuisine cuisine : cuisines) {
				System.out.println(cuisine);
			}
		}
	}
}
