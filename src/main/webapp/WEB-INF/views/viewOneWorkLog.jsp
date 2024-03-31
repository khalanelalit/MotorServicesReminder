<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.lalit.Garages.WorkLog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View WorkLog</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        #header {
            font-size: 14px;
            text-align: center;
            padding: 10px;
            background-color: Blue; /* Blue color for the header */
            color: White; /* White text color for the header */
        }

        #content {
            padding: 20px;
        }

        .form-container {
            border: 1px solid #ccc; /* Add a 1px solid border around the form */
            border-radius: 5px; /* Add border radius for a softer look */
            padding: 20px; /* Add padding for spacing within the border */
            background-color: #f9f9f9; /* Add a light background color */
            margin-bottom: 20px; /* Add margin at the bottom */
        }

        #content h2 {
            margin-top: 0;
            text-align: center;
            margin-bottom: 20px;
        }

        .table {
            width: 100%;
            margin-bottom: 1rem;
            color: #212529;
        }

        .table th,
        .table td {
            padding: 12px;
            text-align: center; /* Center text in cells */
            vertical-align: top;
            border-top: 1px solid #dee2e6;
        }

        .table thead th {
            vertical-align: bottom;
            border-bottom: 2px solid #dee2e6;
            background-color: #343a40; /* Dark background for header */
            color: white; /* White text color for header */
        }

        .table-bordered {
            border: 1px solid #dee2e6;
        }

        .table-bordered th,
        .table-bordered td {
            border: 1px solid #dee2e6;
        }

        .table-striped tbody tr:nth-of-type(odd) {
            background-color: rgba(0, 0, 0, 0.05);
        }
    </style>
</head>
<body>

<div id="header">
    <h4>WorkLog</h4>
</div>

<div id="content">
    <div class="form-container">
        <h2>View One WorkLog</h2>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">WorkLogId</th>
                    <th scope="col">VehicleNo</th>
                    <th scope="col">title</th>
                    <th scope="col">description</th>
                    <th scope="col">date</th>
                    <th scope="col">email</th>
                    <th scope="col">contact</th>
                    <th scope="col">address</th>
                    <th scope="col">garageContact</th>
                    <th scope="col">dueDate</th>
                </tr>
            </thead>
            <tbody>
               
                 <% List<WorkLog> workLog=(List<WorkLog>)request.getAttribute("workLog"); 
                 for(WorkLog c: workLog){
                	 
                	 %>
                <tr>
                    <td scope="row"><%= c.getWorkLogId() %></td>
                    <td scope="row"><%= c.getVehicleNo() %></td>
                    <td scope="row"><%= c.getTitle() %></td>
                    <td scope="row"><%= c.getDescription() %></td>
                    <td scope="row"><%= c.getDate() %></td>
                    <td scope="row"><%= c.getEmail() %></td>
                    <td scope="row"><%= c.getContact() %></td>
                    <td scope="row"><%= c.getAddress() %></td>
                    <td scope="row"><%= c.getGarageContact() %></td>
                    <td scope="row"><%= c.getDueDate() %></td>
                </tr>
                <%
                 }
                %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
