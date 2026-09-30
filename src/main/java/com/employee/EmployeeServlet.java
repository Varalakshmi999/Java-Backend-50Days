package com.employee;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> list = dao.getAllEmployees();

        response.setContentType("text/html");
        var out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Employee List - Day 8</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Salary</th></tr>");

        for (Employee e : list) {
            out.println("<tr>");
            out.println("<td>" + e.getId() + "</td>");
            out.println("<td>" + e.getName() + "</td>");
            out.println("<td>" + e.getEmail() + "</td>");
            out.println("<td>" + e.getSalary() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<h3 style='color:green'>✅ Day 8 - Servlet Working!</h3>");
        out.println("</body></html>");
    }
}