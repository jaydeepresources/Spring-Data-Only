package com.boot;

public class PriceRatingStats {

	private float averagePrice;
	private int productRating;

	public PriceRatingStats() {
	
	}

	public PriceRatingStats(float averagePrice, int productRating) {
		super();
		this.averagePrice = averagePrice;
		this.productRating = productRating;
	}

	public float getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(float averagePrice) {
		this.averagePrice = averagePrice;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}

	@Override
	public String toString() {
		return "\nPriceRatingStats [averagePrice=" + averagePrice + ", productRating=" + productRating + "]\n";
	}

}
