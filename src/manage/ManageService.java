package manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import utils.Order;

public class ManageService {
	
	/**
	 * 获取所有订单
	 * @return JSON String格式订单数据
	 */
	public String getAllJsonString() {
		ManageDao dao = new ManageDao();
		List<Order> list = new ArrayList<Order>();
		ResultSet rs = dao.getALlOrders();
		try {
			while(rs.next()){
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setUsername(rs.getString("username"));
				order.setFoodname(rs.getString("foodname"));
				order.setFoodnumber(rs.getInt("foodnumber"));
				order.setFoodprice(rs.getDouble("foodprice"));
				order.setStatus(rs.getString("status"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);		
		return jsonString;
	}
	
	/**
	 * 更新订单状态
	 * @param id 订单ID
	 * @return 执行结果
	 */
	public boolean updateStatus(int id) {
		ManageDao dao = new ManageDao();
		int r = dao.updateOrderStatus(id);
		if (r == 1) {
			return true;
		}
		return false;
	}
}
