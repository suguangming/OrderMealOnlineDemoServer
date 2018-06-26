package index;

import java.util.List;

import utils.Food;

import com.google.gson.Gson;

public class IndexService {
	
	/**
	 * 获取所有Food
	 * @return JSON String格式的List<Food>
	 */
	public String getJsonString() {
		IndexDao dao = new IndexDao();
		List<Food> list = dao.getFoods();
		Gson gson = new Gson();
		String jsonString = gson.toJson(list);		
		return jsonString;
	}
}
