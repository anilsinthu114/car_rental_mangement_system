package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CarDAO;


@WebServlet("/DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve car ID from the request
		PrintWriter out= response.getWriter();
        int carId = Integer.parseInt(request.getParameter("carId"));
        
        // Delete the car record from the database
        boolean success = CarDAO.deleteCarById(carId, out);
        
        if (success) {
            // Redirect to a success page or back to the view car page
            response.sendRedirect("ViewCarServlet");
        } else {
            request.setAttribute("errorMessage","Data with id not there in Datbase table");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
