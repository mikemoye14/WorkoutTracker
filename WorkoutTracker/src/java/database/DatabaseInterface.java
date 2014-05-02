package database;

import objs.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    private static User user;
    private int userId;

    public static void main(String[] args) {

        DatabaseInterface di = new DatabaseInterface(new User("Mike", "Mo", 25));

        di.createNewUser();
        
        di.updateHeartRate(user, "04/23/2014", "14:19", 209);
        di.updateDistance(user, "04/23/2014", "14:19", 200);
        di.updateSpeed(user, "04/23/2014", "14:19", 100);
        di.updateCalories(user, "04/23/2014", "14:19", 800);
        
        ArrayList<String> hrData;
        ArrayList<String> distanceData;
        ArrayList<String> speedData;
        ArrayList<String> calorieData;
        
        hrData = di.getHeartRates(user);
        distanceData = di.getDistances(user);
        speedData = di.getSpeeds(user);
        calorieData = di.getCalories(user);
        
        System.out.println("Date: " + hrData.get(1));
        System.out.println("Time: " + hrData.get(2));
        
        System.out.println("HeartRate: " + hrData.get(0));
        System.out.println("Distance: " + distanceData.get(0));
        System.out.println("Speed: " + speedData.get(0));
        System.out.println("Calories: " + calorieData.get(0));

        //System.out.println(System.getProperty("java.home"));
    }

    public DatabaseInterface(User u) {

        user = u;

    }
    
    public DatabaseInterface() {

    }

    private void createNewUser() {

        try {

            con = DriverManager.getConnection(url, userName, pwd);

            //create blank user
            Statement stmt;
            String query = "INSERT INTO xUsers\n"
                    + "(\n"
                    + "    fName,\n"
                    + "    lName,\n"
                    + "    age\n"
                    + ")\n"
                    + "VALUES(\n"
                    + "\n"
                    + "    'NULL',\n"
                    + "    'NULL',\n"
                    + "    " + 0 + "\n"
                    + "\n"
                    + ")";

            stmt = con.createStatement();
            stmt.executeUpdate(query);

            //getUserId of blank user
            stmt.close();
            query = "SELECT UserId\n"
                    + "FROM xUsers \n"
                    + "WHERE fName = 'NULL' \n"
                    + "AND lName = 'NULL'\n"
                    + "AND age = 0";

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                userId = rs.getInt("UserId");

            }

            user.setUserId(userId);
            //System.out.print(userId);
            //set values to blank user
            query = "UPDATE xUsers\n"
                    + "SET fName = '" + user.getFName() + "', lName = '" + user.getLName() + "', age = " + user.getAge() + "\n"
                    + "WHERE fName = 'NULL'\n"
                    + "AND  fName = 'NULL'\n"
                    + "AND age = 0";

            stmt = con.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ArrayList<String> getUsers() {
        
        ArrayList<String> users = new ArrayList();
        
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            //create blank user
            Statement stmt;
            String query = "SELECT * FROM xUsers";

            stmt = con.createStatement();
            stmt.execute(query);

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                users.add(rs.getString("fName"));
                users.add(rs.getString("lName"));
                users.add(rs.getString("Age"));

            }

            stmt.close();
            
            con.close();
            
            System.out.print(users.get(0));

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;

    }
    
    private void updateHeartRate(User user, String date, String time, int rate) {
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query = "INSERT INTO HeartRates\n"
                    + "(\n"
                    + "    userId,\n"
                    + "    hrDate,\n"
                    + "    hrTime,\n"
                    + "    heartRate\n"
                    + "\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(\n"
                    + "    " + user.getUserID() + ",\n"
                    + "    '" + date + "',\n"
                    + "    '" + time + "',\n"
                    + "    " + rate + "\n"
                    + "\n"
                    + ")";

            //System.out.print(query);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            
            con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateDistance(User user, String date, String time, int distance) {
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query = "INSERT INTO Distances\n"
                    + "(\n"
                    + "    userId,\n"
                    + "    distanceDate,\n"
                    + "    distanceTime,\n"
                    + "    distance\n"
                    + "\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(\n"
                    + "    " + user.getUserID() + ",\n"
                    + "    '" + date + "',\n"
                    + "    '" + time + "',\n"
                    + "    " + distance + "\n"
                    + "\n"
                    + ")";

            //System.out.print(query);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            
            con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateSpeed(User user, String date, String time, int speed) {
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query = "INSERT INTO Speeds\n"
                    + "(\n"
                    + "    userId,\n"
                    + "    speedDate,\n"
                    + "    speedTime,\n"
                    + "    speed\n"
                    + "\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(\n"
                    + "    " + user.getUserID() + ",\n"
                    + "    '" + date + "',\n"
                    + "    '" + time + "',\n"
                    + "    " + speed + "\n"
                    + "\n"
                    + ")";

            //System.out.print(query);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateCalories(User user, String date, String time, int calories) {
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query = "INSERT INTO Calories\n"
                    + "(\n"
                    + "    userId,\n"
                    + "    caloriesDate,\n"
                    + "    caloriesTime,\n"
                    + "    caloriesBurned\n"
                    + "\n"
                    + ")\n"
                    + "VALUES\n"
                    + "(\n"
                    + "    " + user.getUserID() + ",\n"
                    + "    '" + date + "',\n"
                    + "    '" + time + "',\n"
                    + "    " + calories + "\n"
                    + "\n"
                    + ")";

            //System.out.print(query);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<String> getHeartRates(User user) {
        
        ArrayList<String> heartRateInfo = new ArrayList();
        
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query =  "SELECT * FROM HeartRates\n" +
                            "WHERE UserId = " + user.getUserID();

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                heartRateInfo.add(rs.getString("heartRate"));
                heartRateInfo.add(rs.getString("hrDate"));
                heartRateInfo.add(rs.getString("hrTime"));

            }

            stmt.close();
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return heartRateInfo;
    }

    private ArrayList<String> getDistances(User user) {

        ArrayList<String> distanceInfo = new ArrayList();
        
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query =  "SELECT * FROM Distances\n" +
                            "WHERE UserId = " + user.getUserID();

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                distanceInfo.add(rs.getString("distance"));
                distanceInfo.add(rs.getString("distanceDate"));
                distanceInfo.add(rs.getString("distanceTime"));

            }

            stmt.close();
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return distanceInfo;
    }

    private ArrayList<String> getSpeeds(User user) {

        ArrayList<String> speedInfo = new ArrayList();
        
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query =  "SELECT * FROM Speeds\n" +
                            "WHERE UserId = " + user.getUserID();

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                speedInfo.add(rs.getString("speed"));
                speedInfo.add(rs.getString("speedDate"));
                speedInfo.add(rs.getString("speedTime"));

            }

            stmt.close();
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return speedInfo;
    }

    private ArrayList<String> getCalories(User user) {
        
        ArrayList<String> calorieInfo = new ArrayList();
        
        try {

            con = DriverManager.getConnection(url, userName, pwd);

            Statement stmt;
            String query =  "SELECT * FROM Calories\n" +
                            "WHERE UserId = " + user.getUserID();

            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                calorieInfo.add(rs.getString("caloriesBurned"));
                calorieInfo.add(rs.getString("caloriesDate"));
                calorieInfo.add(rs.getString("caloriesTime"));

            }

            stmt.close();
            
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return calorieInfo;
    }

}
