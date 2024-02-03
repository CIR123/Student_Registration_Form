package in.ashokit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Student;
import in.ashokit.entity.StudentEntity;
import in.ashokit.repo.StudentRepo;

@Controller
public class StudentController {
	
    @Autowired
	private StudentRepo repo;
	
	
	//logic to display the form
	
	
	@GetMapping("/")
	public String loadForm(Model model)
	{
		handleForm(model);
		
		return "index";
		
	}

	private void handleForm(Model model) {
		List<String> courseList =new ArrayList<>();
		courseList.add("java");
		courseList.add("Aws");
		courseList.add("Devops");
		
		List<String> timingList =new ArrayList<>();
		timingList.add("Morning");
		timingList.add("Afternoon");
		timingList.add("Evening");
		
		Student s=new Student();
		model.addAttribute("courses", courseList);
		model.addAttribute("timings",timingList);
		model.addAttribute("student", s);
	}
	
	//logic to submit the form
	
	
	@PostMapping("/save")
	public String handleForm(Student s,Model model)
	{
		
		StudentEntity entity=new StudentEntity();
		//copy student obj to entity obj
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));
		
		repo.save(entity);
		model.addAttribute("msg","student saved");
		handleForm(model);
		
		return "index";
	}
	
	
	//logic to view student details
	
	@GetMapping("/viewStudent")
	public String getStudent(Model model)
	{
		
		List<StudentEntity> studentEntity = repo.findAll();
		model.addAttribute("students", studentEntity);
		return "data";
	}

}
