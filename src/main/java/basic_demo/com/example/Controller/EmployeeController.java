package basic_demo.com.example.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import basic_demo.com.example.Service.EmployeeService;
import basic_demo.com.example.model.Employee;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	
	@PostMapping("/create-employee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		Map<String, Object> respEmp = new LinkedHashMap<String, Object>();
		empService.save(employee);
		respEmp.put("status", 1);
		respEmp.put("message", "Record is saved Successfully");
		return new ResponseEntity<>(respEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-employees")
	public ResponseEntity<?> getEmployees() {
		Map<String, Object> respEmp = new LinkedHashMap<String, Object>();
		List<Employee> empList = empService.findAll();
		if (!empList.isEmpty()) {
			respEmp.put("status", 1);
			respEmp.put("data", empList);
			return new ResponseEntity<>(respEmp, HttpStatus.OK);
		} else {
			respEmp.put("status", 0);
			respEmp.put("data", "data Not found");
			return new ResponseEntity<>(respEmp, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
		Map<String, Object> respEmp = new LinkedHashMap<String, Object>();
		try {
			Employee emp = empService.findById(id);
			respEmp.put("status", 1);
			respEmp.put("data", emp);
			return new ResponseEntity<>(respEmp, HttpStatus.OK);
		} catch(Exception e) {
			respEmp.put("status", 0);
			respEmp.put("data", "data Not found");
			return new ResponseEntity<>(respEmp, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<?> updateEmployeeId(@PathVariable Long Id,@RequestBody Employee employee){
		Map<String, Object> respEmp = new LinkedHashMap<String, Object>();
		try {
			Employee emp = empService.findById(Id);
			 emp.setName(employee.getName());
			 emp.setMobileNo(employee.getMobileNo());
			 emp.setEmail(employee.getEmail());
			 empService.save(emp);
			   respEmp.put("status", 1);
			   respEmp.put("data", empService.findById(Id));
			   return new ResponseEntity<>(respEmp, HttpStatus.OK);
		} catch(Exception e) {
			respEmp.put("status", 0);
			respEmp.put("data", "data Not found");
			return new ResponseEntity<>(respEmp, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteEmployeeId(@PathVariable Long Id){
		Map<String,Object> resp = new LinkedHashMap<String,Object>();
		try {
			Employee emp = empService.findById(Id);
			empService.delete(emp);
			resp.put("status", 1);
			resp.put("message", "Record is deleted successfully!");
		    return new ResponseEntity < > (resp, HttpStatus.OK);
		} catch(Exception e) {
			resp.put("status", 0);
			resp.put("data","data Not found");
			return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
		}
	}
	
	

}
