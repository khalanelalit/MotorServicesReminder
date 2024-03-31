<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.lalit.Garages.WorkLog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View One Month Expiry WorkLog</title>
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
            background-color: red; /* Blue color for the header */
            color: white; /* White text color for the header */
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
        <h2>View One Month Expiry WorkLog</h2>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">WorkLogId</th>
                    <th scope="col">VehicleNo</th>
                    <th scope="col">Title</th>
                    <th scope="col">Description</th>
                    <th scope="col">Date</th>
                    <th scope="col">Email</th>
                    <th scope="col">Contact</th>
                    <th scope="col">Address</th>
                    <th scope="col">GarageContact</th>
                    <th scope="col">DueDate</th>
                </tr>
            </thead>
            <tbody>
               
                 <% 
                 List<WorkLog> list = (List<WorkLog>) request.getAttribute("list");
                 for(WorkLog cp:list) {
                %>
                <tr>
                    <td scope="row"><%= cp.getWorkLogId() %></td>
                    <td scope="row"><%= cp.getVehicleNo() %></td>
                    <td scope="row"><%= cp.getTitle() %></td>
                    <td scope="row"><%= cp.getDescription() %></td>
                    <td scope="row"><%= cp.getDate() %></td>
                    <td scope="row"><%= cp.getEmail() %></td>
                    <td scope="row"><%= cp.getContact() %></td>
                    <td scope="row"><%= cp.getAddress() %></td>
                    <td scope="row"><%= cp.getGarageContact() %></td>
                    <td scope="row"><%= cp.getDueDate() %></td>
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
