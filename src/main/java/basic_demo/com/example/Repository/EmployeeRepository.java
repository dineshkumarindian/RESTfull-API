package basic_demo.com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import basic_demo.com.example.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
