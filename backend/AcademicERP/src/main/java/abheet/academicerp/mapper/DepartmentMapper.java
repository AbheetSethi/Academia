package abheet.academicerp.mapper;

import abheet.academicerp.dto.DepartmentRequest;
import abheet.academicerp.dto.DepartmentResponse;
import abheet.academicerp.entity.Departments;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {
    public Departments toEntity(DepartmentRequest request) {
        return Departments.builder()
                .name(request.name())
                .capacity(request.capacity())
                .build();
    }
    public DepartmentResponse toResponse(Departments departments) {
        return new DepartmentResponse(departments.getId(), departments.getName(), departments.getCapacity());
    }
}
