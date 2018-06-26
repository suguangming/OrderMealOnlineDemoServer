package order;

import utils.Order;

public class OrderService {
	
	/**
	 * 添加订单
	 * @param order 订单数据
	 */
	public void addNewOrder(Order order) {
		OrderDao dao = new OrderDao();
		dao.addOrder(order);
	}
	
}
