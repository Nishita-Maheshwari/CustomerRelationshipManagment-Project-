package in.sp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.main.entity.Employee;
import in.sp.main.service.EmpService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController 
{
	@Autowired
	EmpService empService;
	
	@GetMapping("/")
	public String openIndexPage()
	{
		return "index";
	}
	@GetMapping("/home")
	public String openHomePage()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String openLoginPage()
	{
		return "login";
	}
	
	@GetMapping("/emplist")
	public String openEmpListPage(Model model)
	{
		List<Employee> list_emp = empService.getAllEmployeesService();
		model.addAttribute("model_list_emp", list_emp);
		return "employees-list";
	}
	
	@GetMapping("/profileAdmin")
	public String openAdminProfilePage()
	{
		return "profile-admin";
	}
	
	@PostMapping("/loginForm")
	public String loginForm(
								@RequestParam("email1") String myemail,
								@RequestParam("pass1") String mypass,
								Model model,
								HttpSession session
							)
	{
		String page = "login";
		if(myemail.equals("admin@gmail.com") && mypass.equals("admin123"))
		{
			page = "profile-admin";
		}
		else
		{
			Employee emp = empService.login(myemail);
			if(emp != null && emp.getPassword().equals(mypass))
			{
				session.setAttribute("session_employee", emp);
				page = "profile-employee";
			}
			else
			{
				model.addAttribute("model_error", "Email id and password didnt matched");
				page = "login";
			}
		}
		return page;
	}
	
	@GetMapping("/addEmployee")
	public String openAddEmpPage()
	{
		return "add-employee";
	}
	
	@PostMapping("/addEmpForm")
	public String registerEmployeeForm(
											@RequestParam("name1") String empname,
											@RequestParam("email1") String empemail,
											@RequestParam("pass1") String emppass,
											@RequestParam("phoneno1") String empphoneno,
											Model model
										)
	{
		Employee emp = new Employee();
		emp.setName(empname);
		emp.setEmail(empemail);
		emp.setPassword(emppass);
		emp.setPhoneno(empphoneno);
		
		boolean status = empService.addEmployeeService(emp);
		if(status)
		{
			model.addAttribute("model_success", "Employee added successfully");
		}
		else
		{
			model.addAttribute("model_error", "Employee not added due to some error");
		}
		
		return "add-employee";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
}
