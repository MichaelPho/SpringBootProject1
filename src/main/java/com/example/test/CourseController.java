package com.example.test;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class CourseController {


	
	@Autowired 
	private CourseRepository coRepository;

	
	
	
	@GetMapping("/course.html")
	public String getBloodBankList(Model model) {
		model.addAttribute("courses",coRepository.findAll());
		model.addAttribute("total",coRepository.count());
		return "Course/list";
	}
	
	@RequestMapping("/Course/create.html")
	public String create(Model model) {
		
		return "course/create";
	}
	

	
	@GetMapping(value="/course.html", params="courseCode")
	public String getCourse(@RequestParam("courseCode") String courseCode, Model model) {
		Optional<Course> co = coRepository.findById(Integer.parseInt(courseCode));
		model.addAttribute("course", co.get());
		return "Course/details";
				
	}
	
	
	
	
	@PostMapping(value="/course.html/delete", params="courseCode")
	public String deleteCourse(@RequestParam("courseCode") String courseCode, Model model) {
		coRepository.deleteById(Integer.parseInt(courseCode));
		model.addAttribute("courses",coRepository.findAll());
		return "Course/list";
		
	}
	
	@PostMapping(value="/course.html/update", params="courseCode")
	public String update(HttpServletRequest  request,@RequestParam("courseCode") String courseCode, Model model) {
		int id = Integer.parseInt(request.getParameter("courseCode"));
		String courseName = request.getParameter("courseName");
		int Duration = Integer.parseInt(request.getParameter("duration"));
		String semester = request.getParameter("semester");
		String professorName = request.getParameter("professorName");
		BigDecimal courseFee = new BigDecimal(request.getParameter("courseFee"));
		int creditHours = Integer.parseInt(request.getParameter("creditHours"));
		
		Course temp = new Course(id, courseName,Duration,semester,professorName,courseFee,creditHours);
		coRepository.save(temp);
		
		model.addAttribute("courses",coRepository.findAll());
		return "Course/list";
	}

	@PostMapping(value="/Course/add")
	public String add(HttpServletRequest  request, Model model) {
		int id = Integer.parseInt(request.getParameter("courseCode"));
		String courseName = request.getParameter("courseName");
		int Duration = Integer.parseInt(request.getParameter("duration"));
		String semester = request.getParameter("semester");
		String professorName = request.getParameter("professorName");
		BigDecimal courseFee = new BigDecimal(request.getParameter("courseFee"));
		int creditHours = Integer.parseInt(request.getParameter("creditHours"));
		
		Course temp = new Course(id, courseName,Duration,semester,professorName,courseFee,creditHours);
		coRepository.save(temp);
		
		model.addAttribute("courses",coRepository.findAll());
		
		model.addAttribute("total",coRepository.count());
		
		return "Course/list";
	}
}

