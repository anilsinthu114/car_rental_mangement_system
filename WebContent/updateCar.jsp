<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file='home.jsp' %>
<%@page import="model.Car" %>
<%@page import="dao.CarDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Car Details</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<!-- Retrieve Car Details -->
    <h2>View Car Details</h2>
    <table class="table">
        <thead>
            <tr>
                <th>CarId</th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Rental Rate Per Day</th>
                <th>Availability Status</th>
            </tr>
        </thead>
        <tbody>
            <% 
            int carId = Integer.parseInt(request.getParameter("carId"));
            Car car = CarDAO.getCarById(carId);
            if (car != null) {
            %>
            <tr>
                <td><%= car.getCarId() %></td>
                <td><%= car.getMake() %></td>
                <td><%= car.getModel() %></td>
                <td><%= car.getYear() %></td>
                <td><%= car.getRentalRatePerDay() %></td>
                <td><%= car.getAvailabilityStatus() %></td>
            </tr>
            <% 
            } else {
            %>
            <tr>
                <td colspan="6">No car found with ID <%= carId %></td>
            </tr>
            <% 
            }
            %>
        </tbody>
    </table>
</div>
<div class="container mt-5">
    <h2>Update Car Details</h2>
    <form action="UpdateCarServlet" method="post">
    
        <div class="form-group">
            <label for="carId">CarId:</label>
            <input type="text" name="carId" value="${car.carId}">
        </div>
        <div class="form-group">
            <label for="make">Make:</label>
            <input type="text" class="form-control" id="make" name="make" value="${car.make}">
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" class="form-control" id="model" name="model" value="${car.model}">
        </div>
        <div class="form-group">
            <label for="year">Year:</label>
            <input type="number" class="form-control" id="year" name="year" value="${car.year}">
        </div>
        <div class="form-group">
            <label for="rentalRatePerDay">Rental Rate Per Day:</label>
            <input type="number" step="0.01" class="form-control" id="rentalRatePerDay" name="rentalRatePerDay" value="${car.rentalRatePerDay}">
        </div>
        <div class="form-group">
            <label for="availabilityStatus">Availability Status:</label>
            <input type="text" class="form-control" id="availabilityStatus" name="availabilityStatus" value="${car.availabilityStatus}">
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
 
    

<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
