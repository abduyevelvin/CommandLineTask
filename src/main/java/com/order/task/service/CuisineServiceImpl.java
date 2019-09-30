package com.order.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.task.dao.CuisineDAO;
import com.order.task.model.Cuisine;

@Service
public class CuisineServiceImpl implements CuisineService {

	@Autowired
	private CuisineDAO cuisineDAO;

	@Override
	public List<Cuisine> getCuisines() {
		return cuisineDAO.getCuisines();
	}

	@Override
	public void addCuisine(Cuisine cuisine) {
		cuisineDAO.addCuisine(cuisine);
	}

	@Override
	public Cuisine getCuisine(Long id) {
		return cuisineDAO.getCuisine(id);
	}

}
