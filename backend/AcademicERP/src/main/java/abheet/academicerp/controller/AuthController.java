package abheet.academicerp.controller;

import abheet.academicerp.loginhelper.EncryptionService;
import abheet.academicerp.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final DepartmentService departmentService;
    private final EncryptionService encryptionService;

    @GetMapping
    public ResponseEntity<String> getAuthToken(@RequestParam ("password") String password) {
        //String name = "admin1234";
        return ResponseEntity.ok(encryptionService.encode(password));
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam ("user") String user, @RequestParam ("password") String password) {
        return ResponseEntity.ok(departmentService.login(user, password));
    }

}
