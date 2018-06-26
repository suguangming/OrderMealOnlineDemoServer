package manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.JdbcUtils;
public class ManageDao {
	
	private JdbcUtils utils;
	private Connection connection;
	
	public ManageDao() {
		utils = JdbcUtils.getInstance();
		connection = utils.getConnection();
	}
	
	/**
	 * 获取所有订单
	 * @return ResultSet
	 */
	public ResultSet getALlOrders() {
		ResultSet rs = null;
		String sqlGetAll = "select * from orders";
    	try {
    		Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlGetAll);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 更新订单状态
	 * @param id 订单ID
	 * @return SQL执行结果
	 */
	public int updateOrderStatus(int id) {
		int result = 0;
		String sqlUpdateOrderStatus = "update orders set status='complete' where id=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sqlUpdateOrderStatus);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
