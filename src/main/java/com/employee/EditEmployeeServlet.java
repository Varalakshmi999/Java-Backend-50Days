package com.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-employee")
public class EditEmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;
    public void init() { employeeDAO = new EmployeeDAO(); }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee emp = employeeDAO.getEmployeeById(id);
        req.setAttribute("employee", emp);
        RequestDispatcher rd = req.getRequestDispatcher("edit-employee.jsp");
        rd.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee emp = new Employee(id, name, email, salary);
        employeeDAO.updateEmployee(emp);
        resp.sendRedirect("employees");
    }
}
