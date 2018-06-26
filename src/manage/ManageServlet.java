package manage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		ManageService service = new ManageService();
		printWriter.write(service.getAllJsonString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("id");
		int orderId = Integer.parseInt(id);
		ManageService service = new ManageService();
		boolean r = service.updateStatus(orderId);
		PrintWriter printWriter = resp.getWriter();
		if(r) {
			printWriter.write("success");
		}else{
			printWriter.write("failed");
		}
		}
		
}