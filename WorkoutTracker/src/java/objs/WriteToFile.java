/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class WriteToFile {
    
    private static int counter = 0;
    
    public static void add(){
        counter++;
    }

    public static void main(String[] args) {

    }

    public static void writeToFile(String path) {

        try {
            
            WriteToFile x = new WriteToFile();
            File file = new File("values.js");
            //System.out.println(file.getAbsolutePath());
            
            File xFile = new File(file.getAbsolutePath().replace("values.js", "") + "values_" + counter + ".js");
            
            BufferedWriter writer = null;
            try {
                
                writer = new BufferedWriter(new FileWriter(xFile));
                writer.write("getValues({\n"
                        + "    \"values\": [\n"
                        + "        {\n"
                        + "            \"heartRate\": \"" + SimlatedValues.getHeartRate() + "\",\n"
                        + "            \"distance\": \"" + SimlatedValues.getDistance() + "\",\n"
                        + "            \"speed\": \"" + SimlatedValues.getSpeed() + "\",\n"
                        + "            \"calories\": \"" + SimlatedValues.getCalories() + "\"\n"
                        + "        }\n"
                        + "    ]\n"
                        + "} );");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close the writer regardless of what happens...
                    writer.close();
                } catch (Exception e) {
                }
            }
            try{
            CopyFile.copyFile(xFile, new File(path + "values_" + counter + ".js"));
            }catch(IOException ex){
                //CopyFile.copyFile(xFile, new File(path));
            }finally{
               //CopyFile.copyFile(xFile, new File(path)); 
            }
            
        } catch (Exception ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
