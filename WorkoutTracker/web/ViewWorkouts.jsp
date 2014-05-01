<%-- 
    Document   : ViewWorkouts
    Created on : Apr 30, 2014, 10:44:47 AM
    Author     : Scott
--%>

<%@page import="objs.User" contentType="text/html" pageEncoding="UTF-8"%>

<%
    
    User xUser = (User)request.getAttribute("user");
    
    User user = new User("Mike", "M", 25);
    
    int age = user.getAge();
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
            #heartRate{
                background-image:url("./resources/images/heartRateCircle.png");
                background-repeat: no-repeat;
                background-position:center;
                width: 250px;
                height: 300px;
            }
            #menuButton{
                background-image:url("./resources/images/menuButton.png");
                background-repeat: no-repeat;
                background-color: black;
                background-position:center; 
                margin-bottom: 0px;
                padding-bottom: 0px;
                height: 30px;
                width: 33%;
                float: left;
                position: relative;
            }
            #homeButton{
                background-image:url("./resources/images/homeButton.png");
                background-repeat: no-repeat;
                background-color: black;
                background-position:center; 
                margin-bottom: 0px;
                padding-bottom: 0px;
                height: 30px;
                width: 33%;
                float: left;
                position: relative;
                
            }
            #backButton{
                background-image:url("./resources/images/backButton.png");
                background-repeat: no-repeat;
                background-color: black;
                background-position:center; 
                margin-bottom: 0px;
                padding-bottom: 0px;
                height: 30px;
                width: 33%;
                float: left;
                position: relative;
            }
        </style>
        <script src="./resources/js/jquery-latest.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                
                var age = <%= age %>; //get age
                var mhr = 220 - age; //calc target heart rate
                var thr = parseInt(mhr*.5); //calc max heart rate
                
                $('#thr').html(thr);
                $('#mhr').html(mhr);
                
                $('#startButton').click(function(){
                    alert('En Construcción!');
                });
            });
        </script>
        
        <title>View Workout</title>
    </head>
    <body>
        
        <table style="margin: auto; border: 5px solid black; margin-top: 50px; background-color: white; border-radius: 10px; padding-bottom: 0px;">
            <tr>
                <td></td>
                <td style="text-align: center; background-color: white; padding-top: 20px; padding-bottom: 10px;">
                    <img src="./resources/images/bike.png" alt="bike" />
                </td>
                <td></td>                
            </tr>
            <tr>
                <td colspan="3" style="background-color: white; text-align: center;">
                    <div id="heartRate" style="text-align: center; vertical-align: middle; margin: auto;">
                        <table style="margin: auto; height: 50px;">
                            <tr>
                                <td>
                                </td>
                            </tr>
                        </table>
                        <table style="margin: auto; height: 50px; margin-top: 20px; background-color: white;">
                            <tr>
                                <td id="bpm" style="font-size: 36pt; font-weight: bolder;">
                                   0 
                                </td>
                                <td>
                                </td>
                                <td  style="font-size: 12pt; font-weight: bold;">
                                    <table>
                                        <tr>
                                            <td>
                                                <img src="./resources/images/emptyHeart.png" alt="heart" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                BPM
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <table style="margin: auto; margin-top: 25px; height: 50px; background-color: white;">
                            <tr>
                                <td id="thr" style="font-size: 24pt; font-weight: bolder;">0</td>
                                <td style="font-size: 24pt; font-weight: bolder;"> - </td>
                                <td id="mhr" style="font-size: 24pt; font-weight: bolder;">0</td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr style="margin-top: 0;">
                <td style="background-color: white; padding: 5px;">
                    <div id="startButton" style="background-color: green; border: 2px solid black; text-align: center;  margin-right: -25px; margin-left: 25px; padding: 10px; width: 50px; border-radius: 10px;"><strong>START</strong></div>
                </td>
                <td></td>
                <td style=" background-color: white; padding: 5px;">
                    <div id="stopButton" style="background-color: red; border: 2px solid black; text-align: center; margin-left: -25px; margin-right: 25px; padding: 10px; width: 50px; border-radius: 10px;"><strong>STOP</strong></div>
                </td>
            </tr>
            <tr style="background-color: black; margin-bottom: 0px; padding-bottom: 0px;">
                <td colspan="3" style="background-color: black; margin-bottom: 0px; padding-bottom: 0px; text-align: center;">
                    <div id="menuButton"></div>
                    <div id="homeButton"></div>
                    <div id="backButton"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
