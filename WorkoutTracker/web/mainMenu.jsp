<%-- 
    Document   : mainMenu
    Created on : May 2, 2014, 1:41:54 AM
    Author     : Mike Moye <mtm5313@psu.edu>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="./resources/js/jquery-latest.js"></script>
        <script type="text/javascript">
            
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
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px; border-top: 2px solid black;" onclick="javascript: window.location.href='./heartRateTracker.jsp';" onmouseover="javascript: $(this).css('cursor', 'pointer'); $(this).css('color', 'white'); $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default'); $(this).css('background-color', 'white'); $(this).css('color', 'black');">HEART RATE</div>
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px;">DISTANCE</div>
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px;">SPEED</div>
                    <div style="width: 100%; text-align: center; vertical-align: middle; border: 1px solid black; padding-top: 10px; padding-bottom: 10px;border-bottom: 2px solid black;">CALORIES</div>
                </td>
            </tr>
            <tr style="background-color: black; margin-bottom: 0px; padding-bottom: 0px;">
                <td colspan="3" style="background-color: black; margin-bottom: 0px; padding-bottom: 0px; text-align: center;">
                    <div id="menuButton" onclick="javascript: alert('Settings Menu Coming Soon!');"></div>
                    <div id="homeButton" onclick="javascript: window.location.href='./index.jsp';"></div>
                    <div id="backButton" onclick="javascript: history.go(-1);"></div>
                </td>
            </tr>
        </table>
    </body>
</html>
