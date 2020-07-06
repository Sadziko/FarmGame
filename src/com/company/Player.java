package com.company;

import com.company.Buildings.Farm;
import com.company.Plants.*;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.scanner;

public class Player {
    public String name;
    public double cash;
    public Farm farm;
    public Hashtable<String, Integer> plantsInventory;

    public Player() {
        while (this.name == null || this.name == "") {
            this.name = scanner.next();
        }

        this.cash = 10000.0;
        System.out.println( this.name + ", Your journey starts here, your starting balance is " + this.cash );

        System.out.println( "Choose your starting farm:" );
        List<Farm> farmsToChoose = Randomizer.getRandomFarm( 3 );


        for (int i = 1; i < farmsToChoose.size(); i++) {
            System.out.println( i + ". " + farmsToChoose.get( i ) );
        }

        do {
            try {
                this.farm = farmsToChoose.get( scanner.nextInt() );
            } catch (Exception e) {
                System.out.println( "Wrong farm index" );
            }

        } while (this.farm == null);

        this.plantsInventory = new Hashtable<>();
        plantsInventory.put( "Wheat", 0 );
        plantsInventory.put( "Oat", 0 );
        plantsInventory.put( "Potato", 0 );
        plantsInventory.put( "Apples", 0 );
        plantsInventory.put( "Tobacco", 0 );


    }

    public void getInventory() {
        System.out.println( "Your plants inventory:" );
        plantsInventory.forEach( (s, integer) ->
                System.out.println( s + ": " + integer ) );
    }


    public boolean plant() {
        System.out.println( "Which plant would you like to plant?" );
        getInventory();

        switch (scanner.next()) {
            case "Wheat":
                System.out.println( plantsInventory.get( "Wheat" ) );
                Wheat wheat = new Wheat();
                if (plantsInventory.get( "Wheat" ).intValue() > 0) {
                    if(!Wheat.weeksAllowedToPlant.contains( Main.returnWeekOfCurrentYear() ))
                    {
                        System.out.println("This is not the time of the year to plant wheat! " +
                                "Min: " + Wheat.weeksAllowedToPlant.get(0) +
                                " Max: " + Wheat.weeksAllowedToPlant.get(Wheat.weeksAllowedToPlant.size() - 1));
                        return false;
                    }
                    this.plantsInventory.merge( "Wheat", -1, Integer::sum );
                    for (int i= 0; i < this.farm.plants.length; i++) {
                        if (this.farm.plants[i] == null) {
                            this.farm.plants[i] = (FarmCropPlant)wheat;
                            System.out.println("Planted succesfuly!");
                            return true;
                        }
                        System.out.println( "No space for new plants!" );
                        return false;
                    }
                }
                System.out.println( "You don't have wheat seed to plant!" );
                return false;
            case "Oat":
                System.out.println( plantsInventory.get( "Oat" ) );
                if (plantsInventory.get( "Oat" ).intValue() > 0) {
                    Oat oat = new Oat();
                    if(!Oat.weeksAllowedToPlant.contains( Main.returnWeekOfCurrentYear() ))
                    {
                        System.out.println("This is not the time of the year to plant oat! " +
                                "Min: " + Oat.weeksAllowedToPlant.get(0) +
                                " Max: " + Oat.weeksAllowedToPlant.get(Oat.weeksAllowedToPlant.size() - 1));
                        return false;
                    }
                    this.plantsInventory.merge( "Oat", -1, Integer::sum );
                    for (FarmCropPlant plant : this.farm.plants) {
                        if (plant == null) {
                            plant = oat;
                            System.out.println("Planted succesfuly!");
                            return true;
                        }
                        System.out.println( "No space for new plants!" );
                        return false;
                    }
                }
                System.out.println( "You don't have oat seed to plant!" );
                return false;
            case "Potato":
                System.out.println( plantsInventory.get( "Potato" ) );
                if (plantsInventory.get( "Oat" ).intValue() > 0) {
                    Potato potato = new Potato();
                    if(!Potato.weeksAllowedToPlant.contains( Main.returnWeekOfCurrentYear() ))
                    {
                        System.out.println("This is not the time of the year to plant potato! " +
                                "Min: " + Potato.weeksAllowedToPlant.get(0) +
                                " Max: " + Potato.weeksAllowedToPlant.get(Potato.weeksAllowedToPlant.size() - 1));
                        return false;
                    }
                    this.plantsInventory.merge( "Potato", -1, Integer::sum );
                    for (FarmCropPlant plant : this.farm.plants) {
                        if (plant == null) {
                            plant = potato;
                            System.out.println("Planted succesfuly!");
                            return true;
                        }
                        System.out.println( "No space for new plants!" );
                        return false;
                    }
                }
                System.out.println( "You don't have potato seed to plant!" );
                return false;
            case "Apples":
                System.out.println( plantsInventory.get( "Apples" ) );
                if (plantsInventory.get( "Oat" ).intValue() > 0) {
                    AppleTree appleTree = new AppleTree();
                    if(!AppleTree.weeksAllowedToPlant.contains( Main.returnWeekOfCurrentYear() ))
                    {
                        System.out.println("This is not the time of the year to plant apple tree! " +
                                "Min: " + AppleTree.weeksAllowedToPlant.get(0) +
                                " Max: " + AppleTree.weeksAllowedToPlant.get(AppleTree.weeksAllowedToPlant.size() - 1));
                        return false;
                    }
                    this.plantsInventory.merge( "Apples", -1, Integer::sum );
                    for (FarmCropPlant plant : this.farm.plants) {
                        if (plant == null) {
                            plant = appleTree;
                            System.out.println("Planted succesfuly!");
                            return true;
                        }
                        System.out.println( "No space for new plants!" );
                        return false;
                    }
                }
                System.out.println( "You don't have apple tree's plant to plant!" );
                return false;
            case "Tobacco":
                System.out.println( plantsInventory.get( "Tobacco" ) );
                if (plantsInventory.get( "Oat" ).intValue() > 0) {
                    Tobacco tobacco = new Tobacco();
                    if(!Tobacco.weeksAllowedToPlant.contains( Main.returnWeekOfCurrentYear() ))
                    {
                        System.out.println("This is not the time of the year to plant tobacco! " +
                                "Min: " + Tobacco.weeksAllowedToPlant.get(0) +
                                " Max: " + Tobacco.weeksAllowedToPlant.get(Tobacco.weeksAllowedToPlant.size() - 1));
                        return false;
                    }
                    this.plantsInventory.merge( "Tobacco", -1, Integer::sum );
                    for (FarmCropPlant plant : this.farm.plants) {
                        if (plant == null) {
                            plant = tobacco;
                            System.out.println("Planted succesfuly!");
                            return true;
                        }
                        System.out.println( "No space for new plants!" );
                        return false;
                    }
                }
                System.out.println( "You don't have tobacoo seed to plant!" );
                return false;


            default:
                System.out.println("Wrong plant name (sadly those are case sensitive)");
                return false;

        }
    }


}
