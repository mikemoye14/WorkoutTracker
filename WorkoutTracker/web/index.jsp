<%-- 
    Document   : index
    Created on : May 2, 2014, 9:44:23 AM
    Author     : Mike Moye <mtm5313@psu.edu>
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="objs.User, database.DatabaseInterface" contentType="text/html" pageEncoding="UTF-8"%>

<%

    User xUser = (User) request.getAttribute("user");

    String userTable = "";

    try {

        DatabaseInterface getUsersInterface = new DatabaseInterface();

        ArrayList<User> users;

        users = getUsersInterface.getUsers();

        userTable
                = "<table style=\"margin: auto; width: 100%;\">"
                + " <tr>"
                + "     <th style=\"text-align: center;\">ID</th style=\"text-align: center;\"><th>NAME</th><th style=\"text-align: center;\">AGE</th>"
                + " </tr>";

        if (users.isEmpty()) {
            userTable
                    += " <tr>"
                    + "     <td style=\"text-align: left;\" colspan=\"3\">There are no Users to show on this list</td>"
                    + " </tr>";
        } else {

            for (User used : users) {
                userTable
                        += "<tr onmouseover=\"javascript: "
                                + "     $(this).css(\\'cursor\\', \\'pointer\\'); "
                                + "     $(this).css(\\'color\\', \\'white\\'); "
                                + "     $(this).css(\\'background-color\\', \\'#5F74E2\\');\" "
                                + " onmouseout=\"javascript: $(this).css(\\'cursor\\', \\'default\\');"
                                + "     $(this).css(\\'background-color\\', \\'white\\');"
                                + "     $(this).css(\\'color\\', \\'black\\');>\">"
                            + "<td style=\"text-align: center;\">" + String.valueOf(used.getUserID()) + "</td>"
                            + "<td style=\"text-align: left;\">" + used.getFName() + " " + used.getLName() + "</td>"
                            + "<td style=\"text-align: center;\">" + String.valueOf(used.getAge()) + "</td>"
                        + " </tr>";
            }
        }

        userTable += "</table>";

    } catch (Exception x) {
        x.printStackTrace();
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <title>Workout Tracker</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="./resources/js/jquery-latest.js"></script>

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

        <script type="text/javascript">
            function hideStart() {
                $('.start').hide();
                $('.settings').show();
            }
            function showUsers() {
                $('.settings').hide();
                $('#users').append('<%= userTable%>');
                $('#userRow').show();
            }

        </script>

        <table id="beginTable" style="margin: auto; border: 5px solid black; margin-top: 50px; background-color: white; border-radius: 10px; padding-bottom: 0px;">
            <tr>
                <td></td>
                <td style="text-align: center; background-color: white; padding-top: 20px; padding-bottom: 10px;">
                    <img src="./resources/images/bike.png" alt="bike" />
                </td>
                <td></td>                
            </tr>
            <tr class="start">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px; ">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: window.location.href = './mainMenu.jsp';" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">START</div>
                </td>
            </tr>
            <tr class="start">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: hideStart();" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">SETTINGS</div>
                </td>
            </tr>
            <tr style="display: none;" class="settings">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: showUsers();" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">LOGIN</div>
                </td>
            </tr>
            <tr style="display: none;" class="settings">
                <td colspan="3" style="padding-bottom: 25px; padding-top: 25px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript:" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">NEW USER</div>
                </td>
            </tr>
            <tr  id="userRow" style="display: none; ">
                <td id="users" colspan="3" style="padding-bottom: 25px; padding-top: 25px; width: 250px;">
                    
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
