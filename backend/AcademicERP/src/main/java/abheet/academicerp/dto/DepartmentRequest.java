package abheet.academicerp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record DepartmentRequest(
        @NotNull(message = "Department should be present")
        @JsonProperty("name")
        String name,

        @NotNull(message = "Capacity should be present")
        @JsonProperty("capacity")
        int capacity
) {
}