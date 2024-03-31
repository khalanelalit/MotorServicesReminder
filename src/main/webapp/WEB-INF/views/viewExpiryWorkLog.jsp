<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.lalit.Garages.WorkLog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Expired Work Logs</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
        }

        #header {
            background-color: red;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        #content {
            margin-top: 20px;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .table th, .table td {
            text-align: center;
            padding: 12px;
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
        <h2>View Expired Work Logs</h2>
        <table class="table table-bordered table-striped">
            <thead>
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
                    for (WorkLog cp : list) {
                        // Get current date
                        Calendar currentDate = Calendar.getInstance();
                        
                        // Convert String to Date
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date dueDateAsDate = dateFormat.parse(cp.getDueDate());

                        // Check if the due date is before the current date
                        Calendar dueDate = Calendar.getInstance();
                        dueDate.setTime(dueDateAsDate);

                        if (dueDate.compareTo(currentDate) < 0) {
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
                    }
                %> 
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
