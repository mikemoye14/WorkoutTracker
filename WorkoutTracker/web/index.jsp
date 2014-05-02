<%-- 
    Document   : index
    Created on : May 2, 2014, 9:44:23 AM
    Author     : Mike Moye <mtm5313@psu.edu>
--%>

<%@page import="objs.User" contentType="text/html" pageEncoding="UTF-8"%>

<%

    User xUser = (User) request.getAttribute("user");

    User user = new User("Mike", "M", 18);

%>

<!DOCTYPE html>
<html>
    <head>
        <title>Workout Tracker</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="./resources/js/jquery-latest.js"></script>
        <script type="text/javascript">
            function hideStart(){
                $('.start').hide();
                $('.settings').show();
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
        <table style="margin: auto; border: 5px solid black; margin-top: 50px; background-color: white; border-radius: 10px; padding-bottom: 0px;">
            <tr>
                <td></td>
                <td style="text-align: center; background-color: white; padding-top: 20px; padding-bottom: 10px;">
                    <img src="./resources/images/bike.png" alt="bike" />
                </td>
                <td></td>                
            </tr>
            <tr class="start">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px; ">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: window.location.href='./mainMenu.jsp';" onmouseover="javascript: $(this).css('cursor', 'pointer'); $(this).css('color', 'white'); $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default'); $(this).css('background-color', 'white'); $(this).css('color', 'black');">START</div>
                </td>
            </tr>
            <tr class="start">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: hideStart();" onmouseover="javascript: $(this).css('cursor', 'pointer'); $(this).css('color', 'white'); $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default'); $(this).css('background-color', 'white'); $(this).css('color', 'black');">SETTINGS</div>
                </td>
            </tr>
            <tr style="display: none;" class="settings">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: hideStart();" onmouseover="javascript: $(this).css('cursor', 'pointer'); $(this).css('color', 'white'); $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default'); $(this).css('background-color', 'white'); $(this).css('color', 'black');">LOGIN</div>
                </td>
            </tr>
            <tr style="display: none;" class="settings">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: hideStart();" onmouseover="javascript: $(this).css('cursor', 'pointer'); $(this).css('color', 'white'); $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default'); $(this).css('background-color', 'white'); $(this).css('color', 'black');">NEW USER</div>
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
