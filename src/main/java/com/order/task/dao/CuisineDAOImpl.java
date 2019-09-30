package com.order.task.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.order.task.model.Cuisine;

@Repository
public class CuisineDAOImpl implements CuisineDAO {

	private List<Cuisine> cuisines = new ArrayList<Cuisine>();

	@Override
	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	public void addCuisine(Cuisine cuisine) {

		if (cuisines.isEmpty()) {
			cuisine.setId(1L);
			cuisines.add(cuisine);
			System.out.println("Cuisine is added successfully!");
		} else {

			Cuisine cs = cuisines.stream().filter(c -> cuisines.contains(cuisine)).findAny().orElse(null);

			// System.out.println(cs);

			/*
			 * for (Cuisine c : cuisines) { if (c.getName().equals(cuisine.getName())) {
			 * exists = true; System.out.println("Cuisine is already exists!"); } }
			 */

			if (cs == null) {

				long id = cuisines.get(cuisines.size() - 1).getId() + 1;

				cuisine.setId(id);
				cuisines.add(cuisine);

				System.out.println("Cuisine is added successfully!");
			} else {
				System.out.println("Cuisine is already exists!");
			}

		}
	}

	@Override
	public Cuisine getCuisine(Long id) {
		for (Cuisine cuisine : cuisines) { 
			if (cuisine.getId() == id) {
				return cuisine;
			}
		}
		
		return null;
	}
}
