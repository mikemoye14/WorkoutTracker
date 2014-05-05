/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulationTest;

import Simulation.*;
import java.util.Random;

/**
 *
 * @author Calvin
 */
public class SimulatedValues {
    private int age;                //Age of User
    private int timeDiv;            //The time division between each get statement in seconds
        
    private int heartRate;          //the current heart rate of the user
    private int maxHeartRate;       //the maximum heart rate of the user
    private int maxTarHeartRate;    //the mas target heart rate of the user
    private int minTarHeartRate;    //the minimum target heart rate of the user
    private double speed;           //the current speed of the user
    private double distance;           //the distance the user has traveled
    private GPS gps;                //the GPS location of the user
    private double calories;        //the calories burnt by the user
    
    public SimulatedValues(int age, int timeDivision){
        this.age = age;
        timeDiv = timeDivision;
        calories = 0.0;
        distance = 0.0;   
        gps = new GPS(timeDiv);
        
        maxHeartRate = 220 - this.age;
        maxTarHeartRate = (int)(.85 * (double)maxHeartRate);
        minTarHeartRate = (int)(.5 * (double)maxHeartRate);
        heartRate = (int)(.65 * (double)maxHeartRate);
    }
    
    public SimulatedValues(String Age, String timeDivision){
        this(Integer.parseInt(Age), Integer.parseInt(timeDivision));
    }
    
    public void setAge(int age){
        this.age = age;
        maxHeartRate = 220 - this.age;
        maxTarHeartRate = (int)(.85 * (double)maxHeartRate);
        minTarHeartRate = (int)(.5 * (double)maxHeartRate);
    }
    
    public void setTimeDivision(int timeDivision){
        timeDiv = timeDivision;
    }
    
    public int getHeartRate(){
        return heartRate;
    }
    
    public double getSpeed(){
        return Math.round(speed);
    }
    
    public double getDistance(){
        return (double)Math.round(distance * 100) / 100;
    }
    
    public double getCalories(){
        return Math.round(calories);
    }
    
    public void setNewValues(){
        Random randomNum = new Random();
        double oldSpeed;
        double dis;
        double oldLat;
        double deltaLat;
        double oldLong;
        double deltaLong;
        
        oldLat = ((double)gps.getLat() + ((double)gps.getLatMin() / 60) + 
                ((double)gps.getLatSec() / 3600));
        oldLong = ((double)gps.getLong() + ((double)gps.getLongMin() / 60) + 
                ((double)gps.getLongSec() / 3600));
        
        gps.setNewValues();
        
        deltaLat = ((double)gps.getLat() + ((double)gps.getLatMin() / 60) + 
                ((double)gps.getLatSec() / 3600)) - oldLat;
        deltaLong = ((double)gps.getLong() + ((double)gps.getLongMin() / 60) + 
                ((double)gps.getLongSec() / 3600)) - oldLong;
                
        dis = Math.sqrt(Math.pow((deltaLat * 69.17), 2) + Math.pow((deltaLong * 69.17 * 
                Math.cos(deltaLat * 2 * Math.PI / 360)), 2));
               
        distance = distance + dis;
        oldSpeed = speed;
        speed = (dis / timeDiv) * 3600;
        
        if(speed > oldSpeed)
            heartRate = heartRate + Math.abs(randomNum.nextInt() % 4);
        else if (speed < oldSpeed)
            heartRate = heartRate - Math.abs(randomNum.nextInt() % 2);
        
        if(heartRate > maxTarHeartRate)
            heartRate = maxHeartRate;
        else if(heartRate < minTarHeartRate)
            heartRate = minTarHeartRate;
        
        calories = calories + (((((speed * 170 * .0053) + (.0083*speed*speed*speed)) * 7.2)/3600)*timeDiv);
    }
}
