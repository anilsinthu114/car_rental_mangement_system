
package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        String password = request.getParameter("password");

        // For simplicity, let's assume roll number is both username and password
        if (rollNumber.equals(password)) {
            // Successful login, store user information in session
            HttpSession session = request.getSession();
            session.setAttribute("rollNumber", rollNumber);

            // Redirect to home page or any other page after successful login
            response.sendRedirect("home.jsp");
        } else {
            // Login failed, redirect back to login page with error message
            response.sendRedirect("login.html?error=1");
        }
    }
}
