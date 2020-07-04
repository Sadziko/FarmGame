package com.company.Buildings;


import com.company.Plants.FarmCropPlant;
import com.company.Player;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//stodola
public class Barn extends FarmBuilding {

    public Hashtable<String, Integer> farmPlantsStorage;


    public Barn() {
        super( 100, 1000.0 );
        this.farmPlantsStorage = new Hashtable<String, Integer>();
        farmPlantsStorage.put( "Wheat", 0 );
        farmPlantsStorage.put( "Oat", 0 );
        farmPlantsStorage.put( "Potato", 0 );
        farmPlantsStorage.put( "Apples", 0 );
        farmPlantsStorage.put( "Tobacco", 0 );
    }

    public static boolean displayStorageContent(Player player){
        boolean foundBarn = false;

        for (FarmBuilding building : player.farm.buildingsList) {
            if (building instanceof Barn)
            {
                ((Barn) building).getStorage();
                foundBarn = true;
            }
        }
        if(!foundBarn)
            System.out.println("You don't have a barn yet!");

        return foundBarn;
    }


    private void getStorage(){
        farmPlantsStorage.forEach((s, integer) ->
                System.out.println(s + ": " + integer));
        }

}
