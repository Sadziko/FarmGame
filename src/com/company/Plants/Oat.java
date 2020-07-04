package com.company.Plants;

public class Oat extends FarmCropPlant {
    static final int amountOfCollected = 80;
    static final double valuePerKg = 20.0;
    static final double costOfPreparing = 200.0;
    static final  double costOfCollecting = 200.0;
    static final int weeksToFullyGrow = 35;
    static final int minWeekAllowedToPlant = 8;
    static final int maxWeekAllowedToPlant = 12;


    public Oat() {
        super( amountOfCollected, valuePerKg, costOfPreparing, costOfCollecting, weeksToFullyGrow, minWeekAllowedToPlant, maxWeekAllowedToPlant );
    }
}
