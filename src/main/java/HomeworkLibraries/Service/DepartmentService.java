package HomeworkLibraries.Service;

import HomeworkLibraries.Model.Employee;
import HomeworkLibraries.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee printMaxSalaryEmployeeInDepartment(int departmentEmployee) {
        return employeeService.returnList()
                .stream()
                .filter(employee -> employee.getDepartmentEmployee() == departmentEmployee)
                .max(Comparator.comparingDouble(Employee::getSalaryEmployee))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee printMinSalaryEmployeeInDepartment(int departmentEmployee) {
        return employeeService.returnList()
                .stream()
                .filter(employee -> employee.getDepartmentEmployee() == departmentEmployee)
                .min(Comparator.comparingDouble(Employee::getSalaryEmployee))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findEmployeeInDepartment(int departmentEmployee) {
        return employeeService.returnList()
                .stream()
                .filter(employee -> employee.getDepartmentEmployee() == departmentEmployee)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmployees() {
        return employeeService.returnList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentEmployee));
    }
}