package HomeworkLibraries.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

public class Employee {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private final String lastName;
    private final int departmentEmployee;
    private final double salaryEmployee;

    public Employee(String firstName, String lastName, int departmentEmployee, double salaryEmployee) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.departmentEmployee = departmentEmployee;
        this.salaryEmployee = salaryEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentEmployee() {
        return departmentEmployee;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentEmployee == employee.departmentEmployee && Double.compare(employee.salaryEmployee, salaryEmployee) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentEmployee, salaryEmployee);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentEmployee=" + departmentEmployee +
                ", salaryEmployee=" + salaryEmployee +
                '}';
    }
}