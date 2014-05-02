<%-- 
    Document   : heartRateTracker
    Created on : Apr 30, 2014, 10:44:47 AM
    Author     : Mike Moye
--%>

<%@page import="objs.User" contentType="text/html" pageEncoding="UTF-8"%>

<%

    User xUser = (User) request.getAttribute("user");

    User user = new User("Mike", "M", 18);

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
            $(document).ready(function() {

                var age = <%= age%>; //get age
                var mhr = 220 - age; //calc target heart rate
                var thr = parseInt(mhr * .5); //calc max heart rate

                var getToRestHeartRate;
                var getToTarget;
                var hype;
                var sus;
                var coolDown;
                var stop;
                var w, x, y, z;

                var counter = 0;
                var interval = 50;

                $('#thr').html(thr);
                $('#mhr').html(mhr);

                $('#startButton').click(function() {
                    if (stop) {
                        clearInterval(coolDown);
                        stop = false;
                    }
                    start();
                });

                $('#stopButton').click(function() {
                    if (w) {
                        clearInterval(getToRestHeartRate);
                        w = false;
                    }
                    if (x) {
                        clearInterval(getToTarget);
                        x = false;
                    }
                    if (y) {
                        clearInterval(hype);
                        y = false;
                    }
                    if (z) {
                        clearInterval(sus);
                        z = false;
                    }
                    interval = 50;
                    stopWorkout();
                });

                function start() {
                    getToRestHeartRate = setInterval(function() {
                        w = true;
                        if (counter === 40) {
                            $('#heart').attr('src', './resources/images/halfHeart.png');
                        }
                        if (counter >= 80) {
                            interval = 100;
                            clearInterval(getToRestHeartRate);
                            w = false;
                            doThr();
                        }
                        $('#bpm').html(counter + 1);
                        counter++;
                    }, interval);
                }

                function doThr() {
                    getToTarget = setInterval(function() {
                        x = true;
                        if (counter >= thr) {
                            interval = 250;
                            clearInterval(getToTarget);
                            x = false;
                            $('#heart').attr('src', './resources/images/fullHeart.png');
                            getHype();
                        }
                        $('#bpm').html(counter + 1);
                        counter = counter + 2;
                    }, interval);
                }

                function getHype() {
                    hype = setInterval(function() {
                        y = true;
                        if (counter >= (mhr * .75)) {
                            clearInterval(hype);
                            y = false;
                            sustain();
                        }
                        $('#bpm').html(counter + 1);
                        counter++;
                    }, interval);
                }

                function sustain() {
                    sus = setInterval(function() {
                        z = true;
                        if (counter >= (mhr * .75)) {
                            $('#bpm').html(counter + 1);
                            counter--;
                        } else {
                            $('#bpm').html(counter - 1);
                            counter++;
                        }
                    }, interval);
                }

                function stopWorkout() {
                    coolDown = setInterval(function() {
                        stop = true;
                        if (counter > -1) {
                            $('#bpm').html(counter - 1);
                            counter--;
                        }
                        if (counter <= 20) {
                            $('#heart').attr('src', './resources/images/emptyHeart.png');
                        }
                        if (counter >= 40) {
                            $('#heart').attr('src', './resources/images/halfHeart.png');
                        }
                        if (counter >= thr) {
                            $('#heart').attr('src', './resources/images/fullHeart.png');
                        }
                        if (counter === 0) {
                            clearInterval(coolDown);
                            stop = false;
                        }
                    }, interval);
                }
                
            });
        </script>

        <title>Welcome to the Heart Rate Tracker</title>
    </head>
    <body>

        <table style="margin: auto; width: 320px; height: 480px; border: 5px solid black; background-color: white; border-radius: 10px; padding-bottom: 0px; ">
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
                                <td id="bpm" style="font-size: 30pt; font-weight: bolder;">
                                    0 
                                </td>
                                <td>
                                </td>
                                <td  style="font-size: 12pt; font-weight: bold;">
                                    <table>
                                        <tr>
                                            <td>
                                                <img id="heart" src="./resources/images/emptyHeart.png" alt="heart" />
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
                        <table style="margin: auto; margin-top: 20px; height: 50px; background-color: white;">
                            <tr>
                                <td colspan="3">Target Range:</td>
                            </tr>
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
                    <div id="menuButton" onclick="javascript: alert('Settings Menu Coming Soon!');"></div>
                    <div id="homeButton" onclick="javascript: window.location.href = './index.jsp';"></div>
                    <div id="backButton" onclick="javascript: history.go(-1);"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
