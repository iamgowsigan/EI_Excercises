//Composite pattern is used when we need to treat a group of objects in similar way as a single object. 
// Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy.

package Structural_Design_Patterns;

import java.util.ArrayList;
import java.util.List;

// Component
abstract class Employee {
    protected String name;
    protected String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void add(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public void remove(Employee employee) {
        throw new UnsupportedOperationException();
    }

    public Employee getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public abstract void display();
}

// Leaf
class Developer extends Employee {
    public Developer(String name, String position) {
        super(name, position);
    }

    @Override
    public void display() {
        System.out.println("Developer: " + name + ", Position: " + position);
    }
}

// Leaf
class Manager extends Employee {
    public Manager(String name, String position) {
        super(name, position);
    }

    @Override
    public void display() {
        System.out.println("Manager: " + name + ", Position: " + position);
    }
}

// Composite
class Department extends Employee {
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, String position) {
        super(name, position);
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Employee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public void display() {
        System.out.println("Department: " + name + ", Position: " + position);
        for (Employee employee : employees) {
            employee.display();
        }
    }
}

// Main class to demonstrate
public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee dev1 = new Developer("Dev1", "Frontend Developer");
        Employee dev2 = new Developer("Dev2", "Backend Developer");
        Employee manager1 = new Manager("Manager1", "Project Manager");

        Department engineering = new Department("Engineering", "Engineering Department");
        Department hr = new Department("HR", "HR Department");

        engineering.add(dev1);
        engineering.add(dev2);
        engineering.add(manager1);

        hr.add(new Manager("Manager2", "HR Manager"));

        Department company = new Department("Company", "Company");
        company.add(engineering);
        company.add(hr);

        company.display();
    }
}
