package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.ifaces.RestaurantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantService {
	
	private RestaurantRepository repo;
	
	public Restaurant add(Restaurant entity) {
		return this.repo.save(entity);
	}
	
	public List<Restaurant> findAll() {
		return this.repo.findAll();
	}
	
	public Restaurant findById(int id) {
		
		String message = "Element With "+ id+" Not found";
		return this.repo.findById(id).orElseThrow(() -> new RuntimeException(message));
	}
	public List<Restaurant> findByName(String name) {
		return this.repo.findByRestaurantName(name);
	}
	public List<Restaurant> fetchUsingRating(double rating) {
		return this.repo.fetchUsingRating(rating);
	}
	public int updateRating(int id,double revisedRating) {
		return this.repo.updateRating(30303,4.8);
	}
	
	public List<Restaurant> fetchUsingLocation(String location) {
		return this.repo.fetchUsingLocation(location);
	}
	
	
	public Restaurant update(Restaurant entity) {
		return this.repo.save(entity);
	}
	
	public Restaurant remove(int id) {
		Restaurant obj = findById(id);
		  this.repo.deleteById(id);
		  
		  return obj;
	}
}
