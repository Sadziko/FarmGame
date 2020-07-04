package com.company.Plants;

public class Wheat extends FarmCropPlant {
    public static final int amountOfCollected = 100;
    public static final double valuePerKg = 10.0;
    public static final double costOfPreparing = 100.0;
    public static final  double costOfCollecting = 100.0;
    static final int weeksToFullyGrow = 40;
    static final int minWeekAllowedToPlant = 8;
    static final int maxWeekAllowedToPlant = 12;


    public Wheat() {
        super( amountOfCollected, valuePerKg, costOfPreparing, costOfCollecting, weeksToFullyGrow, minWeekAllowedToPlant, maxWeekAllowedToPlant );
    }
}
