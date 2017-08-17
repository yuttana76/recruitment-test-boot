package com.worldticket.domain;

public class Exchange {

	private String action;
	private String source;
	private String target;
	private int amount;
	private int rating;
	private int result;
	
	public Exchange(){
		super();
	}

	public Exchange(String action, String source, String target, int amount, int rating, int result) {
		super();
		this.action = action;
		this.source = source;
		this.target = target;
		this.amount = amount;
		this.rating = rating;
		this.result = result;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
}
