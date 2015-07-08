/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Design a parking lot using object oriented design
// The statement never states what kind of parking lot...is it a parking lot with many floors?
// Is a parking lot that you have to pay for (toll)

// This parking lot will have three levels with limited spots, 
// specific vehicle implementations/sizes

package ObjectOrientedDesign;
/**
 *
 * @author marcsantiago
 */

public class ParkingLot extends ParkingLevels{
    private final int [][] levels = getLevels();
    private final int carSpace = 1;
    private final int motoSpace = 1;
    private final int busSpace = 4;
    
    private final Car car;
    private final Motocycle moto;
    private final Bus bus;
    
    
    
    public ParkingLot(){
        car = new Car(carSpace);
        moto = new Motocycle(motoSpace);
        bus = new Bus(busSpace);
    }
       
    
    private String findEmptySpot(int spaceNeeded){
        spaceNeeded = spaceNeeded - 1;
        for (int i = 0; i < getNumberOfLevels(); i++) {
            for (int j = 0; j < getSpacesPerLevel(); j++) {
                if(j + spaceNeeded < getSpacesPerLevel()) {
                    if(levels[i][j] == 0 && levels[i][j + spaceNeeded] == 0){
                        return Integer.toString(i) + " " + Integer.toString(j);
                    }
                }
            }
        }
        return null;
    }
    
    public void addCar(){
        String [] indexValues = new String[2];
        int level;
        int space;
        try{
            indexValues = findEmptySpot(car.getSpaceNeeded()).split(" ");
        }
        catch(Exception e){
            System.out.println("Not enough spaces for vehicle");
        }
        
        level = Integer.valueOf(indexValues[0]);
        space = Integer.valueOf(indexValues[1]);
        
        for (int i = 0; i < moto.getSpaceNeeded(); i++) {
            levels[level][space + i] = 1;
        }
                    
    }
    
    public void addMotocycle(){
        String [] indexValues = new String[2];
        int level;
        int space;
        try{
            indexValues = findEmptySpot(moto.getSpaceNeeded()).split(" ");
        }
        catch(Exception e){
            System.out.println("Not enough spaces for vehicle");
        }
        
        level = Integer.valueOf(indexValues[0]);
        space = Integer.valueOf(indexValues[1]);
        
        for (int i = 0; i < moto.getSpaceNeeded(); i++) {
            levels[level][space + i] = 1;
        }
    }
    
    public void addBus(){
        String [] indexValues = new String[2];
        int level;
        int space;
        try{
            indexValues = findEmptySpot(bus.getSpaceNeeded()).split(" ");
        }
        catch(Exception e){
            System.out.println("Not enough spaces for vehicle");
        }
        
        level = Integer.valueOf(indexValues[0]);
        space = Integer.valueOf(indexValues[1]);
        
        for (int i = 0; i < bus.getSpaceNeeded(); i++) {
            levels[level][space + i] = 1;
        }
        
    }
}

class ParkingLevels{    
    private final int spacesPerLevel = 10;
    private final int numberOfLevels = 3;
    private final int [][] levels = new int[numberOfLevels][spacesPerLevel];
    
    public ParkingLevels(){
        
    }

    public int getNumberOfLevels() {
        return numberOfLevels;
    }

    public int getSpacesPerLevel() {
        return spacesPerLevel;
    }

    public int[][] getLevels() {
        return levels;
    }
    
    public boolean isLevelEmpty(int level){
        return levels[level - 1][0] == 0;
    }
    
    public boolean isLevelFull(int level){
        int spacesUsed = 0;
        for (int i = 0; i < spacesPerLevel; i++) {
            if(levels[level - 1][i] == 1){
                spacesUsed++;
            }
        }
        return spacesUsed == spacesPerLevel;
    } 
}

class Vehicle{
    private final int spacesUsed;
    public Vehicle(int spacesUsed){
        this.spacesUsed = spacesUsed;
    }
    
    public int getSpaceNeeded(){
        return spacesUsed;
    }
}

class Car extends Vehicle{
    public Car(int spacesUsed) {
        super(spacesUsed);
    }
}

class Bus extends Vehicle{
    public Bus(int spacesUsed){
        super(spacesUsed);
    }
}

class Motocycle extends Vehicle{
    public Motocycle(int spacesUsed){
        super(spacesUsed);
    }
}