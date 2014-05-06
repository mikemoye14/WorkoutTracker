/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objs;

import Simulation.SimulatedValues;
import database.DatabaseInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class SimlatedValues {
    
    private static int heartRate;
    private static double distance;
    private static double speed;
    private static double calories;
    
    private static SimulatedValues sim;
    
    public static void main(String[] args){
        
            //String userId;
            Timer timer = new Timer();
            
            //userId = request.getParameter("userId");
            User user = DatabaseInterface.getUser(Integer.parseInt("0"));
            sim = new SimulatedValues(user.getAge(), 1);
            
            //dispatcher = request.getRequestDispatcher("/mainMenu.jsp");
            //request.setAttribute("distance", sim.getDistance());
            //request.setAttribute("heartRate", sim.getHeartRate());
            //request.setAttribute("speed", sim.getSpeed());
            //request.setAttribute("calories", sim.getCalories());
            //dispatcher.forward(request, response);
            
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try 
                {                    
                    SimlatedValues.setHeartRate(sim.getHeartRate());
                    SimlatedValues.setDistance(sim.getDistance());
                    SimlatedValues.setSpeed(sim.getSpeed());
                    SimlatedValues.setCalories(sim.getCalories());
                    System.out.println(SimlatedValues.getHeartRate());
                    System.out.println(SimlatedValues.getDistance());
                    System.out.println(SimlatedValues.getSpeed());
                    System.out.println(SimlatedValues.getCalories());
                    
                    BufferedWriter writer = null;
                    try {

                        File values = new File("values.js");

                        writer = new BufferedWriter(new FileWriter(values));
                        writer.write("{\n" +
                                    "  \"heartRate\":[\"" + SimlatedValues.getHeartRate() + "\"],\n" +
                                    "  \" distance\":[\"" + SimlatedValues.getDistance() + "\"],\n" +
                                    "  \" speed\":[\"" + SimlatedValues.getSpeed() + "\"],\n" +
                                    "  \" calories\":[\"" + SimlatedValues.getCalories() + "\"]\n" +
                                    "}");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            // Close the writer regardless of what happens...
                            writer.close();
                        } catch (Exception e) {
                        }
                    }
                    sim.setNewValues();
                }
                
                catch (Exception x) 
                {
                    System.out.println(x);
                }
            }
        }, 50, 5000);
    }
    
    public static void setHeartRate(int hr){
        heartRate = hr;
    }
    public static void setDistance(double dist){
        distance = dist;        
    }
    public static void setSpeed(double sp){
        speed = sp;
    }
    public static void setCalories(double cal){
        calories = cal;
    }
    public static int getHeartRate(){
        return heartRate;
    }
    public static double getDistance(){
        return distance;
    }
    public static double getSpeed(){
        return speed;
    }
    public static double getCalories(){
        return calories;
    }
    
}
