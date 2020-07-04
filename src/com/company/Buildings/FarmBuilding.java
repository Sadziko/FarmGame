package com.company.Buildings;

import java.util.List;

public abstract class FarmBuilding {
    int size;
    public double value;


    public FarmBuilding(int size, double value) {
        this.size = size;
        this.value = value;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() +
                " size=" + size +
                ", value=" + value +
                '}';
    }
}
