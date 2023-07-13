package com.epam.bd201.model;

public enum StayType {

    ERRONEOUS(null, null),
    SHORT_STAY(4,1),
    STANDARD_STAY(10, 5),
    STANDARD_EXTENDED_STAY(14, 11),
    LONG_STAY(null, 14);
    private final Integer minDaysOfStay;
    private final Integer maxDaysOfStay;

    StayType(Integer maxDaysOfStay, Integer minDaysOfStay) {
        this.maxDaysOfStay = maxDaysOfStay;
        this.minDaysOfStay = minDaysOfStay;
    }

    public Integer getMaxDaysOfStay() {
        return maxDaysOfStay;
    }

    public Integer getMinDaysOfStay() {
        return minDaysOfStay;
    }
}
