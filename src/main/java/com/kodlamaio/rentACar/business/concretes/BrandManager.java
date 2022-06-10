package com.kodlamaio.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar.business.abstracts.BrandService;
import com.kodlamaio.rentACar.business.requests.brands.CreateBrandRequest;
import com.kodlamaio.rentACar.business.requests.brands.UpdateBrandRequest;
import com.kodlamaio.rentACar.business.responses.brands.BrandResponse;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.ErrorResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;
import com.kodlamaio.rentACar.core.utilities.results.SuccessResult;
import com.kodlamaio.rentACar.dataAccess.abstracts.BrandRepository;
import com.kodlamaio.rentACar.entities.concretes.Brand;


@Service
public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	
	
	@Autowired
	public BrandManager(BrandRepository brandRepository)
	{
		this.brandRepository=brandRepository;
	}


	@Override
	public Result add(CreateBrandRequest createBrandRequest) {
		
		//mapping
		Brand brand=new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
		
	
		return new SuccessResult("BRAND.ADDED");
		
		
	}


	@Override
	public List<BrandResponse> getAll() {
		//mapping
		List<Brand> brands=brandRepository.findAll();
		return brands.stream().map(b->new BrandResponse(b)).collect(Collectors.toList());
		
		
	}

	
	

	@Override
	public Result deleteById(int id) {
		
		brandRepository.deleteById(id);
		return new SuccessResult("BRAND.DELETED");
		
		
		
	}


	@Override
	public Result update(UpdateBrandRequest updateBrandRequest, int id) {
		//mapping
		Brand brand=new Brand();
		brand.setName(updateBrandRequest.getName());
		Optional<Brand> currentBrand=brandRepository.findById(id);
		if(currentBrand.isPresent())
		{
			Brand foundBrand=currentBrand.get();
			foundBrand.setName(brand.getName());
			brandRepository.save(foundBrand);
			
		}
		return new SuccessResult("BRAND.UPDATED");
		
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public Brand getBrandById(int id) {
		return brandRepository.getById(id);
	}


	

	

}
