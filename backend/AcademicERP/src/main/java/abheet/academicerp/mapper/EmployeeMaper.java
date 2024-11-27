package abheet.academicerp.mapper;

import abheet.academicerp.dto.EmployeeResponse;
import abheet.academicerp.entity.Employees;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMaper {
    public EmployeeResponse employeeResponse(Employees employees) {
        return new EmployeeResponse(employees.getEmployeeId(), employees.getFirstName(), employees.getLastName(), employees.getEmail(), employees.getTitle());
    }
}
