package com.jpmc.theater;

public interface DiscountRules {
	
	double SPECIAL_MOVIE_DISCOUNT = 0.2; // 20% discount for special movie
	
	double SEQUENCE_MOVIE_DISCOUNT_1ST = 3; // $3 discount for 1st show
	
	double SEQUENCE_MOVIE_DISCOUNT_2ND = 2; // $2 discount for 2nd show
	
	double SEQUENCE_MOVIE_DISCOUNT_7TH = 1; // $1 discount for 7th show
	
	double TIME_BASED_MOVIE_DISCOUNT_11AM_4PM = 0.25; // 25% discount for movies showing starting between 11AM ~ 4pm

}
