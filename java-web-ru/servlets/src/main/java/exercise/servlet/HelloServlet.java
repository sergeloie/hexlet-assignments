package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameterMap().containsKey("name")
                ? request.getParameter("name")
                : "Guest";
        request.setAttribute("message", String.format("Hello, %s!", name));
        request.getRequestDispatcher("WEB-INF/hello.jsp").forward(request, response);
    }
    // END
}
