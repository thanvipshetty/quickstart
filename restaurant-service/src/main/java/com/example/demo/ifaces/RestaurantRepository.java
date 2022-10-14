package com.example.demo.ifaces;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
   //findByPropertyName=>property Name first character in caps
	//restaurantName in class becomes RestaurantName in the method
	public List<Restaurant> findByRestaurantName(String name);
	
	@Query(value = "select * from restaurant_sep_2022 where location =:loc",nativeQuery=true)
	public List<Restaurant> fetchUsingLocation(@Param("loc")String Location);
    
	//JPQL => USES CLASS NAME AND PropertyNAME
	@Query(value = "from Restaurant where rating=:reqRating")
	public List<Restaurant> fetchUsingRating(@Param("reqRating")double rating);
    
	//JPQL => Uses class Name and Property Name
	@Modifying
	@Transactional
	@Query(value = "update Restaurant set rating=:newRating where restaurantId=:id")
	public int updateRating(@Param("id")int id ,@Param("newRating")double revisedRating);

	
}
