package in.sp.main.service;

import java.util.List;

import in.sp.main.entity.Employee;

public interface EmpService 
{
	public Employee login(String email);
	public boolean addEmployeeService(Employee emp);
	public List<Employee> getAllEmployeesService();
}
