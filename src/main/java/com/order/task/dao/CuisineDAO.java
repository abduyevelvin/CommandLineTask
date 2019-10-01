package com.order.task.dao;

import java.util.List;

import com.order.task.model.Cuisine;

public interface CuisineDAO {
	
	List<Cuisine> getCuisines();
	Cuisine getCuisine(Long id);
	void addCuisine(Cuisine cuisine);
	void addDefaultCuisines();
}
