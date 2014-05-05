/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulationTest;

import Simulation.SimulatedValues;

/**
 *
 * @author Calvin
 */
public class SimulationTestProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimulatedValues Sim = new SimulatedValues(20, 20);
        
        for(int i = 0; i<10; i++){
            System.out.println("Distance: " + Sim.getDistance() + " miles");
            System.out.println("Heart Rate: " + Sim.getHeartRate() + " BPM");
            System.out.println("Speed: " + Sim.getSpeed() + " mph");
            System.out.println("Calories: " + Sim.getCalories() + " calories");
            Sim.setNewValues();
        }
    }
}
