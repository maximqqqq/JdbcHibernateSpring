package repository;

import entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME = ?1 AND SURNAME = ?2",nativeQuery = true)
    Employee findByFirstNameAndLastName(String name, String surname);

    Employee findByLastName(String surname);

}
