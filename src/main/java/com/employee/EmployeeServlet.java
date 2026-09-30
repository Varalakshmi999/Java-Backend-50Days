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
        out.println("<h2>Employee List - Day 8/9</h2>");
        out.println("<a href='add-employee.html'>Add New Employee</a><br><br>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Salary</th></tr>");
        for (Employee e : list) {
            out.println("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getEmail() + "</td><td>" + e.getSalary() + "</td></tr>");
        }
        out.println("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        double salary = Double.parseDouble(request.getParameter("salary"));
        Employee emp = new Employee(name, email, salary);
        new EmployeeDAO().addEmployee(emp);
        response.sendRedirect("employees");
    }
}