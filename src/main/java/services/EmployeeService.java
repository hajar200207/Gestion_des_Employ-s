package services;

import models.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        employees = new ArrayList<>();
        
    }

 
    public List<Employee> getAllEmployees() {
        return employees;
    }
    //	public List<Employee> getAllEmployees() {
    		  // List<Employee> employees = new ArrayList<>();
    		  // employees.add(new Employee(1, "John Doe", "john.doe@example.com", "123456789", "Marketing", "Manager"));
    		  // employees.add(new Employee(2, "Jane Smith", "jane.smith@example.com", "987654321", "HR", "Recruiter"));
    		  // employees.add(new Employee(2, "Jane Smith", "jane.smith@example.com", "987654321", "HR", "Recruiter"));
    		  // return employees;
    		  //}



    public Employee getEmployeeById(int id) {
        return employees.stream()
                        .filter(e -> e.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    public void addEmployee(Employee employee) {
      
        employees.add(employee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == updatedEmployee.getId()) {
                employees.set(i, updatedEmployee);
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
        employees = employees.stream()
                            .filter(e -> e.getId() != id)
                            .collect(Collectors.toList());
    }

    public List<Employee> searchEmployees(String keyword) {
       
        return employees.stream()
                        .filter(e -> {
                            int    id=e.getId();
                            String name = e.getName();
                            String email = e.getEmail();
                            String department = e.getDepartment();
                            String position = e.getPosition();
                            return  (String.valueOf(id).contains(keyword)) ||
                            		(name != null && name.toLowerCase().contains(keyword.toLowerCase())) ||
                                   (email != null && email.toLowerCase().contains(keyword.toLowerCase())) ||
                                   (department != null && department.toLowerCase().contains(keyword.toLowerCase())) ||
                                   (position != null && position.toLowerCase().contains(keyword.toLowerCase()));
                        })
                        .collect(Collectors.toList());
    }

    public List<Employee> filterEmployees(String department, String position) {
        return employees.stream()
                        .filter(e -> (department == null || department.isEmpty() || e.getDepartment().equalsIgnoreCase(department)) &&
                                     (position == null || position.isEmpty() || e.getPosition().equalsIgnoreCase(position)))
                        .collect(Collectors.toList());
    }

}

