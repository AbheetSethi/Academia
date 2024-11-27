package abheet.academicerp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Departments {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "department_id")
        private long id;

        @Column(name = "name", nullable = false, unique = true, length = 20)
        private String name;

        @Column(name = "capacity", nullable = false)
        private int capacity;

        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
        private List<Employees> employees = new ArrayList<>();

}
