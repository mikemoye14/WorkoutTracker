/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class CurrentUser {
    
    private static int userId = 0;
    
    public static void setId(int id){
        userId = id;
    }
    
    public static int getUserId(){
        return userId;
    }
    
}
