package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.JdbcUtils;
import utils.Order;

public class OrderDao {
	private JdbcUtils utils;
	private Connection connection;
	
	public OrderDao() {
		utils = JdbcUtils.getInstance();
		connection = utils.getConnection();
	}
	
	/**
	 * 添加订单
	 * @param order 订单数据
	 */
	public void addOrder(Order order) {
		String username = order.getUsername();
		String name = order.getFoodname();
		int number = order.getFoodnumber();
		double price = order.getFoodprice();
		try {
			String sqlNewOrder = "insert into orders (username, foodname, foodnumber, foodprice, status) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmtNewOrder = connection.prepareStatement(sqlNewOrder);
			pstmtNewOrder.setString(1, username);
			pstmtNewOrder.setString(2, name);
			pstmtNewOrder.setInt(3, number);
			pstmtNewOrder.setDouble(4, price);
			pstmtNewOrder.setString(5, "new");
			pstmtNewOrder.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
