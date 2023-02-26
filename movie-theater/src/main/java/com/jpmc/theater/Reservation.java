package com.jpmc.theater;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    public double totalFee() {
        return showing.getMovieFee() * audienceCount;
    }

    public double calculateTicketPrice() {
        return totalFee() - getDiscount();
    }

    private double getDiscount() {
    	List<Double> discountList = new ArrayList<>();
        
        int showSequence = this.showing.getSequenceOfTheDay();
        Movie movie = this.showing.getMovie();
        if (movie.isSpecialMovie()) {
        	discountList.add(movie.getTicketPrice() * DiscountRules.SPECIAL_MOVIE_DISCOUNT);  // 20% discount for special movie
        }

        if (showSequence == 1) {
        	discountList.add(DiscountRules.SEQUENCE_MOVIE_DISCOUNT_1ST); // $3 discount for 1st show
        } else if (showSequence == 2) {
        	discountList.add(DiscountRules.SEQUENCE_MOVIE_DISCOUNT_2ND); // $2 discount for 2nd show
        } else if (showSequence == 7) {
        	discountList.add(DiscountRules.SEQUENCE_MOVIE_DISCOUNT_7TH); // $1 discount for 7th show
        }
        
        LocalDateTime showStartTime = this.showing.getStartTime();
        if (showStartTime.getHour() >= 11  && showStartTime.getHour() <= 16) {
        	discountList.add(movie.getTicketPrice() * DiscountRules.TIME_BASED_MOVIE_DISCOUNT_11AM_4PM);
        }
        
        // biggest discount wins
        return Collections.max(discountList);
    }
    
    @Override
    public String toString() {
    	StringBuilder reserversionDetails = new StringBuilder();
    	reserversionDetails.append("Reservation Details: [ ");
    	reserversionDetails.append(customer);
    	reserversionDetails.append(", ");
    	reserversionDetails.append("Tickets count: ");
    	reserversionDetails.append(audienceCount);
    	reserversionDetails.append(", ");
    	reserversionDetails.append("Total Fare: $");
    	reserversionDetails.append(totalFee());
    	reserversionDetails.append(", ");
    	reserversionDetails.append("Discount : $");
    	reserversionDetails.append(getDiscount());
    	reserversionDetails.append(", ");
    	reserversionDetails.append("Final Fare : $");
    	reserversionDetails.append(calculateTicketPrice());
    	reserversionDetails.append("]");
    	return reserversionDetails.toString();
    }
}