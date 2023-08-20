package HomeworkLibraries.Service;

import HomeworkLibraries.Exception.EmployeeAlreadyAddedException;
import HomeworkLibraries.Exception.EmployeeNotFoundException;
import HomeworkLibraries.Exception.EmployeeStorageIsFullException;
import HomeworkLibraries.Exception.InvalidInputException;
import HomeworkLibraries.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees;
    private String firstName;
    private String lastName;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    public Employee add(String firstName, String lastName, int departmentEmployee, double salaryEmployee) {
        validateInput(firstName, lastName);

        Employee employee = new Employee(firstName, lastName, departmentEmployee, salaryEmployee);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee remove(String firstName, String lastName) {
        validateInput(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public Employee find(String firstName, String lastName) {
        validateInput(firstName, lastName);

        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public List<Employee> returnList() {
        return new ArrayList<>(employees.values());
    }

    public String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    public void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}