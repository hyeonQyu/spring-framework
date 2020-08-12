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
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc_mariadb");
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
												+ "values (next value for seq_board, ?, ?, ?, 0, previous value for seq_board, 0, 0)";
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
	
	public Dto getContentView(int id) {
		upHit(id);
		
		Dto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "select * from board where bId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt("bId");
				String name = resultSet.getString("bName");
				String title = resultSet.getString("bTitle");
				String content = resultSet.getString("bContent");
				Timestamp date = resultSet.getTimestamp("bDate");
				int hit = resultSet.getInt("bHit");
				int group = resultSet.getInt("bGroup");
				int step = resultSet.getInt("bStep");
				int indent = resultSet.getInt("bIndent");
				
				dto = new Dto(id, name, title, content, date, hit, group, step, indent);
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
		
		return dto;
	}
	
	public void doModify(Dto dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "update board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dto.getName());
			preparedStatement.setString(2, dto.getTitle());
			preparedStatement.setString(3, dto.getContent());
			preparedStatement.setInt(4, dto.getId());
			
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
	
	public void doDelete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String sql = "delete from board where bId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
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
	
	private void upHit(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			String sql = "update board set bHit = bHit + 1 where bId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
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
