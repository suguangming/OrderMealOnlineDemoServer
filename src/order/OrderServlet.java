package order;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Order;

public class OrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get order");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String orderType = req.getParameter("type");
		String username = req.getParameter("username");
		String foodName = req.getParameter("foodName");
		String foodNumber = req.getParameter("foodNumber");
		String foodPrice = req.getParameter("foodPrice");
		PrintWriter printWriter = resp.getWriter();
		if (orderType.equals("new")) {
			OrderService service = new OrderService();
			Order order = new Order();
			order.setUsername(username);
			order.setFoodname(foodName);
			order.setFoodnumber(Integer.parseInt(foodNumber));
			order.setFoodprice(Double.parseDouble(foodPrice));
			order.setStatus("new");
			service.addNewOrder(order);
			printWriter.write("submit success");
		}
	}
}
