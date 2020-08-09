package org.nextwin.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nextwin.board.dao.Dao;
import org.nextwin.board.dto.Dto;
import org.springframework.ui.Model;

public class ContentCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		String id = request.getParameter("id");
				
		Dao dao = new Dao();
		Dto dto = dao.getContentView(Integer.parseInt(id));
		
		model.addAttribute("content_view", dto);
	}

}
