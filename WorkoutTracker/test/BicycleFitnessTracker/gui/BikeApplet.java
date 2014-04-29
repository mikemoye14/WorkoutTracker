/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class BikeApplet extends JApplet {
    
    BikeApp bike;
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
       try {
        javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
                
                createGUI();
                bike = new BikeApp();
                
                //getContentPane().add(new JPanel());
                //bike.setVisible(true);
            }
        });
    } catch (Exception e) {
        //System.err.println("Could not start Applet.");
    }
       
       start();       
       
    }
    
    private void createGUI() {
    JLabel label = new JLabel(
                       "You are successfully running a Swing applet!");
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
    getContentPane().add(label, BorderLayout.CENTER);
}

    // TODO overwrite start(), stop() and destroy() methods
}
