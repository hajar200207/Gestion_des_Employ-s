package models;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String position;
    
    // Constructeur avec tous les champs
    public Employee(String name, String email, String phone, String department, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.position = position;
    }

   

	 public Employee(int id,String name, String email, String phone, String department, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.position = position;
    }


	// Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }
}
