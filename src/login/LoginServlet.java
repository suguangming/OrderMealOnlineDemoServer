package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String usernameInput = req.getParameter("username");
        String passwordInput = req.getParameter("password");
        PrintWriter printWriter = resp.getWriter();
        if (usernameInput!=null&&passwordInput!=null ) {
            LoginService service = new LoginService();
            try {
                boolean b =service.userLogin(usernameInput, passwordInput);
                System.out.println("service.userLogin");
                if (b) {
                    System.out.println("login succeed");
                    printWriter.write("success");
                    } else {
                    System.out.println("login failed");
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

