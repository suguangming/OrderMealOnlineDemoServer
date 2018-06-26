package signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.JdbcUtils;

public class SignupDao {

	private JdbcUtils utils;
	private Connection connection;

	public SignupDao() {
		utils = JdbcUtils.getInstance();
		connection = utils.getConnection();
	}

	/**
	 * 用户注册DAO
	 * @param username
	 * @param password
	 * @return
	 */
	public int newUser(String username, String password){
		int result = 0;
		ResultSet resultSet = null;
		try {
			String sqlGetUser = "select * from users where username = ?";
			PreparedStatement pstmtQuery = connection.prepareStatement(sqlGetUser);
			pstmtQuery.setString(1, username);
			resultSet = pstmtQuery.executeQuery();
			if (resultSet.next()) {
				result = 0;
			} else {
				String sqlNewUser = "insert into users (username, password) values (?, ?)";
				PreparedStatement pstmtUpdate = connection.prepareStatement(sqlNewUser);
				pstmtUpdate.setString(1, username);
				pstmtUpdate.setString(2, password);
				result = pstmtUpdate.executeUpdate();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
