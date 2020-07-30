package com.nextwin.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("my")
public class MyController {
	
	@RequestMapping("view")
	public String view() {
		return "my/view";
	}

}
