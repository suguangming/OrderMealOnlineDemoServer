package signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String usernameInput = req.getParameter("newusername");
		String passwordInput = req.getParameter("newpassword");
		PrintWriter printWriter = resp.getWriter();
		if (usernameInput!=null&&passwordInput!=null ) {
			SignupService service = new SignupService();
			try {
				boolean b =service.userSignin(usernameInput, passwordInput);
				if (b) {
					System.out.println("Signin succeed");
					printWriter.write("success");
				} else {
					System.out.println("Signin failed");
					printWriter.write("failed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("wrong parameter");
			printWriter.write("net_error");
			}
	}

}




