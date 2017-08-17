package com.worldticket.service;

import java.util.List;

import com.worldticket.domain.Exchange;
import com.worldticket.domain.Rate;

public interface RateService {

	void Save(Rate rate);
	
	Rate FindByCountry(String country);
	
	List<Rate> FindAll();
	
	//Find All
	void Calculate(Exchange exchange);
}
