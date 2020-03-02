package Dao;

import java.util.ArrayList;
import java.util.HashMap;

public class rankData {
	public ArrayList<HashMap<String,Object>> rankDatabyLike(ArrayList<postData> list) {
		ArrayList<HashMap<String,Object>> jsonList = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<list.size();i++) {
			HashMap<String,Object> prMap = new HashMap<String,Object>();
			prMap.put("PostID", list.get(i).getPostID());
			prMap.put("PostName", list.get(i).getPostName());
			prMap.put("PostContent", list.get(i).getPostContent());
			prMap.put("PostTime", list.get(i).getPostTime());
			prMap.put("LikeNumber", list.get(i).getLikeNumber());
			prMap.put("Account", list.get(i).getAccount());
			jsonList.add(prMap);		
			}
		return jsonList;
	}
}
