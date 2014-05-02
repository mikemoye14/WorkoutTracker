package objs;

/**
 * User.java 
 * Purpose: Creates a User
 *
 * @author Mike Moye <mikemoye14@gamil.com>
 * @version 1.0 29 April 2014
 *
 */
public class User {

    private String fName = "";
    private String lName = "";
    private int age = 0;

    private int userID = 0;

    /**
     * Default Constructor
     */
    public User() {
    }

    public User(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    
    public User(int id, String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.userID = id;
    }

    /**
     * Method setFName sets first name
     *
     * @param name User's name
     */
    public void setFName(String name) {
        this.fName = name;
    }

    /**
     * Method setLName sets last name
     *
     * @param name User's name
     */
    public void setLName(String name) {
        this.lName = name;
    }

    /**
     * Method setAge sets age
     *
     * @param age User's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void setUserId(int id) {
        this.userID = id;
    }

    /**
     * Method getFName gets first name
     *
     * @return fName User's first name
     */
    public String getFName() {
        return this.fName;
    }

    /**
     * Method getLName gets user's last name
     *
     * @return lName User's last Name
     */
    public String getLName() {
        return this.lName;
    }

    /**
     * Method getAge gets user's age
     *
     * @return age User's age
     */
    public int getAge() {
        return this.age;
    }

    public int getUserID() {
        return this.userID;
    }

}
