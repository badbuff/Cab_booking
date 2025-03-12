package com.example.cabBooking.service;

import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorService {

    private static final double BASE_FARE_PER_KM = 50.0; // 50 per KM
    private static final double TAX_PERCENTAGE = 5.0;  // 5% tax
    private static final double DISCOUNT_PERCENTAGE = 10.0; // 10% discount for members

    public double calculateBaseFare(double distance) {
        return distance * BASE_FARE_PER_KM;
    }

    public double calculateTax(double fare) {
        return (fare * TAX_PERCENTAGE) / 100;
    }

    public double applyDiscount(double fare, boolean isMember) {
        if (isMember) {
            return (fare * DISCOUNT_PERCENTAGE) / 100;
        }
        return 0;
    }

    public double calculateTotalFare(double distance, boolean isMember) {
        double baseFare = calculateBaseFare(distance);
        double tax = calculateTax(baseFare);
        double discount = applyDiscount(baseFare, isMember);
        return baseFare + tax - discount;
    }
}
