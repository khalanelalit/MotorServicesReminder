<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>GaragesGUI</title>
    <style>
        /* Custom styles for the red color scheme */
        .bg-red {
            background-color: red !important;
        }
        
        .btn-red {
            background-color: red !important;
            border-color: red !important;
        }
        
        .bg-red {
    background-color: red !important; /* Set the background color to red */
       }
        
        
        .btn-red:hover {
            background-color: #ff3333 !important;
            border-color: #ff3333 !important;
        }
        
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-red"> <!-- Changed bg-primary to bg-red -->
        <a class="navbar-brand" href="#">Garages Name</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/MotorServices/">Home</a>
               
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
       

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-red text-white">
                        <h3>Add Vehicle</h3>
                    </div>
                    <div class="card-body">
                        <form action="afterAddVehicle" method="post">
                            <div class="form-group">
                                <label for="VehicleNo">Vehcile No</label>
                                <input type="text" class="form-control" name="VehicleNo" required>
                            </div>
                            <div class="form-group">
                                <label for="ChassisNo">Garage Contact NO</label>
                                <input type="text" class="form-control" name="ChassisNo" required>
                            </div>
                            <div class="form-group">
                                <label for="Address">Name</label>
                                <input type="Name" class="form-control" name="Name" required>
                            </div>
                            <div class="form-group">
                                <label for="OwnerName"> Owner Name</label>
                                <input type="text" class="form-control" name="OwnerName" required>
                            </div>
                            <div class="form-group">
                                <label for="Contact">Contact</label>
                                <input type="text" class="form-control" name="Contact" required>
                            </div>
                            <div class="form-group">
                                <label for="Address">Address</label>
                                <input type="text" class="form-control" name="Address" required>
                            </div>
                            <div class="form-group">
                                <label for="Email">Email</label>
                                <input type="text" class="form-control" name="Email" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" class="form-control" name="Password" required>
                            </div>
                            
                            <button type="submit" class="btn btn-red">Submit</button> <!-- Changed btn-primary to btn-red -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
