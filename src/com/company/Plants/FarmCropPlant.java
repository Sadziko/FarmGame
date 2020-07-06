package com.company.Plants;

import com.company.Enums.EnumSize;
import com.company.Interfaces.Growable;
import com.company.Interfaces.Harvestable;

import java.util.ArrayList;
import java.util.List;


public abstract class FarmCropPlant implements Harvestable, Growable {
    EnumSize size;
    int amountOfCollected;
    double valuePerKg;
    double costOfPreparing;
    double costOfCollecting;
    int weeksToFullyGrow;
    public int currentWeekAge;
    public static List<Integer> weeksAllowedToPlant;

    public FarmCropPlant(int amountOfCollected, double valuePerKg, double costOfPrepraring, double costOfCollecting,
                         int weeksToFullyGrow, int minWeekAllowedToPlant, int maxWeekAllowedToPlant) {
        this.amountOfCollected = amountOfCollected;
        this.valuePerKg = valuePerKg;
        this.costOfPreparing = costOfPrepraring;
        this.costOfCollecting = costOfCollecting;
        this.weeksToFullyGrow = weeksToFullyGrow;
        this.weeksAllowedToPlant = generateRange(minWeekAllowedToPlant, maxWeekAllowedToPlant);
        this.size = EnumSize.NOTGROWN;
        this.currentWeekAge = 0;
    }

    private List<Integer> generateRange(int min, int max){
        List<Integer> integerList = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            integerList.add( i );
        }
        return integerList;
    }
}
