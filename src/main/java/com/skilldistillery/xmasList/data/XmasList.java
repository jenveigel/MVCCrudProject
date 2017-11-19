package com.skilldistillery.xmasList.data;

public class XmasList {
	
	private int id;
	private String recipient;
	private String giftItem;
	private String reason;
	private double cost;
	
	public XmasList(int id, String recipient, String giftItem, String reason, double cost) {
		super();
		this.id = id;
		this.recipient = recipient;
		this.giftItem = giftItem;
		this.reason = reason;
		this.cost = cost;
	}

	public XmasList() { }

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getGiftItem() {
		return giftItem;
	}

	public void setGiftItem(String giftItem) {
		this.giftItem = giftItem;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XmasList other = (XmasList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gift for " + recipient + ": " + giftItem 
				+ "\n" + id + ", cost: $" + cost
				+ "\n Because... " + reason;
	}
	
}