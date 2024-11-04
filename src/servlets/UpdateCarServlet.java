package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import dao.CarDAO;

@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve car ID from request parameter
        int carId = Integer.parseInt(request.getParameter("carId"));

        try {
        	
            // Retrieve car details by ID
            Car car = CarDAO.getCarById(carId);
            
            if (car == null) {
                // If car with the given ID does not exist, forward to an error page
                request.setAttribute("errorMessage", "Error: Car with ID " + carId + " does not exist.");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
                return;
            }

            // Retrieve other parameters from request
            String make = request.getParameter("make");
            String model = request.getParameter("model");
            int year = Integer.parseInt(request.getParameter("year"));
            double rentalRatePerDay = Double.parseDouble(request.getParameter("rentalRatePerDay"));

            String availabilityStatus = request.getParameter("availabilityStatus");
            
            // Create an instance of Car with updated details
            Car updatedCar = new Car();
            updatedCar.setCarId(carId);
            updatedCar.setMake(make);
            updatedCar.setModel(model);
            updatedCar.setYear(year);
            updatedCar.setRentalRatePerDay(rentalRatePerDay);
            updatedCar.setAvailabilityStatus(availabilityStatus);

            // Update the car details
            boolean success = CarDAO.updateCarById(carId, updatedCar);

            if (success) {
                // If update is successful, redirect to a success page
                response.sendRedirect(request.getContextPath() + "/ViewCarServlet");
            } else {
                // If update fails, forward to an error page
                request.setAttribute("errorMessage", "Failed to update car details.");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // Handle number format exception
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: Invalid input format.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
