/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package workoutServlet;

import Simulation.SimulatedValues;
import database.DatabaseInterface;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objs.*;

/**
 *
 * @author Christian
 */
public class workoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //SimulatedValues sim = new SimulatedValues(20, 1);
    SimulatedValues sim;
    RequestDispatcher dispatcher;
    
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            
            String userId;
            Timer timer = new Timer();
            
            userId = request.getParameter("userId");
            User user = DatabaseInterface.getUser(Integer.parseInt(userId));
            sim = new SimulatedValues(user.getAge(), 1);
            dispatcher = request.getRequestDispatcher("/mainMenu.jsp");
            request.setAttribute("init", "yes");
            dispatcher.forward(request, response);
            
            final String path = getServletContext().getRealPath(request.getRequestURI()).replace("build\\web\\WorkoutTracker\\workoutServlet", "web\\resources\\json\\");
            
            //System.out.print(path);
            
            timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try 
                {   
                    System.out.println("Simulating Values...");
                    SimlatedValues.setHeartRate(sim.getHeartRate());
                    SimlatedValues.setDistance(sim.getDistance());
                    SimlatedValues.setSpeed(sim.getSpeed());
                    SimlatedValues.setCalories(sim.getCalories());                    
                    WriteToFile.writeToFile(path); 
                    WriteToFile.add();                    
                    sim.setNewValues();
                    
                }
                
                catch (Exception x) 
                {
                    System.out.println(x);
                }
            }
        }, 1, 1);
            
            
        }
            
            
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
