package com.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    // DAY 10 - JSP Forwarding
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Employee> list = employeeDAO.getAllEmployees();
            req.setAttribute("empList", list);
            RequestDispatcher rd = req.getRequestDispatcher("employees.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    // DAY 9 - Form to DB
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            double salary = Double.parseDouble(req.getParameter("salary"));

            Employee emp = new Employee(name, email, salary);
            employeeDAO.addEmployee(emp);

            resp.sendRedirect("employees");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}