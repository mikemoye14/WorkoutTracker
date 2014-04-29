package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * DatabaseInterface.java 
 * Purpose: interface between app and DB
 *
 * @author Mike Moye <mikemoye14@gamil.com>
 * @version 1.0 29 April 2014
 *
 */
public class DatabaseInterface {
    
    //private User user
    private static final String url = "jdbc:derby://localhost:1527/WorkoutTracker";
    private static final String userName = "mike";
    private static final String pwd = "mike";
    private static Connection con;
    
    public static void main(String[] args){
        
        try { 
            con = DriverManager.getConnection(url, userName, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println(System.getProperty("java.home"));
    }
    
    public DatabaseInterface(){
        
    }    
    
    public DatabaseInterface(String user){
        try { 
            con = DriverManager.getConnection(url, userName, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void createNewUser(String user){
        
        String query =  "INSERT INTO xUser\n" +
                        "(\n" +
                        "    fName,\n" +
                        "    lName,\n" +
                        "    age\n" +
                        ")\n" +
                        "VALUES(\n" +
                        "\n" +
                        "    'Mike',\n" +
                        "    'M',\n" +
                        "    25\n" +
                        "\n" +
                        ")";        
        
        //con.createStatement();
    }
    
    private void updateDB(String userId){
        
    }
    
    private float getHeartRate(String userId){
        
        float heartRate = 0;
        
        return heartRate;
    }
    
    private float getDistance(String userId){
        
        float distance = 0;
        
        return distance;
    }
    
    private float getSpeed(String userId){
        
        float speed = 0;
        
        return speed;
    }
    
    private float getCalories(String userId){
        float calories = 0;
        
        return calories;
    } 
    
}
