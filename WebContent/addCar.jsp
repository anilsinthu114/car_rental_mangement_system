<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Car Success</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="alert alert-success" role="alert">
    <%= request.getAttribute("successMessage") %>
    </div>
    <div class="text-center">
        <a href="addCarForm.html" class="btn btn-primary">Add Another Car</a>
        <a href="ViewCarServlet" class="btn btn-primary">View Cars </a>
        <a href="updateCarForm.html" class="btn btn-info">Update Car Details</a>
        <a href="deleteCar.jsp" class="btn btn-danger">Delete Car</a>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
