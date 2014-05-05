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
public class GPS {
    private int timeDivision;
    
    private int latitude = 0;
    private int latMin = 0;
    private double latSec = 0;
    private char latDir;
    
    private int longitude = 0;
    private int longMin = 0;
    private double longSec = 0;
    private char longDir;
       
    public GPS(int timeDiv){
        Random randomNum = new Random();
        int temp;
        timeDivision = timeDiv; 
        latitude = 50;
        latMin = Math.abs(randomNum.nextInt() % 61);
        latSec = Math.abs(randomNum.nextInt() % 61);
        temp = Math.abs(randomNum.nextInt() % 2);
        if(temp == 1)
            latDir = 'N';
        else
            latDir = 'S';
        
        longitude = 50;
        longMin = Math.abs(randomNum.nextInt() % 61);
        longSec = Math.abs(randomNum.nextInt() % 61);
        temp = Math.abs(randomNum.nextInt() % 2);
        if(temp == 1)
            latDir = 'E';
        else
            latDir = 'W';
    }
    
    //returns latitude
    public int getLat(){
        return latitude;
    }
    
    //returns latitude minutes
    public int getLatMin(){
        return latMin;
    }
    
    //returns latitude seconds
    public double getLatSec(){
        return latSec;
    }
    
    //returns latitude Direction
    public char getLatDir(){
        return latDir;
    }
    
    //returns longitude
    public int getLong(){
        return longitude;
    }
    
    //returns longitude minutes
    public int getLongMin(){
        return longMin;
    }
    
    //returns longitude seconds
    public double getLongSec(){
        return longSec;
    }
    
    //returns longitude Direction
    public char getLongDir(){
        return longDir;
    }
    
    //generates new values of latitude and longitude
    public void setNewValues(){
        Random randomNum = new Random();
        latSec = latSec + (Math.abs(randomNum.nextInt() % 15) * .01445706 * timeDivision);
        longSec = longSec + ((Math.abs(randomNum.nextInt() % 15) * .01445706 * timeDivision) * 
                Math.cos((latitude + (latMin / 60) + (latSec / 3600)) * 2 * Math.PI / 360));
        
        if(latSec > 59){
            latMin++;
            latSec-=60;
        }
        if(longSec > 59){
            longMin++;
            longSec-=60;
        }
        if(latMin > 59){
            latitude++;
            latMin-=60;
        }
        if(longMin > 59){
            longitude++;
            longMin-=60;
        }
    }
}
