package org.nextwin.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.nextwin.board.command.Command;
import org.nextwin.board.command.ContentCommand;
import org.nextwin.board.command.DeleteCommand;
import org.nextwin.board.command.ListCommand;
import org.nextwin.board.command.ModifyCommand;
import org.nextwin.board.command.WriteCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BController {
	
	Command command;

	@RequestMapping("/list")
	public String list(Model model) {
		command = new ListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("write_view")
	public String writeView(Model model) {
		return "write_view";
	}
	
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new WriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("content_view")
	public String contentView(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new ContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="modify")
	public String modify(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new ModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new DeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
