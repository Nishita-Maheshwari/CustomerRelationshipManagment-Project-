package in.sp.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController 
{
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
	public String openEmpListPage()
	{
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
								Model model
							)
	{
		String page = "login";
		if(myemail.equals("admin@gmail.com") && mypass.equals("admin123"))
		{
			page = "profile-admin";
		}
		else
		{
			model.addAttribute("model_error", "Email id and password didnt matched");
			page = "login";
		}
		return page;
	}
	
	@GetMapping("/addEmployee")
	public String openAddEmpPage()
	{
		return "add-employee";
	}
}
