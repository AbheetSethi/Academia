package abheet.academicerp.repo;

import abheet.academicerp.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long> {
    Optional<Employees> findByEmail(String email);
    List<Employees> findAllByDepartment_Id(Long id);
}
