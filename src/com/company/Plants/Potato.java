package com.company.Plants;

public class Potato extends FarmCropPlant {
    static final int amountOfCollected = 30;
    static final double valuePerKg = 50.0;
    static final double costOfPreparing = 50.0;
    static final  double costOfCollecting = 300.0;
    static final int weeksToFullyGrow = 12;
    static final int minWeekAllowedToPlant = 12;
    static final int maxWeekAllowedToPlant = 16;


    public Potato() {
        super( amountOfCollected, valuePerKg, costOfPreparing, costOfCollecting, weeksToFullyGrow, minWeekAllowedToPlant, maxWeekAllowedToPlant );
    }
}
