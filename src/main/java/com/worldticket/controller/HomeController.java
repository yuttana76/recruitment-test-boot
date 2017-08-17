package com.worldticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.worldticket.domain.Exchange;
import com.worldticket.domain.Rate;
import com.worldticket.service.RateService;

@Controller
public class HomeController {
	
	@Autowired
	private RateService rateService;
	
	@RequestMapping("/")
	public String home(){
		return "redirect:/index";
	}
	
	@RequestMapping(value="/index",method = { RequestMethod.GET, RequestMethod.POST })
	public String index(@ModelAttribute("exchange") Exchange exchange,Model model){
		
		List<Rate> rateList = rateService.FindAll();
		
		if(exchange != null && exchange.getAction() !=null){
			rateService.Calculate(exchange);
		}
		
		model.addAttribute("exchange", exchange);
		model.addAttribute("rateList", rateList);
		return "index";
	}
	
	
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String config(Model model){
		
		Rate rate = new Rate("", 0, 0, 0, 0, 0,0);
		model.addAttribute("rate",rate);
		return "config";
	}

	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public String configPost(@ModelAttribute("rate") Rate rate, Model model){
		try{
			rateService.Save(rate);
			return "redirect:/";
		}catch(Exception ex){
			System.out.print(ex.getMessage());
			model.addAttribute("error",ex.getMessage());
		}
		
		model.addAttribute("rate",rate);
		return "redirect:/config";
		
	}
}
