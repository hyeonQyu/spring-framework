package com.nextwin.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextwin.student.Student;
import com.nextwin.student.StudentValidator;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("create")
	public String createStudent(@Valid Student student, BindingResult result) {
		String page = "createDonePage";
		
//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
		if(result.hasErrors())
			page = "createPage";
		
		return page;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
}
