<%-- 
    Document   : ViewWorkouts
    Created on : Apr 30, 2014, 10:44:47 AM
    Author     : Scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            #heartRate{
                background-image:url("./resources/images/heartRateCircle.png");
                background-repeat: no-repeat;
                width: 250px;
                height: 250px;
            }
            #menuButton{
                background-image:url("./resources/images/menuButton.png");
                background-repeat: no-repeat;
                background-color: black;
                margin-bottom: 0px;
                padding-bottom: 0px;
                height: 30px;
                width: 100px;
                float: left;
                position: relative;
            }
            #homeButton{
                background-image:url("./resources/images/homeButton.png");
                background-repeat: no-repeat;
                background-color: black;
                margin-bottom: 0px;
                padding-bottom: 0px;
                height: 30px;
                width: 100px;
                float: left;
                position: relative;
                
            }
            #backButton{
                background-image:url("./resources/images/backButton.png");
                background-repeat: no-repeat;
                background-color: black;
                margin-bottom: 0px;
                padding-bottom: 0px;
                height: 30px;
                width: 100px;
                float: left;
                position: relative;
            }
        </style>
        <title>View Workout</title>
    </head>
    <body>
        
        <table style="margin: auto; border: 5px solid black; margin-top: 50px; background-color: white; border-radius: 10px; padding-bottom: 0px;">
            <tr>
                <td></td>
                <td style="text-align: center; background-color: white;">
                    <img src="./resources/images/bike.png" alt="bike" />
                </td>
                <td></td>                
            </tr>
            <tr>
                <td colspan="3" style="background-color: white; text-align: center;">
                    <div id="heartRate" style="text-align: center; vertical-align: middle; margin: auto;">
                        <table style="margin: auto; border: 1px solid red; height: 50px;">
                            <tr>
                                <td>
                                </td>
                            </tr>
                        </table>
                        <table style="margin: auto; border: 1px solid red; height: 50px; background-color: white;">
                            <tr>
                                <td id="bpm">
                                   72 
                                </td>
                                <td>
                                   BPM 
                                </td>
                            </tr>
                        </table>
                        <table style="margin: auto; border: 1px solid red; margin-top: 50px; height: 50px; background-color: white;">
                            <tr>
                                <td id="thr"> thr </td>
                                <td> - </td>
                                <td id="mhr"> mhr </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr style="margin-top: 0;">
                <td style="background-color: white; padding: 5px;">
                    <div style="background-color: green; border: 1px solid black; text-align: center; margin-left: 20px; padding: 10px; width: 50px;"> START </div>
                </td>
                <td style="background-color: white; margin: 0;"></td>
                <td style=" background-color: white; padding: 5px;">
                    <div style="background-color: red; border: 1px solid black; text-align: center; margin-right: 20px; padding: 10px; width: 50px;"> STOP  </div>
                </td>
            </tr>
            <tr style="background-color: black; margin-bottom: 0px; padding-bottom: 0px;">
                <td colspan="3" style="background-color: black; margin-bottom: 0px; padding-bottom: 0px;">
                    <div id="menuButton"></div>
                    <div id="homeButton"></div>
                    <div id="backButton"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
