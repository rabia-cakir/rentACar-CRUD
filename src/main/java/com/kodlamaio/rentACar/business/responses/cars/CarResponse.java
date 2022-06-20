package com.kodlamaio.rentACar.business.responses.cars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse {
	private int id;
	private String description;
	private double dailyPrice;
	private String licensePlate;
	private int kilometer;
	private int state;
	private int brandId;
	private int colorId;
	private int minFindexScore;

}
