package org.nextwin.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nextwin.board.dao.Dao;
import org.nextwin.board.dto.Dto;
import org.springframework.ui.Model;

public class WriteCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Dto dto = new Dto();
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		
		Dao dao = new Dao();
		dao.doWrite(dto);
	}

}
