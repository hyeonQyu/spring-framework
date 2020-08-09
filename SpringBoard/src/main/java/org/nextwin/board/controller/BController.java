package org.nextwin.board.controller;

import org.nextwin.board.command.Command;
import org.nextwin.board.command.ListCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BController {
	
	Command command;

	@RequestMapping("/list")
	public String list(Model model) {
		command = new ListCommand();
		command.execute(model);
		
		return "list";
	}
	
}
