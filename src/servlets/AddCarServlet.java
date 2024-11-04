package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import dao.CarDAO;
import model.Car;

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve car details from form
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        double rentalRate = Double.parseDouble(request.getParameter("rate"));
        String availability = request.getParameter("availability");

        // Create a Car object
        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        car.setRentalRatePerDay(rentalRate);
        car.setAvailabilityStatus(availability);

        // Use CarDAO to insert the car into the database
        boolean success = CarDAO.addCar(car);

        if (success) {
            // If insertion is successful, redirect to addCar.jsp
            // Use request.setAttribute to set a success message for display on the addCar.jsp page
            
            request.setAttribute("successMessage", "Car Details Inserted Successfully!");
            // Redirect to the addCar.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("addCar.jsp");
            dispatcher.forward(request, response);
        } else {
            // If insertion fails, set an attribute for error message and forward to error.jsp
            request.setAttribute("errorMessage", "Failed to add car.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
