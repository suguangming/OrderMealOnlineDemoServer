package index;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.Food;
import utils.JdbcUtils;

public class IndexDao {
	Connection connection;
	JdbcUtils utils;
	
	public IndexDao() {
		JdbcUtils utils = JdbcUtils.getInstance();
		connection = utils.getConnection();
	}

	/**
	 * 获取所有food
	 * @return List<Food>
	 */
	public List<Food> getFoods() {
		String sqlGetInfo = "select * from dishes";
		ResultSet resultSet;
		List<Food> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(sqlGetInfo);			
            resultSet = pstmt.executeQuery();            
            while(resultSet.next()){
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	String description = resultSet.getString("description");
            	String imgUrl = resultSet.getString("imgUrl");
            	Double price = resultSet.getDouble("price");
            	Food food = new Food();
            	food.setId(id);
            	food.setName(name);
            	food.setDescription(description);
            	food.setImgurl(imgUrl);
            	food.setPrice(price);
            	list.add(food);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return list;		
	}
}

