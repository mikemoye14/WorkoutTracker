<%-- 
    Document   : mainMenu
    Created on : May 2, 2014, 1:41:54 AM
    Author     : Mike Moye <mtm5313@psu.edu>
--%>

<%@page import="java.io.File"%>
<%@page import="java.util.TimerTask"%>
<%@page import="java.util.Timer"%>
<%@page import="objs.SimlatedValues"%>
<%@page import="Simulation.SimulatedValues"%>
<%@page import="objs.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String color = "black";
    //User user = (User) request.getAttribute("user");
    int hr = 60;
    double distance = 0;
    double speed = 0;
    double calories = 0;
    String age = "40";

    String id = "0";

    String init = "no";

    if ((String) request.getAttribute("init") == "yes") {

        init = "yes";

    } else {
        id = (String) request.getAttribute("userId");

        //out.print(id);
        if (request.getAttribute("age") != null) {
            age = (String) request.getAttribute("age");
        }

        //User user = new User("Mike", "M", 18);
        //int age = user.getAge();
        SimulatedValues sv = new SimulatedValues(Integer.parseInt(age), 1);

        hr = sv.getHeartRate();
        distance = sv.getDistance();
        speed = sv.getSpeed();
        calories = sv.getCalories();
    }
    int ehr = 220 - Integer.parseInt(age); //calc target heart rate
    int thr = Integer.parseInt(String.valueOf((int) (ehr * .5))); //calc max heart rate

    int mhr = Integer.parseInt(String.valueOf((int) (ehr * .85)));

    if (hr < thr) {

        color = "blue";

    }
    if (hr > thr && hr < mhr) {

        color = "green";

    }

    if (hr > mhr) {

        color = "red";

    }


%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="./resources/js/jquery-latest.js"></script>
        <script type="text/javascript">

            var hr = '<%= hr%>';
            var distance = '<%= distance%>';
            var speed = '<%= speed%>';
            var calories = '<%= calories%>';
            var setValues;
            var num = 0;

            $(document).ready(function() {
                $('#heartRate').html(hr);
                $('#speed').html(speed);
                $('#distance').html(distance);
                $('#calories').html(calories);

                getValues();

            });

            function getId(id) {
                //alert(id);

                var f = document.getElementById('workout');
                var s = document.createElement("input");
                s.type = "hidden";
                s.name = "userId";
                s.value = id;
                f.appendChild(s);

                f.submit();
            }

            function json() {

                //window.location.href = path;

                $.ajax({
                    type: 'GET',
                    url: './resources/json/values_' + num + '.js',
                    async: false,
                    jsonpCallback: 'getValues',
                    contentType: "application/jsonp",
                    dataType: 'jsonp',
                    success: function(data, status) {

                        //var values = data;
                        //alert(status);
                        hr = data.values[0].heartRate.toString();
                        distance = data.values[0].distance.toString();
                        speed = data.values[0].speed.toString();
                        calories = data.values[0].calories.toString();

                        //alert('hr: ' + hr + '\ndist: ' + distance + '\nsp: ' + speed + '\ncal: ' + calories);

                        $('#heartRate').html(hr);
                        $('#speed').html(speed);
                        $('#distance').html(distance);
                        $('#calories').html(calories);
                    }

                });

            }

            function getValues() {
                var init = '<%= init%>';

                //alert(init);

                if (init === "yes") {

                    setValues = setInterval(function() {
                        try {
                            num++;
                            json();
                        } finally {
                            setTimeout(5000);
                        }

                    }, 1000);

                }

            }

            function stop() {
                clearInterval(setValues);
            }

        </script>
        <style type="text/css">
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
    </head>
    <body>

        <table style="margin: auto; width: 320px; height: 480px; border: 5px solid black; background-color: white; border-radius: 10px; padding-bottom: 0px;">
            <tr>
                <td></td>
                <td style="text-align: center; background-color: white; padding-bottom: 10px;">
                    <img src="./resources/images/bike.png" alt="bike" />
                </td>
                <td></td>                
            </tr>
            <tr>
                <td colspan="3" style=" height: 250px; vertical-align: middle;">
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px; border-top: 2px solid black;" onclick="javascript: window.location.href = './heartRateTracker.jsp';" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">
                        <table style="margin: auto;  width: 75%;"><tr><td style="text-align: left;">HEART RATE 
                                </td>
                                <td style="text-align: right;"><span id="heartRate" style="color: <%= color%>; font-weight: bolder; margin-left: 50px;">
                                    </span></td></tr></table>
                    </div>
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px;">
                        <table style="margin: auto;  width: 75%;"><tr><td style="text-align: left;">DISTANCE
                                </td>
                                <td style="text-align: right;"><span id="distance" style="font-weight: bolder; margin-left: 50px;">
                                    </span></td></tr></table>
                    </div>
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px;">
                        <table style="margin: auto;  width: 75%;"><tr><td style="text-align: left;">SPEED</td>
                                <td style="text-align: right;"><span id="speed" style="font-weight: bolder; margin-left: 50px;">
                                    </span></td></tr></table>
                    </div>
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px;border-bottom: 2px solid black;">
                        <table style="margin: auto;  width: 75%;"><tr><td style="text-align: left;">CALORIES
                                </td>
                                <td style="text-align: right;"><span id="calories" style="font-weight: bolder; margin-left: 50px;">

                                    </span></td></tr></table>
                    </div>
                </td>
            </tr>
            <form id="workout" action="workoutServlet"/>
            <tr style="margin-top: 0;">
                <td style="background-color: white; padding: 5px;">
                    <div onclick="javascript: getId(<%= id%>);" id="startButton" style="background-color: green; border: 2px solid black; text-align: center;  margin-right: -25px; margin-left: 25px; padding: 10px; width: 50px; border-radius: 10px;"><strong>START</strong></div>
                </td>
                <td></td>
                <td style=" background-color: white; padding: 5px;">
                    <div onclick="javascript: stop();" id="stopButton" style="background-color: red; border: 2px solid black; text-align: center; margin-left: -25px; margin-right: 25px; padding: 10px; width: 50px; border-radius: 10px;"><strong>STOP</strong></div>
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
