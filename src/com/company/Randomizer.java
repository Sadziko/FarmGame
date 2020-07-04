package com.company;

import com.company.Buildings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public static Farm getRandomFarm(){
        Farm farmToReturn = new Farm(new Random().nextInt(5) + 5  );
        farmToReturn.buildingsList = new ArrayList<FarmBuilding>(  );
        farmToReturn.buildingsList.add( getRandomFarmBuilding() );
        return farmToReturn;
    }

    public static List<Farm> getRandomFarm(int amount){
        List<Farm> farmsToReturn = new ArrayList<>(  );

        while (farmsToReturn.size() <= amount)
            farmsToReturn.add( getRandomFarm() );

        return farmsToReturn;
    }

    public static FarmBuilding getRandomFarmBuilding(){
        int buildingType = new Random().nextInt(3) + 1;

        switch (buildingType){
            case 1:
                return new Barn();
            case 2:
                return new Henhouse( );
            case 3:
                return new Clew();
        }
        return null;
    }
}
