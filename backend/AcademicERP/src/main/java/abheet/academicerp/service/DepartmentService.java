package abheet.academicerp.service;

import abheet.academicerp.dto.DepartmentRequest;
import abheet.academicerp.dto.DepartmentResponse;
import abheet.academicerp.dto.EmployeeResponse;
import abheet.academicerp.entity.Departments;
import abheet.academicerp.entity.Employees;
import abheet.academicerp.loginhelper.EncryptionService;
import abheet.academicerp.loginhelper.JWThelper;
import abheet.academicerp.mapper.DepartmentMapper;
import abheet.academicerp.mapper.EmployeeMaper;
import abheet.academicerp.repo.DepartmentRepo;
import abheet.academicerp.repo.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepo repo;
    private final DepartmentMapper mapper;
    private final EmployeeRepo employeeRepo;
    private final EncryptionService encryptionService;
    private final JWThelper jwThelper;
    private final EmployeeMaper employeeMaper;

    public String createDepartment(DepartmentRequest request) {
        Departments department = mapper.toEntity(request);
        repo.save(department);
        return "Department created";
    }

    public String deleteDepartment(Long id) {
        Departments department = retrieveDepartment(id);
        repo.delete(department);
        return "Department deleted";
    }

    public String updateDepartment(DepartmentRequest request, Long id) {
        Departments department = retrieveDepartment(id);
        department.setName(request.name());
        department.setCapacity(request.capacity());
        repo.save(department);
        return "Department updated";

    }

    public List<EmployeeResponse> getEmployeeOfDepartment(Long id) {
        List<Employees> employees = employeeRepo.findAllByDepartment_Id(id);
        if (employees.isEmpty()) {
            throw new EntityNotFoundException(format("No employee found for Department id: %d", id));
        }
        return employees.stream()
                .map(employeeMaper::employeeResponse)
                .collect(Collectors.toList());
    }

    public List<DepartmentResponse> getAllDepartment() {
        return repo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Departments retrieveDepartment(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException(format("Department with id %s not found", id)));
    }

    public Employees retrieveEmployees(String email) {
        return employeeRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException((format("Employee with email %s not found", email))));
    }

    public String login(String username, String password) {
        System.out.println(encryptionService.encode(password));
        Employees employees = retrieveEmployees(username);
        if(!encryptionService.validates(password, employees.getPassword())){
            return "Incorrect password";
        }

        return jwThelper.generateToken(username);
    }
}