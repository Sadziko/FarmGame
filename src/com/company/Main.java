package com.company;

import com.company.Buildings.Barn;
import com.company.Plants.FarmCropPlant;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner( System.in );
    static int weeksCounter = 1;
    static boolean increaseTurn = false;

    public static void main(String[] args) {
        System.out.println( "Welcome to the farm game! Please type in your name:" );
        Player player = new Player();
        int choosenOptionMainMenu;

        do {
            if (increaseTurn)
                newTurn( player );
            displayStartingTurnInfo( player );
            displayMainMenu();

            increaseTurn = false;
            choosenOptionMainMenu = scanner.nextInt();


            switch (choosenOptionMainMenu) {
                case 0:

                case 1:
                    if (player.farm.extendFarmSize( player ))
                        setIncreaseTurnTrue();
                    break;
                case 2:
                    if (player.farm.decreaseFarmSize( player ))
                        setIncreaseTurnTrue();
                    break;
                case 3:
                    if (Shop.buyCropPlant( player ))
                        setIncreaseTurnTrue();
                    break;
                case 4:
                    if (Shop.sellCropPlant( player ))
                        setIncreaseTurnTrue();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    if (Shop.buyBuilding( player ))
                        setIncreaseTurnTrue();
                    break;
                case 8:
                    if (Shop.sellBuilding( player ))
                        setIncreaseTurnTrue();
                    break;
                case 9:
                    player.getInventory();
                    break;
                case 10:

                    break;
                case 11:
                    player.farm.displayFarmCrops();
                    break;
                case 12:
                    Barn.displayStorageContent( player );
                    break;
                case 13:
                    if (player.plant())
                        setIncreaseTurnTrue();
                    break;
                default:
                    System.out.println( "Incorrect number!" );
                    setIncreaseTurnTrue();
                    break;
            }
        } while (choosenOptionMainMenu != 0);


    }

    private static void setIncreaseTurnTrue() {
        increaseTurn = true;
    }

    private static void displayStartingTurnInfo(Player player) {
        System.out.println( "This is week number " + weeksCounter );
        System.out.println( "Current balance account is " + player.cash );
    }

    private static void newTurn(Player player) {
        weeksCounter++;
        increaseTurn = false;
        for (FarmCropPlant plant : player.farm.plants) {
            if (plant != null)
                plant.increase();
        }
    }

    private static void displayMainMenu() {
        String[] menuOptions = new String[]{"1. Buy some ground", "2. Sell some ground", "3. Buy plants",
                "4. Sell plants", "5. Buy animals", "6. Sell animals", "7. Buy building", "8. Sell building",
                "9. Check your inventory", "10. Animals info", "11. Plants info", "12. Storage content", "13. Plant seed", "14. Harvest plant", "0. Exit"};

        for (String option : menuOptions) {
            System.out.println( option );
        }
        System.out.println( "Choose your action:" );
    }

    public static int returnWeekOfCurrentYear(){
        int weekToReturn = weeksCounter;
        while (weeksCounter > 52)
            weekToReturn =- 52;
        return weekToReturn;
    }
}
