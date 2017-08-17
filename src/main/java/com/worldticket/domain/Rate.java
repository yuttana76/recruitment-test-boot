package com.worldticket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="Country",nullable=false ,unique=true)
	private String country;
	private int buyMinRate;
	private int buyMaxRate;
	
	private int sellMinRate;
	private int sellMaxRate;
	
	private int buyMinVal;
	private int sellMinVal;
	
	public Rate(){
		super();
	}

	public Rate(String country, int buyMinRate, int buyMaxRate, int sellMinRate, int sellMaxRate, int buyMinVal,
			int sellMinVal) {
		super();
		this.country = country;
		this.buyMinRate = buyMinRate;
		this.buyMaxRate = buyMaxRate;
		this.sellMinRate = sellMinRate;
		this.sellMaxRate = sellMaxRate;
		this.buyMinVal = buyMinVal;
		this.sellMinVal = sellMinVal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getBuyMinRate() {
		return buyMinRate;
	}

	public void setBuyMinRate(int buyMinRate) {
		this.buyMinRate = buyMinRate;
	}

	public int getBuyMaxRate() {
		return buyMaxRate;
	}

	public void setBuyMaxRate(int buyMaxRate) {
		this.buyMaxRate = buyMaxRate;
	}

	public int getSellMinRate() {
		return sellMinRate;
	}

	public void setSellMinRate(int sellMinRate) {
		this.sellMinRate = sellMinRate;
	}

	public int getSellMaxRate() {
		return sellMaxRate;
	}

	public void setSellMaxRate(int sellMaxRate) {
		this.sellMaxRate = sellMaxRate;
	}

	public int getBuyMinVal() {
		return buyMinVal;
	}

	public void setBuyMinVal(int buyMinVal) {
		this.buyMinVal = buyMinVal;
	}

	public int getSellMinVal() {
		return sellMinVal;
	}

	public void setSellMinVal(int sellMinVal) {
		this.sellMinVal = sellMinVal;
	}
	
	
	
		
}
