package controllers;
import models.Employee;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public abstract class EmployeeContextListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "john.doe@example.com", "123456789", "Marketing", "Manager"));
        employees.add(new Employee(2, "Jane Smith", "jane.smith@example.com", "987654321", "HR", "Recruiter"));
        
        // Mettre la liste des employés dans le contexte de l'application
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("employees", employees);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Nettoyage si nécessaire
    }
}

