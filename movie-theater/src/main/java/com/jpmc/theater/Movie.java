package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private boolean isSpecialMovie;

	public Movie(String title, Duration runningTime, double ticketPrice, boolean isSpecialMovie) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.isSpecialMovie = isSpecialMovie;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    
    public boolean isSpecialMovie() {
		return isSpecialMovie;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(isSpecialMovie, movie.isSpecialMovie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, isSpecialMovie);
    }
}