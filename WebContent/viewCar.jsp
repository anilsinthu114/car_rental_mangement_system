<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='home.jsp' %>
<%@ page import="dao.CarDAO" %>
<%@ page import="model.Car" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Cars</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2>View Cars</h2>
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Rental Rate Per Day</th>
                <th>Availability Status</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
           

            List<Car> cars = (List<Car>) request.getAttribute("cars");
            if (cars != null && !cars.isEmpty()) {
                for (Car car : cars) {
            %>
            
            <tr>
                <td><%= car.getCarId() %></td>
                <td><%= car.getMake() %></td>
                <td><%= car.getModel() %></td>
                <td><%= car.getYear() %></td>
                <td><%= car.getRentalRatePerDay() %></td>
                <td><%= car.getAvailabilityStatus() %></td>
                <td>
                    <form action="UpdateCarServlet" method="post">
                        <input type="hidden" name="carId" value="<%= car.getCarId() %>">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
                    <form action="DeleteCarServlet" method="post">
                        <input type="hidden" name="carId" value="<%= car.getCarId() %>">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
            <% 
                }
            } else {
            %>
            <tr>
                <td colspan="7">No cars available</td>
            </tr>
            <% 
            }
            %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
