package abheet.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DepartmentResponse(
        @JsonProperty("department_id")
        Long id,
        @JsonProperty("name")
        String name,
        @JsonProperty("capacity")
        int capacity
) {
}
