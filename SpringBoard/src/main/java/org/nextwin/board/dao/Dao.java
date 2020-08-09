package org.nextwin.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.nextwin.board.dto.Dto;

public class Dao {
	
	DataSource dataSource;
	
	public Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle18c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Dto> getList() {
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from board order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("bId");
				String name = resultSet.getString("bName");
				String title = resultSet.getString("bTitle");
				String content = resultSet.getString("bContent");
				Timestamp date = resultSet.getTimestamp("bDate");
				int hit = resultSet.getInt("bHit");
				int group = resultSet.getInt("bGroup");
				int step = resultSet.getInt("bStep");
				int indent = resultSet.getInt("bIndent");
				
				Dto dto = new Dto(id, name, title, content, date, hit, group, step, indent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public void doWrite(Dto dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "insert into board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) "
												+ "values (board_seq.nextval, ?, ?, ?, 0, board_seq.currval, 0, 0)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getTitle());
			preparedStatement.setString(3, dto.getContent());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
