package com.company;

import com.company.Buildings.Farm;
import com.company.Plants.FarmCropPlant;

import java.util.List;
import java.util.Scanner;

public class Player {
    public String name;
    public double cash;
    public Farm farm;
    public List<FarmCropPlant> availblePlants;

    public Player() {
        Scanner scanner = new Scanner( System.in );
        while (this.name == null || this.name == ""){ this.name = scanner.nextLine();}

        this.cash = 10000.0;
        System.out.println(this.name +", Your journey starts here, your starting balance is " + this.cash);

        System.out.println("Choose your starting farm:");
        List<Farm> farmsToChoose = Randomizer.getRandomFarm( 3 );


        for (int i = 1; i < farmsToChoose.size(); i++){
            System.out.println(i + ". " + farmsToChoose.get( i ));
        }

        do {
            try {
                this.farm = farmsToChoose.get( scanner.nextInt() );
            }
            catch (Exception e){
                System.out.println("Wrong farm index");
            }

        }while (this.farm == null);



    }
}
