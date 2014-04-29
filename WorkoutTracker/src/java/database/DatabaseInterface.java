package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        di.updateHeartRate(user, 209, "04/23/2014", "14:19");

        di.updateDistance(user, "04/23/2014", "14:19", 100);

        di.updateSpeed(user, "04/23/2014", "14:19", 100);

        di.updateCalories(user, "04/23/2014", "14:19", 100);

        //System.out.println(System.getProperty("java.home"));
    }

    public DatabaseInterface(User u) {

        user = u;

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

    private void updateHeartRate(User user, int rate, String date, String time) {
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

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private float getHeartRate(User user) {

        float heartRate = 0;

        return heartRate;
    }

    private float getDistance(User user) {

        float distance = 0;

        return distance;
    }

    private float getSpeed(User user) {

        float speed = 0;

        return speed;
    }

    private float getCalories(User user) {
        float calories = 0;

        return calories;
    }

}
