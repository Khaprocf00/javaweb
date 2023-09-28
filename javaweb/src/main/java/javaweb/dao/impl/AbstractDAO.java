package javaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javaweb.dao.GenericDAO;
import javaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/javaweb";
			String username = "root";
			String password = "";
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> result = new ArrayList<>();
		Connection connection = getConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				statement = connection.prepareStatement(sql);
				setParameter(statement, parameters);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					result.add(rowMapper.mapRow(resultSet));
				}
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					System.out.println("lỗi không close connection statement resultSet được");
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				int index = i + 1;
				Object parameter = parameters[i];
				if (parameters[i] instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameters[i] instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameters[i] instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameters[i] instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = getConnection();
		Long id = 0L ;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection!=null) {
			try {
				connection.setAutoCommit(false);
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				setParameter(statement, parameters);
				statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					id = resultSet.getLong(1);
				}
				connection.commit();
				return id;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					System.out.println("lỗi không close connection statement resultSet được");
					e.printStackTrace();
				}
			}
		}
		return id;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection!=null) {
			try {
				connection.setAutoCommit(false);
				statement = connection.prepareStatement(sql);
				setParameter(statement, parameters);
				statement.executeUpdate();
				connection.commit();
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
				} catch (SQLException e) {
					System.out.println("lỗi không close connection statement resultSet được");
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public int count(String sql,Object... parameters) {
		Connection connection = getConnection();
		if (connection != null) {
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				statement = connection.prepareStatement(sql);
				setParameter(statement, parameters);
				resultSet = statement.executeQuery();
				int count = 0;
				while (resultSet.next()) {
					count = resultSet.getInt(1);
				}
				return count;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					System.out.println("lỗi không close connection statement resultSet được");
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	
}
