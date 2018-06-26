package login;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

	/**
	 * 用户登录
	 * @param usernameInput 输入的用户名
	 * @param passwordInput 输入的密码
	 * @return 登录结果
	 * @throws SQLException
	 */
	public boolean userLogin(String usernameInput, String passwordInput) throws SQLException{
		LoginDao dao = new LoginDao();
		ResultSet resultSet = dao.getUser(usernameInput);
		while(resultSet.next()) {
			String password = resultSet.getString("password");
			if (password.equals(passwordInput)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
