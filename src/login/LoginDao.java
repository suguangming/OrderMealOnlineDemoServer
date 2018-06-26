package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.JdbcUtils;

public class LoginDao {

	private JdbcUtils utils;
	private Connection connection;

	public LoginDao() {
		utils = JdbcUtils.getInstance();
		connection = utils.getConnection();
	}

	/**
	 * 通过用户名获取密码
	 * @param username 用户名
	 * @return ResultSet 查询结果集
	 */
	public ResultSet getUser(String username){
		String sqlGetUser = "select * from users where username = ?";
		ResultSet resultSet = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(sqlGetUser);
			pstmt.setString(1, username);
			resultSet = pstmt.executeQuery();
		} catch (Exception e) {
		}
		return resultSet;		
	}
	
}
