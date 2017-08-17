package com.worldticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.worldticket.domain.Exchange;
import com.worldticket.service.RateService;

@Controller
public class RestController {
	
	@Autowired
	private RateService rateService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/calculate/{country}")
	public @ResponseBody Exchange calculate(@PathVariable String country,@RequestParam(value="action") String action, @RequestParam(value="amount") int amount) {
		
		Exchange exchange = new Exchange();
		exchange.setTarget(country);
		exchange.setAction(action);
		exchange.setAmount(amount);
		
		if(exchange != null && exchange.getAction() !=null){
			rateService.Calculate(exchange);
		}
		
		return exchange;
	}

}
