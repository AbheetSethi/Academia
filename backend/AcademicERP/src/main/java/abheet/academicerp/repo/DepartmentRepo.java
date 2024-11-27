package abheet.academicerp.repo;

import abheet.academicerp.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepo extends JpaRepository<Departments, Long> {
}
