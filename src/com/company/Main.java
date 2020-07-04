package com.company;

import com.company.Animals.Sheep;
import com.company.Buildings.Barn;
import com.company.Buildings.FarmBuilding;

import java.util.Scanner;

public class Main {
    static Scanner menuScanner = new Scanner( System.in );
    private static int choosenOptionMainMenu;
    static int weeksCounter = 1;
    static boolean increaseTurn = false;

    public static void main(String[] args) {
        System.out.println( "Welcome to the farm game! Please type in your name:" );
        Player player = new Player();


        do {
            if (increaseTurn)
                newTurn();
            displayStartingTurnInfo( player );
            displayMainMenu();
            choosenOptionMainMenu = menuScanner.nextInt();


            switch (choosenOptionMainMenu) {
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

                    break;
                case 10:

                    break;
                case 11:
                    player.farm.displayFarmCrops();
                    break;
                case 12:
                    Barn.displayStorageContent( player );
                    break;
                default:
                    System.out.println( "Incorrect number!" );
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

    private static void newTurn() {
        weeksCounter++;
        increaseTurn = false;
    }

    private static void displayMainMenu() {
        String[] menuOptions = new String[]{"1. Buy some ground", "2. Sell some ground", "3. Buy plants",
                "4. Sell plants", "5. Buy animals", "6. Sell animals", "7. Buy building", "8. Sell building",
                "9. Check your inventory", "10. Animals info", "11. Plants info", "12. Storage content", "0. Exit"};

        for (String option : menuOptions) {
            System.out.println( option );
        }
        System.out.println( "Choose your action:" );
    }
}
