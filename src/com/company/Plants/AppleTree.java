package com.company.Plants;

public class AppleTree extends FarmCropPlant {
    static final int amountOfCollected = 200;
    static final double valuePerKg = 7.0;
    static final double costOfPreparing = 100.0;
    static final  double costOfCollecting = 50.0;
    static final int weeksToFullyGrow = 96;
    static final int minWeekAllowedToPlant = 8;
    static final int maxWeekAllowedToPlant = 24;


    public AppleTree() {
        super( amountOfCollected, valuePerKg, costOfPreparing, costOfCollecting, weeksToFullyGrow, minWeekAllowedToPlant, maxWeekAllowedToPlant );
    }
}
