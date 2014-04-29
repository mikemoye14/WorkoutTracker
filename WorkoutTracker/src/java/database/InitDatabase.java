
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * InitDatabase.java 
 * Purpose: Initializes DB
 *
 * @author Mike Moye <mikemoye14@gamil.com>
 * @version 1.0 29 April 2014
 *
 */
public class InitDatabase {

    private static final String url = "jdbc:derby://localhost:1527/WorkoutTracker";
    private static final String userName = "mike";
    private static final String pwd = "mike";
    private static Connection con;

    public static void main(String[] args) {
        try {
            
            String query;
            Statement stmt;
            
            System.out.println("Connecting to DB...");
            
            con = DriverManager.getConnection(url, userName, pwd);
            
            System.out.println("Connected.");
            System.out.println("Delecting Tables...");
            
            query = "DROP TABLE HeartRates\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Distances\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Speeds\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Calories\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE xUsers\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Complete.");
            System.out.println("Disconnecting from DB...");
            con.close();
            System.out.println("DB connection closed.");
                    
        } catch (SQLException ex) {
           //Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            try {
                
                String query;
                Statement stmt;
                
                System.out.println("Reconnecting to DB...");
                
                con = DriverManager.getConnection(url, userName, pwd);
                
                System.out.println("Connected.");
                
                System.out.println("Creating Tables...");
                
                //create user table
                
                query = "CREATE TABLE xUsers\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                        "    fName VARCHAR(25) NOT NULL, \n" +
                        "    lName VARCHAR(50) NOT NULL,\n" +
                        "    age int NOT NULL,    \n" +
                        "\n" +
                        "    CONSTRAINT pk_Users PRIMARY KEY (UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create heartRate table
                
                query = "CREATE TABLE HeartRates\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    hrDate DATE,\n" +
                        "    hrTime TIME,\n" +
                        "    heartRate INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_HeartRates PRIMARY KEY (UserId, hrDate, hrTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create distance table
                
                query = "CREATE TABLE Distances\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    distanceDate DATE,\n" +
                        "    distanceTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Distances PRIMARY KEY (UserId, distanceDate, distanceTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create speed table
                
                query = "CREATE TABLE Speeds\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    speedDate DATE,\n" +
                        "    speedTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Speeds PRIMARY KEY (UserId, speedDate, speedTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create calories table
                
                query = "CREATE TABLE Calories\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    caloriesDate DATE,\n" +
                        "    caloriesTime TIME,\n" +
                        "    caloriesBurned INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Calories PRIMARY KEY (UserId, caloriesDate, caloriestime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                System.out.println("Tables Created.");

                con.close();
                
                System.out.println("Closing DB Connection.");

                } catch (SQLException ex) {
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }
        
    public static void initDB(){
         try {
            
            String query;
            Statement stmt;
            
            System.out.println("Connecting to DB...");
            
            con = DriverManager.getConnection(url, userName, pwd);
            
            System.out.println("Connected.");
            System.out.println("Delecting Tables...");
            
            query = "DROP TABLE HeartRates\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Distances\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Speeds\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Calories\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE xUsers\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Complete.");
            System.out.println("Disconnecting from DB...");
            con.close();
            System.out.println("DB connection closed.");
                    
        } catch (SQLException ex) {
           //Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            try {
                
                String query;
                Statement stmt;
                
                System.out.println("Reconnecting to DB...");
                
                con = DriverManager.getConnection(url, userName, pwd);
                
                System.out.println("Connected.");
                
                System.out.println("Creating Tables...");
                
                //create user table
                
                query = "CREATE TABLE xUsers\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                        "    fName VARCHAR(25) NOT NULL, \n" +
                        "    lName VARCHAR(50) NOT NULL,\n" +
                        "    age int NOT NULL,    \n" +
                        "\n" +
                        "    CONSTRAINT pk_Users PRIMARY KEY (UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create heartRate table
                
                query = "CREATE TABLE HeartRates\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    hrDate DATE,\n" +
                        "    hrTime TIME,\n" +
                        "    heartRate INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_HeartRates PRIMARY KEY (UserId, hrDate, hrTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create distance table
                
                query = "CREATE TABLE Distances\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    distanceDate DATE,\n" +
                        "    distanceTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Distances PRIMARY KEY (UserId, distanceDate, distanceTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create speed table
                
                query = "CREATE TABLE Speeds\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    speedDate DATE,\n" +
                        "    speedTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Speeds PRIMARY KEY (UserId, speedDate, speedTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create calories table
                
                query = "CREATE TABLE Calories\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    caloriesDate DATE,\n" +
                        "    caloriesTime TIME,\n" +
                        "    caloriesBurned INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Calories PRIMARY KEY (UserId, caloriesDate, caloriestime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUsers(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                System.out.println("Tables Created.");

                con.close();
                
                System.out.println("Closing DB Connection.");

                } catch (SQLException ex) {
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }

}
