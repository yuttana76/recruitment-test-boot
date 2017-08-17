package com.worldticket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldticket.domain.Exchange;
import com.worldticket.service.RateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitmentTestBootApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	@Autowired
	private RateService rateService;
	
	@Test
	public void Test_Calculate_BUY_large_volume(){
		
		Exchange exchange = new Exchange();
		exchange.setTarget("US");
		exchange.setAction("BUY");
		exchange.setAmount(10000);
		
		rateService.Calculate(exchange);	//Rate 30
		System.out.println("Test_Calculate()-> " + exchange.getResult());
		assertEquals(exchange.getResult(), 333);
		
	}
	
	@Test
	public void Test_Calculate_BUY_small_volume(){
		
		Exchange exchange = new Exchange();
		exchange.setTarget("US");
		exchange.setAction("BUY");
		exchange.setAmount(500);
		
		rateService.Calculate(exchange);	//Rate 31
		System.out.println("Test_Calculate()-> " + exchange.getResult());
		assertEquals(exchange.getResult(), 16);
		
	}
	
	@Test
	public void Test_Calculate_SELL_large_volume(){
		
		Exchange exchange = new Exchange();
		exchange.setTarget("US");
		exchange.setAction("SELL");
		exchange.setAmount(500);
		
		rateService.Calculate(exchange);	//Rate 21
		System.out.println("Test_Calculate()-> " + exchange.getResult());
		assertEquals(exchange.getResult(), 10500);
		
	}
	
	@Test
	public void Test_Calculate_SELL_small_volume(){
		
		Exchange exchange = new Exchange();
		exchange.setTarget("US");
		exchange.setAction("SELL");
		exchange.setAmount(20);
		
		rateService.Calculate(exchange);	//Rate 20
		System.out.println("Test_Calculate()-> " + exchange.getResult());
		assertEquals(exchange.getResult(), 400);
		
	}
	
}
