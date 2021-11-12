package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<UserModel> allUsers(){
		final String sql = "SELECT * FROM users";
		ArrayList<UserModel> listAllUsers = new ArrayList<UserModel>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				UserModel userModel = new UserModel();
				userModel.setId(resultset.getInt("id"));
				userModel.setName(resultset.getString("name"));
				userModel.setEmail(resultset.getString("email"));
				userModel.setRole(resultset.getString("role"));
				userModel.setCreated_at(resultset.getDate("created_at"));
				listAllUsers.add(userModel);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return listAllUsers;
	}
}
