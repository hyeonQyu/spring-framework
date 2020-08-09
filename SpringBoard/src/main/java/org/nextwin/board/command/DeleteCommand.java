package org.nextwin.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nextwin.board.dao.Dao;
import org.springframework.ui.Model;

public class DeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Dao dao = new Dao();
		dao.doDelete(id);
	}

}
