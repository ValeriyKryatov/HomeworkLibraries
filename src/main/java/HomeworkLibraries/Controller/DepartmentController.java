package HomeworkLibraries.Controller;

import HomeworkLibraries.Model.Employee;
import HomeworkLibraries.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee printMaxSalaryEmployeeInDepartment(@RequestParam("departmentId") int departmentEmployee) {
        return departmentService.printMaxSalaryEmployeeInDepartment(departmentEmployee);
    }

    @GetMapping("/min-salary")
    public Employee printMinSalaryEmployeeInDepartment(@RequestParam("departmentId") int departmentEmployee) {
        return departmentService.printMinSalaryEmployeeInDepartment(departmentEmployee);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeeInDepartment(@RequestParam("departmentId") int departmentEmployee) {
        return departmentService.findEmployeeInDepartment(departmentEmployee);
    }

    @GetMapping("/all")
    public Map<Integer, java.util.List<Employee>> findEmployees() {
        return departmentService.findEmployees();
    }
}