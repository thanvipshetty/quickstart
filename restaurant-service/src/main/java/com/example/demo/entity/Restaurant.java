package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name="restaurant_SEP_2022")
//class Names are noun and singular
public class Restaurant {
	
	@Id
	@Column(name="restaurant_id",length=5)
	int restaurantId;
	
	@Column(name="restaurant_Name",length=45)
	String restaurantName;
	
	@Column(name="rating",precision=2,scale=5)
	double rating;
	
	@Column(name="location",length=30)
	String location;
	
	@Column(name="opening_date")
	LocalDate openingDate;

}
