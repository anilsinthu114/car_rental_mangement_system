package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import dao.CarDAO;
import java.util.List;
import model.Car;

@WebServlet("/ViewCarServlet")
public class ViewCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve car details from the database using CarDAO
        List<Car> cars = CarDAO.getAllCars();

        // Set the list of cars as an attribute in the request object
        request.setAttribute("cars", cars);

        // Forward to viewCar.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewCar.jsp");
        dispatcher.forward(request, response);
    }
}
