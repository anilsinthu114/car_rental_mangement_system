<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Custom styles -->
  <style>
    /* Add your custom styles here */
    .navbar {
      background-color: #000033; /* Dark grey navbar */
    }
    .navbar-brand, .navbar-nav .nav-link {
      color: black;
    }
    .navbar-brand .navbar-nav,.nav-link: hover{
    color: red;
    }
    span{
    color:red;
    font: 18px;
    }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark">
    <a class="navbar-brand" href="#">Car Rental Management System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="addCarForm.html">Add Car</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="ViewCarServlet">View Cars</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="updateCarForm.html">Update Car</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="deleteCar.jsp">Delete Car</a>
        </li>
        <!-- User image and logout button -->
        <li class="nav-item">
          <div id="userInfo" style="text-align: center; margin-top: 10px;">
            <img src="images/user.png" alt="User Image" id="userImage" width="30" height="30" style="cursor: pointer;">
            <span><%= ((HttpSession) request.getSession()).getAttribute("rollNumber") %></span>
            <button id="logoutBtn" class="btn btn-danger" onclick=" window.location.href = 'LogoutServlet';" style="display: none;">Logout</button>
          </div>
        </li>
      </ul>
    </div>
  </nav>

  <!-- Bootstrap JS and jQuery (placed at the end of the document for faster page loading) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  <!-- JavaScript for showing logout button on click -->
  <script>
    
    // Show logout button on clicking user image
    document.getElementById("userImage").onclick = function() {
      document.getElementById("logoutBtn").style.display = "block";
    };
  </script>
</body>
</html>
