package org.deloitte.Project.controller;

import java.util.List;

import javax.validation.Valid;

import org.deloitte.Project.entity.EmployeeEntity;
import org.deloitte.Project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String login()throws Exception
	{
		return "index";
	}
	
	@PostMapping("/login")
	public ModelAndView login1(@RequestParam String name,@RequestParam String pwd)throws Exception
	{
		ModelAndView mv;
		if(name.equals("system")&&pwd.equals("seed1234"))
		{
			mv = new ModelAndView("menu");
			System.err.println("In Login check");
		}
		else
		{
			mv=new ModelAndView("index");
		}
		return mv;
	}
	
/*	@RequestMapping("/menu.htm")
	public ModelAndView menu(@RequestParam String name)throws Exception
	{
		ModelAndView mv;
		if(name.equals("add"))
		{
			mv = new ModelAndView("create");
		}
		else if(name.equals("remove"))
		{
			mv = new ModelAndView("remove");
		}
		else if(name.equals("update"))
		{
			mv = new ModelAndView("update");
		}
		else
		{
			mv = new ModelAndView("display"); 
		}
		return mv;
	}
*/	
	
	@GetMapping("/allEmp")
	public ModelAndView allEmp()throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<EmployeeEntity> emps=employeeService.listEmployees();
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/create")
	public ModelAndView create()
	{
		return new ModelAndView("create","emp",new EmployeeEntity());
	}
	
	@PostMapping("/create")
	public ModelAndView save(@Valid @ModelAttribute("emp")EmployeeEntity employee)
	{
		ModelAndView mv = new ModelAndView("display");
		mv.addObject(employeeService.addEmployee(employee));
		return mv;
	}
	
	@RequestMapping("/updateId")
	public ModelAndView updateId()throws Exception
	{
		ModelAndView mv = new ModelAndView("updateId","emp",new EmployeeEntity());
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update()throws Exception
	{
		ModelAndView mv = new ModelAndView("update","emp",new EmployeeEntity());
		return mv;
	}
	
	@RequestMapping("/menu")
	public ModelAndView menu()throws Exception
	{
		ModelAndView mv = new ModelAndView("menu");
		return mv;
	}

	@PostMapping("/display")
	public ModelAndView display(@Valid @ModelAttribute("employee")EmployeeEntity employee)
	{
		ModelAndView mv = new ModelAndView("display");
		mv.addObject(employeeService.addEmployee(employee));
		return mv;
	}
	
	@GetMapping("/remove")
	public ModelAndView remove()throws Exception
	{
		ModelAndView mv = new ModelAndView("remove");
		mv.addObject("emp",new EmployeeEntity());
		return mv;
	}
	
	@PostMapping("/remove")
	public ModelAndView removeEmp(@ModelAttribute EmployeeEntity employee)throws Exception
	{
		ModelAndView mv = new ModelAndView("remove");
		try{
			EmployeeEntity e= employeeService.findByEmployeeId(employee.employeeid,employee);
		mv.addObject("emp",employeeService.deleteEmployee(e));
		}
		catch(Exception ex)
		{
			mv=new ModelAndView("");
			System.out.println(ex);
		}
		return mv;
	}
	
	@GetMapping("/earful")
	public ModelAndView earful()
	{
		ModelAndView mv = new ModelAndView("earful");
		return mv;
	}
}

