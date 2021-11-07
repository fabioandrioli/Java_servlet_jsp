package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnectionDatabase;
import model.UserModel;

public class DaoUserRepository {
private Connection connection;
	
	public DaoUserRepository() {
		connection = SingleConnectionDatabase.getConnection();
	}
	
	public boolean save(UserModel userModel) {
		final String sql = "INSERT INTO users (name, email, password, role, created_at) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,userModel.getName());
			preparedStatement.setString(2,userModel.getEmail());
			preparedStatement.setString(3,userModel.getPassword());
			preparedStatement.setString(4,userModel.getRole());
			preparedStatement.setDate(5, userModel.getCreated_at());
			
			preparedStatement.executeUpdate();
			connection.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
