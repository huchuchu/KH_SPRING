package com.test03;



public class MyFoodMgr {

	private Food favoriteFood;
	private Food unFavoriteFood;
	
	public MyFoodMgr() {
		Food food = new Food();
		food.setFoodName("삼겹살");
		food.setFoodPrice(8000);
		this.favoriteFood = food;
			
		
	}

	public MyFoodMgr(Food favoriteFood, Food unFavoriteFood) {

		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
	}

	public Food getFavoriteFood() {
		return favoriteFood;
	}

	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}

	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}

	@Override
	public String toString() {
		return "favoriteFood: " + favoriteFood + ", unFavoriteFood: " + unFavoriteFood ;
	}
	
	
	
	
	
}
