package com.company.Buildings;

import com.company.Helpers;
import com.company.Plants.FarmCropPlant;
import com.company.Player;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    public int maxSize;
    public FarmCropPlant[] plants;
    public List<FarmBuilding> buildingsList;

    private double costToExtend;

    public Farm(int size) {
        this.maxSize = size;
        plants = new FarmCropPlant[size];
        costToExtend = 10000;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "plants max amount=" + maxSize +
                ", buildingsList=" + buildingsList +
                '}';
    }

    public boolean extendFarmSize(Player player){
        if (player.cash >= this.costToExtend)
        {
            player.cash -= costToExtend;
            maxSize++;
            Helpers.resizeArray( player.farm.plants, maxSize );
            System.out.println("Your farm is now bigger! New size: " + maxSize);
            costToExtend += 1000.0;
            System.out.println("Next upgrade will cost you " + costToExtend);

            return true;
        }
        System.out.println("You don't have enough money! You need " + costToExtend);
        return false;

    }
    public boolean decreaseFarmSize(Player player){
        if (player.farm.maxSize > 1)
        {
            player.cash += costToExtend/2;
            maxSize--;
            Helpers.resizeArray( player.farm.plants, maxSize );
            System.out.println("Your farm is now smaller! New size: " + maxSize);
            costToExtend -= 1000.0;
            System.out.println("Next upgrade will cost you " + costToExtend);
            return true;
        }
        System.out.println("You have to keep at least some of your ground!");
        return false;

    }

    public void displayFarmCrops(){
        for ( FarmCropPlant plant: plants) {

            if (plant == null)
                System.out.println("Empty");
            else
                System.out.println(plant.getClass().getSimpleName());
        }
    }
}
