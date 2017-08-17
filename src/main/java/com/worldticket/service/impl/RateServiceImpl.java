package com.worldticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldticket.Dao.RateDao;
import com.worldticket.domain.Exchange;
import com.worldticket.domain.Rate;
import com.worldticket.service.RateService;

@Service
public class RateServiceImpl implements RateService{

	final String ACTION_BUY= "BUY"; 
	final String ACTION_SELL= "SELL"; 
	
	@Autowired
	private RateDao rateDao;

	@Override
	public void Save(Rate rate) {
		rateDao.save(rate);
	}

	@Override
	public Rate FindByCountry(String country) {
		return rateDao.findByCountry(country);
	}

	@Override
	public List<Rate> FindAll() {
		return (List<Rate>) rateDao.findAll();
	}

	/*
	 * To calculate exchange 
	 * */
	@Override
	public void Calculate(Exchange exchange) {
		
		Rate rate = rateDao.findByCountry(exchange.getTarget());
		// Buy or Sell
		if(exchange.getAction().equalsIgnoreCase(ACTION_BUY)){
			//Buy
			if(exchange.getAmount()>=rate.getBuyMinVal()){
				System.out.println("BUY min rate is " + rate.getBuyMinRate());
				//User min rate
				exchange.setRating(rate.getBuyMinRate());
				exchange.setResult(exchange.getAmount()/rate.getBuyMinRate());
			}else{
				System.out.println("BUY max rate is " + rate.getBuyMaxRate());
				//Use max rate
				exchange.setRating(rate.getBuyMinRate());
				exchange.setResult(exchange.getAmount()/rate.getBuyMaxRate());
			}
		}else{
			//Sell 
			if(exchange.getAmount()>=rate.getSellMinVal()){
				System.out.println("SELL max rate is " + rate.getSellMaxRate());
				//Use max rate
				exchange.setRating(rate.getBuyMinRate());
				exchange.setResult(exchange.getAmount() * rate.getSellMaxRate());
			}else{
				System.out.println("SELL min rate is " + rate.getSellMinRate());
				//Use min rate
				exchange.setRating(rate.getBuyMinRate());
				exchange.setResult(exchange.getAmount() * rate.getSellMinRate());
			}
		}
//		return exchange;
	}
	
}
