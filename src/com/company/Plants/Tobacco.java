package com.company.Plants;

import com.company.Player;

public class Tobacco extends FarmCropPlant {
    static final int amountOfCollected = 10;
    static final double valuePerKg = 100.0;
    static final double costOfPreparing = 200.0;
    static final double costOfCollecting = 200.0;
    static final int weeksToFullyGrow = 35;
    static final int minWeekAllowedToPlant = 8;
    static final int maxWeekAllowedToPlant = 12;


    public Tobacco() {
        super( amountOfCollected, valuePerKg, costOfPreparing, costOfCollecting, weeksToFullyGrow, minWeekAllowedToPlant, maxWeekAllowedToPlant );
    }

    @Override
    public void harvest(Player player) {
        if (super.currentWeekAge >= weeksToFullyGrow) {
            if (player.farm.getBarn() != null) {
                player.farm.getBarn().farmPlantsStorage.merge( "Tobacoo", amountOfCollected, Integer::sum );
                for (int i = 0; i < player.farm.plants.length; i++) {
                    if (player.farm.plants[i] == this)
                        player.farm.plants[i] = null;
                }
                player.plantsInventory.merge( "Tobacoo", 1, Integer::sum );
            } else
                System.out.println( "You don't have a barn yet!" );
        }
        System.out.println( "It's not ready yet! Weeks remaining: " + (weeksToFullyGrow - currentWeekAge) );
    }

    @Override
    public void increase() {
        this.currentWeekAge++;
        if (currentWeekAge >= weeksToFullyGrow)
            System.out.println( this.getClass().getSimpleName() + " ready to harvest!" );
    }
}
