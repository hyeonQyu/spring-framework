package org.nextwin.board.command;

import java.util.ArrayList;

import org.nextwin.board.dao.Dao;
import org.nextwin.board.dto.Dto;
import org.springframework.ui.Model;

public class ListCommand implements Command {

	@Override
	public void execute(Model model) {
		Dao dao = new Dao();
		ArrayList<Dto> dtos = dao.getList();
		
		model.addAttribute("list", dtos);
	}

}
