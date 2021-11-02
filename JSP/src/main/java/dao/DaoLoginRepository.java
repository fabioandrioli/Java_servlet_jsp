package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import connection.SingleConnectionDatabase;
import model.LoginModel;

public class DaoLoginRepository {

	private Connection connection;
	
	public DaoLoginRepository() {
		connection = SingleConnectionDatabase.getConnection();
	}
	
	public boolean validarAutenticacao(LoginModel loginModel) {
		final String sql = "select * from where email = ? and password = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(0,loginModel.getUsername());
			preparedStatement.setString(1,loginModel.getPassword());
			
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				return true; /*Autenticado*/
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
