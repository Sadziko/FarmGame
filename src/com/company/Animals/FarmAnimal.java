package com.company.Animals;

import com.company.Enums.EnumAge;

public abstract class FarmAnimal {
    EnumAge age;
    int weight;
    double price;
    final int timeToFullyGrowthNeeded;
    final int weightGainByWeek;
    float chanceToReproduce;

    public FarmAnimal(int weight, double price, int timeToFullyGrowthNeeded, int weightGainByWeek, float chanceToReproduce) {
        this.age = EnumAge.YOUNG;
        this.weight = weight;
        this.price = price;
        this.timeToFullyGrowthNeeded = timeToFullyGrowthNeeded;
        this.weightGainByWeek = weightGainByWeek;
        this.chanceToReproduce = chanceToReproduce;
    }
}
