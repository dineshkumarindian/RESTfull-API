package basic_demo.com.example.Service;
import basic_demo.com.example.model.Employee;
import java.util.*;

public interface EmployeeService {
void save(Employee employee);
List<Employee> findAll();
Employee findById(Long id);
void delete(Employee employee);
}
