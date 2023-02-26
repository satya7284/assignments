package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {
  
    @Test
    void testSingleTon() {
    	// Arrange
    	LocalDateProvider expected = LocalDateProvider.singleton();
    	
    	// Act
    	LocalDateProvider actual = LocalDateProvider.singleton();
    	
    	// Assert
    	assertEquals(expected, actual);
    }
    
    @Test
    void testCurrentDate() {
    	
    	// Arrange
    	LocalDate currentDate = LocalDate.now();
    	
    	// Act
    	LocalDate localDate = LocalDateProvider.singleton().currentDate();
    	
    	// Assert
    	assertEquals(currentDate.getYear(), localDate.getYear());
    	assertEquals(currentDate.getMonth(), localDate.getMonth());
    	assertEquals(currentDate.getDayOfMonth(), localDate.getDayOfMonth());
    }
}
