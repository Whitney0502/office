package com.abc.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abc.dao.EmployeeDao;
import com.abc.model.Employee;


@RestController
public class AdminController {
//	@RequestMapping(value="/admin", method=RequestMethod.GET)
//	public String login(@RequestParam("username") String username,
//			@RequestParam("password") String password, Map<String, Object> map) {
//		if(username != null && username.equals("admin") && "admin123".equals(password)) {
//			return "redirect:/index.jsp";
//		} else {
//			map.put("msg", "Wrong username or password");
//			return "login";
//		}
//	}
	
	 	@Autowired
	    EmployeeDao employeeDao;
	 	
	 	//show all employees
	    @GetMapping("/emps")
	    public String list(Model model){
	        Collection<Employee> employees = employeeDao.getAllEmployees();
	        model.addAttribute("emps",employees);
	        return "emp/list";
	    }
	    
	    //add employee
	    @PostMapping("/emp")
	    public String addEmp(Employee employee){
	        employeeDao.save(employee);
	        return "redirect:/emps";
	    }

	    //search employee through empId and show on page
	    @GetMapping("/emp/{empId}")
	    public String searchEmp(@PathVariable("empId") Integer empId,Model model){
	        Employee employee = employeeDao.getEmployeeById(empId);
	        model.addAttribute("emp",employee);
	        return "emp/add";
	    }

	    //edit employee, need empId
	    @PutMapping("/emp")
	    public String updateEmployee(Employee employee){
	        employeeDao.save(employee);
	        return "redirect:/emps";
	    }

	    //delete employee
	    @DeleteMapping("/emp/{empId}")
	    public String deleteEmployee(@PathVariable("empId") Integer empId){
	        employeeDao.delete(empId);
	        return "redirect:/emps";
	    }
	
	
	
	
//	@Autowired
//	private EmployeeService empService;
//	
//	@GetMapping("/")
//	public String defaultMethod() {
//		return "welcome";
//	}
//	
//	@GetMapping("/testing")
//	public Map<String, Object> insertEmps(Map<String, Object> map) {
//		Employee e1 = new Employee();
//		Employee e2 = new Employee();
//		e1.setFirstname("Huining"); e1.setLastname("Zhang");
//		e2.setFirstname("Fan"); e2.setLastname("Yang");
//		map.put("empForm", e1);
//		map.put("empForm", e2);
//		return map;
//	}
//	
//	@GetMapping("/list-emps")
//	public String listEmps(ModelMap model) {
//		int empId = 1001;
//		model.addAttribute("empForm", empService.findEmployeeById(empId));
//		return "list-emps";
//	}
//	
//	@PutMapping("/insert-emps")
//	public String insertEmps(ModelMap model, @Valid Employee emp, 
//			BindingResult result) {
//		empService.addEmps(emp.getEmpId(), emp.getFirstname(), emp.getLastname(), emp.getEmail());
//		return "redirect:/list-emps";
//	}
//	
//	@PutMapping("/edit-emps")
//	public String updateEmps(@RequestParam int empId, ModelMap model) {
//		Employee emp = empService.findEmployeeById(empId);
//		model.addAttribute("edit", emp);
//		return "edit-emps";
//	}
//	
//	@DeleteMapping("/delete-emps")
//	public String deleteEmps(@RequestParam int empId, ModelMap model) {
//		empService.deleteEmp(empId);
//		return "redirect:/list-emps";
//	}
}
