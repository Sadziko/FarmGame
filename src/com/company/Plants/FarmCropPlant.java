package com.company.Plants;

import com.company.Enums.EnumSize;

import java.util.ArrayList;
import java.util.List;


public abstract class FarmCropPlant {
    EnumSize size;
    int amountInKg;
    int amountOfCollected;
    double valuePerKg;
    double costOfPreparing;
    double costOfCollecting;
    int weeksToFullyGrow;
    List<Integer> weeksAllowedToPlant;

    public FarmCropPlant(int amountOfCollected, double valuePerKg, double costOfPrepraring, double costOfCollecting,
                         int weeksToFullyGrow, int minWeekAllowedToPlant, int maxWeekAllowedToPlant) {
        this.amountOfCollected = amountOfCollected;
        this.valuePerKg = valuePerKg;
        this.costOfPreparing = costOfPrepraring;
        this.costOfCollecting = costOfCollecting;
        this.weeksToFullyGrow = weeksToFullyGrow;
        this.weeksAllowedToPlant = generateRange(minWeekAllowedToPlant, maxWeekAllowedToPlant);
        this.size = EnumSize.NOTPLANTED;
        this.amountInKg = 0;
    }

    private List<Integer> generateRange(int min, int max){
        List<Integer> integerList = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            integerList.add( i );
        }
        return integerList;
    }
}
