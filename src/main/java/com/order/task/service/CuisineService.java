package com.order.task.service;

import java.util.List;

import com.order.task.model.Cuisine;

public interface CuisineService {

	List<Cuisine> getCuisines();
	Cuisine getCuisine(Long id);
	void addCuisine(Cuisine cuisine);
}
