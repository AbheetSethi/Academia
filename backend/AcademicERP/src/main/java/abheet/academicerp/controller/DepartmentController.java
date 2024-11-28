package abheet.academicerp.controller;

import abheet.academicerp.dto.DepartmentRequest;
import abheet.academicerp.dto.DepartmentResponse;
import abheet.academicerp.dto.EmployeeResponse;
import abheet.academicerp.loginhelper.Security;
import abheet.academicerp.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final Security security;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@RequestHeader ("Authorization") String authHeader, @PathVariable ("id") Long id) {
        if(!security.authenticate(authHeader)){
            return ResponseEntity.ok("Unauthorized");
        }
        return ResponseEntity.ok(departmentService.deleteDepartment(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDepartment(@RequestHeader ("Authorization") String authHeader, @PathVariable ("id") Long id , @RequestBody @Valid DepartmentRequest departmentRequest) {
        if(!security.authenticate(authHeader)){
            return ResponseEntity.ok("Unauthorized");
        }
        return ResponseEntity.ok(departmentService.updateDepartment(departmentRequest, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EmployeeResponse>> getEmployeeOfDepartment(@RequestHeader ("Authorization") String authHeader, @PathVariable ("id") Long id) {
        if(!security.authenticate(authHeader)){
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(departmentService.getEmployeeOfDepartment(id));
    }


    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getDepartment(@RequestHeader ("Authorization") String authHeader) {
        if(!security.authenticate(authHeader)){
            return ResponseEntity.status(401).build();
        }
        List<DepartmentResponse> department = departmentService.getAllDepartment();
        return ResponseEntity.ok(department);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDepartment(@RequestHeader ("Authorization") String authHeader, @RequestBody @Valid DepartmentRequest departmentRequest) {
        if(!security.authenticate(authHeader)){
            return ResponseEntity.ok("Unauthorized");
        }
        return ResponseEntity.ok(departmentService.createDepartment(departmentRequest));
    }

}