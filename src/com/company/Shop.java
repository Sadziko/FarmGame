package com.company;

import com.company.Buildings.*;


import java.util.Scanner;

import static com.company.Main.scanner;

public class Shop {
    private static String[] cropPlants = new String[]{"1. Wheat", "2. Oat", "3. Potato", "4. Apple Tree", "5. Tobacco"};
    private static final double wheatPrice = 50.0;
    private static final double oatPrice = 100.0;
    private static final double potatoPrice = 500.0;
    private static final double appleTreePrice = 500.0;
    private static final double tobaccoPrice = 5000.0;

    private static String[] farmAnimals = new String[]{"1. Dog", "2. Chicken", "3. Pig", "4. Cow", "5. Sheep"};
    private static final double dogPrice = 50.0;
    private static final double chickenPrice = 100.0;
    private static final double pigPrice = 500.0;
    private static final double cowPrice = 500.0;
    private static final double sheepPrice = 5000.0;

    private static String[] farmBuildings = new String[]{"1. Barn", "2. Clew", "3. Henhouse", "4. Sheepfold"};
    private static final double barnPrice = 1500.0;
    private static final double clewPrice = 6000.0;
    private static final double henhousePrice = 4000.0;
    private static final double sheepfoldPrice = 25000.0;

    public static boolean sellCropPlant(Player player) {
        if (player.farm.buildingsList.stream().anyMatch( type -> type instanceof Barn )) {
            Barn playersBarn = null;
            for (FarmBuilding building : player.farm.buildingsList
                    ) {
                if (building instanceof Barn)
                    playersBarn = (Barn) building;
            }
            if (playersBarn.farmPlantsStorage.values().stream().allMatch( x -> x.equals( 0 ) )) {
                System.out.println( "Your storage is empty!" );
                return false;
            }
            System.out.println( "Which plant would you like to sell?" );
            Barn.displayStorageContent(player);

            //TODO: IMPLEMENT SELLING
        }

        System.out.println( "You can't sell plants without Barn to store them!" );
        return false;
    }


    public static boolean buyCropPlant(Player player) {

            System.out.println( "Which plant would you like to buy?" );
            for (String option : cropPlants) {
                System.out.println( option );
            }

            int shopChoice = scanner.nextInt();

            switch (shopChoice) {
                case 1:
                    if (checkPrice( player.cash, wheatPrice )) {
                        player.plantsInventory.merge( "Wheat", 1, Integer::sum );
                        player.cash -= wheatPrice;
                        System.out.println( "Succesfuly bought wheat seed" );
                        return true;
                    }
                    return false;
                case 2:
                    if (checkPrice( player.cash, oatPrice )) {
                        player.plantsInventory.merge( "Oat", 1, Integer::sum );
                        player.cash -= wheatPrice;
                        System.out.println( "Succesfuly bought oat seed" );
                        return true;
                    }
                    return false;
                case 3:
                    if (checkPrice( player.cash, potatoPrice )) {
                        player.plantsInventory.merge( "Potato", 1, Integer::sum );
                        player.cash -= wheatPrice;
                        System.out.println( "Succesfuly bought potato seed" );
                        return true;
                    }
                    return false;
                case 4:
                    if (checkPrice( player.cash, appleTreePrice )) {
                        player.plantsInventory.merge( "Apples", 1, Integer::sum );
                        player.cash -= wheatPrice;
                        System.out.println( "Succesfuly bought apple tree plant" );
                        return true;
                    }
                    return false;
                case 5:
                    if (checkPrice( player.cash, tobaccoPrice )) {
                        player.plantsInventory.merge( "Tobacco", 1, Integer::sum );
                        player.cash -= wheatPrice;
                        System.out.println( "Succesfuly bought tobacco seed" );
                        return true;
                    }
                    return false;
                default:
                    System.out.println( "Incorrect number!" );
                    return false;
            }
        }



    public static boolean buyBuilding(Player player) {

        System.out.println( "Which building would you like to buy?" );
        for (String option : farmBuildings) {
            System.out.println( option );
        }

        switch (scanner.nextInt()) {
            case 1:
                if (player.farm.buildingsList.stream().anyMatch( x -> x instanceof Barn )) {
                    System.out.println( "You already have one barn!" );
                    return false;
                }

                if (checkPrice( player.cash, barnPrice )) {
                    player.farm.buildingsList.add( new Barn() );
                    player.cash -= barnPrice;
                    System.out.println( "Succesfuly bought barn" );
                    return true;
                }
                displayNotEnoughMoney();
                return false;
            case 2:
                if (player.farm.buildingsList.stream().anyMatch( x -> x instanceof Clew )) {
                    System.out.println( "You already have one clew!" );
                    return false;
                }

                if (checkPrice( player.cash, clewPrice )) {
                    player.farm.buildingsList.add( new Clew() );
                    player.cash -= clewPrice;
                    System.out.println( "Succesfuly bought clew" );
                    return true;
                }
                displayNotEnoughMoney();
                return false;
            case 3:
                if (player.farm.buildingsList.stream().anyMatch( x -> x instanceof Henhouse )) {
                    System.out.println( "You already have one henhouse!" );
                    return false;
                }
                if (checkPrice( player.cash, henhousePrice )) {
                    player.farm.buildingsList.add( new Henhouse() );
                    player.cash -= henhousePrice;
                    System.out.println( "Succesfuly bought henhouse" );
                    return true;
                }
                displayNotEnoughMoney();
                return false;
            case 4:
                if (player.farm.buildingsList.stream().anyMatch( x -> x instanceof Sheepfold )) {
                    System.out.println( "You already have one sheepfold!" );
                    return false;
                }

                if (checkPrice( player.cash, sheepfoldPrice )) {
                    player.farm.buildingsList.add( new Sheepfold() );
                    player.cash -= sheepfoldPrice;
                    System.out.println( "Succesfuly bought sheepfold" );
                    return true;
                }
                displayNotEnoughMoney();
                return false;
            default:
                System.out.println( "Incorrect number!" );
                return false;
        }
    }

    public static boolean sellBuilding(Player player) {

        System.out.println( "Which building would you like to sell?" );
        for (String option : farmBuildings) {
            System.out.println( option );
        }

        switch (scanner.nextInt()) {
            case 1:
                FarmBuilding barnToSell = player.farm.buildingsList.stream()
                        .filter( x -> x.getClass().getSimpleName().equals( "Barn" ) )
                        .findFirst()
                        .orElse( null );

                if (barnToSell == null) {
                    System.out.println( "You don't have a barn to sell!" );
                    return false;
                }

                player.cash += barnToSell.value;
                player.farm.buildingsList.remove( barnToSell );
                System.out.println("Succesfuly sold barn for " + barnToSell.value);
                return true;
            case 2:

                FarmBuilding clewToSell = player.farm.buildingsList.stream()
                        .filter( x -> x.getClass().getSimpleName().equals( "Clew" ) )
                        .findFirst()
                        .orElse( null );

                if (clewToSell == null) {
                    System.out.println( "You don't have a clew to sell!" );
                    return false;
                }

                player.cash += clewToSell.value;
                player.farm.buildingsList.remove( clewToSell );
                System.out.println("Succesfuly sold clew for " + clewToSell.value);
                return true;
            case 3:
                FarmBuilding henhouseToSell = player.farm.buildingsList.stream()
                        .filter( x -> x.getClass().getSimpleName().equals( "Henhouse" ) )
                        .findFirst()
                        .orElse( null );

                if (henhouseToSell == null) {
                    System.out.println( "You don't have a henhouse to sell!" );
                    return false;
                }

                player.cash += henhouseToSell.value;
                player.farm.buildingsList.remove( henhouseToSell );

                System.out.println("Succesfuly sold henhouse for " + henhouseToSell.value);
                return true;

            case 4:
                FarmBuilding sheepfoldToSell = player.farm.buildingsList.stream()
                        .filter( x -> x.getClass().getSimpleName().equals( "Sheepfold" ) )
                        .findFirst()
                        .orElse( null );

                if (sheepfoldToSell == null) {
                    System.out.println( "You don't have a sheepfold to sell!" );
                    return false;
                }

                player.cash += sheepfoldToSell.value;
                player.farm.buildingsList.remove( sheepfoldToSell );
                System.out.println("Succesfuly sold sheepfold for " + sheepfoldToSell.value);
                return true;
            default:
                System.out.println( "Incorrect number!" );
                return false;
        }
    }

    private static void displayNotEnoughMoney() {
        System.out.println( "Not enough money" );
    }

    private static boolean checkPrice(double playerMoney, double price) {
        if (playerMoney >= price)
            return true;
        return false;
    }

}
