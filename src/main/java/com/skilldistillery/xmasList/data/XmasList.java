package com.skilldistillery.xmasList.data;

public class XmasList {
	
	private String recipient;
	private String giftItem;
	private int id;
	private String reason;
	private double cost;
	
	public XmasList(String recipient, String giftItem, int id, String reason, double cost) {
		super();
		this.recipient = recipient;
		this.giftItem = giftItem;
		this.id = id;
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

	public void setGiftId(int id) {
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