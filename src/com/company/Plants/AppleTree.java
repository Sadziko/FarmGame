package com.company.Plants;

import com.company.Player;

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

    @Override
    public void harvest(Player player) {
        if(super.currentWeekAge >= weeksToFullyGrow){
            if(player.farm.getBarn() != null){
                player.farm.getBarn().farmPlantsStorage.merge( "Apples", amountOfCollected, Integer::sum );
                currentWeekAge = 0;
            }
            else
                System.out.println("You don't have a barn yet!");
        }
        System.out.println("It's not ready yet! Weeks remaining: " + (weeksToFullyGrow - currentWeekAge));
    }

    @Override
    public void increase() {
        this.currentWeekAge++;
        if(currentWeekAge >= weeksToFullyGrow)
            System.out.println(this.getClass().getSimpleName() + " ready to harvest!");
    }
}
