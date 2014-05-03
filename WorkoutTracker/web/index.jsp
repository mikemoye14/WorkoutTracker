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
                = "<form id=\"loadUserForm\" method=\"GET\" action=\"\">'\n"
                + "+ '<table style=\"margin: auto; width: 100%;\">'\n"
                + "+ ' <tr>'\n"
                + "+ '     <th style=\"text-align: center; padding-right: 50px;\">ID</th style=\"text-align: center;\"><th style=\"text-align: left;\">NAME</th><th style=\"text-align: center;\">AGE</th>'\n"
                + "+ ' </tr>'\n"
                + "+ ' <tr>'\n"
                + "+ '     <th colspan=\"3\"><hr /></th>'"
                + "+ ' </tr>'\n";

        if (users.isEmpty()) {
            userTable
                    += "+ ' <tr>'\n"
                    + "+ '     <td style=\"text-align: left;\" colspan=\"3\">There are no Users to show on this list</td>'\n"
                    + "+ ' </tr>'\n";
        } else {

            for (User used : users) {
                userTable 
                        += "+ '<tr id=\"" + String.valueOf(used.getUserID()) + "\" name=\"user\" onclick=\"javascript: getId($(this).attr(\\'id\\'));\" class=\"userToLoad\" onmouseover=\"javascript: "
                        + " $(this).css(\\'cursor\\', \\'pointer\\'); "
                        + " $(this).css(\\'color\\', \\'white\\'); "
                        + " $(this).css(\\'background-color\\', \\'#5F74E2\\');\" "
                        + " onmouseout=\"javascript: "
                        + " $(this).css(\\'cursor\\', \\'default\\');'\n"
                        + "+ ' $(this).css(\\'background-color\\', \\'white\\');"
                        + " $(this).css(\\'color\\', \\'black\\');\">'\n"
                        + "+ '<td style=\"text-align: center; padding-right: 50px;\">" + String.valueOf(used.getUserID()) + "</td>'\n"
                        + "+ '<td style=\"text-align: left;\">" + used.getFName() + " " + used.getLName() + "</td>'\n"
                        + "+ '<td style=\"text-align: center;\">" + String.valueOf(used.getAge()) + "</td>'\n"
                        + "+ '</tr>'\n";
                
            }
        }

        userTable +=
                "+ '</table>'\n"
                + "+ '</form>";

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
        <script type="text/javascript">
            
            var selectedUser;
            
            function getId(id){
                //alert(id);
                
                var f = document.getElementById('loadUserForm');
                var s = document.createElement("input");
                s.type="hidden"; s.name="userId"; s.value=id; s.id="userId";            
                f.appendChild(s);

                f.submit();
            }
            
            function hideStart() {
                $('.start').hide();
                $('.settings').show();
            }
            function showUsers() {
                $('.settings').hide();

                $('#users').append('<%= userTable %>');
                $('#userRow').show();
            }
            function showNewUser() {
                $('.settings').hide();
                $('#newUser').show();
            }
            //$(document).ready(function() {

            /*
             $('.user').mouseover(function() {
             
             alert('gotHere');
             $(this).css('cursor', 'pointer');
             $(this).css('color', 'white');
             $(this).css('background-color', '#5F74E2');
             });
             
             $('.user').mouseout(function() {
             $(this).css('cursor', 'default');
             $(this).css('color', 'black');
             $(this).css('background-color', 'white');
             });
             */

            //});
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

        <table id="beginTable" style="margin: auto; width: 320px; height: 480px; border: 5px solid black; background-color: white; border-radius: 10px; padding-bottom: 0px;">
            <tr>
                <td></td>
                <td style="text-align: center; background-color: white; padding-top: 20px; padding-bottom: 10px;">
                    <img src="./resources/images/bike.png" alt="bike" />
                </td>
                <td></td>                
            </tr>
            <tr class="start">
                <td colspan="3" style="padding-bottom: 10px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: window.location.href = './mainMenu.jsp';" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">START</div>
                </td>
            </tr>
            <tr class="start">
                <td colspan="3" style="padding-bottom: 10px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: hideStart();" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">SETTINGS</div>
                </td>
            </tr>
            <tr style="display: none;" class="settings">
                <td colspan="3" style="padding-bottom: 10px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: showUsers();" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">LOGIN</div>
                </td>
            </tr>
            <tr style="display: none;" class="settings">
                <td colspan="3" style="padding-bottom: 10px;">
                    <div style="width: 250px; text-align: center; border: 1px solid black; padding: 25px;" onclick="javascript: showNewUser();" onmouseover="javascript: $(this).css('cursor', 'pointer');
                            $(this).css('color', 'white');
                            $(this).css('background-color', '#5F74E2');" onmouseout="javascript: $(this).css('cursor', 'default');
                                    $(this).css('background-color', 'white');
                                    $(this).css('color', 'black');">NEW USER</div>
                </td>
            </tr>
            <tr  id="userRow" style="display: none;">
                <td id="users" colspan="3" style=" text-align: center; padding-bottom: 10px; width: 250px;">
                    <h2 style="color: #5F74E2;">LOGIN</h2>
                    <span style="color: red; text-align: left;padding-bottom: 10px;">Click your user account.</span>
                    <br />
                </td>
            </tr>
            <tr  id="newUser" style="display: none;">
                <td colspan="3" style="padding-bottom: 10px; width: 250px;">
                    <form action="">
                        <table style="margin: auto;">
                            <tr>
                                <td colspan="2" style="text-align: center; color: #5F74E2;">                                    
                                    <h2>New User</h2>
                                </td>
                            </tr>
                            <tr>
                                <th style="text-align: right;">First Name:</th><th style="text-align: center;"><input type="text" name="fName" style="border: 1px solid #5F74E2;" /></th>
                            </tr>
                            <tr>
                                <th style="text-align: right;">Last Name:</th><th style="text-align: center;"><input type="text" name="lName" style="border: 1px solid #5F74E2;" /></th>
                            </tr>
                            <tr>
                                <th style="text-align: right;">Age:</th><th style="text-align: center;"><input type="text" name="age" style="border: 1px solid #5F74E2;" /></th>
                            </tr>
                            <tr>
                                <td colspan="2" style="text-align: center; color: #5F74E2; padding: 20px;">
                                    <input type="submit" value="Add New User" />
                                </td>
                            </tr>
                        </table>
                    </form>
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
