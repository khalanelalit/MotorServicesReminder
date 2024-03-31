<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Motor Services App</title>
    <style>
        /* Custom styles for the red color scheme */
        .navbar-dark.bg-red {
            background-color: red ;
        }
        
        .bg-white {
            background-color:white ;
        }
        
        .btn-red {
            background-color: red !important;
            border-color: red !important;
        }
        
        .btn-red:hover {
            background-color: Red;
            border-color: Red;
        }
        .card-header {
    background-color: red; /* Set the background color to red */
}
        
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-red"> <!-- Navbar color changed to red -->
        <a class="navbar-brand" href="#">Motor Services App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
                <li class="nav-item">
                    <a class="/MotorServices/" href="#">Home</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container mt-4">
       

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-red text-red"> <!-- Adjusted card header background color to red -->
                        <h3 > Garages Login</h3>
                    </div>
                    <div class="card-body bg-red"> <!-- Adjusted card body background color to light red -->
                        <form action="afterGaragesLogin" method="post">
                            <div class="form-group">
                                <label for="contact">Contact:</label>
                                <input type="text" class="form-control" name="contact" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-red">Login</button> <!-- Adjusted button color to red -->
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
