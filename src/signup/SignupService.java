package signup;

import java.sql.SQLException;

public class SignupService {
	
	/**
	 * 用户注册Service
	 * @param usernameInput 用户名
	 * @param passwordInput 密码
	 * @return 注册结果
	 * @throws SQLException
	 */
	public boolean userSignin(String usernameInput, String passwordInput) throws SQLException{
		SignupDao dao = new SignupDao();
		int result = dao.newUser(usernameInput, passwordInput); 
		if(result==1){
			return true;
		} else {
			return false;
		}
	}
}
