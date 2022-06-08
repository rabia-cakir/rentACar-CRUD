package com.kodlamaio.rentACar.business.requests.cars;


import com.kodlamaio.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateCarRequest {
	private String description;
	private double dailyPrice;
	private int brandId;
	private int colorId;


}
