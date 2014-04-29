package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mike Moye <mikemoye14@gamil.com>
 */
public class DatabaseInterface {
    
    //private User user
    private static String url = "jdbc:derby://localhost:1527/WorkoutTracker";
    private static String userName = "mike";
    private static String pwd = "mike";
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
        
        String query = "INSERT INTO User";        
        
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
    
    /*
    private void connectToDB(){
        //String className=null;
        String url=null;
        String user = null;
        String password = null;
        
        try
        {
            //ResourceBundle resources;
            //InputStream in = null;
            //ResourceBundle newResources;

            //in = ClassLoader.getSystemResourceAsStream("db.properties");

            //resources = new PropertyResourceBundle(in);

            //in.close();

            //className = resources.getString("jdbc.driver");
            //url = resources.getString("jdbc.url");
            //System.out.println(url);
            //user = resources.getString("jdbc.user");
            //password = resources.getString("jdbc.password");
        }
        catch (Exception exp)
        {
            //System.out.println("Couldn't load resources." + exp);
            //System.exit(-1);
        }
        
        try
        {
            //Class.forName(className);
        }
        catch (Exception e) 
        {
            //System.out.println("Failed to load  driver.");
            //return;
        }
        
        try
        {
                  
                
            //Statement stmt = con.createStatement();

            //stmt.execute("SELECT * FROM USERINFO");       
        
            //stmt.close();
        
            con.close();
        }
        catch (Exception e) 
        {
            //System.out.println(e);
        }
    }
    */
    
}
