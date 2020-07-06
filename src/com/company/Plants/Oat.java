package com.company.Plants;

import com.company.Player;

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

    @Override
    public void harvest(Player player) {
        if(super.currentWeekAge >= weeksToFullyGrow){
            if(player.farm.getBarn() != null)
                player.farm.getBarn().farmPlantsStorage.merge( "Oat", amountOfCollected, Integer::sum );
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
