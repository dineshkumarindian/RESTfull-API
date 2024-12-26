package basic_demo.com.example.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import basic_demo.com.example.model.Employee;
import basic_demo.com.example.Repository.EmployeeRepository;


@Service
public class EmployeeServiceImple implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void save(Employee employee) {
		empRepo.save(employee);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll()    ;
	}
	
	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}


	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		empRepo.delete(employee);
		
	}

	
}
