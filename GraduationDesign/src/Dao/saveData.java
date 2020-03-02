package Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;

import Dao.postData;
import Dao.rankData;

public class saveData {
	public String saveListData(ResultSet rs){
		ArrayList<HashMap<String,Object>> jsonList = new ArrayList<HashMap<String,Object>>();
		ArrayList<postData> dataList = new ArrayList<postData>();
		try {
			while(rs.next()) {
				postData data = new postData();
				data.setPostID(rs.getInt(1));
				data.setPostName(rs.getString(2));
				data.setPostContent(rs.getString(3));
				data.setPostTime(rs.getString(4));
				data.setLikeNumber(rs.getInt(5));
				data.setAccount(rs.getInt(6));
				dataList.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rankData rank = new rankData();
			jsonList = rank.rankDatabyLike(dataList);
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(jsonList);
		return jsonString;
	}
	
}
