/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class InitDatabase {

    private static String url = "jdbc:derby://localhost:1527/WorkoutTracker";
    private static String userName = "mike";
    private static String pwd = "mike";
    private static Connection con;

    public static void main(String[] args) {
        try {
            
            String query;
            Statement stmt;
            
            System.out.println("Connecting to DB...");
            
            con = DriverManager.getConnection(url, userName, pwd);
            
            System.out.println("Connected.");
            System.out.println("Delecting Tables...");
            
            query = "DROP TABLE HeartRate\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Distance\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Speed\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Calories\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE xUser\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Complete.");
            System.out.println("Disconnecting from DB...");
            con.close();
            System.out.println("DB connection closed.");
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            try {
                
                String query;
                Statement stmt;
                
                System.out.println("Reconnecting to DB...");
                
                con = DriverManager.getConnection(url, userName, pwd);
                
                System.out.println("Connected.");
                
                System.out.println("Creating Tables...");
                
                //create user table
                
                query = "CREATE TABLE xUser\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                        "    fName VARCHAR(25) NOT NULL, \n" +
                        "    lName VARCHAR(50) NOT NULL,\n" +
                        "    age int NOT NULL,    \n" +
                        "\n" +
                        "    CONSTRAINT pk_User PRIMARY KEY (UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create heartRate table
                
                query = "CREATE TABLE HeartRate\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    hrDate DATE,\n" +
                        "    hrTime TIME,\n" +
                        "    heartRate INT,    \n" +
                        "    maxHeartRate INT,\n" +
                        "    targetHeartRate INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_HeartRate PRIMARY KEY (UserId, hrDate, hrTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create distance table
                
                query = "CREATE TABLE Distance\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    distanceDate DATE,\n" +
                        "    distanceTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Distance PRIMARY KEY (UserId, distanceDate, distanceTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create speed table
                
                query = "CREATE TABLE Speed\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    speedDate DATE,\n" +
                        "    speedTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Speed PRIMARY KEY (UserId, speedDate, speedTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
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
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
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
            
            query = "DROP TABLE HeartRate\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Distance\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Speed\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE Calories\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();

            query = "DROP TABLE xUser\n";
            stmt = con.createStatement();
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Complete.");
            System.out.println("Disconnecting from DB...");
            con.close();
            System.out.println("DB connection closed.");
                    
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
            try {
                
                String query;
                Statement stmt;
                
                System.out.println("Reconnecting to DB...");
                
                con = DriverManager.getConnection(url, userName, pwd);
                
                System.out.println("Connected.");
                
                System.out.println("Creating Tables...");
                
                //create user table
                
                query = "CREATE TABLE xUser\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT NOT NULL GENERATED ALWAYS AS IDENTITY,\n" +
                        "    fName VARCHAR(25) NOT NULL, \n" +
                        "    lName VARCHAR(50) NOT NULL,\n" +
                        "    age int NOT NULL,    \n" +
                        "\n" +
                        "    CONSTRAINT pk_User PRIMARY KEY (UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create heartRate table
                
                query = "CREATE TABLE HeartRate\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    hrDate DATE,\n" +
                        "    hrTime TIME,\n" +
                        "    heartRate INT,    \n" +
                        "    maxHeartRate INT,\n" +
                        "    targetHeartRate INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_HeartRate PRIMARY KEY (UserId, hrDate, hrTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create distance table
                
                query = "CREATE TABLE Distance\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    distanceDate DATE,\n" +
                        "    distanceTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Distance PRIMARY KEY (UserId, distanceDate, distanceTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                //create speed table
                
                query = "CREATE TABLE Speed\n" +
                        "(\n" +
                        "\n" +
                        "    UserId INT,\n" +
                        "    speedDate DATE,\n" +
                        "    speedTime TIME,\n" +
                        "    distance INT,\n" +
                        "    \n" +
                        "    CONSTRAINT pk_Speed PRIMARY KEY (UserId, speedDate, speedTime),\n" +
                        "\n" +
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
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
                        "    FOREIGN KEY (UserId) REFERENCES xUser(UserId)\n" +
                        "\n" +
                        ")";
                        
                stmt = con.createStatement();
                stmt.execute(query);
                stmt.close();
                
                System.out.println("Tables Created.");
                System.out.println("Closing DB Connection.");
                con.close();
                System.out.println("Connection closed.");                

                } catch (SQLException ex) {
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }
}
